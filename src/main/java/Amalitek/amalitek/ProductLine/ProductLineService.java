package Amalitek.amalitek.ProductLine;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductLineService {
    public ProductLine saveProductLine(ProductLine productLine);
    public ProductLine EditProductLine(ProductLine productLine);

    public List<ProductLine> productLines();
}
