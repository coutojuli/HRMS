package business;

public class Performance extends Employee{
		
	//Variable creation
		
		    private String annualPerformance;
		    private String responsibleAssigned;
		    private String date;
		    private String type;
		    //private String responsibleManager;
		    private String comments;
		   
		    private int productivy;
		    private int quality;
		    private int dependability;
		    private int attendance;
		    private int teamwork;
		    private int rating;

	//Employee Constructors
		    public Performance() {
				
			}
	//General Properties: get:set
		    
	  		public void setEmpId(int empId) 
	  		{
	  			super.setEmpId(empId);
	  		}
	  		public int getEmpId() 
	  		{
				return super.getEmpId();
			}
	  		
		    public void setFirstName(String firstName) 
		    {
				super.setFirstName(firstName);
			}
			public String getFirstName() 
			{
				return super.getFirstName();
			}
			
			public void setDepartment(String department) 
		    {
				super.setDepartment(department);
			}
			public String getDepartment() 
			{
				return super.getDepartment();
			}

			public void setJobTitle(String jobTitle) 
		    {
				super.setJobTitle(jobTitle);
			}
			public String getJobTitle() 
			{
				return super.getJobTitle();
			}
			
			public void setAnnualPerformance(String annualPerformance) 
			{
				this.annualPerformance = annualPerformance;
			}
			public String getAnnualPerformance() 
			{
				return annualPerformance;
			}
			
			public void setResponsibleAssigned(String responsibleAssigned)
			{
				this.responsibleAssigned = responsibleAssigned;
			}
			public String getResponsibleAssigned() 
			{
				return responsibleAssigned;
			}
			
			public void setPerformanceDate(String date)
			{
				this.date = date;
			}
			public String getPerformanceDate() 
			{
				return date;
			}
			
			public void setPermormanceType(String type)
			{
				this.type = type;
			}
			public String getPerformanceType() 
			{
				return type;
			}
			
//			public void setResponsibleManager(String responsibleManager)
//			{
//				this.responsibleManager = responsibleManager;
//			}
//			public String getResponsibleManager() 
//			{
//				return responsibleManager;
//			}
//			
			public void setProductivity(int productivity)
			{
				this.productivy = productivity;
			}
			public int getProductivity() 
			{
				return productivy;
			}
			
			public void setQuality(int quality)
			{
				this.quality = quality;
			}
			public int getQuality() 
			{
				return quality;
			}
			
			public void setDependability(int dependability)
			{
				this.dependability = dependability;
			}
			public int getDependability() 
			{
				return dependability;
			}
			
			public void setAttendance(int attendance)
			{
				this.attendance = attendance;
			}
			public int getAttendance() 
			{
				return attendance;
			}

			public void setTeamwork(int teamwork)
			{
				this.teamwork = teamwork;
			}
			public int getTeamwork() 
			{
				return teamwork;
			}
			
			public void setComments(String comments)
			{
				this.comments = comments;
			}
			public String getComments() 
			{
				return comments;
			}
			
			public void setRating(int rating)
			{
				this.rating = rating;
			}
			public int getRating() 
			{
				return rating;
			}	
	}




