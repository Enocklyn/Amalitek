/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author lys
 * class to 
 */
@Service
public class JwtService {
    
    private static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
    
    public <T>T extractClaim (String token , Function<Claims,T>claimsResolver){
    
    final Claims claims =extractAllClaims(token);
    return claimsResolver.apply(claims);
    }
    public String generateToken (Map<String , Object>extractClaims, UserDetails details){
    return Jwts.builder().setClaims(extractClaims)
            .setSubject(details.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            
            .setExpiration(new Date (System.currentTimeMillis()+100*60*24)).signWith(getSignInKey(),SignatureAlgorithm.HS256).compact();
    }
    public String generateToken(UserDetails details){
    return generateToken(new HashMap<>(),details);
    
    }
    public boolean isTokenValid(String token , UserDetails details){
    
    final String username=extractUsername(token);
    return (username.equals(details.getUsername())&&!IsTokenExpired(token));
    }
    private boolean IsTokenExpired(String token){
    return extractExpiration(token).before(new Date());
    }
    public Date extractExpiration (String token){
    return extractClaim (token, Claims::getExpiration);
    }
    public String extractUsername (String jwtToken){
    //subject is the email of the user
    return extractClaim(jwtToken, Claims::getSubject);
    }
    //siginInKey is used to verify the client (algorithn and key)
    private Claims extractAllClaims (String token){
    return Jwts.parserBuilder()
            .setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }
    private Key getSignInKey (){
    byte [] keyBytes = Decoders.BASE64.decode(SECRET);
    return Keys.hmacShaKeyFor(keyBytes);
    }
}
