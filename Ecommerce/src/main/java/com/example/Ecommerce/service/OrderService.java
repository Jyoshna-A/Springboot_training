package com.example.Ecommerce.service;

import com.example.Ecommerce.entity.Order;
import com.example.Ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public String createOrder(Order order) {

        if(orderRepository.findAccountNumber(order.getAccountNumber())!=null) {
            if(orderRepository.findProductNumber(order.getProductId())!=null) {
                String generatedOrderId=generateOrderId();
                order.setOrderId(generatedOrderId);
                System.out.println("Account: " + order.getAccountNumber());
                System.out.println("Product: " + order.getProductId());
                System.out.println("Account Exists: " + orderRepository.findAccountNumber(order.getAccountNumber()));
                System.out.println("Product Exists: " + orderRepository.findProductNumber(order.getProductId()));

                orderRepository.save(order);
                return "Order Placed and the order Number is "+generatedOrderId;
            }
            else {
                return "Invalid ProductId";
            }
        }
        else {
            return "Invalid AccountId";

        }


    }


    private String generateOrderId() {
        String lastAccNo = orderRepository.findLastOrderNumber();
        int nextNumber = 1;

        if (lastAccNo != null && lastAccNo.startsWith("OID")) {
            nextNumber = Integer.parseInt(lastAccNo.substring(3)) + 1;
        } else {
            nextNumber = 1;
        }

        return String.format("OID%06d", nextNumber);
    }
}
