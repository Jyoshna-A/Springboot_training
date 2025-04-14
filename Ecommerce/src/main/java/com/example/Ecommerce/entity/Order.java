package com.example.Ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="J_OrderDetails")
public class Order {
    @Id
    private String orderId;
    private String accountNumber;
    private String productId;
    private int quantity;
    private float price;
    @Value("New")
    private String status;
}
