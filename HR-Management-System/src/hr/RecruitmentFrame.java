package hr;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class RecruitmentFrame extends JInternalFrame {
	private JPanel profilePanel;
	
	public RecruitmentFrame(JPanel panel) {
		this.profilePanel = panel;
		this.add(panel);
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Recruitment");
		this.setIconifiable(true);
		this.setSize(1000,1000);
	}
}
