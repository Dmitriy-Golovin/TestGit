package com.product.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.product.products.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
