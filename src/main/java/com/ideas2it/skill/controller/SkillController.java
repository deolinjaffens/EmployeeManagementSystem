package com.ideas2it.skill.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ideas2it.util.exception.DatabaseException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Skill;
import com.ideas2it.skill.service.SkillService;
import com.ideas2it.skill.service.SkillServiceImpl;

/**
 *<p>
 *Creation,Edition,removal and viewing of skill data is done
 *Initialisation and extraction of skill details are given and obtained
 *</p>
 *@author Deolin Jaffens
 */ 

public class SkillController {
	
	private static Logger logger = LogManager.getLogger(SkillController.class);
    SkillService skillService = new SkillServiceImpl();
    Scanner scanner = new Scanner(System.in);

    /**
	 *<p>
     *Initialization and extraction of details related to Skills are done 
     *for its creation,visualisation,edition and removal
     *</p>
     */

    public void menu() {
        boolean exit = false;
        while(!exit) {
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
            System.out.println("================Back To Main Menu================");
        }
	}

    /**
	 *<p>
     *Details of the skill that has to be added to the database or associated with the 
     *employee is received
     *</p>
     */

    public void addSkill() {
        try {
            System.out.print("Add a Skill : ");
            String name = scanner.next();
            int id = skillService.addSkill(name);
            System.out.println(id);      
            System.out.println("=============Skill Added=============");
        } catch(DatabaseException e) {
            logger.error("failed to add employee");
        }
    }