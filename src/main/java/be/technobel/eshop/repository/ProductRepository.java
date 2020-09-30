package be.technobel.eshop.repository;

import be.technobel.eshop.model.entity.Order;
import be.technobel.eshop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
