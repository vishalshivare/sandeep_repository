package com.example.Exceptions;

@SuppressWarnings("serial")
public class EmployeeListNotFoundException extends Exception {

	public EmployeeListNotFoundException(String message) {
	    System.out.println(message);
	}
	
}
