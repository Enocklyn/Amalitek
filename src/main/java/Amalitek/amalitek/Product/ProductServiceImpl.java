package Amalitek.amalitek.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
private final ProductRepository Pr;
    @Override
    public Product CreateProduct(Product product) {
    try{
     return   Pr.save(product);
    }catch (Exception ex){
      return null;

    }

    }

    @Override
    public Product EditProduct(Product product) {
       try{

       }catch (Exception ex){

       }
    }

    @Override
    public void DeleteProduct(int productId) {

    }

    @Override
    public Optional<Product> FindProduct(int ProductId) {
        return Optional.empty();
    }
}
