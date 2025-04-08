package com.example.myApp;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
	
	public void compile()
	{
		System.out.println("We have compiled\n");
	}

}
