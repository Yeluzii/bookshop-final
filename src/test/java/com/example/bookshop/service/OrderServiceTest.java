package com.example.bookshop.service;

import com.example.bookshop.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Slf4j
class OrderServiceTest {
    OrderService service = new OrderService();

    @Test
    void addOrder() throws SQLException {
        Order order = new Order();
        order.setStatus(4);
        order.setDatetime(LocalDateTime.now());
        order.setUser(new UserService().login("admin", "admin"));
        service.addOrder(order);
    }

    @Test
    void selectAll() {
        service.selectAll(1).forEach(System.out::println);
    }

    @Test
    void getOrderPage() {
        log.info(service.getOrderPage(2, 2).toString());
    }

    @Test
    void updateStatus() {
        service.updateStatus(20,1);
    }

    @Test
    void delete() {
        service.delete(21);
    }
}