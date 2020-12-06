package data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import business.Employee;
import business.Performance;

public class PerformanceDAORandom implements PerformanceDAO
{

	private int count;
	private File performanceFile = null;
	private RandomAccessFile dataFile = null;

	//Creating an object of class File with constant fixed size
	public PerformanceDAORandom()
	{
		performanceFile = new File(EmployeeConstants.PERFORMANCE_FILENAME_BIN_FIXED);
	}
	//PerformanceReader implementation
	@Override
	public Performance getPerformance(int empId) 
	{
		int empIdPos = empId;
		
		try {
	//Creating an object of RandomFile
			dataFile = new RandomAccessFile(performanceFile, "rw");
	//Find the length of one record : therefore, one employee
			count = (int)dataFile.length()/EmployeeConstants.PERFORMANCE_RECORD_SIZE;
			
			if (empIdPos <= count)
			{
	//Seek: Move a pointer forward to a location
				dataFile.seek((empIdPos-1) * EmployeeConstants.PERFORMANCE_RECORD_SIZE);
	//Creating an object of Employee type
				//Employee employee = new Employee();
				Performance performance = new Performance();
	//Setting values for the employee object with the required empid.
				performance.setEmpId(dataFile.readInt());
				performance.setDepartment(readString(dataFile, EmployeeConstants.DEPARTMENT_SIZE));
				performance.setAnnualPerformance(readString(dataFile, EmployeeConstants.ANNUAL_PERFORMANCE_SIZE));
				performance.setFirstName(readString(dataFile, EmployeeConstants.FIRST_NAME_SIZE));
				performance.setJobTitle(readString(dataFile, EmployeeConstants.JOB_TITLE_SIZE));
				performance.setResponsibleAssigned(readString(dataFile, EmployeeConstants.RESPONSIBLE_ASSIGNED_SIZE));
				performance.setPerformanceDate(readString(dataFile, EmployeeConstants.PERFORMANCE_DATE_SIZE));
				performance.setPermormanceType(readString(dataFile, EmployeeConstants.PERFMORMANCE_TYPE));
				performance.setResponsibleManager(readString(dataFile, EmployeeConstants.RESPONSIBLE_MANAGER_SIZE));
				performance.setProductivity(dataFile.readInt());
				performance.setQuality(dataFile.readInt());
				performance.setDependability(dataFile.readInt());
				performance.setAttendance(dataFile.readInt());
				performance.setTeamwork(dataFile.readInt());
				performance.setComments(readString(dataFile, EmployeeConstants.COMMENTS_SIZE));
				performance.setRating(dataFile.readInt());
				return performance;
			}
	//Exceptions for: File not found, input-output exception
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
	//Finally: close the file
		} finally {
			try {
				dataFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	//If there is no record or error: return null
		return null;
		}
	}
	//ReadString method (datafile, length to read)
	//The function that call needs to have try: catch - throws
		private String readString(DataInput in, int length) throws IOException {
			StringBuilder sb = new StringBuilder();
	//As long as i is less then the length of the file: read each char on c and append.
			for (int i = 0; i < length; i++) {
				char c = in.readChar();
				if (c != 0)
					sb.append(c);
			}
			return sb.toString();
		}
		
	//Performance Reader implementation : List all Employees Performance
	//Not implemented for performance yet.
	@Override
	public ArrayList<Performance> getPerformances() {
		
		return null;
	}
	//EmployeeWriter implementation
	@Override
	public boolean addPerformance(Performance performance) {

			boolean success = false;
			try {
		//Creating an object of random file
				dataFile = new RandomAccessFile (performanceFile, "rw");
		//Find the length of one record : therefore, one employee
				count = (int) dataFile.length()/EmployeeConstants.PERFORMANCE_RECORD_SIZE;
		//Seek: Move a pointer forward to the next free location
				dataFile.seek(count * EmployeeConstants.PERFORMANCE_RECORD_SIZE);
		
				dataFile.writeInt(performance.getEmpId());
				writeString(dataFile, EmployeeConstants.DEPARTMENT_SIZE, performance.getDepartment());
				writeString(dataFile, EmployeeConstants.ANNUAL_PERFORMANCE_SIZE, performance.getAnnualPerformance());
				writeString(dataFile, EmployeeConstants.FIRST_NAME_SIZE, performance.getFirstName());
				writeString(dataFile, EmployeeConstants.JOB_TITLE_SIZE, performance.getJobTitle());
				writeString(dataFile, EmployeeConstants.RESPONSIBLE_ASSIGNED_SIZE, performance.getResponsibleAssigned());
				writeString(dataFile, EmployeeConstants.PERFORMANCE_DATE_SIZE, performance.getPerformanceDate());
				writeString(dataFile, EmployeeConstants.PERFMORMANCE_TYPE, performance.getPerformanceType());
				writeString(dataFile, EmployeeConstants.RESPONSIBLE_MANAGER_SIZE, performance.getResponsibleManager());
				dataFile.writeInt(performance.getProductivity());
				dataFile.writeInt(performance.getQuality());
				dataFile.writeInt(performance.getDependability());
				dataFile.writeInt(performance.getAttendance());
				dataFile.writeInt(performance.getTeamwork());
				writeString(dataFile, EmployeeConstants.COMMENTS_SIZE, performance.getComments());
				dataFile.writeInt(performance.getRating());
				
				success = true;
			//Exceptions for: File not found, input-output exception
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					dataFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return success;
		}
		//writeString method (datafile, recordlength, getmethod)
		private void writeString(DataOutput out, int length, String s) throws IOException {
		//As long as i is less then record length
			for (int i = 0; i < length; i++) {
		//As long as i is less than getmethod length: write each char of get method on index i
				if (i < s.length())
					out.writeChar(s.charAt(i));
				else
					out.writeChar(0);
			}
		}
	}
