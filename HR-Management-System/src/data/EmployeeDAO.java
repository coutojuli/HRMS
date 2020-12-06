package data;

import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;

import business.Employee;
import business.Recruitment;

public class EmployeeDAO
{
	protected Connection con = null;
	protected ResultSet result = null;
	protected PreparedStatement statement = null;
	protected StringBuilder query = null;

	public EmployeeDAO() throws SQLException, ClassNotFoundException
	{
//		this.getConnection();
//		this.getResultSet(); 
	}
	
	public Connection getConnection()
	{
		//Step 1: Import packages
		String driver = "oracle.jdbc.driver.OracleDriver";
		String db_url = "jdbc:oracle:thin:@calvin.humber.ca:1521:GROK";
		
		//Database credentials
		
		String username = "N01348498";
		String password = "oracle";
		
		//Step 2: Register jdbc driver
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
	
	   //Step 3: Open a connection
			con = DriverManager.getConnection(db_url,username,password);
		
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		catch(SQLException s) {
			s.printStackTrace();
		}		
		return con;	
	}
	
	public ResultSet getResultSet() 
	{
		Statement statement = null;
		result = null;
		query = new StringBuilder();
		
		try {
			con = getConnection();
			statement =  con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
			query.append(" Select * from recruitment    													");
			result = statement.executeQuery(query.toString());
			}
			catch(SQLException s) {
				s.printStackTrace();
			}		
			return result;
	}
		
	public void disconect() throws SQLException
	{
		if(!result.isClosed())
		{
			result.close();
			con.close();
			statement.close();
		}
	}
	
	protected void refresh() throws SQLException //Fix it
	{
		Statement statement = null;
		query = new StringBuilder();
		
		query.append("Select * From employee 								"); 
		statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		result = statement.executeQuery(String.valueOf(query));
		result.beforeFirst();
	}

	public int DeleteProfileData(Employee employee) throws SQLException
	{
		statement = null;
		PreparedStatement statement2 = null;
    	result = null;
    	query = new StringBuilder();
    	StringBuilder query2 = new StringBuilder();
    	
    	int profile_handler = employee.getEmpId();
		int count = 0;
		
		query.append("   DELETE    										        ");
		query.append("   FROM employee										");
		query.append("   WHERE EMPLOYEE_ID=?									    ");
		
		statement = con.prepareStatement(query.toString());
		statement.setInt(1, profile_handler);
		count = statement.executeUpdate(); //Returns 1 for dml or 2 for nothing.
		
		query2.append("   DELETE    										        ");
		query2.append("   FROM address										");
		query2.append("   WHERE EMPLOYEE_ID=?									    ");
		
		statement2 = con.prepareStatement(query2.toString());
		statement2.setInt(1, profile_handler);
		count = statement2.executeUpdate(); //Returns 1 for dml or 2 for nothing.
		
		//this.refresh();
		return count;
	}

