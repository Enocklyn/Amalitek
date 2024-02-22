/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.Security;

import Amalitek.amalitek.User.Role;
import Amalitek.amalitek.User.User;
import Amalitek.amalitek.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author lys
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repos;
    private final PasswordEncoder passwordEncorder;
    private final JwtService jwtService;   
    private final AuthenticationManager authenticationManger;
    public AuthenticationResponse register (RegisterResquest request){
    var  user = User.
            builder()
            .email(request
                    .getEmail())
            .password(
                   
                    passwordEncorder
                            .encode(
           request
                                    .getPassword()))
            .role(Role.USER).build();
    System.out.println(user.toString());
user = repos.save(user);
    var jwtToken = jwtService.generateToken(user);
   
    return
            AuthenticationResponse
                    .builder()
                    .token 
        (jwtToken).build();
    
    }
    
   public AuthenticationResponse 
        authentication 
        (RegisterResquest
                request){
        authenticationManger.authenticate
        (new UsernamePasswordAuthenticationToken
        (request.getEmail(), 
                request.getPassword()));
        
         var  user = repos.findByEmail(request.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
   
    return
            AuthenticationResponse
                    .builder()
                    .token 
        (jwtToken).build();
    
    }
   
        }
        


