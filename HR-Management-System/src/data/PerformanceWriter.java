package data;

public interface PerformanceWriter {
	//Every class inheriting this interface
	//needs to pass an performance object
	boolean addPerformance(business.Performance performance);
}
