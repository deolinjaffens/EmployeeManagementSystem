package com.ideas2it.skill.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.employee.service.EmployeeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Skill;
import com.ideas2it.skill.service.SkillService;
import com.ideas2it.skill.service.SkillServiceImpl;

/**
 * <p>
 * Creation,Edition,removal and viewing of skill data is done
 * Initialisation and extraction of skill details are given and obtained
 * </p>
 *
 * @author Deolin Jaffens
 */

public class SkillController {

    private static Logger logger = LogManager.getLogger(SkillController.class);
    SkillService skillService = new SkillServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();
    Scanner scanner = new Scanner(System.in);

    /**
     * <p>
     * Initialization and extraction of details related to Skills are done
     * for its creation,visualisation,edition and removal
     * </p>
     */

    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("(1) Add a Skill");
            System.out.println("(2) Update a Skill");
            System.out.println("(3) Add skill to employee");
            System.out.println("(4) Remove Skill from Employee");
            System.out.println("(5) Display all employees related to a specific skill");
            System.out.println("(6) Display all Skills related to a specific employee");
            System.out.println("(7) Exit");
            System.out.println("Enter an option");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addSkill();
                    break;
                case 2:
                    updateSkill();
                    break;
                case 3:
                    addSkillToEmployee();
                    break;
                case 4:
                    removeSkillFromEmployee();
                    break;
                case 5:
                    displayEmployeesBySkill();
                    break;
                case 6:
                    displaySkillsByEmployee();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Option!!!");
            }
        }
        System.out.println("================Back To Main Menu================");
    }

    /**
     * <p>
     * Details of the skill that has to be added to the database or associated with the
     * employee is received
     * </p>
     */

    public void addSkill() {
        try {
            System.out.print("Add a Skill : ");
            String name = scanner.next();
            int id = skillService.addSkill(name);
            System.out.println(id);
            System.out.println("=============Skill Added=============");
        } catch (EmployeeException e) {
            logger.error("Error while adding a skill");
        } catch (InputMismatchException e) {
            logger.warn("Error due to invalid details");
        }
    }

    /**
     * <p>
     * Updates the details of a specific skill
     * </p>
     */

    public void updateSkill() {
        int id = 0;
        try {
            System.out.print("Enter the skill Id : ");
            id = scanner.nextInt();
            System.out.print("Enter name to be updated");
            String name = scanner.next();
            skillService.updateSkill(id, name);
            System.out.println("=============Skill Updated=============");
        } catch (EmployeeException e) {
            logger.error("Error while updating skill of id {}", id);
        }
    }

    /**
     * <p>
     * Adds a new skill to an employee
     * </p>
     */

    public void addSkillToEmployee() {
        int id = 0;
        int employeeId = 0;
        try {
            System.out.print("Enter the skill Id : ");
            id = scanner.nextInt();
            System.out.print("Enter the Employee Id : ");
            employeeId = scanner.nextInt();
            skillService.insertSkillToEmployee(id, employeeId);
            System.out.println("=============Skill Added=============");
        } catch (EmployeeException e) {
            logger.error("Error while adding skill of id {} to employee of id {}", id, employeeId);
        }
    }

    /**
     * <p>
     * Removes a specific skill from a specific employee
     * </p>
     */

    public void removeSkillFromEmployee() {
        int id = 0;
        int employeeId = 0;
        try {
            System.out.print("Enter the skill Id : ");
            id = scanner.nextInt();
            System.out.print("Enter the Employee Id : ");
            employeeId = scanner.nextInt();
            skillService.removeSkillFromEmployee(id, employeeId);
            System.out.println("=============Skill Removed=============");
        } catch (EmployeeException e) {
            logger.error("Error while removing skill of id {} from employee of id {}", id, employeeId);
        }
    }

    /**
     * <p>
     * Displays all employees related to a specific skill
     * </p>
     */

    public void displayEmployeesBySkill() {
        int id = 0;
        try {
            System.out.print("Enter the skill Id : ");
            id = scanner.nextInt();
            System.out.println("=============Employees related to the Skill=============");
            for (Employee employee : skillService.getEmployeesBySkill(id)) {
                System.out.println(employee.getName());
            }
        } catch (EmployeeException e) {
            logger.error("Error while fetching employees of skill of id {}", id);
        }
    }

    /**
     * <p>
     * Displays all skills related to an employee
     * </p>
     */

    public void displaySkillsByEmployee() {
        int id = 0;
        try {
            System.out.print("Enter the Employee Id : ");
            id = scanner.nextInt();
            System.out.println("=============Skills related to an Employee=============");
            for (Skill skill : employeeService.getEmployeeById(id).getSkills()) {
                System.out.println(skill.getName());
            }
        } catch (EmployeeException e) {
            logger.error("Error while fetching skills of employee of id {}", id);
        }
    }
}