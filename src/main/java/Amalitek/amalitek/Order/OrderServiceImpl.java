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
public class OrderServiceImpl implements  OrderService{
    private final OrderRepository repo;
    private final UserService us;
    public List<OrderResponse> findAllOrders(){
        try{
            List<OrderResponse> responses =new ArrayList<>();
            repo.findAll().forEach(c->{
            responses.add(new OrderResponse(c));
            });
            return responses;

        }catch (Exception ex){
            return new ArrayList<>();

        }

    }
    public List<OrderResponse>FindOrderByUser(User user){
        try{
 List<OrderResponse> responses =new ArrayList<>();
           us.FindUserById(user).orElseThrow().getOrders().forEach(c->{
            responses.add(new OrderResponse(c));
            });
            return responses;
         
            
        }catch (Exception ex){
            return null;
        }

    }

    @Override
    public OrderResponse saveOrder(Order order)throws Exception {
      
        return new OrderResponse(repo.save(order));
       
        }
}
