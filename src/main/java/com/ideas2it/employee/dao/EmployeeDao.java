package com.ideas2it.employee.dao;

import java.util.List;

import com.ideas2it.util.exception.DatabaseException;
import com.ideas2it.model.Employee;

/**
 *<p>
 *Stores and retrieves information related to employee from the database
 *</p>
 *@author Deolin Jaffens
 */

public interface EmployeeDao {

    /**
     *<p>
     *Adds new employee details to the database
     *Links employee with department in the database
     *</p>
     *@param employee - contains details of employee who is going to 
     *be added
     *@return int
     *@throws DatabaseException
     */

    public int addEmployee(Employee employee) throws DatabaseException;
   
    /**
	 *<p>
     *Checks the availability of specific employee details
     *using id number and extracts it
     *</p>
     *@param id - id of employee whose details are to be extracted
     *@return Employee
     *@throws DatabaseException
     */

    public Employee getEmployee(int id) throws DatabaseException;

    /**
	 *<p>
     *Updates the details of the employee
     *</p>
     *@param employee- employee whose details has to updated
     *@throws DatabaseException
     */

    public void updateEmployee(Employee employee) throws DatabaseException;

    /**
	 *<p>
     *Restricts anyone from viewing details of a specific employee
     *</p>
     *@param id - id of employee 
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

}