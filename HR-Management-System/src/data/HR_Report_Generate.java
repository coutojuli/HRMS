package data;

import java.util.ArrayList;

import javax.swing.*;
import business.*;

public class HR_Report_Generate {
	
	public JTable genertePerformanceReport(JTable table){
		
		PerformanceDAO prDAO = DAOFactory.getPerformanceDAO();
		  
		String column[]= {"Emp ID","Name","Department", "Job Title", "Type",
				"Productivity Score", "Quality Score", "Dependability Score","Attendance score", 
				"Team Work Score","Overall Rating"};

			ArrayList<Performance> arr = prDAO.getPerformances();		
			if (!arr.isEmpty())
			{
				String[][] data = new String[arr.size()][11];
				int currentPosition = 0;
				for (Performance p : arr) {									
					data[currentPosition][0] = String.valueOf(p.getEmpId());
					data[currentPosition][1] = p.getFirstName();
					data[currentPosition][2] = p.getDepartment();
					data[currentPosition][3] = p.getJobTitle();
					data[currentPosition][4] = p.getPerformanceType();
					data[currentPosition][5] = String.valueOf(p.getProductivity());
					data[currentPosition][6] = String.valueOf(p.getQuality());
					data[currentPosition][7] = String.valueOf(p.getDependability());
					data[currentPosition][8] = String.valueOf(p.getAttendance());
					data[currentPosition][9] = String.valueOf(p.getTeamwork());
					data[currentPosition][10] = String.valueOf(p.getRating());
					currentPosition++;
				}	
				table = new JTable(data, column);	
			}
		return table;
	}
}
