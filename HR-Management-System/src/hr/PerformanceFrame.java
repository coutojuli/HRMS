package hr;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class PerformanceFrame extends JInternalFrame{
	private JPanel PerformancePanel;
	
	public PerformanceFrame (JPanel panel) {
		this.PerformancePanel = panel;
		this.add(panel);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Performance");
		this.setIconifiable(true);
		this.setSize(1000,1000);
	}
}
