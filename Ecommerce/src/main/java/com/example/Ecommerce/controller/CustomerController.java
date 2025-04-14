package com.example.Ecommerce.controller;

import com.example.Ecommerce.entity.Customer;
import com.example.Ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("allCustomers")
    public List<Customer> viewCustomers()
    {
        return customerService.viewAllCustomers();

    }
    @PostMapping("customerRegistration")
    public String customerRegistration(@RequestBody Customer customer) {
        try {
            System.out.println("Received Customer: " + customer);
            customerService.customerRegistration(customer);
            return "Customer Added Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while registering the customer.";
        }
    }

}
