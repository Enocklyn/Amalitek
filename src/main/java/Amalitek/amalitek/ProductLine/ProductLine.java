/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.ProductLine;

import Amalitek.amalitek.Order.Order;
import Amalitek.amalitek.Product.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author lys
 */
@Entity
 @Table(name = "_ProductLine")
public class ProductLine {
   @Id
   private int id;
   @ManyToOne
   private Product product;
   @ManyToOne
   private Order order;
   private int quantity;
   private int stock;
   private float price;

    public Order getOder() {
        return order;
    }

    public void setOder(Order oder) {
        this.order = oder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductLine(int id, int quantity, int stock, float price) {
        this.id = id;
        this.quantity = quantity;
        this.stock = stock;
        this.price = price;
    }

    public ProductLine() {
        this.id = id;
    }
}
