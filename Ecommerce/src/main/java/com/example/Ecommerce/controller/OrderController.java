package com.example.Ecommerce.controller;

import com.example.Ecommerce.entity.Order;
import com.example.Ecommerce.service.OrderService;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody Order order)
    {
        return orderService.createOrder(order);
    }




}
