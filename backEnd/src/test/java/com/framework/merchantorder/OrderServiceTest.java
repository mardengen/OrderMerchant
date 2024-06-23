package com.framework.merchantorder;


import com.framework.user.dto.OrderDTO;
import com.framework.user.repository.OrderRepository;
import com.framework.user.service.OrderService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.*;

class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    void testCreateOrder() {
        MockitoAnnotations.openMocks(this);

        OrderDTO order = new OrderDTO();
        order.setProductName("Test Product");
        order.setAmount(1.0);

        OngoingStubbing<T> tOngoingStubbing = when(orderRepository.save(order)).thenReturn(order);

        orderService.createOrder(order);

        verify(orderRepository, times(1)).save(order);
    }
}
