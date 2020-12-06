package hr;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import business.Employee;
import business.Performance;
import data.DAOFactory;
import data.EmployeeConstants;
import data.PerformanceDAO;
import data.PerformanceDAORandom;
import data.RecruitmentDAO;

public class PerformancePanel extends JPanel{
	
	private PerformanceDAO prDAO = DAOFactory.getPerformanceDAO();
	
	//Creation of labels, textbox, and button
		private JLabel lblEmployeeDetails;
		private JLabel lblEmployeeId;
		private JLabel lblDepartment;
		private JLabel lblAnnualPerformance;
		private JLabel lblFirstName;
		private JLabel lblJobTitle;
		private JLabel lblResponsible;
		private JTextField txtEmployeeId;
		//private JTextField txtDepartment;
		private JTextField txtAnnualPerformance;
		private JTextField txtFirstName;
		private JTextField txtJobTitle;
		private JTextField txtResponsible;
		private JLabel lblPerformance;
		private JLabel lblDate;
		private JLabel lblType;
		private JLabel lblManagerResponsible;
		private JLabel lblProductivity;
		private JLabel lblQuality;
		private JLabel lblDependability;
		private JLabel lblAttendance;
		private JLabel lblTeamwork;
		private JLabel lblComments;
		private JTextArea txtComments;
		private JLabel lblRating;
		private JTextField txtDate;
		private JButton btnSave;
		private JButton btnCancel;
		private JRadioButton jrbProdExceeds;
		private JRadioButton jrbProdMeets;
		private JRadioButton jrbProdUnsatisfactory;
		private JRadioButton jrbQualExceeds;
		private JRadioButton jrbQualMeets;
		private JRadioButton jrbQualUnsatisfactory;
		private JRadioButton jrbDepExceeds;
		private JRadioButton jrbDepMeets;
		private JRadioButton jrbDepUnsatisfactory;
		private JRadioButton jrbAttendanceExceeds;
		private JRadioButton jrbAttendanceMeets;
		private JRadioButton jrbAttendanceUnsatisfactory;
		private JRadioButton jrbTeamExceeds;
		private JRadioButton jrbTeamMeets;
		private JRadioButton jrbTeamUnsatisfactory;
		private JComboBox cbDepartment;
		private JButton btnSearch;
		private JComboBox cbJobTitle;
		private JComboBox cbType;
		private JTextField txtRating;
		private JDatePickerImpl datePicker;
		private JDatePanelImpl datePanel;
		private UtilDateModel model;
		
		//Creation of radio button group
		ButtonGroup ProductivityGroup = new ButtonGroup();
		ButtonGroup QualityGroup = new ButtonGroup();
		ButtonGroup DependabilityGroup = new ButtonGroup();
		ButtonGroup AttendanceGroup = new ButtonGroup();
		ButtonGroup TeamworkGroup = new ButtonGroup();
		private JButton btnCalcTotal;
		
		public PerformancePanel() {
			this.initialize();
			btnSave.addActionListener(new SaveButtonHandler());
			btnSearch.addActionListener(new SearchButtonHandler());
			btnCancel.addActionListener(new CancelButtonHandler());
			btnCalcTotal.addActionListener(new RatingHandler());
		}
		
