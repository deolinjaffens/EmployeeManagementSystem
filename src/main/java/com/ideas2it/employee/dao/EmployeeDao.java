package com.ideas2it.employee.dao;

import java.util.List;

import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.model.Employee;

/**
 * <p>
 * Inserts and retrieves information related to employee from the database
 * </p>
 *
 * @author Deolin Jaffens
 */

public interface EmployeeDao {

    /**
     * <p>
     * Adds new employee details to the database
     * Links employee with department in the database
     * </p>
     *
     * @param employee - contains details of employee who is going to
     *                 be added
     * @return int
     * @throws EmployeeException - Exception thrown when there is an issue in
     *                           connecting with the database
     */

    int addEmployee(Employee employee) throws EmployeeException;

    /**
     * <p>
     * Checks the availability of the details of a specific employee and extracts it
     * </p>
     *
     * @param id - id of employee whose details has to be extracted
     * @return Employee
     * @throws EmployeeException - Error thrown while connecting with the database
     *                           and when the initialised doesn't match an employee in the database
     */

    Employee getEmployee(int id) throws EmployeeException;

    /**
     * <p>
     * Updates the details of the employee
     * </p>
     *
     * @param employee- employee whose details has to updated
     * @throws EmployeeException - Error thrown when there is an issue in connecting
     *                           with the database
     */

    void updateEmployee(Employee employee) throws EmployeeException;

    /**
     * <p>
     * Restricts anyone from viewing details of a specific employee
     * </p>
     *
     * @param id - id of employee
     * @throws EmployeeException - Exception thrown while there is an issue in
     *                           connecting with database and when the given id doesn't match any department
     *                           in the database
     */

    void removeEmployee(int id) throws EmployeeException;

    /**
     * <p>
     * Extracts all the employees from the database
     * </p>
     *
     * @return Set<Employee>
     * @throws EmployeeException - Exception thrown while there is a trouble in
     *                           connecting with the database
     */

    List<Employee> getEmployees() throws EmployeeException;

}