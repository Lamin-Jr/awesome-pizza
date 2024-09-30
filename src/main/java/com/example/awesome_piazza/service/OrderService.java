package com.example.awesome_piazza.service;

import com.example.awesome_piazza.exception.OrderNotFoundException;
import com.example.awesome_piazza.model.Order;
import com.example.awesome_piazza.model.OrderStatus;
import com.example.awesome_piazza.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(String pizzaType, int quantity) {
        Order order = new Order();
        order.setPizzaType(pizzaType);
        order.setQuantity(quantity);
        order.setStatus(OrderStatus.ORDERED);
        order.setOrderTime(LocalDateTime.now());

        System.out.print("New createOrder " );
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    public Order updateOrderStatus(Long id, OrderStatus newStatus) {
        System.out.println("New Status " + newStatus);
        Order order = getOrderById(id);
        order.setStatus(newStatus);
        return orderRepository.save(order);
    }
}