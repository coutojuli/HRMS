package business;

public class User {
	
    private static String name, dept, userID, job_title;
    private static int phone, empID;
    private static boolean isHR = false;
    
	public static String getName() {
		return name;
	}
	public static void setName(String newName) {
		name = newName;
	}
	public static int getEmpID() {
		return empID;
	}
	public static void setEmpID(int newEmpID) {
		empID = newEmpID;
	}
	public static String getDept() {
		return dept;
	}
	public static void setDept(String newDept) {
		dept = newDept;
	}
	public static boolean getisHR() {
		return isHR;
	}
	public static void setisHR(boolean newisHR) {
		isHR = newisHR;
	}
}