	public ResultSet ShowProfileDataR(Employee employee) throws SQLException
	{
		int rec_handler_id = employee.getRecruitmentID();
    	query = new StringBuilder();
    	Statement statement = null;
    	
    	query.append("SELECT r.RECRUIT_ID, r.EMPLOYEE_ID,r.INTERVIEW_DATE,r.FIRST_NAME,r.LAST_NAME,r.PHONE,r.EMAIL,jt.jobtitle,		");
    	query.append("d.DEPARTMENT_name,r.CONTACT_PHONE,jty.JOBTYPE,r.EXPECTEDSALARY,r.RECRUITMENTREASON,r.JOBQUALIFICATION,		");
    	query.append("r.RECRUITMENTSTATUS,r.ADDITIONALINTERVIEW,m.managername,r.APPROVAL											");
    	query.append("FROM recruitment r																							");
    	query.append("LEFT JOIN jobtitle jt																						 	");
    	query.append("ON r.JOB_ID = jt.JOBTITLEID																					");
    	query.append("LEFT JOIN jobtype jty																			 			 	");
    	query.append("ON r.JOBTYPE_ID = jty.JOBTYPE_ID																		 		");
    	query.append("LEFT JOIN department d																			 			");
    	query.append("ON r.DEPARMENT_ID=d.DEPARTMENT_ID																			 	");
    	query.append("LEFT JOIN manager m																			 				");
    	query.append("ON r.MANAGERID=m.MANAGER_ID																					");
    	query.append(" WHERE RECRUIT_ID =" + rec_handler_id																			 );
	
    	con = getConnection();
		statement =  con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    	result = statement.executeQuery(query.toString());
    	
    	while(result.next())
    	{
    		int rec_id = result.getInt("RECRUIT_ID");
    		int emp_id = result.getInt("EMPLOYEE_ID");
    		String interview_date = String.valueOf(result.getDate("INTERVIEW_DATE"));
    		String firstName = result.getString("FIRST_NAME");
    		String lastName = result.getString("LAST_NAME");
    		String phone = result.getString("PHONE");
    		String email = result.getString("EMAIL");
    		String jobtitle = result.getString("jobtitle");
    		String dept_name = result.getString("DEPARTMENT_name");
    		String contact_phone = result.getString("CONTACT_PHONE");
    		String jobtype = result.getString("JOBTYPE");
    		String salary = result.getString("EXPECTEDSALARY");
    		String reason = result.getString("RECRUITMENTREASON");
    		String qualification = result.getString("JOBQUALIFICATION");
    		String status = result.getString("RECRUITMENTSTATUS");
    		String interview = result.getString("ADDITIONALINTERVIEW");
    		String manager = result.getString("managername");
    		String approval = result.getString("APPROVAL");
	    	
    		if(rec_id == rec_handler_id)
	    	{
    			employee.setRecruitentID(rec_id);
    			employee.setEmpId(emp_id);
    			employee.setFirstName(firstName);
    			employee.setLastName(lastName);
    			employee.setPhone(phone);
    			employee.setEmail(email);
    			employee.setJobTitle(jobtitle);
    			employee.setDepartment(dept_name);
    			employee.setEmployeeType(jobtype);
    			employee.setStatus(status);
    			employee.setDoh(interview_date);
	    	}
    	}
    	return result;	
	}

	public ResultSet ShowProfileDataE(Employee employee) throws SQLException
	{
		int emp_handler_id = employee.getEmpId();
    	query = new StringBuilder();
    	Statement statement = null;
    	
    	query.append(" SELECT e.EMPLOYEE_ID,e.FIRST_NAME,e.LAST_NAME,e.EMAIL,e.PHONE,e.DATE_OF_BIRTH,																					");
    	query.append(" e.MARITAL_STATUS,e.STATUS,d.DEPARTMENT_name,e.DATE_OF_HIRE,jty.JOBTYPE,																							");
    	query.append(" e.PAY_RATE,e.EMERGENCYCONTACT,e.EMERGENCYPHONE,e.DOC_EXPIRY_DATE,e.SINNUMBER,e.WORKPERMIT,e.JOBTITLE,e.ADDRESS,r.RECRUIT_ID,                                                   ");
    	query.append(" c.CITY,a.STREET,a.PROVINCE,a.POSTAL_CODE                                                     														");
    	query.append(" FROM employee e																								                                                     ");
    	query.append(" LEFT JOIN jobtype jty																			 					 			                                 ");
    	query.append(" ON e.JOBTYPE_ID = jty.JOBTYPE_ID																								 	                                ");
    	query.append(" LEFT JOIN department d																			 					 		                                    ");
    	query.append(" ON e.DEPARTMENT_ID=d.DEPARTMENT_ID                                                                                                                                ");
    	query.append("LEFT JOIN recruitment r                                                                                                                                            ");
    	query.append("ON e.EMPLOYEE_ID = r.EMPLOYEE_ID																																	");
    	query.append("LEFT JOIN address a																																				");
    	query.append("ON e.EMPLOYEE_ID = a.EMPLOYEE_ID                                                                                                                                   ");
    	query.append("LEFT JOIN city c                                                                                                                                                  ");
    	query.append("ON a.CITY_ID = c.CITY_ID                                                                                                                                            ");
    	query.append(" WHERE e.EMPLOYEE_ID =" + emp_handler_id																															 );
    	
    	con = getConnection();
		statement =  con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    	result = statement.executeQuery(query.toString());
    	
    	while(result.next())
    	{
    		int emp_id = result.getInt("EMPLOYEE_ID");
    		String firstName = result.getString("FIRST_NAME");
    		String lastName = result.getString("LAST_NAME");
    		String email = result.getString("EMAIL");
    		int phone = result.getInt("PHONE");
    		String dob = result.getString(String.valueOf("DATE_OF_BIRTH"));
    		String maritalStatus = result.getString("MARITAL_STATUS");
    		String status = result.getString("STATUS");
    		String dept_name = result.getString("DEPARTMENT_name");
    		String doh = result.getString(String.valueOf("DATE_OF_HIRE"));
    		String jobType = result.getString("JOBTYPE");
    		int payRate = result.getInt("PAY_RATE");
    		String emergencyContact = result.getString("EMERGENCYCONTACT");
    		int emergencyPhone = result.getInt("EMERGENCYPHONE");
    		String expiry_date = result.getString(String.valueOf("DOC_EXPIRY_DATE"));
    		int sin = result.getInt("SINNUMBER");
    		int permit = result.getInt("WORKPERMIT");
    		String jobTitle = result.getString("JOBTITLE");
    		String address = result.getString("ADDRESS");
    		int rec_id = result.getInt("RECRUIT_ID");
    		String city = result.getString("CITY");
    		String street = result.getString("STREET");
    		String province = result.getString("PROVINCE");
    		String postalcode = result.getString("POSTAL_CODE");

    		if(emp_id == emp_handler_id)
    		{   		
        		employee.setEmpId(emp_id);
        		employee.setFirstName(firstName);
    			employee.setLastName(lastName);
    			employee.setEmail(email);
    			employee.setPhone(String.valueOf(phone));
    			employee.setDob(dob);
    			employee.setMaritalStatus(maritalStatus);
    			employee.setStatus(status);
    			employee.setDepartment(dept_name);
    			employee.setDoh(doh);
    			employee.setEmployeeType(jobType);
    			employee.setPayRate(payRate);
    			employee.setEmergencyContact(emergencyContact);
    			employee.setEmergencyPhone(String.valueOf(emergencyPhone));
    			employee.setExpiryDate(expiry_date);
    			employee.setSinNumber(sin);
    			employee.setPermit(String.valueOf(permit));
    			employee.setJobTitle(jobTitle);
    			employee.setRecruitentID(rec_id);
    			employee.setCity(city);
    			employee.setStreet(street);
    			employee.setProvince(province);
    			employee.setPostalCode(postalcode);
	    	}
    	}
    	return result;	
	}
	
