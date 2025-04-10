package com.example.FirstApiApplication.controller;

import com.example.FirstApiApplication.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

    public Mycontroller()
    {
        System.out.println("controller constructor called");
    }
    @Autowired
    MyService service;

    @GetMapping("/")
    public String  greet()
    {
        return service.greet();
    }
    @GetMapping("/login")
    public String login()
    {
        return "logged in";
    }
}
