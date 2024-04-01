package Amalitek.amalitek.Order;

import Amalitek.amalitek.ProductLine.ProductLine;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OrderResponse {
    private int id;
    private  List<ProductLine>productLine;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductLine> getProductLine() {
        return productLine;
    }

    public void setProductLine(List<ProductLine> productLine) {
        this.productLine = productLine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.productLine = order.getProductLine();
        this.email = order.getUser().getEmail();
    }

    public OrderResponse() {
    }
    
    
}
