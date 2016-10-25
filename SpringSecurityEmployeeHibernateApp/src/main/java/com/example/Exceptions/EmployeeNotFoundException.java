package com.example.Exceptions;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception {

	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
}
