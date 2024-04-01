package Amalitek.amalitek.ProductLine;

import Amalitek.amalitek.Order.Order;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProductLineResponse {

    private int id;


    private int quantity;
    private int stock;
    private float price;


}
