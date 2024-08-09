package com.ideas2it.department.dao;

import java.util.List;

import com.ideas2it.model.Department;
import com.ideas2it.util.exception.EmployeeException;

/**
 * <p>
 * Stores and retrieves required details from the database
 * </p>
 *
 * @author Deolin Jaffens
 */

public interface DepartmentDao {

    /**
     * <p>
     * Stores a new department
     * </p>
     *
     * @param department - contain the department details to be added
     * @return id of the department that is generated
     * @throws EmployeeException - Exception thrown while there is error in adding department
     */

    int addDepartment(Department department) throws EmployeeException;

    /**
     * <p>
     * Gets all the available departments
     * </p>
     *
     * @return list of all departments present in the database
     * @throws EmployeeException - Exception thrown while connecting with database
     */

    List<Department> getAllDepartments() throws EmployeeException;

    /**
     * <p>
     * gets a specific department from the available departments
     * </p>
     *
     * @param id - id of the department to be extracted
     * @return department whose id matches with the id initialised
     * @throws EmployeeException - Exception thrown while initialising id and
     *                           extracting department
     */

    public Department getDepartmentById(int id) throws EmployeeException;

    /**
     * <p>
     * Updates specific details of of a specific department
     * </p>
     *
     * @param id   - id of the department
     * @param name - name that has to be updated
     * @throws EmployeeException - Exception thrown while updating specific details
     *                           or connecting with the database
     */

    void updateDepartment(int id, String name) throws EmployeeException;

    /**
     * <p>
     * Removes a specific department from the database
     * </p>
     *
     * @param id - id of the department which should be removed
     * @throws EmployeeException - Exception thrown while there is an issue in
     *                           connecting with the database
     */

    void removeDepartment(int id) throws EmployeeException;
} 