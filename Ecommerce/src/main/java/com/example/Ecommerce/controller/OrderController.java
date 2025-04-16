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
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody Order order)
    {

        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }
    @GetMapping("/allOrders")
    public ResponseEntity<List<Order>> getAllOrders()
    {

        return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.FOUND);
    }
    @GetMapping("/deleteOrders")
    public ResponseEntity<Boolean> deleteAllOrders() {
        boolean result = orderService.deleteAllOrders();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }




}
