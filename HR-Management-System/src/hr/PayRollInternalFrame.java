package hr;
import javax.swing.*;


public class PayRollInternalFrame extends JInternalFrame {
	private JPanel panel;
	
	public PayRollInternalFrame(JPanel panel) {
		this.panel = panel;
		this.add(panel);
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Payroll GUI");
		this.setLocation(80, 0);
		this.setIconifiable(true);
		this.setSize(1000,700);
	}
}
