package com.ideas2it.skill.service;

import java.util.Set;

import com.ideas2it.model.Employee;
import com.ideas2it.model.Skill;
import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.employee.service.EmployeeServiceImpl;
import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.skill.dao.SkillDao;
import com.ideas2it.skill.dao.SkillDaoImpl;

/**
 * <p>
 * Implements the skill interface
 * Connects controller to the dao
 * </p>
 *
 * @author Deolin Jaffens
 */

public class SkillServiceImpl implements SkillService {
    SkillDao skillDao = new SkillDaoImpl();

    public int addSkill(String name) throws EmployeeException {
        Skill skill = new Skill(name);
        return skillDao.insertSkill(skill);
    }

    public void updateSkill(int id, String name) throws EmployeeException {
        skillDao.updateSkill(id, name);
    }

    public void insertSkillToEmployee(int id, int employeeId) throws EmployeeException {

        skillDao.insertSkillToEmployee(id, employeeId);
    }

    public void removeSkillFromEmployee(int id, int employeeId) throws EmployeeException {
        skillDao.removeSkillFromEmployee(id, employeeId);
    }

    public Set<Employee> getEmployeesBySkill(int id) throws EmployeeException {
        return skillDao.getSkillById(id).getEmployees();
    }
}