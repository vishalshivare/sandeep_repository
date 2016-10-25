package com.example.dao;

import java.util.List;

import com.example.pojo.Employee;

public interface EmployeeDao {

	public String storeEmployee(Employee employee) ;
	public String updateEmployeeById(int id,Employee employee) ;
	public Employee getEmployeeById(int id) ;
	public List<Employee> getEmployeeList() ;
	public String deleteEmployeeById(int id) ;

}
