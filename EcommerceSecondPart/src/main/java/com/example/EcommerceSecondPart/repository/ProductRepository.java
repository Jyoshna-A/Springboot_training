package com.example.EcommerceSecondPart.repository;

import com.example.EcommerceSecondPart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
