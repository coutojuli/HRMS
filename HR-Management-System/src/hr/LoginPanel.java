package hr;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import data.DAOFactory;
import data.LoginDAO;


public class LoginPanel extends JPanel{
	
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JButton btnLogin;
	private JButton btnReset;
	
	private LoginDAO lDao = new LoginDAO();
	
	public LoginPanel() {
		this.initialize();
		btnLogin.addActionListener(new LoginButtonHandler());
		btnReset.addActionListener(new ResetButtonHandler());
	}
	
	public void initialize() {
		
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBounds(37, 84, 899, 140);
		this.setLayout(null);
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblUserName = new JLabel("User Name: ");
		lblUserName.setBounds(300, 150, 92, 13);
		this.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(400, 148, 208, 22);
		this.add(txtUserName);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(300, 180, 92, 13);
		this.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(400, 178, 208, 22);
		this.add(txtPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(340, 220, 89, 23);
		this.add(btnLogin);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(450, 220, 89, 23);
		this.add(btnReset);
	}
	
	private class LoginButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if (!isValidData())
				return;
			String userName = txtUserName.getText();
			String passwd = txtPassword.getText();
			
			if (LoginDAO.LoginUser(userName,passwd)) {				
				JOptionPane.showMessageDialog(null, "Login Success", "Login", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Login Failed", "Login", JOptionPane.ERROR_MESSAGE);
			}			
		}
	}

	private class ResetButtonHandler implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {
			txtUserName.setText("");
			txtPassword.setText("");
		//JOptionPane.showMessageDialog(null, "Operation is cancelled", "Cancel", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean isValidData() {
		if (!Validator.isPresent(txtUserName, " First Name "))
			return false;
		if (!Validator.isPresent(txtPassword, " Last Name "))
			return false;

		return true;
	}
}
