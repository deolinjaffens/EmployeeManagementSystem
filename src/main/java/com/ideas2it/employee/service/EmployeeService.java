package com.ideas2it.employee.service;

import java.time.LocalDate;

import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.model.Employee;

/**
 * <p>
 * Extracts and imports required details from various databases
 * </p>
 *
 * @author Deolin Jaffens
 */

public interface EmployeeService {

    /**
     * <p>
     * Adds the new employee to the specified department
     * The new employee is passed to the Dao
     * </p>
     *
     * @param name         - name of the employee to be added
     * @param dob          - date of birth of the employee
     * @param gender       - gender of the employee
     * @param phoneNumber  - phone number of the employee
     * @param salary       - salary of the employee
     * @param departmentId - id of the department where employee has to be assigned
     * @throws EmployeeException - Exception thrown while there is an issue in adding
     *                           specific details of the employee
     */

    int addEmployee(String name, LocalDate dob, char gender, long phoneNumber, double salary, int departmentId) throws EmployeeException;

    /**
     * <p>
     * Checks whether the details of the specific employee should be viewed
     * </p>
     *
     * @param id - id of employee to be checked and extracted
     * @return Employee
     * @throws EmployeeException - Exception thrown while there is an issue in
     *                           Extracting a specific employee
     */

    Employee getEmployee(int id) throws EmployeeException;

    /**
     * <p>
     * Transfers the employee details that has to be updated to the dao
     * </p>
     *
     * @param employee - contains details of the employee to be updated
     * @throws EmployeeException - Exception thrown while there is an issue in
     *                           updating the employee details
     */

    void updateEmployee(Employee employee) throws EmployeeException;

    /**
     * <p>
     * Transfers the employee to be removed
     * </p>
     *
     * @param id - id of the employee to be removed
     * @throws EmployeeException - Error thrown while there is an issue in
     *                           removing a specific employee
     */

    void removeEmployee(int id) throws EmployeeException;

} 