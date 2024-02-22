package Amalitek.amalitek.ProductLine;

import Amalitek.amalitek.Product.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductLineServiceImpl implements ProductLineService{
  private  final ProductLineRepository PLR;
    @Override
    public ProductLine saveProductLine(ProductLine productLine) {
       try{
           return PLR.save(productLine);

       } catch (Exception ex){
    return null;

       }
    }

    @Override
    public ProductLine EditProductLine(ProductLine productLine) {
       try{
           if (PLR.findById(productLine.getId()).isPresent()){
               return PLR.save(productLine);

           }else{

               return null;
           }

       }catch (Exception ex){
       System.out.println(ex.toString());
           return null;
       }
    }

    @Override
    public List<ProductLine> productLines() {
        return null;
    }
}
