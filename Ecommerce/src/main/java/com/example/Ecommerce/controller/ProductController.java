package com.example.Ecommerce.controller;

import com.example.Ecommerce.entity.Customer;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("allProducts")
    public List<Product> viewProducts()
    {
        return productService.viewAllProducts();

    }
    @GetMapping("findByCategory")
    public List<String> viewProductCategories()
    {
        return productService.viewProductCategories();
    }
    @PostMapping("productRegistration")
    public String customerRegistration(@RequestBody Product product) {
        try {
            System.out.println("Received Product: " + product);
            return productService.productRegistration(product);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while registering the product.";
        }
    }

}
