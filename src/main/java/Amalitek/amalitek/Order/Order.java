/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.Order;

import Amalitek.amalitek.ProductLine.ProductLine;
import Amalitek.amalitek.User.User;


import jakarta.persistence.*;

import java.util.List;


/**
 *
 * @author lys
 */
@Entity
@Table(name = "_Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany(mappedBy="order")
    private List<ProductLine>productLine;
    @ManyToOne
    private User user;

    public List<ProductLine> getProductLine() {
        return productLine;
    }

    public void setProductLine(List<ProductLine> productLine) {
        this.productLine = productLine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
