package Amalitek.amalitek.RestController;


import Amalitek.amalitek.Order.Order;
import Amalitek.amalitek.Order.OrderService;
import Amalitek.amalitek.Product.ProductService;
import Amalitek.amalitek.ProductLine.ProductLineService;
import Amalitek.amalitek.Security.AuthenticationResponse;
import Amalitek.amalitek.Security.RegisterResquest;
import Amalitek.amalitek.User.User;
import Amalitek.amalitek.User.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class APICOntroller {
 private ProductLineService PLS;
 private ProductService PS;
 private OrderService OS;
 private UserService US;

    @PostMapping("/CreateOrder")
    public ResponseEntity<Order>CreateOrder
            (Principal p,@RequestBody Order order){
         try{

             return ResponseEntity.ok(OS.saveOrder(order));
         }catch (Exception ex){
         return ResponseEntity.ok(null);

         }
    }
}
