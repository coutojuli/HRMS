package hr;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class HR_Report_InternalFrame extends JInternalFrame{
private JPanel hrReportPanel;
	
	public HR_Report_InternalFrame(JPanel panel) {
		this.hrReportPanel = panel;
		this.add(panel);
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("HR Report");
		this.setIconifiable(true);
		this.setSize(1200,770);
	}
}