	public int UpdateEmployeeData(Employee employee) throws SQLException
	{
		this.SelectDepartment(employee);
		this.SelectJobType(employee);
		
		query = new StringBuilder();
    	
		int count = 0;
		
		query.append("  UPDATE employee SET FIRST_NAME =?,LAST_NAME =? ,EMAIL =? ,PHONE =? ,DATE_OF_BIRTH =? , 																					");
		query.append("	MARITAL_STATUS =? ,STATUS =? ,DEPARTMENT_ID =? ,DATE_OF_HIRE =? ,JOBTYPE_ID =? ,PAY_RATE =? ,EMERGENCYCONTACT =? ,EMERGENCYPHONE =?, 									");
		query.append("	DOC_EXPIRY_DATE =? ,SINNUMBER =? ,WORKPERMIT =? ,JOBTITLE =? 																											");
		query.append("	WHERE EMPLOYEE_ID =?																														");
	
		statement = con.prepareStatement(String.valueOf(query));
		
		statement.setString(1, employee.getFirstName());
		statement.setString(2,employee.getLastName());
		statement.setString(3, employee.getEmail());
		statement.setString(4, employee.getPhone());
		statement.setString(5, employee.getDob());
		statement.setString(6, employee.getMaritalStatus());
		statement.setString(7, employee.getStatus()); 
		statement.setInt(8, Integer.parseInt(employee.getDepartment())); //dptid?
		statement.setString(9, employee.getDoh()); 
		statement.setInt(10, Integer.parseInt(employee.getEmployeeType())); //jobtypeid?
		statement.setDouble(11, employee.getPayRate());
		statement.setString(12, employee.getEmergencyContact());
		statement.setString(13, employee.getEmergencyPhone());
		statement.setString(14, employee.getExpiryDate());
		statement.setInt(15, employee.getSinNumber());
		statement.setString(16, employee.getPermit()); 
		statement.setString(17, employee.getJobTitle());
		statement.setInt(18, employee.getEmpId());
	
		count = statement.executeUpdate();  //Returns 1 for dml or 2 for nothing.
		//this.refresh();
		return count;
	}
	
