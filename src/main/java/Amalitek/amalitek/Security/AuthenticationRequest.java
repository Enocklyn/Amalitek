/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.Security;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * @author lys
 */
@Component
@Data
public class AuthenticationRequest {
    private String Email;
    private String Password;
}
