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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;




/**Product: { id, name, stock, price }
 *
 * @author lys
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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


    private boolean Active;


    public Product(int Id) {
        this.Id=Id;
    }
}