	public ResultSet SelectAddressId(Employee employee) throws SQLException
    {
    	query = new StringBuilder();
    	//Query to select MAX AddressId : Used to generate next random number
		query.append(" SELECT MAX(ADRESS_ID) As MAXADDID									 				 ");
		query.append(" FROM Address																 ");
		
		statement = con.prepareStatement(query.toString());
		result = statement.executeQuery();
		
		while(result.next())
		{
			int add_id = result.getInt("MAXADDID");
			employee.setAddressID(add_id);
		}
		return result;
    }
	
	public int UpdateAddressData(Employee employee) throws SQLException
	{
		this.SelectCity(employee);
		query = new StringBuilder();
		StringBuilder query1 = new StringBuilder();
		int count = 0;
		result = null;
		int emp_handler = employee.getEmpId();
		boolean flag = false;
		
		
		query1.append( "	SELECT COUNT(1) count	FROM Address	where employee_id = " + emp_handler);
		statement = con.prepareStatement(String.valueOf(query1));
		result = statement.executeQuery(query1.toString());
		
		if(result != null)
		{
				while(result.next())
			{
				int countEmp = result.getInt("count");
				
				if(countEmp > 0)
				{
					flag = true;
				}
				else 
				{
					flag = false;
				}
			}
		}
		else
		{	
			flag=false;
		}
			
		if(flag == false)
		{
			statement = null;
			query.append("	INSERT INTO Address (ADRESS_ID,CITY_ID, STREET, EMPLOYEE_ID, PROVINCE, POSTAL_CODE) 			                     ");
			query.append("  VALUES (?,?,?,?,?,?)																								     ");
		
			statement = con.prepareStatement(String.valueOf(query));
			statement.setInt(1, employee.getAddressID());
			statement.setString(2, employee.getCity());
			statement.setString(3,employee.getStreet());
			statement.setInt(4, employee.getEmpId());
			statement.setString(5, employee.getProvince());
			statement.setString(6, employee.getPostalCode());
				
			count = statement.executeUpdate();  //Returns 1 for dml or 2 for nothing.
			//this.refresh();
		}
		else
		{
			statement = null;
			query.append("UPDATE Address SET CITY_ID =? , STREET =? , PROVINCE =? , POSTAL_CODE =? 																		");
			query.append("WHERE EMPLOYEE_ID =? 																									");
		
			statement = con.prepareStatement(String.valueOf(query));
			
			statement.setString(1, employee.getCity());
			statement.setString(2,employee.getStreet());
			statement.setString(3, employee.getProvince());
			statement.setString(4, employee.getPostalCode());
			statement.setInt(5, employee.getEmpId());
			
			count = statement.executeUpdate();  //Returns 1 for dml or 2 for nothing.
			
			//this.refresh();
		}
		
		return count;
	}
	public ResultSet SelectCity(Employee employee) throws SQLException
	{
		//Query: Converting cityName into cityId
				query = new StringBuilder();
				String city_handler_name = employee.getCity();
				query.append("SELECT CITY_ID, CITY 										 ");
				query.append("FROM city																 ");
				query.append("WHERE CITY=?														 ");
				statement = con.prepareStatement(query.toString());
				statement.setString(1, city_handler_name);
				result = statement.executeQuery();
				
				while(result.next())
				{
					int city_id = result.getInt("CITY_ID");
					String city_name = result.getString("CITY");
					if (city_name.equalsIgnoreCase(city_handler_name))
					{
						employee.setCity(String.valueOf(city_id));
					}
				}
				return result;
	}
	public ResultSet SelectDepartment(Employee employee) throws SQLException
	{
		//Query: Converting departmentName into departmentId
		query = new StringBuilder();
		String dept_handler_name = employee.getDepartment();
		query.append("SELECT department_id, department_name 										 ");
		query.append("FROM departments																 ");
		query.append("WHERE department_name=?														 ");
		statement = con.prepareStatement(query.toString());
		statement.setString(1, dept_handler_name);
		result = statement.executeQuery();
		
		while(result.next())
		{
			int dept_id = result.getInt("department_id");
			String dept_name = result.getString("department_name");
			if (dept_name.equalsIgnoreCase(dept_handler_name))
			{
				employee.setDepartment(String.valueOf(dept_id));
			}
		}
		return result;
	}
	public ResultSet SelectJobType(Employee employee) throws SQLException
	{
		//Query: Converting JobTypenName into JobTypeId
		query = new StringBuilder();
		String jobtype_handler_name = employee.getEmployeeType();
		query.append("SELECT jobtype_id, jobtype										 ");
		query.append("FROM jobtype														  ");
		query.append("WHERE jobtype=?												      ");
		statement = con.prepareStatement(query.toString());
		statement.setString(1, jobtype_handler_name);
		result = statement.executeQuery();
		
		while(result.next())
		{
			int jobtype_id = result.getInt("jobtype_id");
			String jobtype_name = result.getString("jobtype");
			if (jobtype_name.equalsIgnoreCase(jobtype_handler_name))
			{
				employee.setEmployeeType(String.valueOf(jobtype_id));
			}
		}
		return result;
	}

