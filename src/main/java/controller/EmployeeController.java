package controller;

import java.util.List;
import java.util.Scanner;
import model.dao.EmployeeDao;
import model.dto.Employee;
public class EmployeeController {
	
	Scanner userInput = new Scanner(System.in);
	Employee emp = new Employee();
	EmployeeDao eDao = new EmployeeDao();
	List<Employee> employees;
	
	public boolean loginValidate() {
		System.out.println("Enter the user id");
		int id = userInput.nextInt();
		userInput.nextLine();
		System.out.println("Enter the user password");
		String password = userInput.nextLine();
		
		emp.setId(id);
		emp.setPassword(password);
		
		return eDao.loginValidate(emp);	
		} // EOF loginValidate() Method

	public boolean insertEmployee() {
		
		System.out.println("Enter the employee id");
		int id = userInput.nextInt();
		userInput.nextLine();
		
		System.out.println("Enter the employee name");
		String name = userInput.nextLine();
		
		System.out.println("Enter the employee salary");
		double salary = userInput.nextDouble();
		
		System.out.println("Enter the employee phone");
		long phone = userInput.nextLong();
		userInput.nextLine();
		
		System.out.println("Enter the user password");
		String password = userInput.nextLine();
		
		System.out.println("Enter the user role");
		String role = userInput.nextLine();
		
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setPhone(phone);
		emp.setPassword(password);
		emp.setRole(role);
		
		return eDao.insertEmployee(emp);	
	} // EOF insertEmployee() method
	
	public boolean removeEmployee() {
		
		System.out.println("Enter the employee id");
		int id = userInput.nextInt();
		userInput.nextLine();
		emp = eDao.viewEmployee(id);
		if(!emp.getRole().equals("Admin")) {
		return eDao.removeEmployee(id);
		}
		else {
			return false;
		}
	} // EOF removeEmployee() method
	
	public Employee viewEmployee() {
		
		System.out.println("Enter the employee id");
		int id = userInput.nextInt();
		userInput.nextLine();
		
		return eDao.viewEmployee(id);
	} // EOF viewEmployee() method
	
	public List<Employee> viewAllEmployee(){
		return eDao.viewAllEmployee();
		
	} // EOF viewAllEmployee() method

	
	public boolean UpdateEmployee() {
		System.out.println("Enter the employee id");
		int id = userInput.nextInt();
		userInput.nextLine();
		emp = eDao.viewEmployee(id);
			
		if(emp != null) {
			System.out.println(emp);
			System.out.println("Enter the new name otherwise press enter");
			String name = userInput.nextLine();
			System.out.println("Enter the new salary otherwise press enter");
			String salary = userInput.nextLine();
			System.out.println("Enter the new phone otherwise press enter");
			String phone = userInput.nextLine();
			System.out.println("Enter the new password otherwise press enter");
			String password = userInput.nextLine();
			System.out.println("Enter the new role otherwise press enter");
			String role = userInput.nextLine();
			
			if(!name.isEmpty()) {
				emp.setName(name);
			}
			if(!salary.isEmpty()) {
				emp.setSalary(Double.parseDouble(salary));
			}
			if(!phone.isEmpty()) {
				emp.setPhone(Long.parseLong(phone));
			}
			if(!password.isEmpty()) {
				emp.setPassword(password);
			}
			if(!role.isEmpty()) {
				emp.setRole(role);
			}
			return eDao.UpdateEmployee(emp);
		}
		return false;
		
	} // EOF UpdateEmployee() method
	
	
	/* EMPLOYEE LOGIN*/
	
	public boolean loginValidateForEmployee() {
		System.out.println("Enter the user id");
		int id = userInput.nextInt();
		userInput.nextLine();
		System.out.println("Enter the user password");
		String password = userInput.nextLine();
		
		emp.setId(id);
		emp.setPassword(password);
		
		return eDao.loginValidateForEmployee(emp);	
		} // EOF loginValidateForEmployee() Method
	
	public boolean UpdateData() {
		/*
		System.out.println("Enter the employee id");
		int id = userInput.nextInt();
		userInput.nextLine();
		if(id==emp.getId()) {
		emp = eDao.viewEmployee(id);
		System.out.println(emp);
		if(emp != null) {
			System.out.println(emp);
			System.out.println("Enter the new name otherwise press enter");
			String name = userInput.nextLine();
			System.out.println("Enter the new phone otherwise press enter");
			String phone = userInput.nextLine();
			System.out.println("Enter the new password otherwise press enter");
			String password = userInput.nextLine();
			
			if(!name.isEmpty()) {
				emp.setName(name);
			}
			if(!phone.isEmpty()) {
				emp.setPhone(Long.parseLong(phone));
			}
			if(!password.isEmpty()) {
				emp.setPassword(password);
			}
			return eDao.UpdateData(emp);
		}
		}
		else {
			System.out.println("Access denied, Enter correct id");
			return false;
		}
		*/
		
		/*OR*/
		emp = eDao.viewEmployee(emp.getId());
		if(emp != null) {
			System.out.println(emp);
			System.out.println("Enter the new name otherwise press enter");
			String name = userInput.nextLine();
			System.out.println("Enter the new phone otherwise press enter");
			String phone = userInput.nextLine();
			System.out.println("Enter the new password otherwise press enter");
			String password = userInput.nextLine();
			
			if(!name.isEmpty()) {
				emp.setName(name);
			}
			if(!phone.isEmpty()) {
				emp.setPhone(Long.parseLong(phone));
			}
			if(!password.isEmpty()) {
				emp.setPassword(password);
			}
			return eDao.UpdateData(emp);
		}
		return false;
		
	} // EOF UpdateData() method
	
	public Employee view() {
		int id = emp.getId();
		
		/*return eDao.view(id);*/
		return eDao.viewEmployee(id);
	} // EOF view() method
	
	/*
	public static void main(String[] args) {
		EmployeeController eControl = new EmployeeController();
		System.out.println(eControl.loginValidate());
		System.out.println(eControl.insertEmployee());
		System.out.println(eControl.removeEmployee());
		System.out.println(eControl.viewEmployee());
		eControl.employees = eControl.viewAllEmployee();
		for(Employee e: eControl.employees) {
			System.out.println(e);
		}
		System.out.println(eControl.UpdateEmployee());
		*/
		
		/*EMPLOYEE LOGIN*/
	/*
		System.out.println(eControl.loginValidateForEmployee());
		System.out.println(eControl.UpdateData());
		System.out.println(eControl.view());
		System.out.println(eControl.viewEmployee());
		
	}
	*/
}
