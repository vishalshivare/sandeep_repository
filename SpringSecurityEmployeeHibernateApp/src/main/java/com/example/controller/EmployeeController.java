package com.example.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exceptions.EmployeeNotFoundException;
import com.example.Exceptions.OtherException;
import com.example.Exceptions.UpdationFailedException;
import com.example.pojo.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService service;
	
	private static final Logger logger=Logger.getLogger(EmployeeController.class); 
	
	@RequestMapping(value="/emp/{id}",produces="application/JSON",method=RequestMethod.GET)
	public ResponseEntity<?> getEmployeeById(@PathVariable int id) throws SQLException, EmployeeNotFoundException 
	{
		if(service.getEmployeeById(id)==null)
		{
			logger.info("In Log Info EmployeeController:Not Successfully in getEmployeeById");
			/*return new ResponseEntity<String>("Required Data is Not Found", HttpStatus.NOT_FOUND);*/
			throw new EmployeeNotFoundException("Employee Record is not Found in System");
		}
		else
		{
			logger.info("In Log Info EmployeeController: Successfully in getEmployeeById");
			return new ResponseEntity<Employee>(service.getEmployeeById(id), HttpStatus.OK);
			
		}
		
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.POST,produces="application/JSON",consumes="application/JSON")
	public  ResponseEntity<String> StoreEmployee(@Valid @RequestBody Employee employee) throws OtherException, SQLException 
	{
			String obj=service.storeEmployee(employee);
			if(obj==null)
			{
				logger.info("In Log Info EmployeeController: Successfully in StoreEmployee");
				/*return new ResponseEntity<String>("Please try Again", HttpStatus.NOT_FOUND);*/
				throw new OtherException("Employee Record Failed to Store ");
		
				}
			else
			{	
				logger.info("In Log Info EmployeeController:Not Successfully in StoreEmployee");
			return new ResponseEntity<String>(obj, HttpStatus.OK);
		}
			}
	
	@RequestMapping(value="/emp/{id}",produces="application/JSON",method=RequestMethod.DELETE)
	public ResponseEntity<String> DeleteEmployeeById(@PathVariable int id) throws EmployeeNotFoundException, SQLException 
	{
		String deleteEmployee=service.deleteEmployeeById(id);
		if(service.deleteEmployeeById(id)==null)
		{
			logger.info("In Log Info EmployeeController: Successfully in DeleteEmployeeById");
			return new ResponseEntity<String>("Data is not Deleted",HttpStatus.NOT_FOUND);
		}
		else
		{
			logger.info("In Log Info EmployeeController:Not Successfully in DeleteEmployeeById");
		return new ResponseEntity<String>(deleteEmployee, HttpStatus.OK);
		}
	}
	@RequestMapping(value="/emp",produces="application/JSON",method=RequestMethod.GET)
	public ResponseEntity<?> showAllEmployeeList() throws Exception
	{
		List<Employee> employees=service.getEmployeeList();
		if(employees==null)
		{
			logger.info("In Log Info EmployeeController: Not Successfully in showAllEmployeeList");
			return new ResponseEntity<String>("List is Not Found", HttpStatus.NOT_FOUND);
		}
		else
		{
			logger.info("In Log Info EmployeeController: Successfully in showAllEmployeeList");
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		
		}
	}
	
	
	@RequestMapping(value="/emp/{id}",produces="application/JSON",method=RequestMethod.PUT,consumes="application/JSON")
	public ResponseEntity<?> updateEmployeeById(@PathVariable int id,@RequestBody Employee employee) throws UpdationFailedException, SQLException 
	{
		String updatedDetails=service.updateEmployeeById(id, employee);
			if(updatedDetails==null)
			{
				logger.info("In Log Info EmployeeController: Successfully in updateEmployeeById");
				return new ResponseEntity<String>("Such Data is Not Available in Database", HttpStatus.NOT_FOUND);
			}
			else
			{
				logger.info("In Log Info EmployeeController:Not Successfully in updateEmployeeById");
				return new ResponseEntity<String>("Data updated in Database Successfully", HttpStatus.OK);
			}
	}
}
