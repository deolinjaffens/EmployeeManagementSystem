package com.ideas2it.employee.controller;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ideas2it.department.service.DepartmentService;
import com.ideas2it.department.service.DepartmentServiceImpl;
import com.ideas2it.util.dateutil.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.employee.service.EmployeeServiceImpl;
import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.model.Department;
import com.ideas2it.model.Employee;
import com.ideas2it.util.validator.Validator;

/**
 * <p>
 * Creation,Edition,removal and viewing of employee data is done
 * Initialisation and extraction of employee details are given and obtained
 * </p>
 *
 * @author Deolin Jaffens
 */

public class EmployeeController {

    private static Logger logger = LogManager.getLogger(EmployeeController.class);
    EmployeeService employeeService = new EmployeeServiceImpl();
    DepartmentService departmentService = new DepartmentServiceImpl();
    DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    Scanner scanner = new Scanner(System.in);

    /**
     * <p>
     * Creation,edition,visualisation and removal of details related
     * to employee is done
     * </p>
     */

    public void menu() {
        boolean exit = false;
        try {
            while (!exit) {
                System.out.println(" ");
                System.out.println("(1) Add an employee");
                System.out.println("(2) View an employee");
                System.out.println("(3) Update an employee");
                System.out.println("(4) Delete an employee");
                System.out.println("(5) Exit");
                System.out.println(" ");
                System.out.print("Enter an option : ");
                int option = scanner.nextInt();
                System.out.println(" ");

                switch (option) {

                    case 1:
                        addEmployee();
                        break;

                    case 2:
                        viewEmployee();
                        break;

                    case 3:
                        updateEmployee();
                        break;

                    case 4:
                        removeEmployee();
                        break;

                    case 5:
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid option!!");
                }
            }
            System.out.println("=============Back to Main Menu=============");
        } catch (InputMismatchException e) {
            logger.warn(e.getMessage());
        }
    }

    /**
     * <p>
     * To add the details of a specific employee
     * </p>
     */

    public void addEmployee() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.next();
            if (Validator.isValidName(name)) {
                System.out.println("Invalid name");
                return;
            }
            System.out.print("Enter date of birth(dd-mm-yyyy): ");
            LocalDate dob = LocalDate.parse(scanner.next(), datetimeformatter);
            System.out.print("Enter Male(M) or Female(F): ");
            char gender = scanner.next().charAt(0);
            if (Validator.isValidGender(gender)) {
                System.out.println("Enter valid gender");
                return;
            }
            System.out.print("Enter mobile number: ");
            long phNum = scanner.nextLong();
            if (Validator.isValidNumber(phNum)) {
                System.out.println("Invalid Phone Number");
                return;
            }
            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
            if (!departmentService.isDepartmentPresent()) {
                System.out.printf("|%-5s|%-10s|\n", "Department Id", "Department Name");
                for (Department department : departmentService.getAllDepartments()) {
                    System.out.printf("|%-13s|%-15s|\n", department.getId(), department.getName());
                }
            } else {
                System.out.println("No department found");
                return;
            }
            System.out.print("Enter the department Id : ");
            int departmentId = scanner.nextInt();
            int id = employeeService.addEmployee(name, dob, gender, phNum, salary, departmentId);
            System.out.println("Id Number = " + id);
            System.out.println("=============Employee Added=============");
        } catch (InputMismatchException | DateTimeParseException e) {
            logger.warn("Error due to invalid details while adding an employee");
        } catch (EmployeeException e) {
            logger.error("Error while adding employee");
        }
    }

    /**
     * <p>
     * Displays all the details related to a specific employee
     * <p>
     */

    public void viewEmployee() {
        int id = 0;
        try {
            System.out.print("Enter Id Number : ");
            id = scanner.nextInt();
            Employee employee = employeeService.getEmployeeById(id);
            System.out.println("Name : " + employee.getName());
            System.out.println("Department : " + employee.getDepartment().getName());
            System.out.println("Dob : " + employee.getDob());
            System.out.println("Age : " + DateUtil.calculateAge(employee.getDob()));
            System.out.println("Gender : " + employee.getGender());
            System.out.println("Mob. Number : " + employee.getPhoneNumber());
            System.out.println("Salary : " + employee.getSalary());
        } catch (IllegalArgumentException | InputMismatchException e) {
            logger.warn("Error while displaying employee of id {}", id);
        } catch (EmployeeException e) {
            logger.error("Failed to fetch employee details of id {}", id);
        }
    }

    /**
     * <p>
     * Updates any specific details related to a specific employee
     * <p>
     */

    public void updateEmployee() {
        int id = 0;
        try {
            System.out.print("Enter Employee Id : ");
            id = scanner.nextInt();
            Employee employee = employeeService.getEmployeeById(id);
            System.out.print("Name (");
            System.out.print(employee.getName());
            System.out.print(") :");
            String name = scanner.next();
            if (Validator.isValidName(name)) {
                System.out.println("Invalid name");
                return;
            }
            employee.setName(name);
            System.out.print("Date of birth (");
            System.out.print(employee.getDob());
            System.out.print(") :");
            String stringDob = scanner.next();
            LocalDate dob = LocalDate.parse(stringDob, datetimeformatter);
            employee.setDob(dob);
            System.out.print("Gender (");
            System.out.print(employee.getGender());
            System.out.print(") :");
            char gender = scanner.next().charAt(0);
            if (Validator.isValidGender(gender)) {
                System.out.println("Enter valid gender");
            }
            employee.setGender(gender);
            System.out.print("Ph.No. (");
            System.out.print(employee.getPhoneNumber());
            System.out.print(") :");
            long phNum = scanner.nextLong();
            if (Validator.isValidNumber(phNum)) {
                System.out.println("Invalid Phone Number");
            }
            employee.setPhoneNumber(phNum);
            System.out.print("Salary (");
            System.out.print(employee.getSalary());
            System.out.print(") :");
            double salary = scanner.nextDouble();
            employee.setSalary(salary);
            employeeService.updateEmployee(employee);
            System.out.println("=============Employee Updated=============");
        } catch (DateTimeParseException | InputMismatchException e) {
            logger.warn("Value given to update specific details are not true");
        } catch (EmployeeException e) {
            logger.error("Failed to update employee details of employee id {}", id);
        }
    }

    /**
     * <p>
     * Get the id of the employee whose details has to be removed
     * </p>
     */

    public void removeEmployee() {
        int id = 0;
        try {
            System.out.print("Enter Employee Id : ");
            id = scanner.nextInt();
            employeeService.removeEmployee(id);
        } catch (EmployeeException e) {
            logger.error("Failed to remove employee of id {} from the database", id);
        } catch (InputMismatchException e) {
            logger.warn("Value entered for id is not numeric");
            return;
        }
        System.out.println("=============Employee Deleted=============");
    }
}