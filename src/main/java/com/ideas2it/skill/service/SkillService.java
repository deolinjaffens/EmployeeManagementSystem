package com.ideas2it.skill.service;

import java.util.Set;

import com.ideas2it.model.Employee;
import com.ideas2it.util.exception.EmployeeException;

/**  
 * <p>
 * Connects controller to the dao
 * </p>
 *
 * @author Deolin Jaffens
 */

public interface SkillService {

    /**
     * <p>
     * Adds a new Skill
     * </p>
     *
     * @param name - name of the skill to be added
     * @return id of the skill which is generated
     * @throws EmployeeException - Exception thrown when there is an issue in
     *                           adding a specific skill
     */

    int addSkill(String name) throws EmployeeException;

    /**
     * <p>
     * Updates the details of a specific skill
     * </p>
     *
     * @param id   - id of the skill that has to be updated
     * @param name - name that is to be updated for a skill
     * @throws EmployeeException - Exception thrown when there is an issue in
     *                           updating any specific skill details
     */

    void updateSkill(int id, String name) throws EmployeeException;

    /**
     * <p>
     * Inserts a specific skill to a specific employee
     * </p>
     *
     * @param id         - id of the skill that has to be added to an employee
     * @param employeeId - id of the employee to whom a specific skill has to be
     *                   added
     * @throws EmployeeException - Exception thrown when there is an issue in
     *                           inserting skill to an employee
     */

    void insertSkillToEmployee(int id, int employeeId) throws EmployeeException;

    /**
     * <p>
     * Passes the skill detail that has to be removed from the association of a
     * specific employee
     * </p>
     *
     * @param id         - id of skill that has to be removed
     * @param employeeId - id of employee whose skill has to be removed
     * @throws EmployeeException - Exception thrown when there is an issue in extracting
     *                           employee details or skill details
     */

    void removeSkillFromEmployee(int id, int employeeId) throws EmployeeException;

    /**
     * <p>
     * Extracted data of employees related to a specific skill
     * from the Dao is transferred to the controller
     * </p>
     *
     * @param id - id of the skill for which the employees have to be
     *           extracted
     * @return employees who are proficient in a specific skill
     * @throws EmployeeException -  Exception thrown when there is an issue in extracting
     *                           employee details or skill details
     */

    Set<Employee> getEmployeesBySkill(int id) throws EmployeeException;
}