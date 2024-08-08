package com.ideas2it.skill.service;

import java.util.List;
import java.util.Set;

import com.ideas2it.model.Employee;
import com.ideas2it.model.Skill;
import com.ideas2it.util.exception.EmployeeException;

/**
 *<p>
 *Connects controller to the dao
 *</p>
 *@author Deolin Jaffens
 */ 

public interface SkillService {

    /**
	 *<p>
     *Adds the new Skill to the database by transferring details from the 
	 *controller to the dao 
     *</p>
     *@param name - name of the skill to be added
     *@throws EmployeeException
     */    

    public int addSkill(String name) throws EmployeeException;

    /**
	 *<p>
     *Extracts all the skills related to a specific employee from the Dao
     *</p>
     *@return Set<Skill>
     *@throws EmployeeException
     */

    public List<Skill> getAllSkills() throws EmployeeException;

    /**
	 *<p>
     *Passes the details that has to be updated from the user to the dao
     *</p>
     *@param id - id of the skill that has to be updated
     *@param name - name that is to be updated for a skill
     */

    public void updateSkill(int id, String name) throws EmployeeException;

	/**
	 * <p>
	 * Inserts a specific skill to a specific employee
	 * </p>
	 * @param id - id of the skill that has to be added to an employee
	 * @param employeeId - id of the employee to whom a specific skill has to be added
	 * @throws EmployeeException
	 */

	public void insertSkillToEmployee(int id, int employeeId) throws EmployeeException;

    /**
	 *<p>
     *Passes the skill detail that has to be removed from the association of a 
	 *specific employee
     *</p>
     *@param id - id of skill that has to be removed
	 *@param employeeId - id of employee whose skill has to be removed
	 * @throws EmployeeException
     */

	public void removeSkillFromEmployee(int id, int employeeId) throws EmployeeException;

    /**
	 *<p>
     *Extracted data of employees related to a specific skill
     *from the Dao is transferred to the controller
     *</p>
     *@param id - id of the skill for which the employees have to be
     *extracted
     *@return Set<Employee>
	 *@throws EmployeeException
     */ 

    public Set<Employee> getEmployeesBySkill(int id) throws EmployeeException;
}