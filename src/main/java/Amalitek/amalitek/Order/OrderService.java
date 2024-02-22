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
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repo;
    private UserService us;
    public List<Order> findAllOrders(){
        try{
            return repo.findAll();

        }catch (Exception ex){
         return new ArrayList<>();

        }

    }
    public List<Order>FindOrderByUser(User user){
   try{

       return us.FindUserById(user).orElseThrow().getOrders();
   }catch (Exception ex){
    return null;
   }

    }
}
