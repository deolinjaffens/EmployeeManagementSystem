package com.ideas2it.department.service;

import java.util.List;

import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.model.Department;

/**
 * <p>
 * Connects Controller to the Dao
 * </p>
 *
 * @author Deolin Jaffens
 */

public interface DepartmentService {

    /**
     * <p>
     * Gets every department details and creates a new Department
     * </p>
     *
     * @param name - name of the department
     * @throws EmployeeException - Exception thrown while there is an issue in
     *                           adding specific details of a department
     */

    int addDepartment(String name) throws EmployeeException;

    /**
     * <p>
     * Gets all the available departments
     * </p>
     *
     * @return List<Department>
     * @throws EmployeeException - Exception thrown while there is an issue in
     *                           getting the department
     */

    List<Department> getAllDepartments() throws EmployeeException;

    /**
     * <p>
     * Extract details of a specific department and updates it after passing it
     * to the dao
     * </p>
     *
     * @param id   - id of the department to be updated
     * @param name - name to be updated for the department
     * @throws EmployeeException - Exception thrown while there is an issue while
     *                           updating the specific department
     */

    void updateDepartment(int id, String name) throws EmployeeException;

    /**
     * <p>
     * Department id is extracted from the controller and passed to the dao
     * </p>
     *
     * @param id - id of department to be removed
     * @throws EmployeeException - Exception thrown while there is a failure
     *                           in removing a specific department
     */

    void removeDepartment(int id) throws EmployeeException;

    /**
     * <p>
     * Check for the availability of any department in the database
     * </p>
     *
     * @return whether there is a presence of any departments
     * @throws EmployeeException - Exception thrown while checking for the presence
     *                           of any departments
     */

    boolean isDepartmentPresent() throws EmployeeException;

    /**
     * <p>
     * gets a specific department from the available departments
     * </p>
     *
     * @param id - id of the department to be extracted
     * @return department which has to be extracted
     * @throws EmployeeException - exception thrown while there is an issue in
     *                           getting a specific department
     */

    Department getDepartmentById(int id) throws EmployeeException;

}