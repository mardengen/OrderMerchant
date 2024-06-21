package com.framework.merchant.controller;

import com.framework.merchant.dto.ProductDTO;
import com.framework.merchant.entity.Product;
import com.framework.merchant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDTO productDTO) {
        Product product = new Product();
        product.setSku(productDTO.getSku());
        product.setName(productDTO.getName());
        product.setPrice(Double.valueOf(productDTO.getPrice().toString()));
        product.setQuantity(productDTO.getQuantity());
        productService.addProduct(product);
        return ResponseEntity.ok().build();
    }
}
