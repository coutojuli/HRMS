package data;

import java.sql.*;
import business.User;

public class LoginDAO {
	
	private PreparedStatement statement;
	
	public void LoginUser(String userId, String psswd){  
		
		try{  		
 
		StringBuilder str = new StringBuilder();	
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		  
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:GROK","N01348498","oracle");  
		
		str.append("SELECT e.EMPLOYEE_ID, DEPARTMENT, FIRST_NAME || ' ' || LAST_NAME Name ");
		str.append("FROM LOGIN l");
		str.append("JOIN employee e ON (l.EMPLOYEE_ID = e.EMPLOYEE_ID)");
		str.append("WHERE USER_NAME = :userid AND USER_PASSWORD = :psswd");
		
		statement =con.prepareStatement(str.toString());
		statement.setString(1, userId);
		statement.setString(2, psswd);
		
		int empID = 0;
		String name, dept ="";
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			User.setEmpID(rs.getInt("EMPLOYEE_ID"));
			dept = rs.getString("DEPARTMENT");
			User.setDept(dept); 
			User.setName(rs.getString("Name")); 
			
			if(dept.equalsIgnoreCase("HR"))
				User.setisHR(true);
		}
		
		con.close();  		
		}
		catch(Exception e) {

		}
	}  
}
