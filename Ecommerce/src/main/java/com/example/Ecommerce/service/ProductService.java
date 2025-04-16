package com.example.Ecommerce.service;

import com.example.Ecommerce.entity.Customer;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> viewAllProducts() {
        return productRepository.findAll();

    }




    public String productRegistration(Product product) {
        String nextProNo = generateNextProductNumber();
        product.setProductId(nextProNo);
        productRepository.save(product);
        return "Product Added Successfully and ProductId "+nextProNo;

    }

    private String generateNextProductNumber() {
        String lastProNo = productRepository.findLastProductNumber();
        int nextNumber = 1;

        if (lastProNo != null && lastProNo.startsWith("PID")) {
            nextNumber = Integer.parseInt(lastProNo.substring(3)) + 1;
        } else {
            nextNumber = 1;
        }

        return String.format("PID%06d", nextNumber);
    }

    public List<String> viewProductCategories() {
        return productRepository.findAllCategories();
    }

    public Product updateProductStock(String productId, int stock) {
        Product product = productRepository.getReferenceById(productId);
        product.setStock(stock);
        return productRepository.save(product); // Persist changes
    }

}
