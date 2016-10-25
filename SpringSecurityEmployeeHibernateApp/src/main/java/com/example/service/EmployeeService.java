package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.Exceptions.EmployeeListNotFoundException;
import com.example.Exceptions.EmployeeNotFoundException;
import com.example.Exceptions.OtherException;
import com.example.Exceptions.UpdationFailedException;
import com.example.pojo.Employee;

public interface EmployeeService {
public String storeEmployee(Employee employee) throws OtherException, SQLException;
public Employee getEmployeeById(int id) throws SQLException, EmployeeNotFoundException;
public List<Employee> getEmployeeList() throws EmployeeListNotFoundException, SQLException;
public String deleteEmployeeById(int id) throws EmployeeNotFoundException, SQLException;
public String updateEmployeeById(int id,Employee employee) throws UpdationFailedException, SQLException;
}