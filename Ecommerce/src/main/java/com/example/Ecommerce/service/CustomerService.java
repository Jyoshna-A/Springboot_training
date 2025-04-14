package com.example.Ecommerce.service;

import com.example.Ecommerce.entity.Customer;
import com.example.Ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public void customerRegistration(Customer customer) {
        String nextAccNo = generateNextAccountNumber();
        customer.setAccountNumber(nextAccNo);
        customerRepository.save(customer);

    }

    private String generateNextAccountNumber() {
        String lastAccNo = customerRepository.findLastAccountNumber(); // e.g., ACC000025
        int nextNumber = 1;

        if (lastAccNo != null && lastAccNo.startsWith("ACC")) {
            nextNumber = Integer.parseInt(lastAccNo.substring(3)) + 1;
        } else {
            nextNumber = 1;  // For the very first record
        }

        return String.format("ACC%06d", nextNumber); // ACC000001, ACC000002 ...
    }

    public List<Customer> viewAllCustomers() {
        return customerRepository.findAll();
    }
}
