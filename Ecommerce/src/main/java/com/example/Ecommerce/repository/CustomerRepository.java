package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    @Query(value = "SELECT account_number FROM j_customer_details ORDER BY account_number DESC LIMIT 1", nativeQuery = true)
    String findLastAccountNumber();

}