		private void initialize() {
			lblEmployeeDetails = new JLabel("Employee Details");
			lblEmployeeId = new JLabel("Employee ID:");
			lblDepartment = new JLabel("Department: ");
			lblAnnualPerformance = new JLabel ("Annual Performance Review: ");
			lblFirstName = new JLabel ("First Name: ");
			lblJobTitle = new JLabel ("Job Title: ");
			lblResponsible = new JLabel ("Responsible Assigned: ");
			txtEmployeeId = new JTextField();
			//txtDepartment = new JTextField();
			txtAnnualPerformance = new JTextField();
			txtFirstName = new JTextField();
			txtJobTitle = new JTextField();
			txtResponsible = new JTextField();
			lblPerformance = new JLabel("Performance Analysis");
			lblDate = new JLabel("Date: ");
			//txtDate = new JTextField();
			lblType = new JLabel("Type: ");
			lblManagerResponsible = new JLabel("Manager Responsible: ");
			lblProductivity = new JLabel("Productivity: ");
			lblQuality = new JLabel("Quality: ");
			lblDependability = new JLabel("Dependability: ");
			lblAttendance = new JLabel("Attendance: ");
			lblTeamwork = new JLabel("Teamwork: ");
			lblComments = new JLabel("Comments:");
			lblRating = new JLabel("Rating: ");
			btnSave = new JButton("Save");
			btnCancel = new JButton("Cancel");
			jrbProdExceeds = new JRadioButton("Exceeds");
			jrbProdMeets = new JRadioButton("Meets Standard");
			jrbProdUnsatisfactory = new JRadioButton("Unsatisfactory");
			jrbQualExceeds = new JRadioButton("Exceeds");
			jrbQualMeets = new JRadioButton("Meets Standard");
			jrbQualUnsatisfactory = new JRadioButton("Unsatisfactory");
			jrbDepExceeds = new JRadioButton("Exceeds");
			jrbDepMeets = new JRadioButton("Meets Standard");
			jrbDepUnsatisfactory = new JRadioButton("Unsatisfactory");
			jrbAttendanceExceeds = new JRadioButton("Exceeds");
			jrbAttendanceMeets = new JRadioButton("Meets Standard");
			jrbAttendanceUnsatisfactory = new JRadioButton("Unsatisfactory");
			jrbTeamExceeds = new JRadioButton("Exceeds");
			jrbTeamMeets = new JRadioButton("Meets Standard");
			jrbTeamUnsatisfactory = new JRadioButton("Unsatisfactory");
			txtComments = new JTextArea();
			cbDepartment = new JComboBox();
			btnSearch = new JButton("Search");
			cbJobTitle = new JComboBox();
			cbType = new JComboBox();
			txtRating = new JTextField();
			
			//model.setDate(20,04,2014);
			// Need this...
			Properties p = new Properties();
			p.put("text.today", "Today");
			p.put("text.month", "Month");
			p.put("text.year", "Year");
			model = new UtilDateModel();
			datePanel = new JDatePanelImpl(model, p);
			datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
			
			
			//Creating the grid Layout for the panel
			this.setLayout(null);
			
			//Adding the components to the panel
			// setBounds(x,y,width,height)
			
			JPanel panel1 = new JPanel();
			panel1.setBorder(BorderFactory.createLineBorder(Color.black));
			panel1.setLayout(null);
			panel1.setBounds(10, 30, 950, 234);
			this.add(panel1);
			
			lblEmployeeDetails.setBounds(430, 20, 150, 30);
			panel1.add(lblEmployeeDetails);
			lblEmployeeId.setBounds(30, 80, 90, 30);
			panel1.add(lblEmployeeId);
			txtEmployeeId.setBounds(130, 80, 200, 30);
			panel1.add(txtEmployeeId);
			btnSearch.setBounds(350, 80, 85, 30);
			panel1.add(btnSearch);
			lblDepartment.setBounds(30, 130, 90, 30);
			panel1.add(lblDepartment);
			cbDepartment.setBounds(130, 130, 300, 30);
			panel1.add(cbDepartment);
			lblAnnualPerformance.setBounds(30, 180, 200, 30);
			panel1.add(lblAnnualPerformance);
			txtAnnualPerformance.setBounds(220, 180, 210, 30);
			panel1.add(txtAnnualPerformance);
			txtAnnualPerformance.setEditable(true);
			lblFirstName.setBounds(500, 80, 90, 30);
			panel1.add(lblFirstName);
			txtFirstName.setBounds(600, 80, 300, 30);
			panel1.add(txtFirstName);
			lblJobTitle.setBounds(500, 130, 90, 30);
			panel1.add(lblJobTitle);
			cbJobTitle.setBounds(600, 130, 300, 30);
			panel1.add(cbJobTitle);
			lblResponsible.setBounds(500, 180, 150, 30);
			panel1.add(lblResponsible);
			txtResponsible.setBounds(650, 180, 250, 30);
			panel1.add(txtResponsible);
			txtResponsible.setEditable(true);
			
			JPanel panel2 = new JPanel();
			panel2.setBorder(BorderFactory.createLineBorder(Color.black));
			panel2.setLayout(null);
			panel2.setBounds(10, 275, 950, 507);
			this.add(panel2);
			
			lblPerformance.setBounds(430, 20, 150, 30);
			panel2.add(lblPerformance);
			lblDate.setBounds(30, 80, 90, 30);
			panel2.add(lblDate);
			//txtDate.setBounds(80, 80, 200, 30);
			//panel2.add(txtDate);
			lblType.setBounds(300, 80, 90, 30);
			panel2.add(lblType);
			cbType.setBounds(350, 80, 200, 30);
			panel2.add(cbType);
//			lblManagerResponsible.setBounds(580, 80, 150, 30);
//			panel2.add(lblManagerResponsible);
//			JComboBox cbManagerResponsible = new JComboBox();
//			cbManagerResponsible.setBounds(730, 80, 200, 30);
//			panel2.add(cbManagerResponsible);
			lblProductivity.setBounds(80, 150, 90, 30);
			panel2.add(lblProductivity);
			lblQuality.setBounds(80, 200, 90, 30);
			panel2.add(lblQuality);
			lblDependability.setBounds(80, 250, 90, 30);
			panel2.add(lblDependability);
			lblAttendance.setBounds(80,300, 90, 30);
			panel2.add(lblAttendance);
			lblTeamwork.setBounds(80,350, 90, 30);
			panel2.add(lblTeamwork);

			
			datePicker.setBounds(80, 80, 200, 30);
			panel2.add(datePicker);
			
			ProductivityGroup.add(jrbProdExceeds);
			ProductivityGroup.add(jrbProdMeets);
			ProductivityGroup.add(jrbProdUnsatisfactory);
			QualityGroup.add(jrbQualExceeds);
			QualityGroup.add(jrbQualMeets);
			QualityGroup.add(jrbQualUnsatisfactory);
			DependabilityGroup.add(jrbDepExceeds);
			DependabilityGroup.add(jrbDepMeets);
			DependabilityGroup.add(jrbDepUnsatisfactory);
			AttendanceGroup.add(jrbAttendanceExceeds);
			AttendanceGroup.add(jrbAttendanceMeets);
			AttendanceGroup.add(jrbAttendanceUnsatisfactory);
			TeamworkGroup.add(jrbTeamExceeds);
			TeamworkGroup.add(jrbTeamMeets);
			TeamworkGroup.add(jrbTeamUnsatisfactory);
			//Location of objects on the panel
			
			jrbProdExceeds.setBounds(200, 150, 90, 30);
			panel2.add(jrbProdExceeds);
			jrbProdMeets.setBounds(300, 150, 150, 30);
			panel2.add(jrbProdMeets);
			jrbProdUnsatisfactory.setBounds(450, 150, 150, 30);
			panel2.add(jrbProdUnsatisfactory);
			jrbQualExceeds.setBounds(200, 200, 90, 30);
			panel2.add(jrbQualExceeds);
			jrbQualMeets.setBounds(300, 200, 150, 30);
			panel2.add(jrbQualMeets);
			jrbQualUnsatisfactory.setBounds(450, 200, 150, 30);
			panel2.add(jrbQualUnsatisfactory);
			jrbDepExceeds.setBounds(200, 250, 90, 30);
			panel2.add(jrbDepExceeds);
			jrbDepMeets.setBounds(300, 250, 150, 30);
			panel2.add(jrbDepMeets);
			jrbDepUnsatisfactory.setBounds(450, 250, 150, 30);
			panel2.add(jrbDepUnsatisfactory);
			jrbAttendanceExceeds.setBounds(200, 300, 90, 30);
			panel2.add(jrbAttendanceExceeds);
			jrbAttendanceMeets.setBounds(300, 300, 150, 30);
			panel2.add(jrbAttendanceMeets);
			jrbAttendanceUnsatisfactory.setBounds(450, 300, 150, 30);
			panel2.add(jrbAttendanceUnsatisfactory);
			jrbTeamExceeds.setBounds(200, 350, 90, 30);
			panel2.add(jrbTeamExceeds);
			jrbTeamMeets.setBounds(300, 350, 150, 30);
			panel2.add(jrbTeamMeets);
			jrbTeamUnsatisfactory.setBounds(450, 350, 150, 30);
			panel2.add(jrbTeamUnsatisfactory);
			lblComments.setBounds(30, 391, 90, 30);
			panel2.add(lblComments);
			txtComments.setBounds(30, 430, 550, 58);
			panel2.add(txtComments);
			lblRating.setBounds(650, 324, 90, 30);
			panel2.add(lblRating);
			txtRating.setBounds(703, 325, 150, 30);
			panel2.add(txtRating);
			txtRating.setEditable(false);
			btnSave.setBounds(650, 440, 100, 30);
			panel2.add(btnSave);
			btnCancel.setBounds(788, 440, 100, 30);
			panel2.add(btnCancel);
			
			cbType.addItem("Monthly");
			cbType.addItem("Qauterly");
			cbType.addItem("Annually");
			
			btnCalcTotal = new JButton("Calc Total");
			btnCalcTotal.setBounds(725, 365, 128, 21);
			panel2.add(btnCalcTotal);
			
			cbDepartment.addItem("HR");
			cbDepartment.addItem("IT");
			cbDepartment.addItem("Accounts");
			cbDepartment.addItem("Admin");
			
			cbJobTitle.addItem("Software Developer");
			cbJobTitle.addItem("HR Executive");
			cbJobTitle.addItem("Admin Executive");
			cbJobTitle.addItem("Operation Executive");	
		}
		
