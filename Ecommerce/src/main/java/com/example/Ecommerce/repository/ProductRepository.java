package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


    @Query(value = "SELECT product_Id FROM CJ_Product_Details ORDER BY product_Id DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
    String findLastProductNumber();


    @Query(value = "SELECT DISTINCT category FROM CJ_Product_Details", nativeQuery = true)
    List<String> findAllCategories();
}
