package Amalitek.amalitek.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReporitory extends JpaRepository<Product, Integer> {
}
