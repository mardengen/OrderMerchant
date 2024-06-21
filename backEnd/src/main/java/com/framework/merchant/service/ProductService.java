package com.framework.merchant.service;

import com.framework.merchant.entity.Product;
import com.framework.merchant.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow();
        existingProduct.setQuantity(product.getQuantity());
        productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
