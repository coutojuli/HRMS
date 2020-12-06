package hr;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.LineBorder;

import data.EmployeeDAO;
import data.HRConstants;
import data.RecruitmentDAO;

public class MainFrame extends JFrame {
	private JMenuBar mBar;
	private JMenu mFile;
	private JMenu mEmployee;

	
	private JMenuItem mItemLogin;
	private JMenuItem mItemLogout;
	private JMenuItem mItemRecruitment;
	private JMenuItem mItemProfile;
	private JMenuItem mItemAttendance;
	private JMenuItem mItemPayRoll;
	private JMenuItem mItemExit;
	private JMenuItem mItemPerformance;
	private JMenuItem mHR_Report;
	
	private JDesktopPane desktop;
	//private JPanel payRollPanel;
	
	public MainFrame()
	{
		this.initialize();
		this.setTitle("HR Management System");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	private void initialize() {
		//Recruitment | Employee Database File
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosed(WindowEvent e) {
				try 
				{
					RecruitmentDAO database = new RecruitmentDAO();
					EmployeeDAO database1 = new EmployeeDAO();
					database.disconect();
					database1.disconect();
					System.exit(0);
				}
				catch (SQLException ex) {
					ex.printStackTrace();
					System.exit(1);
				}
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		mBar = new JMenuBar();
		
		desktop = new JDesktopPane();
		this.setContentPane(desktop);
		
		mFile = new JMenu("Login");
		mFile.setMnemonic(KeyEvent.VK_F);
		
		if (HRConstants.HR_FLAG) {
			mEmployee = new JMenu("HR");
			mEmployee.setMnemonic(KeyEvent.VK_H);
		}	
		else {
			mEmployee = new JMenu("Employee");
			mEmployee.setMnemonic(KeyEvent.VK_E);
		}
		mItemLogin = new JMenuItem("Login");
		mItemLogin.setMnemonic(KeyEvent.VK_L); 
		mItemLogin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		mItemLogin.addActionListener(new LoginEventHandler());
		
		mItemLogout = new JMenuItem("Logout");
		mItemLogout.setMnemonic(KeyEvent.VK_O); 
		mItemLogout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		mItemLogout.addActionListener(new PayRollEventHandler());
		
		mItemRecruitment = new JMenuItem("Recruitment");
		mItemRecruitment.setMnemonic(KeyEvent.VK_R); 
		mItemRecruitment.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		mItemRecruitment.addActionListener(new RecruitmentEventHandler());
		
		mItemProfile = new JMenuItem("Employee Profile");
		mItemProfile.setMnemonic(KeyEvent.VK_P); 
		mItemProfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		mItemProfile.addActionListener(new ProfileEventHandler());
		
		mItemAttendance = new JMenuItem("Attendance");
		mItemAttendance.setMnemonic(KeyEvent.VK_A); 
		mItemAttendance.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		mItemAttendance.addActionListener(new AttendanceEventHandler());
		
		mItemPayRoll = new JMenuItem("Pay Roll");
		mItemPayRoll.setMnemonic(KeyEvent.VK_Y); 
		mItemPayRoll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		mItemPayRoll.addActionListener(new PayRollEventHandler());
		
		mItemPerformance = new JMenuItem("Performance");
		mItemPerformance.setMnemonic(KeyEvent.VK_M); 
		mItemPerformance.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));

		mItemPerformance.setMnemonic(KeyEvent.VK_F); 
		mItemPerformance.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		mItemPerformance.addActionListener(new PerformanceEventHandler());
		
		mItemExit = new JMenuItem("Exit");
		mItemExit.setMnemonic(KeyEvent.VK_X); 
		mItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		mItemExit.addActionListener(new ExitEventHandler());
		
		mHR_Report = new JMenuItem("HR Report");
		mHR_Report.setMnemonic(KeyEvent.VK_R); 
		mHR_Report.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		mHR_Report.addActionListener(new HR_ReportEventHandler());
		
		mFile.add(mItemLogin);
		mFile.add(mItemLogout);
		mFile.add(mItemExit);
		
		if (HRConstants.HR_FLAG) {
			mEmployee.add(mItemRecruitment);
			mEmployee.add(mHR_Report);
		}
		mEmployee.add(mItemProfile);
		mEmployee.add(mItemPayRoll);
		mEmployee.add(mItemAttendance);
		mEmployee.add(mItemPerformance);
		
		mBar.add(mFile);
		mBar.add(mEmployee);
		this.setJMenuBar(mBar);
	}
	
