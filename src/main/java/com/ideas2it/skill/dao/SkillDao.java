package com.ideas2it.skill.dao;

import java.util.List;

import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.model.Skill;

/**
 * <p>
 *Stores and retrieves details related to skills from the database
 *</p>
 *@author Deolin Jaffens
 */

public interface SkillDao {

    /**
	 *<p>
     *Adds new skill associated to employee in the database
     *</p>
     *@param skill - contains the new skill that has to be added
     *@return id of the employee that is generated
     *@throws EmployeeException - Exception thrown when there is an issue in
     * inserting skill to the database
     */

    int insertSkill(Skill skill) throws EmployeeException;

    /**
	 *<p>
     *Extracts all the skills related to the employee
     *</p>
     *@return all the skill that are present in the database
     * @throws EmployeeException - Exception thrown while there is an issue in
     * extracting all the skill
     */

    List<Skill> getAllSkills() throws EmployeeException;

    /**
     * <p>
     * Extracts the details of a specific skill from the database
     * </p>
     * @param id - id of the skill to be extracted
     * @return skill whose id matches with the id initialised
     * @throws EmployeeException - Exception thrown when there is an issue in
     * extracting the details of a specific skill
     */

    Skill getSkill(int id) throws EmployeeException;

    /**
	 *<p>
     *Update any specific details of the skill from the database
     *</p>
     *@param id - id of skill that has to be updated
     *@param name - skills name to be updated
     *@throws EmployeeException - Exception thrown when there is an issue in updating
     * specific details of a skill
     */

    void updateSkill(int id, String name) throws EmployeeException;

    /**
     *<p>
     *Adds a specific skill to an employee
     *</p>
     *@param id - id of the skill that has to be inserted to the employee
     *@param employeeId - id of employee who is going to get a new skill inserted
     * @throws EmployeeException - Exception thrown while inserting a specific skill
     * to a specific employee
     */

     void insertSkillToEmployee(int id, int employeeId) throws EmployeeException;

    /**
	 *<p>
     *Removes the association of an employee with a particular skill
     *</p>
     *@param id - id of skill to be removed
     *@param employeeId - id of employee who needs to remove a particular skill
     *@throws EmployeeException - Exception thrown when there is an issue in removing
     * skill from the employee
     */

    void removeSkillFromEmployee(int id, int employeeId) throws EmployeeException;
}