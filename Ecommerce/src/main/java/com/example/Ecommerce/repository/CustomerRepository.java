package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    @Query(value = "SELECT account_number FROM CJ_Customers ORDER BY account_number DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
    String findLastAccountNumber();

}
