package com.example.awesome_piazza;

import com.example.awesome_piazza.model.Order;
import com.example.awesome_piazza.model.OrderStatus;
import com.example.awesome_piazza.repository.OrderRepository;
import com.example.awesome_piazza.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setPizzaType("Margherita");
        order.setQuantity(1);
        order.setStatus(OrderStatus.ORDERED);

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order createdOrder = orderService.createOrder("Margherita", 1);
        assertEquals("Margherita", createdOrder.getPizzaType());
        assertEquals(1, createdOrder.getQuantity());
        assertEquals(OrderStatus.ORDERED, createdOrder.getStatus());
    }

    @Test
    public void testUpdateOrderStatus() {
        Order order = new Order();
        order.setPizzaType("Margherita");
        order.setQuantity(1);
        order.setStatus(OrderStatus.ORDERED);

        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));

        Order updatedOrder = orderService.updateOrderStatus(1L, OrderStatus.IN_PROGRESS);
        assertEquals(OrderStatus.IN_PROGRESS, updatedOrder.getStatus());
    }
}