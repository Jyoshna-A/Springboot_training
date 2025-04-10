package com.example.FirstApiApplication.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public MyService() {
        System.out.println("Hello Service");
    }
    public String greet()
    {
        return "Hello from service";
    }
}
