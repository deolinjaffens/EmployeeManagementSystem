import java.util.InputMismatchException;
import java.util.Scanner;

import com.ideas2it.department.controller.DepartmentController;
import com.ideas2it.employee.controller.EmployeeController;
import com.ideas2it.skill.controller.SkillController;

/**
 *<p>
 *Acts as a navigation to all the controllers
 *</p>
 *@author Deolin Jaffens
 */

public class EmployeeManagementSystem {
	
	/**
	 *<p>
	 *Navigate to various Controllers and provides access to them
	 *</p>
	 */

    public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		DepartmentController departmentController = new DepartmentController();
		EmployeeController employeeController = new EmployeeController();
		SkillController skillController = new SkillController();
		try {
		    while(!exit) {
	            System.out.println("(1) Department menu");
                System.out.println("(2) Employee menu");
                System.out.println("(3) Skill menu");
                System.out.println("(4) Exit");
                System.out.println(" ");
                System.out.print("Enter an option : ");
                int option = scanner.nextInt();
                switch(option) {
		        case 1:
	                departmentController.menu();
		    	    break;
		    	
		        case 2:
		            employeeController.menu();
		    	    break;
		    	
	            case 3:
		            skillController.menu();
		    	    break;
		    	
	            case 4:
		            exit = true;
		    	    break;
		    	
		        default:
		            System.out.println("Invalid option!!");
		    	}
		    }
		    System.out.println("=================Thank You======================");
		} catch(InputMismatchException e) {
			System.out.println("Enter a valid option!!");
		}
    }
}