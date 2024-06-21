package com.framework.user.service;

import com.framework.user.dto.MemberDTO;
import com.framework.user.dto.OrderDTO;
import com.framework.user.dto.OrderSearchCriteria;
import com.framework.user.entity.Member;
import com.framework.user.entity.Order;
import com.framework.user.repository.MemberRepository;
import com.framework.user.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *@author: Joshma
 *@date: 2024-06-12
 *@desc:
 */

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MemberRepository memberRepository;

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = new Order();
//        order.setMemberId(orderDTO.getMemberId());
        order.setProductName(orderDTO.getProductName());
        order.setPurchaseDate(orderDTO.getPurchaseDate());
        return convertToDto(orderRepository.save(order));
    }

    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
//        order.setMemberId(orderDTO.getMemberId());
        order.setProductName(orderDTO.getProductName());
        order.setPurchaseDate(orderDTO.getPurchaseDate());
        return convertToDto(orderRepository.save(order));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return convertToDto(order);
    }

    public List<OrderDTO> searchOrders(OrderSearchCriteria criteria, int page, int size) {
        return orderRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<MemberDTO> getMembersWithOrderCountGreaterThan(int n) {
        return memberRepository.findMembersWithOrderCountGreaterThan(n)
                .stream()
                .map(this::convertToMemberDto)
                .collect(Collectors.toList());
    }

    private OrderDTO convertToDto(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
//        dto.setMemberId(order.getMemberId());
        dto.setProductName(order.getProductName());
        dto.setPurchaseDate(order.getPurchaseDate());
        return dto;
    }

    private MemberDTO convertToMemberDto(Member member) {
        MemberDTO dto = new MemberDTO();
        dto.setId(member.getId());
        dto.setName(member.getName());
        dto.setEmail(member.getEmail());
        return dto;
    }
}
