package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
    @Query(nativeQuery = true, value = "SELECT account_number FROM CJ_customers WHERE account_number = ?1 LIMIT 1")
    String findAccountNumber(String account_id);
    @Query(nativeQuery = true, value = "SELECT product_id FROM CJ_product_details WHERE product_id = ?1 LIMIT 1")
    String findProductNumber(String product_id);
    @Query(nativeQuery = true,value="SELECT order_id from cj_order_details Order By order_id DESC LIMIT 1")
    String findLastOrderNumber();
    @Query(nativeQuery = true,value = "SELECT PRICE FROM cj_product_details where product_id=?1 LIMIT 1 ")
    Float findProductPrice(String product_id);
}
