package data;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import business.Employee;
import business.Recruitment;

public class RecruitmentDAO 
{
	public Connection con = null;
	ResultSet result = null;
	PreparedStatement statement = null;
	StringBuilder query = new StringBuilder();

	public RecruitmentDAO () throws SQLException, ClassNotFoundException
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
		
		query.append("Select * From recruitment 								"); 
		statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		result = statement.executeQuery(String.valueOf(query));
		result.beforeFirst();
	}

	public ResultSet SelectDepartments(Recruitment recruitment) throws SQLException
	{
	//Query A: Converting departmentName into departmentId
		query = new StringBuilder();
		String dept_handler_name = recruitment.getDepartment();
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
				recruitment.setDepartment(String.valueOf(dept_id));
			}
		}
		return result;
	}
	
	public ResultSet SelectJobtype(Recruitment recruitment) throws SQLException
    {
	//Query B: Converting JobTypenName into JobTypeId
		query = new StringBuilder();
		String jobtype_handler_name = recruitment.getJobType();
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
				recruitment.setJobType(String.valueOf(jobtype_id));
			}
		}
		return result;
    }
		
    public ResultSet SelectJobtitle(Recruitment recruitment) throws SQLException
    {
    	query = new StringBuilder();
	//Query C: Converting jobid into jobTitleName
		String jobtitle_handler_name = recruitment.getJobTitle();
		query.append("SELECT jobtitleid, jobtitle										 ");
		query.append("FROM jobtitle																 ");
		query.append("WHERE jobtitle=?															 ");
		statement = con.prepareStatement(query.toString());
		statement.setString(1, jobtitle_handler_name);
		result = statement.executeQuery();
		
		while(result.next())
		{
			int jobtitle_id = result.getInt("jobtitleid");
			String jobtitle_name = result.getString("jobtitle");
			if (jobtitle_name.equalsIgnoreCase(jobtitle_handler_name))
			{
				recruitment.setJobTitle(String.valueOf(jobtitle_id));
			}
		}
		return result;
    }
    
    public void PopulateDepartmentCb(JComboBox cbDepartment,JComboBox cbJobTitle,JComboBox cbHR,JComboBox cbJobType) throws SQLException
    {
    	String query = " SELECT department_name          FROM departments";
    	String query1 = " SELECT jobtitle                FROM jobtitle";
    	String query2 = " SELECT  MANAGERNAME            FROM manager";
    	String query3 = " SELECT JOBTYPE                 FROM jobtype";

    	PreparedStatement statement = null;
    	PreparedStatement statement1 = null;
    	PreparedStatement statement2 = null;
    	PreparedStatement statement3 = null;
    	
    	ResultSet result = null;
    	ResultSet result1 = null;
    	ResultSet result2 = null;
    	ResultSet result3 = null;
    	
		try {
			
			con = getConnection();
			statement =  con.prepareStatement(query);
			statement1 = con.prepareStatement(query1);
			statement2 = con.prepareStatement(query2);
			statement3 = con.prepareStatement(query3);
			result = statement.executeQuery();
			result1 = statement1.executeQuery();
			result2 = statement2.executeQuery();
			result3 = statement3.executeQuery();
			
			while(result.next())
			{
				String dept_name = result.getString("department_name");
				cbDepartment.addItem(dept_name);
			}
			while(result1.next())
			{
				String jobtitle_name = result1.getString("jobtitle");
				cbJobTitle.addItem(jobtitle_name);
			}
			while(result2.next())
			{
				String manager_name = result2.getString("MANAGERNAME");
				cbHR.addItem(manager_name);
			}
			while(result3.next())
			{
				String jobtype = result3.getString("JOBTYPE");
				cbJobType.addItem(jobtype);
			}
    	}catch (SQLException e) {
			e.printStackTrace();
    	}
//    	}finally
//		{
//    		this.disconect();
//		}
    }
	
    public ResultSet SelectManager(Recruitment recruitment) throws SQLException
    {
    //Query D: Converting managerId into manager name
    	query = new StringBuilder();		
		String manager_handler_name = recruitment.getHrManager();
		query.append("SELECT manager_id, managername										 ");
		query.append("FROM manager																 ");
		query.append("WHERE managername=?															 ");
		statement = con.prepareStatement(query.toString());
		statement.setString(1, manager_handler_name);
		result = statement.executeQuery();
		
		while(result.next())
		{
			int manager_id = result.getInt("manager_id");
			String manager_name = result.getString("managername");
			if (manager_name.equalsIgnoreCase(manager_handler_name))
			{
				recruitment.setHrManager(String.valueOf(manager_id));
			}
		}
		return result;
    }
    
    public ResultSet SelectEmpId(Recruitment recruitment) throws SQLException
    {
    	query = new StringBuilder();
    	//Query to select MAX empId : Used to generate next random number
		query.append(" SELECT MAX(EMPLOYEE_ID) As MAXEMPID									 				 ");
		query.append(" FROM employee																 ");
		
		statement = con.prepareStatement(query.toString());
		result = statement.executeQuery();
		
		while(result.next())
		{
			int emp_id = result.getInt("MAXEMPID");
			recruitment.setEmpId(emp_id);
		}
		return result;
    }
    
    public int InsertRecruitmentData(Recruitment recruitment) throws SQLException
    {
    	SelectDepartments(recruitment);
    	SelectJobtitle(recruitment);
    	SelectJobtype(recruitment);
    	SelectManager(recruitment);
    	
    	query = new StringBuilder();
		int count = 0;
		query.append("	INSERT INTO recruitment (RECRUIT_ID, EMPLOYEE_ID,INTERVIEW_DATE,FIRST_NAME,LAST_NAME,PHONE, 			");
		query.append("	EMAIL,JOB_ID,DEPARMENT_ID,CONTACT_PHONE,JOBTYPE_ID,EXPECTEDSALARY,RECRUITMENTREASON, 					");		
		query.append("	JOBQUALIFICATION,RECRUITMENTSTATUS,ADDITIONALINTERVIEW,MANAGERID,APPROVAL)								");
		query.append("	VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)															");		
		
		statement = con.prepareStatement(query.toString());
		statement.setInt(1, recruitment.getRecruitmentId());
		statement.setInt(2, recruitment.getEmpId());
		statement.setString(3,recruitment.getRecruitmentDate());
		statement.setString(4, recruitment.getFirstName());
		statement.setString(5, recruitment.getLastName());
		statement.setString(6, String.valueOf(recruitment.getPhone()));
		statement.setString(7, recruitment.getEmail());
		statement.setInt(8, Integer.parseInt(recruitment.getJobTitle())); // jobid?
		statement.setInt(9, Integer.parseInt(recruitment.getDepartment())); //dptid?
		statement.setString(10, recruitment.getContactPhone()); //contact phone?
		statement.setInt(11, Integer.parseInt(recruitment.getJobType())); //jobtypeid?
		statement.setString(12, String.valueOf(recruitment.getExpectedSalary()));
		statement.setString(13, recruitment.getRecruitmentReason());
		statement.setString(14, recruitment.getJobQualifications());
		statement.setString(15, recruitment.getRecruitmentStatus());
		statement.setString(16, recruitment.getAdditionalInterview());
		statement.setInt(17, Integer.parseInt(recruitment.getHrManager())); //managerid?
		statement.setString(18, recruitment.getApproval());
		
		count = statement.executeUpdate(); //Returns 1 for dml or 2 for nothing.
		//this.refresh();
		
		//Data on employee will only be insert if rec_status is Approved.
		if(recruitment.getRecruitmentStatus().equalsIgnoreCase("Approved"))
		{
			Employee employee = new Employee();
			this.InsertRecEmpData(recruitment, employee);
			
			if(count == 1)
			{	
				if(this.InsertRecEmpData(recruitment, employee) == 1)
				{
					return count;
				}
			}
			return count = 0;
		}

			return count;
    }

    public int InsertRecEmpData(Recruitment recruitment,Employee employee) throws SQLException
    {
    	query = new StringBuilder();
		int count = 0;
		query.append("  INSERT INTO employee (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,PHONE,EMAIL,DATE_OF_HIRE,                        ");
		query.append("  DEPARTMENT_ID,JOBTYPE_ID,JOBTITLE,STATUS)																");
		query.append("  VALUES (?,?,?,?,?,?,?,?,?,?)																			");
		
		statement = con.prepareStatement(query.toString());
		statement.setInt(1, recruitment.getEmpId());
		statement.setString(2, recruitment.getFirstName());
		statement.setString(3, recruitment.getLastName());
		statement.setString(4, String.valueOf(recruitment.getPhone()));
		statement.setString(5, recruitment.getEmail());
		statement.setString(6,recruitment.getRecruitmentDate());
		statement.setInt(7, Integer.parseInt(recruitment.getDepartment()));
		statement.setInt(8, Integer.parseInt(recruitment.getJobType()));
		statement.setInt(9, Integer.parseInt(recruitment.getJobTitle()));
		statement.setString(10, recruitment.getRecruitmentStatus());
		
		count = statement.executeUpdate(); //Returns 1 for dml or 2 for nothing.
		//this.refresh();
		return count;
    }
    
    public int DeleteRecruitmentData(Recruitment recruitment) throws SQLException
    {
    	statement = null;
    	PreparedStatement statement1 = null;
    	PreparedStatement statement2 = null;
    	ResultSet result2 = null;
    	query = new StringBuilder();
    	StringBuilder query1 = new StringBuilder();
    	StringBuilder query2 = new StringBuilder();
    	
    	int recruitment_handler = recruitment.getRecruitmentId();
    	int employee_handler = 0;
		int count = 0;
		int count1 = 0;
		
		query2.append("   SELECT RECRUIT_ID,EMPLOYEE_ID                                                 ");
    	query2.append("   FROM recruitment                                                         ");
    	query2.append("   WHERE RECRUIT_ID =? 													  ");
    	
    	statement2 = con.prepareStatement(String.valueOf(query2));
    	statement2.setInt(1,recruitment_handler);
    	result2 = statement2.executeQuery();
    	
    	while(result2.next())
		{
			int rec_id  = result2.getInt("RECRUIT_ID");
    		int emp_id = result2.getInt("EMPLOYEE_ID");
			if (rec_id == recruitment_handler)
			{
				employee_handler = emp_id;
			}
		}
		
		query.append("   DELETE    										        ");
		query.append("   FROM recruitment										");
		query.append("   WHERE RECRUIT_ID=?									    ");
		
		statement = con.prepareStatement(query.toString());
		statement.setInt(1, recruitment_handler);
		count = statement.executeUpdate(); //Returns 1 for dml or 2 for nothing.
    
		//When a interview candidate is deleted from recruitment, it is also deleted on the employee database.
		if(count == 1)
		{
			query1.append("   DELETE    										        ");
			query1.append("   FROM employee												");
			query1.append("   WHERE EMPLOYEE_ID=?									    ");
			
			statement1 = con.prepareStatement(query1.toString());
			statement1.setInt(1, employee_handler);
			count1 = statement1.executeUpdate(); //Returns 1 for dml or 2 for nothing.
		}
		//this.refresh();
		return count1;		
    }
		
    public int Update(Recruitment recruitment) throws SQLException
    {
    	//Passing the actual status of the recruitment id
    	query = new StringBuilder();
    	int rec_handler_id = recruitment.getRecruitmentId();
    	String act_status = "Approved";
    	result = null;
       	int count = 0;
    	
    	query.append("   SELECT RECRUIT_ID,RECRUITMENTSTATUS                                                 ");
    	query.append("   FROM recruitment                                                         ");
    	query.append("   WHERE RECRUIT_ID =? 													  ");
    	
    	statement = con.prepareStatement(String.valueOf(query));
    	statement.setInt(1,rec_handler_id);
    	result = statement.executeQuery();
    	
    	while(result.next())
		{
			int rec_id  = result.getInt("RECRUIT_ID");
    		String rec_status = result.getString("RECRUITMENTSTATUS");
			if (rec_id == rec_handler_id)
			{
				act_status = rec_status;
			}
		}
		
    	//If this status is not Approved, it will be able to be changed
    	if(!(act_status.equalsIgnoreCase("Approved")))
    	{
	    	this.SelectDepartments(recruitment);
	    	this.SelectJobtitle(recruitment);
	    	this.SelectJobtype(recruitment);
	    	this.SelectManager(recruitment);
	    	
	    	query = new StringBuilder();
	    	
			query.append("	UPDATE recruitment SET EMPLOYEE_ID =? ,INTERVIEW_DATE =? ,FIRST_NAME =? ,LAST_NAME =? ,PHONE =?,  									");
			query.append("	EMAIL =? ,JOB_ID =? ,DEPARMENT_ID =? ,CONTACT_PHONE =? ,JOBTYPE_ID =? ,EXPECTEDSALARY =? ,RECRUITMENTREASON =?,  					");		
			query.append("	JOBQUALIFICATION =? ,RECRUITMENTSTATUS =? ,ADDITIONALINTERVIEW =? ,MANAGERID =? ,APPROVAL =? 										");
			query.append("	WHERE RECRUIT_ID =?		                                                                                                            ");
																															
			statement = con.prepareStatement(String.valueOf(query));
			statement.setInt(1, recruitment.getEmpId());
			statement.setString(2,recruitment.getRecruitmentDate());
			statement.setString(3, recruitment.getFirstName());
			statement.setString(4, recruitment.getLastName());
			statement.setString(5, String.valueOf(recruitment.getPhone()));
			statement.setString(6, recruitment.getEmail());
			statement.setInt(7, Integer.parseInt(recruitment.getJobTitle())); // jobid?
			statement.setInt(8, Integer.parseInt(recruitment.getDepartment())); //dptid?
			statement.setString(9, recruitment.getContactPhone()); //contact phone?
			statement.setInt(10, Integer.parseInt(recruitment.getJobType())); //jobtypeid?
			statement.setString(11, String.valueOf(recruitment.getExpectedSalary()));
			statement.setString(12, recruitment.getRecruitmentReason());
			statement.setString(13, recruitment.getJobQualifications());
			statement.setString(14, recruitment.getRecruitmentStatus());
			statement.setString(15, recruitment.getAdditionalInterview());
			statement.setInt(16, Integer.parseInt(recruitment.getHrManager())); //managerid?
			statement.setString(17, recruitment.getApproval());
			statement.setInt(18, recruitment.getRecruitmentId());
		
			count = statement.executeUpdate();  //Returns 1 for dml or 2 for nothing.	
			
			if(recruitment.getRecruitmentStatus().equalsIgnoreCase("Approved"))
			{
				Employee employee = new Employee();
				this.InsertRecEmpData(recruitment, employee);
				
				if(count == 1)
				{	
					if(this.InsertRecEmpData(recruitment, employee) == 1)
					{
						return count;
					}
				}
				return count = 0;
			}
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null, "Candidate with approved status cannot be updated. Delete candidate and create a new one. This will also delete his employee record.");
    	}
    	return count;	
    }
    
    public ResultSet ShowRecruitmentData(Recruitment recruitment) throws SQLException
    {
    	int rec_handler_id = recruitment.getRecruitmentId();
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
	    		recruitment.setRecruitmentId(rec_id);
	    		recruitment.setEmpId(emp_id);
	    		recruitment.setRecruitmentDate(interview_date);
	    		recruitment.setFirstName(firstName);
	    		recruitment.setLastName(lastName);
	    		recruitment.setPhone(phone);
	    		recruitment.setEmail(email);
	    		recruitment.setJobTitle(jobtitle);
	    		recruitment.setDepartment(dept_name);
	    		recruitment.setContactPhone(contact_phone);
	    		recruitment.setJobType(jobtype);
	    		recruitment.setExpectedSalary(salary);
	    		recruitment.setRecruitmentReason(reason);
	    		recruitment.setJobQualifications(qualification);
	    		recruitment.setRecruitmentStatus(status);;
	    		recruitment.setAdditionalInterview(interview);
	    		recruitment.setHrManager(manager);
	    		recruitment.setApproval(approval);
	    	}
    	}
    	return result;	
    }
    
}
