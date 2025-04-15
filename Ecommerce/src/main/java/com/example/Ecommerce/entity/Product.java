package com.example.Ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CJ_product_details")
public class Product {
    @Id
    private String productId;
    private String productName;
    private String category;
    private float pricePerQuantity;
    private int stock;

}
