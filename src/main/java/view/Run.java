package view;

import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import controller.EmployeeController;
import model.dto.Employee;

public class Run {
	
	static { // Static Initializers
		System.out.println("===Welcome to Employee Management System===");
		System.out.println();
		
	       } // EOF Static Initializers
	
	
	Scanner userInput = new Scanner(System.in);
	EmployeeController eControl = new EmployeeController();
	List<Employee> employees;
	Employee emp;
	
	
	public static void main(String [] args) {
		Run run = new Run();
		
		boolean lCondition=true;
		
		while(lCondition) {
			System.out.println("1: Admin Login");
			System.out.println("2: Employee Login");
			System.out.println("3: Exit");
			System.out.println();
			System.out.println("Enter your Choice");
			int lChoice = run.userInput.nextInt();
			run.userInput.nextLine();
			
			switch(lChoice) {
			case 3:
				lCondition=false;
				break;
			case 1:{
				if(run.eControl.loginValidate()) {
					System.out.println("Login SuccessFul");
					System.out.println();
					boolean aCondition = true;
					while(aCondition) {
						System.out.println("1: Insert Employee");
						System.out.println("2: Remove Employee");
						System.out.println("3: Update Employee");
						System.out.println("4: View Employee");
						System.out.println("5: View All Employee");
						System.out.println("6: Exit");
						System.out.println();
						
						System.out.println("Enter the Choice");
						int aChoice = run.userInput.nextInt();
						switch(aChoice) {
						case 6:
							aCondition=false;
							break;
						case 1:
							if(run.eControl.insertEmployee()) {
								System.out.println("Employee Record Inserted successFully");
								System.out.println();
								}
							break;
						case 2:
							if(run.eControl.removeEmployee()) {
								System.out.println("Employee removed successFully");
								System.out.println();
							}
							else {
								System.out.println("Admin can't be removed");
							}
							break;
						case 3:
							if(run.eControl.UpdateEmployee()) {
								System.out.println("Record Updated");
								System.out.println();
							}
							break;
						case 4:
							run.emp=run.eControl.viewEmployee();
							if(run.emp!=null) {
								System.out.println(run.emp);
							System.out.println();
							}
							else {
								System.out.println("No record found");
							}
							break;
						case 5:
							run.employees=run.eControl.viewAllEmployee();
							if(run.employees!=null)
								for(Employee e: run.employees) {
									System.out.println(e);
								}
							System.out.println();
							break;
						} 
					} 
				}
				else
					System.out.println("Invalid Credentials or Employee doesn't Exist");
				System.out.println();
				break;
				} // EOF Case 1
			
			case 2:
			{
				if(run.eControl.loginValidateForEmployee()) {
					System.out.println("Login Succesful");
					System.out.println();
					boolean eCondition = true;
					while(eCondition) {
						System.out.println("1: Update Data");
						System.out.println("2: View Employee");
						System.out.println("3: Exit");
						System.out.println();
						
						System.out.println("Enter the Choice");
						int eChoice = run.userInput.nextInt();
						
						switch(eChoice) {
						case 3:
							eCondition=false;
							System.out.println();
							break;
						case 1:
							if(run.eControl.UpdateData()) {
								System.out.println("Record Updated");
								System.out.println();
							}
							break;
						case 2:
							run.emp=run.eControl.view();
							if(run.emp!=null)
								System.out.println(run.emp);
							System.out.println();
							break;
						}
					}
				}
				else 
					System.out.println("Invalid Credentials");
				System.out.println();
				break;
			
			} // EOF Case 2 
		} // EOF outer While Loop
}
		System.out.println("===Thank You!===");
	}
}
