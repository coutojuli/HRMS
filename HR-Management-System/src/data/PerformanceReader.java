package data;

import java.util.ArrayList;

public interface PerformanceReader {
		//Every class using Performance Interface
		//should provide empId
		business.Performance getPerformance(int empId);
		//If we want the performance list: ArrayList<business.Performance> getPerformance();
		ArrayList<business.Performance> getPerformances();

}
