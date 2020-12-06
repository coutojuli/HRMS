package hr;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class AttendanceInternalFrame extends JInternalFrame {
	private JPanel attendancePanel;
	
	public AttendanceInternalFrame (JPanel panel) {
		this.attendancePanel = panel;
		this.add(panel);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Attendance");
		this.setLocation(80, 0);
		this.setIconifiable(true);
		this.setSize (1000,1000);			
	}
}
