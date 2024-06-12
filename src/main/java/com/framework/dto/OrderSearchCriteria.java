package com.framework.dto;

import lombok.Data;

/**
 *@author: Joshma
 *@date: 2024-06-12
 *@desc:
 */

@Data
public class OrderSearchCriteria {
    private String orderNumber;
    private String productName;
    private String orderDate;
}
