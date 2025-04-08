package com.example.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {
	// Field injection
	
	@Autowired
	@Qualifier("desktop")
	Computer com;  //It is instance variable,by default null value is stored
	
	//Constructor Injection
	
	//@Autowired
	/*
	public Dev(Computer com)
	{
		this.com=com;
	}
	*/
	
	//Setter Injection
	/*
	
	@Autowired
	public void setDev(Computer com)
	{
		this.com=com;
	}
	*/
	public void build()
	
	{
		com.compile();
		System.out.println("The System is working");
	}

}
