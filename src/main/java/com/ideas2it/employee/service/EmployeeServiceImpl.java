package com.ideas2it.employee.service;

import java.time.LocalDate;
import java.util.List;

import com.ideas2it.model.Department;
import com.ideas2it.department.service.DepartmentService;
import com.ideas2it.department.service.DepartmentServiceImpl;
import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.employee.dao.EmployeeDaoImpl;
import com.ideas2it.util.exception.DatabaseException;
import com.ideas2it.model.Employee;

/**
 *<p>
 *Implements the EmployeeService interface 
 *Connects Controller to the dao
 *</p>
 *@author Deolin Jaffens
 */

public class EmployeeServiceImpl implements EmployeeService {
    
    EmployeeDao employeeDao = new EmployeeDaoImpl();
	DepartmentService departmentService = new DepartmentServiceImpl();

    public int addEmployee(String name, LocalDate dob, char gender, long phNum, double salary) throws DatabaseException{
        Employee employee = new Employee(name, dob, gender, phNum, salary);
        return employeeDao.addEmployee(employee);
    }

    public Employee getEmployee(int id) throws DatabaseException {
        if(!employeeDao.getEmployee(id).getDelete()) {
            return employeeDao.getEmployee(id);
        }
        return null;
    }

    public void updateEmployee(Employee employee) throws DatabaseException {
        employeeDao.updateEmployee(employee);
    }

    public void removeEmployee(int id) throws DatabaseException {
        employeeDao.removeEmployee(id) ;
    }

    public List<Employee> getEmployees() throws DatabaseException{
        return employeeDao.getEmployees();
    }
	 
	public boolean isEmpty() throws DatabaseException {
	    return departmentService.isEmpty();
	}
	  
    public void addDepartmentToEmployee(int id,int departmentId) throws DatabaseException {
	    for(Department department : getAllDepartments()) {
		    if(department.getId() == departmentId){
		  	    getEmployee(id).setDepartment(department);
			}
		}
	}
	
	public List<Department> getAllDepartments() throws DatabaseException {
		return departmentService.getAllDepartments();
	}
}