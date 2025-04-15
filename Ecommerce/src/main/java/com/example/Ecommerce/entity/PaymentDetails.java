package com.example.Ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CJ_payment_details")
public class PaymentDetails {
    private String paymentMethod;
    @Id
    private long cardNumber;
    private String status;

}
