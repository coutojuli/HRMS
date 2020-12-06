package hr;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import business.Recruitment;
import data.DAOFactory;
import data.EmployeeDAO;
import data.RecruitmentDAO;

public class RecruitmentPanel extends JPanel{
	//Creation of labels, textbox, and button
		
		private JLabel lblDate;
		private JLabel lblFirstName;
		private JLabel lblPhone;
		private JLabel lblLastName;
		private JLabel lblEmail;
		private JLabel lblJobTitle;
		private JLabel lblDepartment;
		private JLabel lblExpectedSalary;
		private JLabel lblRecruitmentStatus;
		private JLabel lblAdditionalInterview;
		private JLabel lblHRApproval;
		private JLabel lblApproval;
		private JLabel lblReason;
		private JLabel lblQualifications;
		private JLabel lblCandidateDetails;
		private JLabel lblPositionDetails;
		//private JTextField txtDate;
		private JTextField txtFirstName;
		private JTextField txtPhone;
		private JTextField txtLastName;
		private JTextField txtEmail;
		//private JTextField txtDepartment;
		private JTextField txtExpectedSalary;
		private JTextArea txtReason;
		private JTextArea txtQualifications;
		private JButton btnSubmit;
		private JButton btnCancel;
		private JButton btnUpdate;
		private JButton btnDelete;
		private JButton btnSearch;
		private JRadioButton jrbRejected;
		private JRadioButton jrbApproved;
		private JRadioButton jrbPending;
		private JRadioButton jrbInterviewYes;
		private JRadioButton jrbInterviewNo;
		private JComboBox cbDepartment;
		private JComboBox cbJobTitle;
		private JComboBox cbRecruitmentType;
		private JComboBox cbHR;
		private JComboBox cbApproval;
		private JComboBox cbJobType;
		private ButtonGroup RecruitmentGroup;
		private ButtonGroup InterviewGroup;
		private JTextField txtRecruitmentId;
		private JTextField txtDate;
		private JLabel lblJobType;
		private RecruitmentDAO database;
		private ResultSet result = null;
		
