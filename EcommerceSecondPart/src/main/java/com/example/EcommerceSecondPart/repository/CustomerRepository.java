package com.example.EcommerceSecondPart.repository;

import com.example.EcommerceSecondPart.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