	private class ExitEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	private class ProfileEventHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			JInternalFrame ProfileFrame = new ProfileFrame(new ProfilePanel());
			ProfileFrame.setVisible(true);
			ProfileFrame.setContentPane(new JScrollPane(new ProfilePanel()));
			MainFrame.this.desktop.add(ProfileFrame);
			ProfileFrame.setResizable(true);
			ProfileFrame.setMaximizable(true);
			ProfileFrame.setIconifiable(true);
			ProfileFrame.setClosable(true);
			ProfileFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		}		
	}
	
	private class PayRollEventHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			JInternalFrame PayRollInternalFrame = new PayRollInternalFrame(new PayrollPanel());
			PayRollInternalFrame.setVisible(true);
			MainFrame.this.desktop.add(PayRollInternalFrame);
			PayRollInternalFrame.setResizable(true);
			PayRollInternalFrame.setMaximizable(true);
			PayRollInternalFrame.setIconifiable(true);
			PayRollInternalFrame.setClosable(true);
			PayRollInternalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		}		
	}
	
	private class RecruitmentEventHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			JInternalFrame RecruitmentFrame = new RecruitmentFrame(new RecruitmentPanel());
			RecruitmentFrame.setVisible(true);
			MainFrame.this.desktop.add(RecruitmentFrame);
			RecruitmentFrame.setResizable(true);
			RecruitmentFrame.setMaximizable(true);
			RecruitmentFrame.setIconifiable(true);
			RecruitmentFrame.setClosable(true);
			RecruitmentFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		}		
	}
	
	private class AttendanceEventHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			JInternalFrame AttendanceInternalFrame = new AttendanceInternalFrame(new AttenancePanel());
			AttendanceInternalFrame.setVisible(true);
			AttendanceInternalFrame.setContentPane(new JScrollPane(new AttenancePanel()));
			AttendanceInternalFrame.setResizable(true);
			AttendanceInternalFrame.setMaximizable(true);
			AttendanceInternalFrame.setIconifiable(true);
			MainFrame.this.desktop.add(AttendanceInternalFrame);
			AttendanceInternalFrame.setClosable(true);
			AttendanceInternalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		}		
	}
	
	private class PerformanceEventHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			JInternalFrame PerformancePanel = new PerformanceFrame(new PerformancePanel());
			PerformancePanel.setVisible(true);
			PerformancePanel.setContentPane(new JScrollPane(new PerformancePanel()));
			PerformancePanel.setResizable(true);
			PerformancePanel.setMaximizable(true);
			PerformancePanel.setIconifiable(true);
			MainFrame.this.desktop.add(PerformancePanel);
			PerformancePanel.setClosable(true);
			PerformancePanel.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);			
		}		
	}
	
	private class LoginEventHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			JInternalFrame LoginInternalFrame = new LoginInternalFrame(new LoginPanel());
			LoginInternalFrame.setVisible(true);			
			MainFrame.this.desktop.add(LoginInternalFrame);
		}		
	}
	
	private class HR_ReportEventHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			JInternalFrame hrReportFrame = new HR_Report_InternalFrame(new HR_Report_Panel());
			hrReportFrame.setVisible(true);			
			MainFrame.this.desktop.add(hrReportFrame);		
		}		
	}
	
	
	public static void main(String[] args) {
		
		MainFrame mainframe= new MainFrame();
		mainframe.setBounds(100, 0, 1100, 1000);
		mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.getContentPane().setLayout(null);
		mainframe.setResizable(true);
		mainframe.setVisible(true);
	}
}
