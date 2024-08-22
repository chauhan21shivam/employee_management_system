package model.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dto.Employee;

public class EmployeeDao { 
	String url="jdbc:postgresql://localhost:5432/emp_management_system";
	String user="postgres";
	String password="root";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stm;
	List<Employee> employees = new ArrayList<Employee>();
		
		{ /*Non Static initializers*/
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,user,password);
			
			stm = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   } /*EOF non static block*/
		
		public boolean loginValidate(Employee emp) {
			String query = "SELECT password FROM employee WHERE role = 'Admin' ";
			try {	
				rs=stm.executeQuery(query);
				if(rs.next()) {
					if(rs.getString(1).equals(emp.getPassword())) 
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else{
					return false;
					}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		} // EOF loginValidateForEmployee() method
		
			
		public boolean insertEmployee(Employee emp) {
			String query = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)";
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, emp.getId());
				ps.setString(2, emp.getName());
				ps.setDouble(3, emp.getSalary());
				ps.setLong(4, emp.getPhone());
				ps.setString(5, emp.getPassword());
				ps.setString(6, emp.getRole());
				
				if(ps.executeUpdate()>0) {
					return true;
				}
				else {
					return false;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return false;	
		} // EOF insertEmployee() method
		
		public boolean removeEmployee(int id) {
			String query = "DELETE FROM EMPLOYEE WHERE ID=?";
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				
				if(ps.executeUpdate()>0) {
					return true;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return false;	
		} // EOF removeEmployee() method
		
		
		public Employee viewEmployee(int id) {
			String query = "SELECT * FROM EMPLOYEE WHERE ID=?";
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs= ps.executeQuery();
				if(rs.next()) {
					return new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getLong(4), rs.getString(5), rs.getString(6));
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		} // EOF viewEmployee() method
		
		public List<Employee> viewAllEmployee(){
			String query = "SELECT * FROM EMPLOYEE";
			try {
				rs=stm.executeQuery(query);
				if(rs.next()) {
					employees.clear();
				do {
					employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getLong(4), rs.getString(5), rs.getString(6)));
				}
				while(rs.next());
			}
			return employees;
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			
		} // EOF viewAllEmployee()
		
		public boolean UpdateEmployee(Employee emp) {
			String query = "update employee set name = ?, salary=?, phone=?, password=?, role=? where id=?";
			try {
				ps = con.prepareStatement(query);
				
				ps.setString(1, emp.getName());
				ps.setDouble(2, emp.getSalary());
				ps.setLong(3, emp.getPhone());
				ps.setString(4, emp.getPassword());
				ps.setString(5, emp.getRole());
				ps.setInt(6, emp.getId());
				
				if(ps.executeUpdate()>0) {
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
			
		} // EOF UpdateEmployee()
		
		
		/* EMPLOYEE LOGIN*/
		
		public boolean loginValidateForEmployee(Employee emp) {
			String query = "SELECT password, role FROM employee WHERE ID = ? ";
			try {	
				ps = con.prepareStatement(query);
				ps.setInt(1, emp.getId());
				rs = ps.executeQuery();
				if(rs.next()) {
					if (rs.getString(1).equals(emp.getPassword()) && !rs.getString(2).equals("Admin"))
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else{
					return false;
					}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		} // EOF loginValidateForEmployee() method
	
		public boolean UpdateData(Employee emp) {
			String query = "update employee set name = ?, phone=?, password=? where id=?";
			try {
				ps = con.prepareStatement(query);
				
				ps.setString(1, emp.getName());
				ps.setLong(2, emp.getPhone());
				ps.setString(3, emp.getPassword());
				ps.setInt(4, emp.getId());
				
				if(ps.executeUpdate()>0) {
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
			
		}
		/*
		public Employee view(int id) {
			String query = "SELECT * FROM EMPLOYEE WHERE ID=?";
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs= ps.executeQuery();
				if(rs.next()) {
					return new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getLong(4), rs.getString(5));
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		} // EOF viewEmployee() method
		*/
}
