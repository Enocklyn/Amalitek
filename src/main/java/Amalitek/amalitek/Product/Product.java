/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.Product;

import Amalitek.amalitek.ProductLine.ProductLine;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;




/**Product: { id, name, stock, price }
 *
 * @author lys
 */
@Entity
@Table(name = "_Product")
public class Product {
    @Id
    private int Id;
    private String name;
    private int stock;
    private float price;
   @OneToMany(mappedBy="product")
   private List<ProductLine>productlines;

    public List<ProductLine> getProductlines() {
        return productlines;
    }
    private boolean Active;

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean Active) {
        this.Active = Active;
    }
    
    public void setProductlines(List<ProductLine> productlines) {
        this.productlines = productlines;
    }
   
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
}
