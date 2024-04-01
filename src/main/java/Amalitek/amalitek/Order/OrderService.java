/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amalitek.amalitek.Order;

import Amalitek.amalitek.User.User;
import Amalitek.amalitek.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lys
 */
@Service
public interface OrderService {
    public List<OrderResponse> findAllOrders();
    public List<OrderResponse>FindOrderByUser(User user);
    public OrderResponse saveOrder(Order oder)throws Exception ;

  //  t all orders for a specific user.
    //Query to get all products for a specific order
}
