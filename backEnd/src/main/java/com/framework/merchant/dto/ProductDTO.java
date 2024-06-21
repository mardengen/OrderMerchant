package com.framework.merchant.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private String sku;
    private String name;
    private BigDecimal price;
    private int quantity;

}
