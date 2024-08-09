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
     * Adds new employee to the database
     * Links employee with department
     * </p>
     *
     * @param employee - contains details of employee who is going to
     *                 be added
     * @return id of the employee that is generated
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
     * @return employee whose id matches with the given id
     * @throws EmployeeException - Error thrown while connecting with the database
     *                           and when the initialised doesn't match an employee
     *                           in the database
     */

    Employee getEmployeeById(int id) throws EmployeeException;

    /**
     * <p>
     * Updates the details of the employee
     * </p>
     *
     * @param employee- employee whose details has to updated
     * @throws EmployeeException - Error thrown when there is an issue in connecting
     *                           with the database and the details given doesn't match
     *                           with the type in the database
     */

    void updateEmployee(Employee employee) throws EmployeeException;

    /**
     * <p>
     * Removes a specific employee from the database
     * </p>
     *
     * @param id - id of employee
     * @throws EmployeeException - Exception thrown while there is an issue in
     *                           connecting with database and when the given id
     *                           doesn't match any department in the database
     */

    void removeEmployee(int id) throws EmployeeException;

}