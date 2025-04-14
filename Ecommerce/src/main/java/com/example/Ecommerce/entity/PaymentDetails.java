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
@Table(name="J_PaymentDetails")
public class PaymentDetails {
    private String paymentMethod;
    @Id
    private long cardNumber;
    private String status;

}
