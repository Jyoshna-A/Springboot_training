package com.example.EcommerceSecondPart.service;

import com.example.EcommerceSecondPart.entity.Customer;
import com.example.EcommerceSecondPart.entity.Order;
import com.example.EcommerceSecondPart.entity.Product;
import com.example.EcommerceSecondPart.repository.CustomerRepository;
import com.example.EcommerceSecondPart.repository.OrderRepository;
import com.example.EcommerceSecondPart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class OrderProcessingService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);


    private final ConcurrentHashMap<String, Object> productLocks = new ConcurrentHashMap<>();


    @Scheduled(fixedDelay = 10000)
    public void fetchAndProcessNewOrders() {
        List<Order> newOrders = orderRepository.findByStatus("New");

        for (Order order : newOrders) {
            executorService.submit(() -> processOrder(order));
        }
    }

    
    public void processOrder(Order order) {
        try {

            Object lock = productLocks.computeIfAbsent(order.getProductId(), k -> new Object());

            synchronized (lock) {

                Product product = productRepository.findById(order.getProductId()).orElse(null);
                if (product == null) {
                    updateOrderStatus(order, "Failed - Product Not Found");
                    return;
                }


                if (product.getStock() < order.getQuantity()) {
                    updateOrderStatus(order, "Failed - Not Enough Stock");
                    return;
                }


                product.setStock(product.getStock() - order.getQuantity());
                productRepository.save(product);


                Customer customer = customerRepository.findById(order.getAccountNumber()).orElse(null);
                if (customer == null || customer.getPaymentDetails() == null ||
                        !"active".equalsIgnoreCase(customer.getPaymentDetails().getStatus())) {
                    updateOrderStatus(order, "Failed - Invalid Payment Method");
                    return;
                }

                float total = product.getPricePerQuantity() * order.getQuantity();
                order.setPrice(total);
                order.setStatus("Success");
                orderRepository.save(order);

                System.out.println("Order " + order.getOrderId() + " processed successfully!");
            }

        } catch (Exception e) {
            updateOrderStatus(order, "Failed - " + e.getMessage());
        }
    }

    public void updateOrderStatus(Order order, String status) {
        order.setStatus(status);
        orderRepository.save(order);
    }
}
