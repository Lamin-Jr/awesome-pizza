package com.example.awesome_piazza.controller;

import com.example.awesome_piazza.model.Order;
import com.example.awesome_piazza.model.OrderStatus;
import com.example.awesome_piazza.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestParam String pizzaType, @RequestParam int quantity) {
        return orderService.createOrder(pizzaType, quantity);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public List<Order> getOrdersByStatus(@RequestParam OrderStatus status) {
        return orderService.getOrdersByStatus(status);
    }

    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
        return orderService.updateOrderStatus(id, status);
    }
}