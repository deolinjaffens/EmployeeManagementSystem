package com.ideas2it.skill.dao;

import java.util.Set;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 

import com.ideas2it.util.exception.DatabaseException;
import com.ideas2it.model.Skill;
import com.ideas2it.model.Employee;

/**
 *Stores and retrieves details related to skills from the database
 *Implements the SkillDao interface
 *
 *@author Deolin Jaffens
 */

public interface SkillDao {

    /**
	 *<p>
     *Adds new skill associated to employee in the database
     *</p>
     *@param skill - contains the new skill that has to be added
     *@param employee - contains employee that has to be linked with the skill
     *@return int
     */

    public int insertSkill(Skill skill) throws DatabaseException;

    /**
	 *<p>
     *Extracts all the skills related to the employee
     *</p>
     *@return List<Skill>
     */

    public List<Skill> getAllSkills() throws DatabaseException;

    /**
     * <p>
     * Extracts the details of a specific skill from the database
     * </p>
     * @param id - id of the skill to be extracted
     */

    public Skill getSkill(int id);

    /**
	 *<p>
     *Update any specific details of the skill from the database
     *</p>
     *@param employee - employee whose details has to be updated
     *@param id - id of skill that has to be updated
     *@param name - skills name to be updated
     *@throws DatabaseException
     */

    public void updateSkill(int id, String name) throws DatabaseException;

    /**
	 *<p>
     *Removes the association of an employee with a particular skill
     *</p>
     *@param id - id of skill to be removed
     *@param employee - employee who needs to remove a particular skill
     *@throws DatabaseException
     */

    public void removeSkillFromEmployee(int id, int employeeId) throws DatabaseException;
}