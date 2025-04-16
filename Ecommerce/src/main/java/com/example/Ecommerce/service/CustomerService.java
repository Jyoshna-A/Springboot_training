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
    public String customerRegistration(Customer customer) {
        String nextAccNo = generateNextAccountNumber();
        customer.setAccountNumber(nextAccNo);
        customerRepository.save(customer);
        return "Account created and AccountId is "+nextAccNo;

    }

    private String generateNextAccountNumber() {
        String lastAccNo = customerRepository.findLastAccountNumber();
        int nextNumber = 1;

        if (lastAccNo != null && lastAccNo.startsWith("ACC")) {
            nextNumber = Integer.parseInt(lastAccNo.substring(3)) + 1;
        } else {
            nextNumber = 1;
        }

        return String.format("ACC%06d", nextNumber);
    }

    public List<Customer> viewAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer  getCustomerById(String accountId) {
        return customerRepository.findById(accountId).orElse(null);
    }

    public String deleteCustomerById(String accId)
    {
        if(getCustomerById(accId)!=null) {
            customerRepository.deleteById(accId);
            return "Successfully deleted";
        }
        else
        {
            return "customerId not found";
        }
    }

    public String updateCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getAccountNumber())) {
            customerRepository.save(customer);
            return "Customer details updated";
        } else {
            return "Customer not found";
        }
    }

}
