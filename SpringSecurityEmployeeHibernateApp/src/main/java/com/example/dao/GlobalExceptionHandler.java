package com.example.dao;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exceptions.EmployeeListNotFoundException;
import com.example.Exceptions.EmployeeNotFoundException;
import com.example.Exceptions.OtherException;
import com.example.Exceptions.StorageFailedException;
import com.example.Exceptions.UpdationFailedException;



@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	private static final Logger logger=Logger.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public String handleValidation(MethodArgumentNotValidException exception) {
		logger.error(exception.getMessage(),exception);
		return exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
	
	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Employee does not exist in System")
	@ExceptionHandler
	public String handleEmployeeNotFoundException(EmployeeNotFoundException exception){
		logger.error(exception.getMessage(), exception);
		return exception.getMessage();

	}
	
	@ResponseStatus(value=HttpStatus.NO_CONTENT,reason="Employee List is not Available in System")
	@ExceptionHandler
	public void handleEmployeeListNotFoundException(EmployeeListNotFoundException exception1)
	{
	   logger.error(exception1, exception1);
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Error due to Bad Request")
	@ExceptionHandler
	public void handleOtherException(OtherException exception)
	{
		logger.error(exception.getMessage(), exception);
	}
	
	@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED,reason="Employee Data Storage Failed")
	@ExceptionHandler
	public void handleStorageFailedException(StorageFailedException exception){
		logger.error(exception.getMessage(), exception);
	}
	
	@ResponseStatus(value=HttpStatus.NOT_MODIFIED,reason="Employee Data Storage Failed")
	@ExceptionHandler
	public void handleUpdationFailedException(UpdationFailedException exception){
		
	}
}
