package business;

public class Employee {
	
//Variable creation
	
	    private String firstName;
	    private String lastName;
	    private String dob;
	    private String street;
	    private String city;
	    private String status;
	    private String email;
	    private String maritalStatus;
	    private String province;
	    private String postalCode;
	    private String doh;
	    private String department;
	    private String permitNumber;
	    private String employeeType;
	    private String jobTitle;
	    private String expiryDate;
	    private String emergencyContact;
	    private String emergencyPhone;
	    
	    private int recruitment_id;
	    private int empId;
	    private String phone;
	    private int sinNumber;
	    private int add_id;
	    
	    private double payRate;

//Employee Constructors
	    public Employee() {
			
		}
		public Employee(int empId) {

			this.empId = empId;
		}
//General Properties: get:set
	    
    //Employee Id Properties
  		public void setEmpId(int empId) 
  		{
  			this.empId=empId;
  		}
  		public int getEmpId() 
  		{
			return empId;
		}
  //Name Properties
	    public void setFirstName(String firstName) 
	    {
			this.firstName = firstName;
		}
		public String getFirstName() 
		{
			return firstName;
		}
		public void setLastName(String lastName) 
		{
			this.lastName = lastName;
		}
		public String getLastName() 
		{
			return lastName;
		}
	//Phone Properties
		public void setPhone(String phone) 
	    {
			this.phone = phone;
		}
		public String getPhone() 
		{
			return phone;
		}
	//Email Properties
		public void setEmail(String email) 
	    {
			this.email = email;
		}
		public String getEmail() 
		{
			return email;
		}
	//Date of Birth Properties
		public void setDob(String dob) 
	    {
			this.dob = dob;
		}
		public String getDob() 
		{
			return dob;
		}
	//Marital Status Properties
		public void setMaritalStatus(String maritalStatus) 
	    {
			this.maritalStatus = maritalStatus;
		}
		public String getMaritalStatus() 
		{
			return maritalStatus;
		}
	//Address Properties
		public void setStreet(String street) 
	    {
			this.street = street;
		}
		public String getStreet() 
		{
			return street;
		}
		public void setProvince(String province) 
	    {
			this.province = province;
		}
		public String getProvince() 
		{
			return province;
		}
		public void setCity(String city) 
	    {
			this.city = city;
		}
		public String getCity() 
		{
			return city;
		}
		public void setPostalCode(String postalCode) 
	    {
			this.postalCode = postalCode;
		}
		public String getPostalCode() 
		{
			return postalCode;
		}
	//Status Properties
		public void setStatus(String status) 
	    {
			this.status = status;
		}
		public String getStatus() 
		{
			return status;
		}
	//Date of Hire Properties
		public void setDoh(String doh) 
	    {
			this.doh = doh;
		}
		public String getDoh() 
		{
			return doh;
		}
	//Department Properties
		public void setDepartment(String department) 
	    {
			this.department = department;
		}
		public String getDepartment() 
		{
			return department;
		}
	//Permit Properties
		public void setPermit(String permitNumber) 
	    {
			this.permitNumber = permitNumber;
		}
		public String getPermit() 
		{
			return permitNumber;
		}
	//Employee Type Properties
		public void setEmployeeType(String employeeType) 
	    {
			this.employeeType = employeeType;
		}
		public String getEmployeeType() 
		{
			return employeeType;
		}
	//Sin Number Properties
		public void setSinNumber(int sinNumber) 
	    {
			this.sinNumber = sinNumber;
		}
		public int getSinNumber() 
		{
			return sinNumber;
		}
		public void setExpiryDate(String expiryDate ) 
	    {
			this.expiryDate = expiryDate;
		}
		public String getExpiryDate() 
		{
			return expiryDate;
		}
	//Job Title Properties
		public void setJobTitle(String jobTitle) 
	    {
			this.jobTitle = jobTitle;
		}
		public String getJobTitle() 
		{
			return jobTitle;
		}
	//Pay Rate Properties
		public void setPayRate(double payRate ) 
	    {
			this.payRate = payRate;
		}
		public double getPayRate() 
		{
			return payRate;
		}
	//Emergency Contact Properties
		public void setEmergencyContact(String emergencyContact ) 
	    {
			this.emergencyContact = emergencyContact;
		}
		public String getEmergencyContact() 
		{
			return emergencyContact;
		}
		public void setEmergencyPhone(String emergencyPhone) 
		{
			this.emergencyPhone = emergencyPhone;
		}
		public String getEmergencyPhone() 
		{
			return emergencyPhone;
		}
		public void setRecruitentID(int recruitment_id)
		{
			this.recruitment_id = recruitment_id;
		}
		public int getRecruitmentID()
		{
			return recruitment_id;
		}
		public void setAddressID(int add_id)
		{
			this.add_id = add_id;
		}
		public int getAddressID()
		{
			return add_id;
		}
		
		
		
		
}


