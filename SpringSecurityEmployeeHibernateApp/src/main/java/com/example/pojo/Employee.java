package com.example.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="Employee")
public class Employee {
	
	private static final Logger logger=Logger.getLogger(Employee.class);
	
	
	private int empId;
	@NotEmpty(message="First Name must not be blanked")
	private String fName;
	@NotEmpty(message="Last Name must not be blanked")
	private String lName;
	@NotEmpty(message="Gender must not be blanked")
	private String gender;
	@NotEmpty(message="Email must not be blanked")
	@Email(message="Email Invalid")
	private String email;
	@NotEmpty(message="Password must not be blanked")
	private String password;
	@NotEmpty(message="Address must not be blanked")
	private String address;
	
	private int age;
	
	private float salary;
	@NotNull(message="Date must not be blanked")
	@DateTimeFormat(pattern="dd-mm-yyyy")
	private Date dateOfJoining;
public Employee() {
	logger.info("In Info Employee Pojo ");
	
}



public Employee(String fName, String lName, String gender, String email, String password, String address, int age,
		float salary, Date dateOfJoining) {
	super();
	this.fName = fName;
	this.lName = lName;
	this.gender = gender;
	this.email = email;
	this.password = password;
	this.address = address;
	this.age = age;
	this.salary = salary;
	this.dateOfJoining = dateOfJoining;
}



@Id
@GeneratedValue
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
@Column(length=20,name="fName")
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
@Column(length=20,name="lName")
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
@Column(length=20,name="gender")
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
@Column(length=30,name="email")
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Column(length=20,name="password")
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Column(length=20,name="address")
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Column(length=10,name="age")
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Column(length=20,name="salary")
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
@Temporal(TemporalType.DATE)
@Column(name="DateOfJoining")
public Date getDateOfJoining() {
	return dateOfJoining;
}
public void setDateOfJoining(Date dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", email="
			+ email + ", password=" + password + ", address=" + address + ", age=" + age + ", salary=" + salary
			+ ", dateOfJoining=" + dateOfJoining + "]";
}



	
}
