package com.ideas2it.department.dao;

import java.util.List;

import com.ideas2it.model.Department;
import com.ideas2it.util.exception.DatabaseException;

/**
 *<p>
 *Stores and retrieves required details from the database
 *</p>
 *@author Deolin Jaffens
 */

public interface DepartmentDao {

    /**
	 *<p>
     *Stores new department details in the database
     *</p>
     *@param department - contain the department details to be added
     *@throws DatabaseException
     */

    public int addDepartment(Department department) throws DatabaseException;


    /**
	 *<p>
     *Extracts department from the Set departmentData
     *</p>
     *@return Set<Department>
     *@throws DatabaseException
     */    

    public List<Department> getAllDepartments() throws DatabaseException;
	
	/**
	 *<p>
	 *Extracts a specific department from the database
	 *</p>
	 *@param id - id of the department
	 *@return Department
	 *@throws DatabaseException
	 */
	 
	public Department getDepartment(int id) throws DatabaseException;

    /**
	 *<p>
     *Updates specific details of department in the database
     *</p>
     *@param id - id of the department
     *@param name - name that has to be updated
     *@throws DatabaseException
     */

    public void updateDepartment(int id, String name) throws DatabaseException;

    /**
	 *<p>
     *Removes a specific department from the database
     *</p>
     *@param id - id of the department which should be hid
     *@throws DatabaseException
     */

    public void removeDepartment(int id)  throws DatabaseException;
} 