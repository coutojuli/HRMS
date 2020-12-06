package hr;
import javax.swing.*;

public class ProfileFrame extends JInternalFrame{
	private JPanel profilePanel;
	
	public ProfileFrame (JPanel panel) {
		this.profilePanel = panel;
		this.add(panel);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Employee Profile");
		this.setIconifiable(true);
		this.setSize(1000,900);
				
	}
}
