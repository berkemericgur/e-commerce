package com.bmg.ecommercedemo.dataaccess.abstracts;

import com.bmg.ecommercedemo.entity.Order;
import com.bmg.ecommercedemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
    List<Order> findByOrderDate(LocalDateTime orderDate);
    Order getOrderById(long id);
    Order deleteOrderById(long id);
}
