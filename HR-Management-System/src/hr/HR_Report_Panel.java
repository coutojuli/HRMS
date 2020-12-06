package hr;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Properties;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import data.HR_Report_Generate;

public class HR_Report_Panel extends JPanel {
	private JTable table;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JDatePickerImpl datePickerEndDate;
	private JDatePickerImpl datePickerStartDate;
	private JDatePanelImpl datePanel_start_date;
	private JDatePanelImpl datePanel_end_date;
	private UtilDateModel model_start_date;
	private UtilDateModel model_end_date;
	private JTextField txtEmpID;
	JComboBox cbReportSelect;
	
	public HR_Report_Panel() {
		setLayout(null);
		initialize();
		btnSearch.addActionListener(new SearchButtonHandler());
	}
	
	private void initialize() {
	
		JPanel panel_search = new JPanel();
		panel_search.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_search.setBounds(25, 65, 1133, 161);		
		panel_search.setLayout(null);
		
		JLabel lblReport = new JLabel("Select Report");
		lblReport.setBounds(10, 53, 102, 22);
		panel_search.add(lblReport);
		
		cbReportSelect = new JComboBox();
		cbReportSelect.setBounds(100, 54, 187, 21);					
		panel_search.add(cbReportSelect);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(397, 58, 63, 13);
		panel_search.add(lblStartDate);
		
		Properties p_start_date = new Properties();
		p_start_date.put("text.today", "Today");
		p_start_date.put("text.month", "Month");
		p_start_date.put("text.year", "Year");
		model_start_date = new UtilDateModel();
		datePanel_start_date = new JDatePanelImpl(model_start_date, p_start_date);
		
		datePickerStartDate = new JDatePickerImpl(datePanel_start_date, new DateComponentFormatter());
		datePickerStartDate.setBounds(500, 50, 200, 30);
		panel_search.add(datePickerStartDate);
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(804, 58, 68, 13);
		panel_search.add(lblEndDate);
		
		Properties p_end_date = new Properties();
		p_end_date.put("text.today", "Today");
		p_end_date.put("text.month", "Month");
		p_end_date.put("text.year", "Year");
		model_end_date = new UtilDateModel();
		datePanel_end_date = new JDatePanelImpl(model_end_date, p_start_date);
		
		datePickerEndDate = new JDatePickerImpl(datePanel_end_date, new DateComponentFormatter());
		datePickerEndDate.setBounds(900, 50, 200, 30);
		panel_search.add(datePickerEndDate);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(973, 115, 123, 36);
		panel_search.add(btnSearch);
		
		this.add(panel_search);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 256, 1133, 441);
		this.add(scrollPane);						
		
		cbReportSelect.addItem("Employee Recruitment");
		cbReportSelect.addItem("Employee Profile");
		cbReportSelect.addItem("Employee Attendance");
		cbReportSelect.addItem("Employee PayRoll");
		cbReportSelect.addItem("Employee Performace");		
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(397, 101, 102, 13);
		panel_search.add(lblEmployeeId);
		
		txtEmpID = new JTextField();
		txtEmpID.setBounds(500, 93, 200, 30);
		panel_search.add(txtEmpID);
		txtEmpID.setColumns(10);
	}
	
	private class SearchButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) 
		{
			String reportType = (String)cbReportSelect.getSelectedItem();
			if (reportType.equalsIgnoreCase("Employee Performace")) {

				HR_Report_Generate hr = new HR_Report_Generate();
				table = hr.genertePerformanceReport(table);
				table.setBounds(30,70,200,300); 			
				scrollPane.setViewportView(table);
			}				
		}
	}
	
	public boolean isValidData() {
		
		if ((datePickerStartDate.getJFormattedTextField().getText() == "" || datePickerEndDate.getJFormattedTextField().getText() == "") || txtEmpID.getText() == "" )
		{
			JOptionPane.showMessageDialog(null,"Enter either date or employee ID", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (txtEmpID.getText() != "") {
			if (!Validator.isInteger(txtEmpID, "Emplooyee ID "))
				return false;			
		}
		return true;
	}
}
