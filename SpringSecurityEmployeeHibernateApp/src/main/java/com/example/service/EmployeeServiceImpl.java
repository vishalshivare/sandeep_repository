package com.example.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.EmployeeListNotFoundException;
import com.example.Exceptions.EmployeeNotFoundException;
import com.example.Exceptions.OtherException;
import com.example.Exceptions.UpdationFailedException;
import com.example.dao.EmployeeDao;
import com.example.pojo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeDao dao;

	private static final Logger logger=Logger.getLogger(EmployeeServiceImpl.class); 
	
	@Override
	public String storeEmployee(Employee employee) throws OtherException, SQLException {

		String obj = dao.storeEmployee(employee);
		if (obj != null)
		{
			logger.info("In Log Info DEmployeeServiceImpl: Employee Stored Successfully");
			return obj;
		}
		else{
			logger.info("In Log Info DEmployeeServiceImpl: Employee Not Stored ");
		return null;
		}
	}

	@Override
	public Employee getEmployeeById(int id) throws SQLException, EmployeeNotFoundException   {
		Employee emp = dao.getEmployeeById(id);
		if (emp != null) {
			logger.info("In Log Info DEmployeeServiceImpl: Successfully GetEmployeeById");
			return emp;
		}
		else
		{
			logger.info("In Log Info DEmployeeServiceImpl: Not Successfully GetEmployeeById");
		return null;
		}
	}

	@Override
	public List<Employee> getEmployeeList() throws EmployeeListNotFoundException, SQLException {
		List<Employee> employees = dao.getEmployeeList();
		if (employees.isEmpty()) {
			logger.info("In Log Info EmployeeServiceImpl: Not Successfully in getEmployeeList");
			return null;
		}
		else{
			logger.info("In Log Info EmployeeServiceImpl: Successfully in getEmployeeList");
		return employees;
		}
	}

	@Override
	public String deleteEmployeeById(int id) throws EmployeeNotFoundException, SQLException {
		String d = dao.deleteEmployeeById(id);
		if (d != null) {
			logger.info("In Log Info EmployeeServiceImpl: Successfully in deleteEmployeeById");
			return d;
		}
		else
		{
			logger.info("In Log Info EmployeeServiceImpl: Not Successfully in deleteEmployeeById");
		return null;
	    } 
		}

	@Override
	public String updateEmployeeById(int id, Employee employee) throws UpdationFailedException, SQLException {
		String update=null;
		
			update = dao.updateEmployeeById(id, employee);
		       if(update!=null)
		       {
		    	   logger.info("In Log Info EmployeeServiceImpl: Successfully in updateEmployeeById");
		    	   return update;
		       }
		       else
		       {
		    	   logger.info("In Log Info EmployeeServiceImpl:Not Successfully in updateEmployeeById");
		    	   return null;
		       }
	}

}