		private class SaveButtonHandler implements ActionListener {

			public void actionPerformed(ActionEvent e) {
					if(isValidData()) 
					{
						
					Performance per = new Performance();
					
					per.setEmpId(Integer.parseInt(txtEmployeeId.getText()));
					per.setFirstName(txtFirstName.getText());
					per.setDepartment((String)cbDepartment.getSelectedItem());
					per.setAnnualPerformance(txtAnnualPerformance.getText());
					per.setJobTitle((String)cbJobTitle.getSelectedItem());
					per.setResponsibleAssigned(txtResponsible.getText());
					per.setAnnualPerformance(txtAnnualPerformance.getText());
					per.setPerformanceDate(datePicker.getJFormattedTextField().getText());
					per.setPermormanceType((String)cbType.getSelectedItem());
					//per.setResponsibleAssigned(txtResponsible.getText());
					per.setProductivity(getSelectedButtonValue(ProductivityGroup));
					per.setQuality(getSelectedButtonValue(QualityGroup));
					per.setDependability(getSelectedButtonValue(DependabilityGroup));
					per.setAttendance(getSelectedButtonValue(AttendanceGroup));
					per.setTeamwork(getSelectedButtonValue(TeamworkGroup));
					per.setComments(txtComments.getText());
					per.setRating(Integer.parseInt(txtRating.getText()));
					
					if (prDAO.addPerformance(per))
					{
						JOptionPane.showMessageDialog(null, "performance data is saved\n" , "Save Employee", JOptionPane.INFORMATION_MESSAGE);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "performance data could not be saved\n" , "Save Employee", JOptionPane.ERROR_MESSAGE);
					}
					
					}	
			}
		}
		
		private class SearchButtonHandler implements ActionListener {

			public void actionPerformed(ActionEvent e) 
			{
				int empId = Integer.parseInt(txtEmployeeId.getText());
					if (empId > 0)
					{
						Performance p = prDAO.getPerformance(empId);
						if (p !=null)
						{
							txtEmployeeId.setText(String.valueOf(p.getEmpId()));
							txtFirstName.setText(p.getFirstName());
							cbDepartment.setSelectedItem(p.getDepartment());
							txtAnnualPerformance.setText(p.getAnnualPerformance());
							txtJobTitle.setText(p.getJobTitle());
							txtResponsible.setText(p.getResponsibleAssigned());
							datePicker.getJFormattedTextField().setText(p.getPerformanceDate());
							cbType.setSelectedItem(p.getPerformanceType());
							
							// Returning Syntax for buttons : Productivity
							JRadioButton prod;
							if (p.getProductivity() == 0)
							{
								prod = jrbProdUnsatisfactory;
								jrbProdUnsatisfactory.setSelected(true);
							}
							else if (p.getProductivity() == 1)
							{
								prod = jrbProdMeets;
								jrbProdMeets.setSelected(true);
							}
							else
							{
								prod = jrbProdExceeds;
								jrbProdExceeds.setSelected(true);
							}
							
							// Returning Syntax for buttons : Quality
							JRadioButton qual;
							if (p.getQuality() == 0)
							{
								qual = jrbQualUnsatisfactory;
								jrbQualUnsatisfactory.setSelected(true);
							}
							else if (p.getQuality() == 1)
							{
								qual = jrbQualMeets;
								jrbQualMeets.setSelected(true);
							}
							else
							{
								qual = jrbQualExceeds;
								jrbQualExceeds.setSelected(true);
							}
							
							// Returning Syntax for buttons : Dependability
							JRadioButton dep;
							if (p.getDependability() == 0)
							{
								dep = jrbDepUnsatisfactory;
								jrbDepUnsatisfactory.setSelected(true);
							}
							else if (p.getDependability() == 1)
							{
								dep = jrbDepMeets;
								jrbDepMeets.setSelected(true);
							}
							else
							{
								dep = jrbDepExceeds;
								jrbDepExceeds.setSelected(true);
							}
							
							// Returning Syntax for buttons : Attendance
							JRadioButton at;
							if (p.getAttendance() == 0)
							{
								at = jrbAttendanceUnsatisfactory;
								jrbAttendanceUnsatisfactory.setSelected(true);
							}
							else if (p.getAttendance() == 1)
							{
								at = jrbAttendanceMeets;
								jrbAttendanceMeets.setSelected(true);
							}
							else
							{
								at = jrbAttendanceExceeds;
								jrbAttendanceExceeds.setSelected(true);
							}
							
							// Returning Syntax for buttons : Teamwork
							JRadioButton tw;
							if (p.getTeamwork() == 0)
							{
								tw = jrbTeamUnsatisfactory;
								jrbTeamUnsatisfactory.setSelected(true);
							}
							else if (p.getTeamwork() == 1)
							{
								tw = jrbTeamMeets;
								jrbTeamMeets.setSelected(true);
							}
							else
							{
								tw = jrbTeamExceeds;
								jrbTeamExceeds.setSelected(true);
							}
							
							txtComments.setText(p.getComments());
							txtRating.setText(String.valueOf(p.getRating()));
						}
						else 
						{
							JOptionPane.showMessageDialog(null, txtEmployeeId.getText() + " is not found", "Find Employee",
							JOptionPane.INFORMATION_MESSAGE);
						}				
					}
				}
			}
		
		private class CancelButtonHandler implements ActionListener {

			public void actionPerformed(ActionEvent e) 
			{
				txtEmployeeId.setText("");
				txtFirstName.setText("");
				cbDepartment.setSelectedItem("");
				txtAnnualPerformance.setText("");
				txtJobTitle.setText("");
				txtResponsible.setText("");
				datePicker.getJFormattedTextField().setText("");
				cbType.setSelectedIndex(0);
				ProductivityGroup.clearSelection();
				QualityGroup.clearSelection();
				AttendanceGroup.clearSelection();
				DependabilityGroup.clearSelection();
				TeamworkGroup.clearSelection();
				txtComments.setText("");
				txtRating.setText("");						
			}
		}
		
		private class RatingHandler implements ActionListener {

			public void actionPerformed(ActionEvent e) 
			{
				int totalRating = getSelectedButtonValue(ProductivityGroup) + getSelectedButtonValue(QualityGroup) + 
						 getSelectedButtonValue(ProductivityGroup) + getSelectedButtonValue(AttendanceGroup) + getSelectedButtonValue(TeamworkGroup);
				txtRating.setText(String.valueOf(totalRating));
			}
		}
		
		public boolean isValidData() {
			if (!Validator.isInteger(txtEmployeeId, "Emplooyee ID "))
				return false;
			if (!Validator.isPresent(txtFirstName, "First Name"))
				return false;
			if (!Validator.isPresent(txtResponsible, "Responsible assigned"))
				return false;
			if (!Validator.isPresent(txtAnnualPerformance, "Annaul Performance"))
				return false;
			if (!Validator.isPresent(txtComments, "Comments"))
				return false;
			if (!Validator.isPresent(txtRating, "Rating"))
				return false;
		
			return true;
		}
		
		public int getSelectedButtonValue(ButtonGroup buttonGroup)
		{  
		    String btnText = "";
		    int result =0;
			for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();)
			{
		        AbstractButton button = buttons.nextElement();
		        if (button.isSelected()) {
		        	btnText = button.getText();
		        }
			}
			
			if (btnText.equalsIgnoreCase("Exceeds")) 	
				result = 2;
			else if (btnText.equalsIgnoreCase("Meets Standard"))
				result = 1;
			else
				result = 0;
			return result;
		
		}
}

