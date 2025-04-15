package com.example.EcommerceSecondPart.repository;

import com.example.EcommerceSecondPart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
    List<Order> findByStatus(String status);
}
