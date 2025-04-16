package com.example.Ecommerce.controller;

import com.example.Ecommerce.entity.Customer;
import com.example.Ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("allCustomers")
    public ResponseEntity<List<Customer>> viewCustomers()
    {
        return new ResponseEntity<>(customerService.viewAllCustomers(),HttpStatus.OK);

    }

    @PostMapping("customerRegistration")
    public ResponseEntity<String> customerRegistration(@RequestBody Customer customer) {
        try {
            System.out.println("Received Customer: " + customer);
            return new ResponseEntity<>(customerService.customerRegistration(customer),HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/getCustomerById/{accountId}")
    public ResponseEntity<Customer> getcustomerById(@PathVariable String accountId) {
        Customer customer = customerService.getCustomerById(accountId);
        if (customer != null) {
            return new ResponseEntity<>(customerService.getCustomerById(accountId), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteCustomerById/{accountId}")
    public ResponseEntity<String> deletecustomerById(@PathVariable String accountId)
    {
            return new ResponseEntity<>(customerService.deleteCustomerById(accountId), HttpStatus.OK);

    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        String result = customerService.updateCustomer(customer);

        if (result.equals("Customer details updated")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }



}
