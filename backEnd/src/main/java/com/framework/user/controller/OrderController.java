package com.framework.user.controller;

import com.framework.user.dto.MemberDTO;
import com.framework.user.dto.OrderDTO;
import com.framework.user.dto.OrderSearchCriteria;
import com.framework.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *@author: Joshma
 *@date: 2024-06-12
 *@desc:
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.updateOrder(id, orderDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<OrderDTO>> searchOrders(OrderSearchCriteria criteria, @RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(orderService.searchOrders(criteria, page, size));
    }

    @GetMapping("/stats")
    public ResponseEntity<List<MemberDTO>> getMembersWithOrderCountGreaterThan(@RequestParam int n) {
        return ResponseEntity.ok(orderService.getMembersWithOrderCountGreaterThan(n));
    }
}
