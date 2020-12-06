package hr;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class LoginInternalFrame extends JInternalFrame {
	private JPanel loginPanel;
	
	public LoginInternalFrame (JPanel panel) {
		this.loginPanel = panel;
		this.add(panel);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Login");
		this.setLocation(80, 0);
		this.setIconifiable(true);
		this.setSize(900,500);			
	}
}

