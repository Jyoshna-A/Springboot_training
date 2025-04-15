package com.example.EcommerceSecondPart.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CJ_Order_details")
@Getter
@Setter
public class Order {

    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private float price;

    @Column(name = "status")
    private String status;
}