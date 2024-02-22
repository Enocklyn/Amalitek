/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.Product;

import org.springframework.stereotype.Service;

/**
 *
 * @author lys
 */
@Service
public interface ProductService {
    public  Product AddProduct (Product product);
    public  Product EditProduct (Product product);
    public  void DeleteProduct (int productId);
    
}
