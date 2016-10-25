package com.example.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.example.pojo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private static final Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public EmployeeDaoImpl() {

	}

	@Override
	// @Transactional
	public String storeEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();
		// session.save(employee);
		session.persist(employee);
		transaction.commit();
		session.close();

		return "Data Successfully Inserted in database";
	}

	@Override
	// @Transactional
	public String updateEmployeeById(int id, Employee employee) {
		/*
		 * Session session=this.sessionFactory.getCurrentSession(); Employee
		 * emp=session.load(Employee.class, new Integer(id));
		 * if(emp.getEmpId()==employee.getEmpId()) { session.update(employee);
		 * return "Employee Record Updated Successfully"; } else { return
		 * "Employee Record does not Exist"; }
		 */
		String msg = "failed to update";
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();
		Employee emp = session.get(Employee.class, id);
		if (emp != null) {
			emp.setlName(employee.getlName());
			emp.setfName(employee.getfName());
			emp.setDateOfJoining(employee.getDateOfJoining());
			emp.setEmail(employee.getEmail());
			emp.setAge(employee.getAge());
			emp.setAddress(employee.getAddress());
			emp.setGender(employee.getGender());
			emp.setPassword(employee.getPassword());
			emp.setSalary(employee.getSalary());
			session.update(emp);
			msg = "Record Updated Successfully";
		}

		transaction.commit();
		session.close();

		return msg;

	}

	@Override
	// @Transactional
	public Employee getEmployeeById(int empId) {
		/* Session session=this.sessionFactory.getCurrentSession(); */
		logger.info("Entering EmployeeDaoImpl:::Employee loaded successfully");
		// return (Employee)
		// sessionFactory.getCurrentSession().createQuery("select e from
		// Employee e where e.empId=:empId").setParameter("empId",
		// empId).uniqueResult();
		/* Employee emp=session.load(Employee.class, new Integer(id)); */
		/*
		 * logger.info("Employee loaded successfully, Employee details="+emp);
		 */
		/* return emp; */

		Session session = sessionFactory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();
		Employee emp = session.get(Employee.class, empId);

		transaction.commit();
		session.close();
		return emp;
	}

	@SuppressWarnings("unchecked")
	@Override
	// @Transactional
	public List<Employee> getEmployeeList() {
		/*
		 * Session session = this.sessionFactory.getCurrentSession();
		 * List<Employee>
		 * employeeList=session.createQuery("from Employee").list();
		 * for(Employee emp : employeeList){ logger.info("Person List::"+emp); }
		 */
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		transaction.commit();
		session.close();
		return employeeList;
	}

	@Override
	// @Transactional
	public String deleteEmployeeById(int empId) {
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();

		Employee emp = session.get(Employee.class, empId);

		if (emp != null) {
			session.delete(emp);
		} else
			System.out.println("Record Not Found");
		transaction.commit();
		session.close();
		/*
		 * Employee emp=(Employee) sessionFactory.getCurrentSession().
		 * createQuery("select e from Employee e where e.empId=:empId").
		 * setParameter("empId", empId).uniqueResult();
		 * sessionFactory.getCurrentSession().delete(emp);
		 */
		logger.info("Employee deleted successfully, person details=");
		return "Employee Data Deleted Successfully";
	}

}
