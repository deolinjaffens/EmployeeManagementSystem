package com.ideas2it.department.service;

import java.util.List;

import com.ideas2it.department.dao.DepartmentDao;
import com.ideas2it.department.dao.DepartmentDaoImpl;
import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.model.Department;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDao departmentDao = new DepartmentDaoImpl();

    public int addDepartment(String name) throws EmployeeException {
        Department department = new Department(name);
        return departmentDao.addDepartment(department);
    }

    public List<Department> getAllDepartments() throws EmployeeException {
        return departmentDao.getAllDepartments();
    }

    public void updateDepartment(int id, String name) throws EmployeeException {
        departmentDao.updateDepartment(id, name);
    }

    public void removeDepartment(int id) throws EmployeeException {
        departmentDao.removeDepartment(id);
    }

    public boolean isDepartmentPresent() throws EmployeeException {
        return departmentDao.getAllDepartments().isEmpty();
    }

    public Department getDepartmentById(int id) throws EmployeeException {
        return departmentDao.getDepartmentById(id);
    }
}