	 public void PopulateProfileCb(JComboBox cbRecruitmentId,JComboBox cbCity,JComboBox cbStatus,JComboBox cbMaritalStatus,JComboBox cbProvince, JComboBox cbDepartment,JComboBox cbEmployeeType,JComboBox cbEmpId) throws SQLException
	    {
		 cbRecruitmentId.removeAllItems();
		 cbCity.removeAllItems();
		 cbStatus.removeAllItems();
		 cbMaritalStatus.removeAllItems();
		 cbProvince.removeAllItems();
		 cbDepartment.removeAllItems();
		 cbEmployeeType.removeAllItems();
		 cbEmpId.removeAllItems();
		 	
		 	StringBuilder query0=new StringBuilder();
		 	query0.append(" 	SELECT recruit_id												");
		 	query0.append("		from recruitment r												");
		 	query0.append("		left join employee e 											");
		 	query0.append("		on r.employee_id = e.employee_id								");
		 	query0.append("		where r.RECRUITMENTSTATUS = 'Approved' AND e.STATUS ='Approved'										");
		 	
		 	String query1 = " SELECT CITY,PROVINCE              FROM city ";
		 	String query2 = " SELECT status_name                FROM status";
		 	String query3 = " SELECT status_name                FROM maritalStatus";            
		 	String query4 = " SELECT department_name          FROM departments";
	    	String query5 = " SELECT JOBTYPE                 FROM jobtype";
	    	String query6 = " SELECT EMPLOYEE_ID             FROM employee";									

	    	PreparedStatement statement0 = null;
	    	PreparedStatement statement1 = null;
	    	PreparedStatement statement2 = null;
	    	PreparedStatement statement3 = null;
	    	PreparedStatement statement4 = null;
	    	PreparedStatement statement5 = null;
	    	PreparedStatement statement6 = null;
	    	
	    	ResultSet result0 = null;
	    	ResultSet result1 = null;
	    	ResultSet result2 = null;
	    	ResultSet result3 = null;
	    	ResultSet result4 = null;
	    	ResultSet result5 = null;
	    	ResultSet result6 = null;
	    	
			try {
				
				con = getConnection();
				statement0 =  con.prepareStatement(query0.toString());
				statement1 = con.prepareStatement(query1);
				statement2 = con.prepareStatement(query2);
				statement3 = con.prepareStatement(query3);
				statement4 = con.prepareStatement(query4);
				statement5 = con.prepareStatement(query5);
				statement6 = con.prepareStatement(query6);
				
				result0 = statement0.executeQuery();
				result1 = statement1.executeQuery();
				result2 = statement2.executeQuery();
				result3 = statement3.executeQuery();
				result4 = statement4.executeQuery();
				result5 = statement5.executeQuery();
				result6 = statement6.executeQuery();
				
				while(result0.next())
				{
					String rec_id = result0.getString("RECRUIT_ID");
					cbRecruitmentId.addItem(rec_id);
				}
				while(result1.next())
				{
					String city_name = result1.getString("CITY");
					String province_name = result1.getString("PROVINCE");
					cbCity.addItem(city_name);
					cbProvince.addItem(province_name);
				}
				while(result2.next())
				{
					String status_name = result2.getString("status_name");
					cbStatus.addItem(status_name);
				}
				while(result3.next())
				{
					String m_status_name = result3.getString("status_name");
					cbMaritalStatus.addItem(m_status_name);
				}
				while(result4.next())
				{
					String department_name = result4.getString("department_name");
					cbDepartment.addItem(department_name);
				}
				while(result5.next())
				{
					String jobtype = result5.getString("JOBTYPE");
					cbEmployeeType.addItem(jobtype);
				}
				while(result6.next())
				{
					String emp_id = result6.getString("EMPLOYEE_ID");
					cbEmpId.addItem(emp_id);
				}
	    	}catch (SQLException e) {
				e.printStackTrace();
	    	}
//	    	}finally
//			{
//	    		this.disconect();
//			}
	    }
}
