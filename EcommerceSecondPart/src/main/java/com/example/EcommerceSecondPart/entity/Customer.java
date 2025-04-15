package com.example.EcommerceSecondPart.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CJ_Customers")
@Getter
@Setter
public class Customer{

    @Id
    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @OneToOne
    @JoinColumn(name = "card_number", referencedColumnName = "card_number", insertable = false, updatable = false)
    private PaymentDetails paymentDetails;
}
