/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.RestController;

import Amalitek.amalitek.Security.AuthenticationResponse;
import Amalitek.amalitek.Security.AuthenticationService;
import Amalitek.amalitek.Security.RegisterResquest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lys
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
 @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>
        registerData (@RequestBody RegisterResquest request ){
     return ResponseEntity.ok(authenticationService.register(request));
     
    }
        @PostMapping("/validateToken")
        public ResponseEntity<AuthenticationResponse>register 
        (@RequestBody RegisterResquest request){
       return ResponseEntity.ok(authenticationService.authentication(request));
        }
}
