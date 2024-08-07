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
 *@author Deolin Jaffens
 */ 

public class SkillServiceImpl implements SkillService {
    SkillDao skillDao = new SkillDaoImpl();
	EmployeeService employeeService = new EmployeeServiceImpl();

    public int addSkill(String name) throws DatabaseException{
        Skill skill = new Skill(name);
        return skillDao.insertSkill(skill);
    }

    public List<Skill> getAllSkills() {
        return skillDao.getAllSkills();
    }

    public void updateSkill(int id, String name) throws DatabaseException {
        skillDao.updateSkill(id, name);
    }

    public void insertSkillToEmployee(int id, int employee id) throws DatabaseException {
        employeeService.getEmployee(id).getSkills().add(getSkill(id));
    }

    public void removeSkillFromEmployee(int id, int employeeId) throws DatabaseException {
        skillDao.removeSkillFromEmployee(id, employeeId);
    }

    public Set<Employee> getEmployeesBySkill(int id) throws DatabaseException {
        return skillDao.getSkill(id).getEmployees();
    }
	 
	public List<Skills> getSkillsByEmployee(int id) throws DatabaseException{
		return employeeService.getEmployee(id).getSkills().list();
	}
    
}