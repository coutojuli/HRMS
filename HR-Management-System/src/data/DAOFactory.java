package data;

public class DAOFactory {
	public static EmployeeDAO getEmployeeDAO() 
	{
		EmployeeDAO eDAO=new EmployeeDAORandom();
		return eDAO;
	}

	public static PerformanceDAO getPerformanceDAO()
	{
		PerformanceDAO prDAO = new PerformanceDAOText();
		return prDAO;
	}
	
//	public static PayRollDAO getPayRollDAO()
//	{
//		PayRollDAO prDAO = new PayRollDAORandom();
//		return prDAO;
//	}
	
	public static RecruitmentDAO getRecruitmentDAO()
	{
		RecruitmentDAO rDAO = new RecruitmentDAOText();
		return rDAO;
	}
}