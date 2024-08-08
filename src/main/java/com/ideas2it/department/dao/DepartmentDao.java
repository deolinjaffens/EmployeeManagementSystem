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
     * Stores new department details in the database
     * </p>
     *
     * @param department - contain the department details to be added
     * @return id of the department that is generated
     * employee
     * @throws EmployeeException - Exception thrown while there is error in adding
     */

    int addDepartment(Department department) throws EmployeeException;

    /**
     * <p>
     * Extracts department from the Set departmentData
     * </p>
     *
     * @return list of all departments present in the database
     * @throws EmployeeException - Exception thrown while extracting department
     */

    public List<Department> getAllDepartments() throws EmployeeException;

    /**
     * <p>
     * Extracts a specific department from the database
     * </p>
     *
     * @param id - id of the department to be extracted
     * @return department whose id matches with the id initialised
     * @throws EmployeeException - Exception thrown while initialising id and
     *                           extracting department
     */

    public Department getDepartment(int id) throws EmployeeException;

    /**
     * <p>
     * Updates specific details of department in the database
     * </p>
     *
     * @param id   - id of the department
     * @param name - name that has to be updated
     * @throws EmployeeException - Exception thrown while updating specific details
     *                           in the database
     */

    void updateDepartment(int id, String name) throws EmployeeException;

    /**
     * <p>
     * Removes a specific department from the database
     * </p>
     *
     * @param id - id of the department which should be hid
     * @throws EmployeeException - Exception thrown while removing department
     */

    void removeDepartment(int id) throws EmployeeException;
} 