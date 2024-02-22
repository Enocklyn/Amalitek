/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author lys
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
//checking JWT Token
      private final JwtService jwtService;
      private final UserDetailsService userDetailsService;
      
    @Override
    protected void doFilterInternal
        (@NonNull HttpServletRequest request, 
            @NonNull    HttpServletResponse response, 
            @NonNull    FilterChain filterChain) 
                throws ServletException, IOException {
            //class to extract the email
          
            
           final String authHeader = request.getHeader("Authorization");
           final String jwt;final String userEmail;
           if (authHeader==null||authHeader.startsWith("Bearer ")){
           filterChain.doFilter(request, response);
           return;
           }
           jwt = authHeader.substring(7);
          //extract user Email from the JWTService
          userEmail =jwtService.extractUsername(jwt); //
         if (userEmail!=null&&SecurityContextHolder.getContext().getAuthentication()==null ){
             UserDetails userdetails = this.userDetailsService.loadUserByUsername(userEmail);
         if (jwtService.isTokenValid(jwt, userdetails)){
         
             UsernamePasswordAuthenticationToken authToken  =new 
        UsernamePasswordAuthenticationToken(userdetails,null, userdetails.getAuthorities());
             authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
             SecurityContextHolder.getContext().setAuthentication(authToken);
         }
         
         }
         filterChain.doFilter(request, response);
        }
    
    
}
