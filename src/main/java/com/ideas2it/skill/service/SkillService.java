package com.ideas2it.skill.service;

import java.util.Set;

import com.ideas2it.model.Employee;
import com.ideas2it.model.Skill;
import com.ideas2it.util.exception.DatabaseException;

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
     *@throws DatabaseException
     */    

    public int addSkill(String name) throws DatabaseException;

    /**
	 *<p>
     *Extracts all the skills related to a specific employee from the Dao
     *</p>
     *@return Set<Skill>
     *@throws DatabaseException
     */

    public List<Skill> getAllSkills() throws DatabaseException;

    /**
	 *<p>
     *Passes the details that has to be updated from the user to the dao
     *</p>
     *@param id - id of the skill that has to be updated
     *@param name - name that is to be updated for a skill
     */

    public void updateSkill(int id, String name) throws DatabaseException;

	/**
	 * <p>
	 * Inserts a specific skill to a specific employee
	 * </p>
	 * @param id - id of the skill that has to be added to an employee
	 * @param employee - employee to whom a specific skill has to be added
	 * @throws DatabaseException
	 */

	public void insertSkillToEmployee(int id, int employee id) throws DatabaseException

    /**
	 *<p>
     *Passes the skill detail that has to be removed from the association of a 
	 *specific employee
     *</p>
     *@param id - id of skill that has to be removed
	 *@param employeeId - id of employee whose skill has to be removed
	 * @throws DatabaseException
     */

	public void removeSkillFromEmployee(int id, int employeeId) throws DatabaseException;

    /**
	 *<p>
     *Extracted data of employees related to a specific skill
     *from the Dao is transferred to the controller
     *</p>
     *@param id - id of the skill for which the employees have to be
     *extracted
     *@return Set<Employee>
	 *@throws DatabaseException
     */ 

    public Set<Employee> getEmployeesBySkill(int id) throws DatabaseException;
	
	/**
	 *<p>
	 *A specific employee is extracted from the database
	 *</p>
	 *@param id - id of employee whose skills has to be extracted
	 *@return Employee
	 *@throws DatabaseException
	 */
	 
	public Employee getSkillsByEmployee(int id) throws DatabaseException;
}