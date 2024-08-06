package com.ideas2it.department.service;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import com.ideas2it.department.dao.DepartmentDao;
import com.ideas2it.department.dao.DepartmentDaoImpl;
import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.employee.service.EmployeeServiceImpl;
import com.ideas2it.util.exception.DatabaseException;
import com.ideas2it.model.Department;
import com.ideas2it.model.Employee;

/**
 *Connects Controller to the Dao
 *
 *@Deolin Jaffens
 */

public interface DepartmentService {

    /**
     *Extract details from the controller and stores it in Department
     *The newly formed department is passed to the Dao
     *
     *@param name - name of the department
     *@param id - id of the department
     */

    public void addDepartment(String name) throws DatabaseException;

    /**
     *Extracts all the departments from the Dao
     *
     *@return List<Department>
     */

    public List<Department> getAllDepartments() throws DatabaseException;

    /**
     *Extract details of a specific department and updates it after passing it 
     *to the dao
     *
     *@param id - id of the department
     *@param name - name to be updated for the department
     */
  
    public void updateDepartment(int id, String name) throws DatabaseException;

   /**
    *Department id is extracted from the controller and passed to
    *the dao
    *
    *@param id - id of department to be removed
    */
  
    public void removeDepartment(int id) throws DatabaseException;

    /**
     *Checks wheather there is any department in the database
     *
     *@return boolean
     */

    public boolean isEmpty() throws DatabaseException;

    /**
     *Extracts all the employees from the employee service 
     *
     *@param id - id of the department to be extracted
     *@return Department
     */

     public Department getDepartment(int id) throws DatabaseException;    

}