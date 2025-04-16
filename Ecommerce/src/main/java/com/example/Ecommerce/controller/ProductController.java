package com.example.Ecommerce.controller;

import com.example.Ecommerce.entity.Customer;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("allProducts")
    public ResponseEntity<List<Product>> viewProducts()
    {
        return new ResponseEntity<>(productService.viewAllProducts(),HttpStatus.OK);

    }
    @GetMapping("findByCategory")
    public ResponseEntity<List<String>> viewProductCategories()
    {
        return new ResponseEntity<>(productService.viewProductCategories(),HttpStatus.FOUND);
    }
    @PostMapping("productRegistration")
    public ResponseEntity<String> customerRegistration(@RequestBody Product product) {
        try {
            System.out.println("Received Product: " + product);
            return new ResponseEntity<>(productService.productRegistration(product),HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("updateProduct")
   public Product updateProductStock(@Param("productId") String productId, @Param("stock") int stock)
    {
        return productService.updateProductStock(productId,stock);
    }
}
