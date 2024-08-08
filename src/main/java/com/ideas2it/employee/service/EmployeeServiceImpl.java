package com.ideas2it.employee.service;

import java.time.LocalDate;

import com.ideas2it.model.Department;
import com.ideas2it.department.service.DepartmentService;
import com.ideas2it.department.service.DepartmentServiceImpl;
import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.employee.dao.EmployeeDaoImpl;
import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.model.Employee;

/**
 * <p>
 * Implements the EmployeeService interface
 * Connects Controller to the dao
 * </p>
 *
 * @author Deolin Jaffens
 */

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao employeeDao = new EmployeeDaoImpl();
    DepartmentService departmentService = new DepartmentServiceImpl();

    public int addEmployee(String name, LocalDate dob, char gender, long phNum, double salary, int departmentId) throws EmployeeException {
        for (Department department : departmentService.getAllDepartments()) {
            if (department.getId() == departmentId) {
                Employee employee = new Employee(name, dob, gender, phNum, salary, department);
                return employeeDao.addEmployee(employee);
            }
        }
        return 0;
    }

    public Employee getEmployee(int id) throws EmployeeException {
        return employeeDao.getEmployee(id);
    }

    public void updateEmployee(Employee employee) throws EmployeeException {
        employeeDao.updateEmployee(employee);
    }

    public void removeEmployee(int id) throws EmployeeException {
        employeeDao.removeEmployee(id);
    }
}