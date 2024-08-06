package com.ideas2it.skill.service;

import java.util.Set;

import com.ideas2it.model.Employee;
import com.ideas2it.model.Skill;
import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.employee.service.EmployeeServiceImpl;
import com.ideas2it.util.exception.DatabaseException;
import com.ideas2it.skill.dao.SkillDao;
import com.ideas2it.skill.dao.SkillDaoImpl;

/**
 *<p>
 *Implements the skill interface
 *Connects controller to the dao
 *</p>
 *@Deolin Jaffens
 */ 

public class SkillServiceImpl implements SkillService {
    SkillDao skillDao = new SkillDaoImpl();
	EmployeeService employeeService = new EmployeeServiceImpl();

    public int addSkill(String name, Employee employee) throws DatabaseException{
        Skill skill = new Skill(name);
        return skillDao.addSkill(skill, employee);
    }

    public Set<Skill> getAllSkills(Employee employee) throws DatabaseException {
        return skillDao.getAllSkills(employee);
    }

    public void updateSkill(Employee employee, int id, String name) throws DatabaseException {
        skillDao.updateSkill(employee, id, name);
    }

    public void removeSkill(int id, Employee employee) throws DatabaseException {
        skillDao.removeSkill(id, employee);
    }

    public Set<Employee> getEmployees(int id) throws DatabaseException {
        return skillDao.getEmployees(id);
    }
	 
	public Employee getEmployee(int id) throws DatabaseException{
		return employeeService.getEmployee(id);
	}
    
}