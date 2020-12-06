package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import business.Performance;
import business.Recruitment;

public class PerformanceDAOText implements PerformanceDAO {
	
	private File performanceFile = null;
	
	public PerformanceDAOText()
	{
		performanceFile = new File (EmployeeConstants.PERFORMANCE_FILENAME_TEXT);
	}
	//It will throw an input output exception: If does not exist - create
		private void checkFile() throws IOException
		{
			if(!performanceFile.exists())
				performanceFile.createNewFile();
		}
		private boolean savePerformances(ArrayList<Performance> performances) 
		//Create an ArrayList of type Performance : name performances
		{
		
		//Create a variable of printWriter
			PrintWriter out = null;
			
			try
			{
				this.checkFile();
		//Set out to be performanceFile
				out = new PrintWriter (new BufferedWriter(new FileWriter(performanceFile)));
		//For each loop on candidates arrayList : r-item
				for (Performance p : performances)
				{
					out.print(p.getEmpId() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getDepartment() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getAnnualPerformance() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getFirstName() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getJobTitle() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getResponsibleAssigned() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getPerformanceDate() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getPerformanceType() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					//out.print(p.getResponsibleManager() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getProductivity() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getQuality() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getDependability() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getAttendance() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getTeamwork() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.print(p.getComments() +EmployeeConstants.PERFORMANCE_FIELD_SEP);
					out.println(p.getRating());
				}
		//Exceptions: Input - Output 
			} catch (IOException ioe) {
				ioe.printStackTrace();
				return false;
			} finally {
				this.close(out);
			}
			return true;
		}
		//Close method for the performance file
		private void close(Closeable stream) {
			try {
				if(stream!=null)
					stream.close();
			}
			catch(IOException io)
			{
				io.printStackTrace();
			}
			
		}
	@Override
	public Performance getPerformance(int empId) {
		//Access the performances arrayList and get Performances with parameter
		ArrayList<Performance> performances = this.getPerformances();
		//For each p item in recruitment candidates
			for (Performance p : performances) {
				if (p.getEmpId()== empId)
					//Show message? //add method to return more than one performance?
					return p;
			}
			return null;
		}
	@Override
	public ArrayList<Performance> getPerformances() 
	{
			//Reading the file - in obj
			BufferedReader in = null;
			try {
				this.checkFile();
				in = new BufferedReader(new FileReader(performanceFile));
				ArrayList<Performance> performances = new ArrayList<Performance>();
				String line = in.readLine();
				
				while (line != null) {
					//Each index will be devided by the Field Separator.
					//Values will be as string inside file
					//Convert to remove of the file when not String
					String[] index = line.split(EmployeeConstants.PERFORMANCE_FIELD_SEP);
					int empId = Integer.parseInt(index[0]);
					String department = index[1];
					String annualPerformance = index[2];
					String firstName = index[3];
					String jobTitle = index[4];
					String responsibleAssigned = index[5];
					String performanceDate = index[6];
					String performanceType = index[7];
					//String responsibleManager = index[8];
					int productivity = Integer.parseInt(index[8]);
					int quality = Integer.parseInt(index[9]);
					int dependability = Integer.parseInt(index[10]);
					int attendance = Integer.parseInt(index[11]);
					int teamwork = Integer.parseInt(index[12]);
					String comments = index[13];
					int rating = Integer.parseInt(index[14]);

					Performance p = new Performance();
					p.setEmpId(empId);
					p.setDepartment(department);
					p.setAnnualPerformance(annualPerformance);
					p.setFirstName(firstName);
					p.setJobTitle(jobTitle);
					p.setResponsibleAssigned(responsibleAssigned);
					p.setPerformanceDate(performanceDate);
					p.setPermormanceType(performanceType);
					//p.setResponsibleManager(responsibleManager);
					p.setProductivity(productivity);
					p.setQuality(quality);
					p.setDependability(dependability);
					p.setAttendance(attendance);
					p.setTeamwork(teamwork);
					p.setComments(comments);
					p.setRating(rating);
					
					performances.add(p);
					line = in.readLine();
				}
				return performances;
			}
			//Exceptions: Input-Output
			catch (IOException io) {
				io.printStackTrace();
				return null;
			} finally {
				this.close(in);
			}
	}

	@Override
	public boolean addPerformance(Performance performance) {
		//Array list of type Performance named performance: Returning 
		ArrayList<Performance> performances = this.getPerformances();
		performances.add(performance);
		return this.savePerformances(performances);
	}
}
