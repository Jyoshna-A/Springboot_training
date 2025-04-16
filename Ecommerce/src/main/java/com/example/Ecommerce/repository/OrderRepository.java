package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @Query(nativeQuery = true, value = "SELECT account_number FROM CJ_customers WHERE account_number = ?1 FETCH FIRST 1 ROWS ONLY")
    String findAccountNumber(String account_id);

    @Query(nativeQuery = true, value = "SELECT product_id FROM CJ_product_details WHERE product_id = ?1 FETCH FIRST 1 ROWS ONLY")
    String findProductNumber(String product_id);

    @Query(nativeQuery = true, value = "SELECT order_id FROM cj_order_details ORDER BY order_id DESC FETCH FIRST 1 ROWS ONLY")
    String findLastOrderNumber();

    @Query(nativeQuery = true, value = "SELECT price FROM cj_product_details WHERE product_id = ?1 FETCH FIRST 1 ROWS ONLY")
    Float findProductPrice(String product_id);
}
