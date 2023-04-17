package com.product.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.products.models.Product;
import com.product.products.repositories.ProductRepository;

@Service
@Transactional(readOnly = true)
public class ProductService {
    
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProductId(int id) {
        Optional<Product> optionalUser = productRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Transactional
    public void productAdd(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void productEdit(int id, Product product) {
        product.setId(id);
        productRepository.save(product);
    }
    
    @Transactional
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
