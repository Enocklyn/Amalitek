/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.Product;

import Amalitek.amalitek.Order.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author lys
 */
@Service
public interface ProductService {
    public  Product CreateProduct (Product product);
    public  Product EditProduct (Product product);
    public  void DeleteProduct (int productId);
    public Optional<Product> FindProduct (int ProductId);
//    Query to get all products for a specific order
    public List<Product> product(Order order);
}
