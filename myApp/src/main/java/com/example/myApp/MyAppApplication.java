package com.example.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		ApplicationContext a=SpringApplication.run(MyAppApplication.class, args); //This will return an object of type ApplicationContext
	
		Dev dev=a.getBean(Dev.class);
		dev.build();
	}
	
	

}
