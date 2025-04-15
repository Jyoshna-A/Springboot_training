package com.example.EcommerceSecondPart.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CJ_payment_details")
@Getter
@Setter
public class PaymentDetails {

    @Id
    @Column(name = "card_number")
    private Long cardNumber;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "status")
    private String status;
}
