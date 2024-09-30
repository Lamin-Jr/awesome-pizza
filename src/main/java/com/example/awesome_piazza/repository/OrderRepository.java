package com.example.awesome_piazza.repository;

import com.example.awesome_piazza.model.Order;
import com.example.awesome_piazza.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(OrderStatus status);
}