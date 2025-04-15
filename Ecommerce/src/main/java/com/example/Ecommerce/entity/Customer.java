package com.example.Ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CJ_customers")
public class Customer {
    @Id
    private String accountNumber;
    private String firstName;
    private String lastname;
    private String mobileNumber;
    private String emailId;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_number") // Foreign key column in Customer table
    private PaymentDetails method;
}