		public RecruitmentDAO database() {
			try
			{
				database = new RecruitmentDAO();
				result = database.getResultSet();
				while(result.next()) {
					result.first();
				}
				
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return database;
		}
		
		public RecruitmentPanel() {
			this.initialize(); //To create the components
		
				try {
					database = new RecruitmentDAO();
					//database = this.database;
					database.PopulateDepartmentCb(cbDepartment,cbJobTitle,cbHR,cbJobType);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			btnSubmit.addActionListener(new SubmitButtonHandler(database));
			btnCancel.addActionListener(new CancelButtonHandler(database));
			btnUpdate .addActionListener(new UpdateButtonHandler(database));
			btnDelete.addActionListener(new DeleteButtonHandler(database));
			btnSearch.addActionListener(new SearchButtonHandler(database));			
		}
		
		private void initialize () {
			
			lblFirstName = new JLabel("First Name: ");
			lblPhone = new JLabel("Phone: ");
			lblLastName = new JLabel("Last Name: ");
			lblEmail = new JLabel("Email: ");
			lblJobTitle = new JLabel("Job Title: ");
			lblDepartment = new JLabel("Department: ");
			lblExpectedSalary = new JLabel("Expected Salary: ");
			lblRecruitmentStatus = new JLabel("Recruitment Status: ");
			lblAdditionalInterview = new JLabel("Additional Interview: ");
			lblHRApproval = new JLabel("Manager: ");
			lblApproval = new JLabel("Approval: ");
			lblReason = new JLabel("Recruitment Reason: ");
			lblQualifications = new JLabel("Job Qualifications: ");
			lblCandidateDetails = new JLabel("Candidate Details ");
			lblPositionDetails = new JLabel("Job Position Details ");
			//txtDate = new JTextField();
			txtFirstName = new JTextField();
			txtPhone = new JTextField();
			txtLastName = new JTextField();
			txtEmail = new JTextField();
			//txtDepartment= new JTextField();
			txtExpectedSalary = new JTextField();
			txtReason = new JTextArea();
			txtQualifications = new JTextArea();
			btnSubmit = new JButton("Submit");
			btnCancel = new JButton("Cancel");
			btnSearch = new JButton("Search");
			btnDelete = new JButton("Delete");
			btnUpdate = new JButton("Update");
			jrbRejected = new JRadioButton ("Rejected");
			jrbApproved = new JRadioButton ("Approved");
			jrbPending = new JRadioButton ("Pending");
			jrbInterviewYes = new JRadioButton ("Yes");
			jrbInterviewNo = new JRadioButton ("No");
			cbDepartment = new JComboBox();
			cbJobTitle = new JComboBox();
			cbRecruitmentType = new JComboBox();
			cbHR = new JComboBox();
			cbApproval = new JComboBox();
			
			//Creating the grid Layout for the panel
			this.setLayout(null);
			//txtDate.setBounds(160, 30, 300, 30);
			//this.add(txtDate);
			btnSubmit.setBounds(755,30,80,30);
			this.add(btnSubmit);
			btnCancel.setBounds(845,30,80,30);
			this.add(btnCancel);
			btnSearch.setBounds(485, 30, 80, 30);
			this.add(btnSearch);
			btnUpdate.setBounds(575, 30, 80, 30);
			this.add(btnUpdate);
			btnDelete.setBounds(665, 30, 80, 30);
			this.add(btnDelete);

			JPanel panel1 = new JPanel();
			panel1.setBorder(BorderFactory.createLineBorder(Color.black));
			panel1.setLayout(null);
			panel1.setBounds(10, 75, 950, 218);
			this.add(panel1);
			
			lblCandidateDetails.setBounds(430, 20, 150, 30);
			panel1.add(lblCandidateDetails);
			lblFirstName.setBounds(30, 113, 90, 30);
			panel1.add(lblFirstName);
			txtFirstName.setBounds(150, 113, 300, 30);
			panel1.add(txtFirstName);
			lblPhone.setBounds(30, 163, 90, 30);
			panel1.add(lblPhone);
			txtPhone.setBounds(150, 163, 300, 30);
			panel1.add(txtPhone);
			lblLastName.setBounds(500, 113, 90, 30);
			panel1.add(lblLastName);
			txtLastName.setBounds(600, 113, 300, 30);
			panel1.add(txtLastName);
			lblEmail.setBounds(500, 163, 90, 30);
			panel1.add(lblEmail);
			txtEmail.setBounds(600, 163, 300, 30);
			panel1.add(txtEmail);
			
			//Creating an object and calling the constructor
			lblDate = new JLabel("Date: ");
			lblDate.setBounds(30, 72, 90, 30);
			panel1.add(lblDate);
			
			txtDate = new JTextField();
			txtDate.setBounds(150, 72, 300, 30);
			panel1.add(txtDate);

			JPanel panel2 = new JPanel();
			panel2.setBorder(BorderFactory.createLineBorder(Color.black));
			panel2.setLayout(null);
			panel2.setBounds(10, 304, 950, 299);
			this.add(panel2);
			
			lblPositionDetails.setBounds(410, 25, 150, 30);
			panel2.add(lblPositionDetails);
			lblJobTitle.setBounds(32, 97, 90, 30);
			panel2.add(lblJobTitle);
			cbJobTitle.setBounds(152, 97, 300, 30);
			panel2.add(cbJobTitle);
			lblDepartment.setBounds(32, 197, 90, 30);
			panel2.add(lblDepartment);
			cbDepartment.setBounds(152, 197, 300, 30);
			panel2.add(cbDepartment);
			lblExpectedSalary.setBounds(32, 245, 120, 30);
			panel2.add(lblExpectedSalary);
			txtExpectedSalary.setBounds(152, 245, 300, 30);
			panel2.add(txtExpectedSalary);
			lblReason.setBounds(503, 80, 150, 30);
			panel2.add(lblReason);
			txtReason.setBounds(503, 121, 400, 52);
			panel2.add(txtReason);
			lblQualifications.setBounds(503, 183, 150, 30);
			panel2.add(lblQualifications);
			txtQualifications.setBounds(503, 218, 400, 57);
			panel2.add(txtQualifications);
			
			JPanel panel3 = new JPanel();
			panel3.setBorder(BorderFactory.createLineBorder(Color.black));
			panel3.setLayout(null);
			panel3.setBounds(10, 614, 950, 170);
			this.add(panel3);
			
			lblRecruitmentStatus.setBounds(30, 30, 130, 30);
			panel3.add(lblRecruitmentStatus);
			
			//Creation of radio button group
			
			RecruitmentGroup = new ButtonGroup();
			InterviewGroup = new ButtonGroup();
			RecruitmentGroup.add(jrbRejected);
			RecruitmentGroup.add(jrbApproved);
			RecruitmentGroup.add(jrbPending);
			InterviewGroup.add(jrbInterviewYes);
			InterviewGroup.add(jrbInterviewNo);
			
			//Action Commands
			jrbRejected.setActionCommand("Rejected");
			jrbApproved.setActionCommand("Approved");
			jrbPending.setActionCommand("Pending");
			jrbInterviewYes.setActionCommand("Yes");
			jrbInterviewNo.setActionCommand("No");
		
			//Location of objects on the panel
			jrbRejected.setBounds(200, 30, 130, 30);
			panel3.add(jrbRejected);
			jrbApproved.setBounds(330, 30, 130, 30);
			panel3.add(jrbApproved);
			jrbPending.setBounds(460, 30, 130, 30);
			panel3.add(jrbPending);
			lblAdditionalInterview.setBounds(30, 80, 130, 30);
			panel3.add(lblAdditionalInterview);
			jrbInterviewYes.setBounds(200, 80, 130, 30);
			panel3.add(jrbInterviewYes);
			jrbInterviewNo.setBounds(330, 80, 130, 30);
			panel3.add(jrbInterviewNo);
			lblHRApproval.setBounds(30, 130, 200, 30);
			panel3.add(lblHRApproval);
			cbHR.setBounds(142, 130, 200, 30);
			panel3.add(cbHR);
			lblApproval.setBounds(393, 130, 250, 30);
			panel3.add(lblApproval);
			JComboBox cbApproval = new JComboBox();
			cbApproval.setBounds(495, 130, 200, 30);
			panel3.add(cbApproval);
			
			//Hardcoding values for cb
			cbApproval.addItem("Yes");
			cbApproval.addItem("No");
			
			lblJobType = new JLabel("Job Type: ");
			lblJobType.setBounds(32, 142, 90, 30);
			panel2.add(lblJobType);
			
			cbJobType = new JComboBox();
			cbJobType.setBounds(152, 143, 300, 30);
			panel2.add(cbJobType);
			
			
//			UtilDateModel model = new UtilDateModel();
//			//model.setDate(20,04,2014);
//			// Need this...
//			Properties p = new Properties();
//			p.put("text.today", "Today");
//			p.put("text.month", "Month");
//			p.put("text.year", "Year");
//			JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//			
			JLabel lblRecruitmentId = new JLabel("Recruitment ID:");
			lblRecruitmentId.setBounds(27, 30, 90, 30);
			add(lblRecruitmentId);
			
			txtRecruitmentId = new JTextField();
			txtRecruitmentId.setBounds(116, 30, 300, 30);
			add(txtRecruitmentId);
			
		}	
		
		private class SubmitButtonHandler implements ActionListener
		{
			RecruitmentDAO database;
			public SubmitButtonHandler(RecruitmentDAO database) {
				this.database = database;
			}
			
			public void actionPerformed(ActionEvent e) 
			{
				if(isValidData()) 
				{			
					Recruitment recruitment = new Recruitment();
					
					int rec_id = Integer.parseInt(txtRecruitmentId.getText());
					String date = txtDate.getText();
					String firstName = txtFirstName.getText();
					String lastName = txtLastName.getText();
					String phone = txtPhone.getText();
					String email = txtEmail.getText();
					String jobTitle = String.valueOf(cbJobTitle.getSelectedItem());
					String department = String.valueOf(cbDepartment.getSelectedItem());
					String jobType = String.valueOf(cbJobType.getSelectedItem());
					String expectedSalary = txtExpectedSalary.getText();
					String reason = txtReason.getText();
					String qualifications = txtQualifications.getText();
					String status = (RecruitmentGroup.getSelection().getActionCommand());
					String interview = String.valueOf(InterviewGroup.getSelection().getActionCommand());
					String manager = String.valueOf(cbHR.getSelectedItem());
					String approval = String.valueOf(cbApproval.getSelectedItem());
					String contactPhone = txtPhone.getText();
					int emp_id = GenerateEmpId(recruitment);
					
					recruitment.setRecruitmentId(rec_id);
					recruitment.setEmpId(emp_id);
					recruitment.setRecruitmentDate(date);
					recruitment.setFirstName(firstName);
					recruitment.setLastName(lastName);
					recruitment.setPhone(phone);
					recruitment.setEmail(email);
					recruitment.setJobTitle(jobTitle);
					recruitment.setDepartment(department);
					recruitment.setContactPhone(contactPhone);
					recruitment.setJobType(jobType);
					recruitment.setExpectedSalary(expectedSalary);
					recruitment.setRecruitmentReason(reason);
					recruitment.setJobQualifications(qualifications);
					recruitment.setRecruitmentStatus(status);
					recruitment.setAdditionalInterview(interview);
					recruitment.setHrManager(manager);
					recruitment.setApproval(approval);	
					
					try
					{
						if(database.InsertRecruitmentData(recruitment) == 1)
						{
							result = database.getResultSet();
							JOptionPane.showMessageDialog(null, "Candidate with Recruitment Id " + rec_id + " submitted.", "Submit Action" ,JOptionPane.INFORMATION_MESSAGE);	
							clearRecruitment();
						}
					}catch(SQLException sqle)
					{
						JOptionPane.showMessageDialog(null, "Candidate with Recruitment Id " + rec_id + " submitted.", "Submit Action" ,JOptionPane.INFORMATION_MESSAGE);	
						//JOptionPane.showMessageDialog(null, sqle.getMessage());
					}
				}
			}
		}
		

		private class CancelButtonHandler implements ActionListener{
		
			RecruitmentDAO database;
			public CancelButtonHandler(RecruitmentDAO database) {
				this.database = database;
			}
			
			public void actionPerformed(ActionEvent e) {
				clearRecruitment();
				JOptionPane.showMessageDialog(null, "Operation is cancelled : Fields are cleared", "Cancel Action", JOptionPane.INFORMATION_MESSAGE);
			}
		}
			
		private class SearchButtonHandler implements ActionListener {

			RecruitmentDAO database;
			public SearchButtonHandler(RecruitmentDAO database) {
				this.database = database;
			}
			
			public void actionPerformed(ActionEvent e) {
				{
					if(isValidID())
					{
						Recruitment recruitment = new Recruitment();
						int rec_id = Integer.parseInt(txtRecruitmentId.getText());
						recruitment.setRecruitmentId(rec_id);
						result = null;
						
						try 
						{
							result = database.ShowRecruitmentData(recruitment);
							populateRecruitment(result, recruitment);
						}catch (SQLException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Search Action: Employee Id " + rec_id + " successful", "Search Action", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}
		
		private class UpdateButtonHandler implements ActionListener {

			RecruitmentDAO database;
			public UpdateButtonHandler(RecruitmentDAO database) {
				this.database = database;
			}
			
			public void actionPerformed(ActionEvent e) 
			{
				if(isValidData()) 
				{
					Recruitment recruitment = new Recruitment();
					
					int rec_id = Integer.parseInt(txtRecruitmentId.getText());
					String date = txtDate.getText();
					String firstName = txtFirstName.getText();
					String lastName = txtLastName.getText();
					String phone = txtPhone.getText();
					String email = txtEmail.getText();
					String jobTitle = String.valueOf(cbJobTitle.getSelectedItem());
					String department = String.valueOf(cbDepartment.getSelectedItem());
					String jobType = String.valueOf(cbJobType.getSelectedItem());
					String expectedSalary = txtExpectedSalary.getText();
					String reason = txtReason.getText();
					String qualifications = txtQualifications.getText();
					String status = (RecruitmentGroup.getSelection().getActionCommand());
					String interview = String.valueOf(InterviewGroup.getSelection().getActionCommand());
					String manager = String.valueOf(cbHR.getSelectedItem());
					String approval = String.valueOf(cbApproval.getSelectedItem());
					String contactPhone = txtPhone.getText();
					int emp_id = GenerateEmpId(recruitment);
					
					recruitment.setRecruitmentId(rec_id);
					recruitment.setEmpId(emp_id);
					recruitment.setRecruitmentDate(date);
					recruitment.setFirstName(firstName);
					recruitment.setLastName(lastName);
					recruitment.setPhone(phone);
					recruitment.setEmail(email);
					recruitment.setJobTitle(jobTitle);
					recruitment.setDepartment(department);
					recruitment.setContactPhone(contactPhone);
					recruitment.setJobType(jobType);
					recruitment.setExpectedSalary(expectedSalary);
					recruitment.setRecruitmentReason(reason);
					recruitment.setJobQualifications(qualifications);
					recruitment.setRecruitmentStatus(status);
					recruitment.setAdditionalInterview(interview);
					recruitment.setHrManager(manager);
					recruitment.setApproval(approval);	
					
					try
					{
						if(database.Update(recruitment) == 1)
						{
							result = database.getResultSet();
							JOptionPane.showMessageDialog(null, "Recruitment with Id " + rec_id + " updated.", "Update Action", JOptionPane.INFORMATION_MESSAGE);
							clearRecruitment();
						}
					}catch(SQLException sqle)
					{
						JOptionPane.showMessageDialog(null, sqle.getMessage());
					}	
				}
			}
		}
		
		private class DeleteButtonHandler implements ActionListener {

			RecruitmentDAO database;
			public DeleteButtonHandler(RecruitmentDAO database) {
				this.database = database;
			}
			
			public void actionPerformed(ActionEvent e) 
			{
				if(isValidID())
				{
					Recruitment recruitment = new Recruitment();
					int rec_id = Integer.parseInt(txtRecruitmentId.getText());
					recruitment.setRecruitmentId(rec_id);
					
					try
					{
						if (database.DeleteRecruitmentData(recruitment) == 1)
						{
							result = database.getResultSet();
							clearRecruitment();
							JOptionPane.showMessageDialog(null, "Candiate with Recruitment Id " + rec_id + " deleted." , "Delete Action",JOptionPane.INFORMATION_MESSAGE);
						}
					}catch(SQLException sqle)
					{
						JOptionPane.showMessageDialog(null, sqle.getMessage());
					}
				}
			}
		}
		
		private void populateRecruitment(ResultSet result, Recruitment recruitment) throws SQLException
		{
			
			txtRecruitmentId.setText(String.valueOf(recruitment.getRecruitmentId()));
			//txtEmpID();
			txtDate.setText(recruitment.getRecruitmentDate());
			txtFirstName.setText(recruitment.getFirstName());
			txtLastName.setText(recruitment.getLastName());
			txtPhone.setText(recruitment.getPhone());
			txtEmail.setText(recruitment.getEmail());
			cbJobTitle.setSelectedItem(recruitment.getJobTitle());
			cbDepartment.setSelectedItem(recruitment.getDepartment());
			//txtContactPhone();
			cbJobType.setSelectedItem(recruitment.getJobType());
			txtExpectedSalary.setText(recruitment.getExpectedSalary());
			txtReason.setText(recruitment.getRecruitmentReason());
			txtQualifications.setText(recruitment.getJobQualifications());
			
			switch(recruitment.getRecruitmentStatus()) {   
			  case "Rejected":
				  jrbRejected.setSelected(true); 
			    break;
			  case "Approved":
				  jrbApproved.setSelected(true); 
			    break;
			  case "Pending" :
			  	  jrbPending.setSelected(true); 
			    break;
			  default:
			}
			switch(recruitment.getAdditionalInterview()) {
			  case "Yes":
				  jrbInterviewYes.setSelected(true); 
			    break;
			  case "No":
				  jrbInterviewNo.setSelected(true); 
			    break;
			  default:
			}
			cbHR.setSelectedItem(recruitment.getHrManager());
			cbApproval.setSelectedItem(recruitment.getApproval());
		}
		
		private void clearRecruitment()
		{
			txtRecruitmentId.setText("");
			//txtEmpID();
			txtDate.setText("");
			txtFirstName.setText("");
			txtLastName.setText("");
			txtPhone.setText("");
			txtEmail.setText("");
			cbJobTitle.setSelectedItem(null);
			cbDepartment.setSelectedItem(null);
			//txtContactPhone();
			cbJobType.setSelectedItem(null);
			cbApproval.setSelectedItem(null);
			txtExpectedSalary.setText("");
			txtReason.setText("");
			txtQualifications.setText("");
			
			RecruitmentGroup.clearSelection();
			InterviewGroup.clearSelection();
			
			cbHR.setSelectedItem(null);
			cbApproval.setSelectedItem(null);
		}
		
		public boolean isValidData() {
			if (!Validator.isPresent(txtDate, "Date"))
				return false;
			if (!Validator.isPresent(txtRecruitmentId, "Recruitment Id"))
				return false;
			if (!Validator.isPresent(txtFirstName, "First Name"))
				return false;
			if (!Validator.isPresent(txtLastName, "Last Name"))
				return false;
			if (!Validator.isPresent(txtPhone, "Phone"))
				return false;
			if (!Validator.isPresent(txtEmail, "Email"))
				return false;
			if (!Validator.isComboBox(cbJobTitle, "Job Title"))
				return false;
			if (!Validator.isComboBox(cbDepartment, "Department"))
				return false;
			if (!Validator.isComboBox(cbJobType, "Job Type"))
				return false;
			if (!Validator.isPresent(txtExpectedSalary, "Expected Salary"))
				return false;
			if (!Validator.isPresent(txtReason, "Reason"))
				return false;
			if (!Validator.isPresent(txtQualifications, "Qualifications"))
				return false;
			if (!Validator.isPresent(txtReason, "Reason"))
				return false;
			if (!Validator.isRadio(RecruitmentGroup, "Recruitment Status"))
				return false;
			if (!Validator.isRadio(InterviewGroup, "Additional Interview"))
				return false;
			if (!Validator.isComboBox(cbHR, "Manager"))
				return false;
			//if (!Validator.isComboBox(cbApproval, "Approval"))
			//	return false;
			if (!Validator.isInteger(txtRecruitmentId, "Recruitment Id "))
				return false;
			return true;
		}
		
		public boolean isValidID()
		{
			if (!Validator.isPresent(txtRecruitmentId, "Recruitment Id"))
				return false;
			if (!Validator.isInteger(txtRecruitmentId, "Recruitment Id "))
				return false;
			return true;
		}

		public int GenerateEmpId(Recruitment recruitment)
		{
			try {
				database.SelectEmpId(recruitment);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			int emp_id = recruitment.getEmpId();
			int nextEmp_id = emp_id + 1;
			
			return nextEmp_id;
		}
}
		

