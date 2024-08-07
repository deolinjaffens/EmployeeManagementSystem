package com.ideas2it.employee.service;

import java.time.LocalDate;
import java.util.List;

import com.ideas2it.model.Department;
import com.ideas2it.util.exception.DatabaseException;
import com.ideas2it.model.Employee;

/**
 *<p>
 *Extracts and imports required details from various databases
 *</p>
 *@author Deolin Jaffens
 */

public interface EmployeeService {

    /**
	 *<p>
     *Adds the new employee to the specified department
     *The new employee is passed to the Dao
     *</p>
     *@param name - name of the employee to be added
     *@param dob - date of birth of the employee
     *@param gender - gender of the employee
     *@param phNum - phone number of the employee
     *@param salary - salary of the employee
     *@throws DatabaseException 
     */

     public int addEmployee(String name, LocalDate dob, char gender, long phNum, double salary) throws DatabaseException;
     
     /**
	  *<p>
      *Checks whether the details of the specific employee should be viewed
      *</p>
      *@param id - id of employee to be checked and extracted 
      *@return Employee
      *@throws DatabaseException
      */
	  
     public Employee getEmployee(int id) throws DatabaseException ;

     /**
	  *<p>
      *Transfers the employee details that has to be updated to the dao
      *</p>
      *@param employee - contains details of the employee to be updated
      *@throws DatabaseException
      */

     public void updateEmployee(Employee employee) throws DatabaseException;

     /**
	  *<p>
      *Transfers the details of the employee to be removed
      *</p>
      *@param id - id of the employee to be removed
      *@throws DatabaseException
      */

     public void removeEmployee(int id) throws DatabaseException;

     /**
	  *<p>
      *Extracts all the employees from the database
      *</p>
      *@return Set<Employee>
      *@throws DatabaseException
      */

     public List<Employee> getEmployees() throws DatabaseException;
	 
	 /** 
	 *<p>
	 *Check for the availability of any department in the database
	 *</p>
	 *return boolean
	 *throws DatabaseException
	 */
	 
	 public boolean isEmpty() throws DatabaseException;
	 
	 /**
	  *<p>
	  *Adds employee to a specific department
	  *</p>
	  *@param id - id of the employee to be added to a department
	  *@param departmentId - id of the department where employee has to be added
	  *return Department
	  *throws DatabaseException
	  */
	  
	  public void addDepartmentToEmployee(int id, int departmentId) throws DatabaseException;

	  /**
	   *<p>
	   *Extracts all the departments from the database
	   *</p>
	   *@return List<Department>
	   *@throws DatabaseException
	   */
	   
	  public List<Department> getAllDepartments() throws DatabaseException;
} 