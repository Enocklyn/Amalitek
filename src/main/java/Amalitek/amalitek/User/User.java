/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.User;

import Amalitek.amalitek.Order.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author lys
 */
 @Data
 @Builder
 @NoArgsConstructor
 @AllArgsConstructor
 @Entity
 @Table(name = "_user")
public class User implements UserDetails{
    @Id
    @GeneratedValue
 private int Id;   
    private String email;
    private String password ;



    @Enumerated(EnumType.STRING)
     private Role role;
     
    @OneToMany
    private List<Order>orders;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
  
    @Override
    public String getUsername() {
     return email;
    }
 @Override
    public String getPassword() {
     return password;
    }
    @Override
    public boolean isAccountNonExpired() {
  return true;  }

    @Override
    public boolean isAccountNonLocked() {
  return true;  }

    @Override
    public boolean isCredentialsNonExpired() {
  return true;  }

    @Override
    public boolean isEnabled() {
  return true;  }
    
}
