package business;

public class Recruitment extends Employee{
	
	//Variable creation
	
	String recruitmentDate;
	String recruitmentType;
	String paymentType;
	String recruitmentReason;
	String jobQualifications;
	String recruitmentStatus;
	String additionalInterview;
	String HrManager;
	String DptManager;
	int recruitmentId;
	String jobtype;
	String contactPhone;
	String approval;
	String expectedSalary;
	
	//Methods for get and set 
	
	public Recruitment()
	{
		
	}
	public void setRecruitmentId(int recruitmentId)
	{
		this.recruitmentId = recruitmentId;
	}
	public int getRecruitmentId()
	{
		return recruitmentId;
	}
	public void setRecruitmentDate(String recruitmentDate)
	{
		this.recruitmentDate = recruitmentDate;
	}
	public String getRecruitmentDate()
	{
		return recruitmentDate;
	}
	
	public void setRecruitmentType(String recruitmentType)
	{
		this.recruitmentType = recruitmentType;
	}
	public String getRecruitmentType()
	{
		return recruitmentType;
	}
	
	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}
	public String getPaymentType()
	{
		return paymentType;
	}

	public void setRecruitmentReason(String recruitmentReason)
	{
		this.recruitmentReason = recruitmentReason;
	}
	public String getRecruitmentReason()
	{
		return recruitmentReason;
	}
	
	public void setJobQualifications(String jobQualifications)
	{
		this.jobQualifications = jobQualifications;
	}
	public String getJobQualifications()
	{
		return jobQualifications;
	}
	
	public void setRecruitmentStatus(String recruitmentStatus)
	{
		this.recruitmentStatus = recruitmentStatus;
	}
	public String getRecruitmentStatus()
	{
		return recruitmentStatus;
	}
	
	public void setAdditionalInterview(String additionalInterview)
	{
		this.additionalInterview = additionalInterview;
	}
	public String getAdditionalInterview()
	{
		return additionalInterview;
	}
	
	public void setHrManager(String HrManager)
	{
		this.HrManager = HrManager;
	}
	public String getHrManager()
	{
		return HrManager;
	}
	public void setExpectedSalary(String expectedSalary)
	{
		this.expectedSalary = expectedSalary;
	}
	public String getExpectedSalary()
	{
		return expectedSalary;
	}

	public void setFirstName(String firstName)
	{
		super.setFirstName(firstName);
	}
	public String getFirstName()
	{
		return super.getFirstName();
	}
	
	public void setLastName(String lastName)
	{
		super.setLastName(lastName);
	}
	public String getLastName()
	{
		return super.getLastName();
	}
	
	public void setPhone(String phone)
	{
		super.setPhone(phone);
	}
	public String getPhone()
	{
		return super.getPhone();
	}
	public void setContactPhone(String contactPhone)
	{
		this.contactPhone = contactPhone;
	}
	public String getContactPhone()
	{
		return contactPhone;
	}
	public void setEmail(String email)
	{
		super.setEmail(email);
	}
	public String getEmail()
	{
		return super.getEmail();
	}
	
	public void setJobTitle(String jobTitle)
	{
		super.setJobTitle(jobTitle);
	}
	public String getJobTitle()
	{
		return super.getJobTitle();
	}
	
	public void setDepartment(String department)
	{
		super.setDepartment(department);
	}
	public String getDepartment()
	{
		return super.getDepartment();
	}
	public void setEmpId(int empId)
	{
		super.setEmpId(empId);
	}
	public int getEmpId()
	{
		return super.getEmpId();
	}
	public void setJobType(String jobtype)
	{
		this.jobtype = jobtype;
	}
	public String getJobType()
	{
		return jobtype;
	}
	public void setApproval(String approval)
	{
		this.approval = approval;
	}
	public String getApproval()
	{
		return approval;
	}
}
