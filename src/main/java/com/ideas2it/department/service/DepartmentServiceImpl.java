package com.ideas2it.department.service;

import java.util.List;

import com.ideas2it.department.dao.DepartmentDao;
import com.ideas2it.department.dao.DepartmentDaoImpl;
import com.ideas2it.util.exception.DatabaseException;
import com.ideas2it.model.Department;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDao departmentDao = new DepartmentDaoImpl();

    public int addDepartment(String name) throws DatabaseException {
        Department department = new Department(name);
        return departmentDao.addDepartment(department);
    }

    public List<Department> getAllDepartments() throws DatabaseException {
        return departmentDao.getAllDepartments();
    }

    public void updateDepartment(int id, String name) throws DatabaseException {
        try {
            departmentDao.updateDepartment(id, name);
        } catch(NullPointerException e) {
            throw new DatabaseException("Department does not exist");
        }	
    }
    
    public void removeDepartment(int id) throws DatabaseException {
        departmentDao.removeDepartment(id);
    }

    public boolean isEmpty() throws DatabaseException {
        return departmentDao.getAllDepartments().isEmpty();
    }

    public Department getDepartment(int id) throws DatabaseException {
       return departmentDao.getDepartment(id);
	}
}