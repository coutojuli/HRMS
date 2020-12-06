package hr;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class AttenancePanel extends JPanel {
	private JTextField txtEmployeeID;
	private JTextField txtEmployeeName;
	private JTextField txtJobTitle;
	private JLabel lblEmployeeId;
	private JTextField txtEnterTime;
	private JTextField txtTotalHours;
	private JTextField txtOutTime;
	private JButton btnUpdate;
	private JButton btnCancel;
	private JTable table;
	
	public AttenancePanel() {
		this.initialize();
		btnUpdate.addActionListener(new SaveButtonHandler());		
	}
	
public void initialize() {
		
		try {
			this.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.setBounds(37, 84, 948, 808);
			this.setLayout(null);
			this.setBorder(new LineBorder(new Color(0, 0, 0)));
			
			JLabel lblEmployeeDetails = new JLabel("Employee Details");
			lblEmployeeDetails.setFont(lblEmployeeDetails.getFont().deriveFont(lblEmployeeDetails.getFont().getStyle() | Font.BOLD));
			lblEmployeeDetails.setBounds(380, 30, 111, 23);
			this.add(lblEmployeeDetails);
			
			lblEmployeeId = new JLabel("Employee ID:");
			lblEmployeeId.setBounds(42, 89, 92, 13);
			this.add(lblEmployeeId);
			
			txtEmployeeID = new JTextField();
			txtEmployeeID.setColumns(10);
			txtEmployeeID.setBounds(144, 79, 167, 30);
			this.add(txtEmployeeID);
			
			JLabel lblEmployeeName = new JLabel("Employee Name:");
			lblEmployeeName.setBounds(42, 141, 101, 14);
			this.add(lblEmployeeName);
			
			txtEmployeeName = new JTextField();
			txtEmployeeName.setEditable(false);
			txtEmployeeName.setColumns(10);
			txtEmployeeName.setBounds(144, 137, 254, 30);
			this.add(txtEmployeeName);
			
			JLabel lblDepartment = new JLabel("Department:");
			lblDepartment.setBounds(452, 88, 76, 14);
			this.add(lblDepartment);
			
			JLabel lblJobTitle = new JLabel("Job Title:");
			lblJobTitle.setBounds(452, 141, 76, 14);
			this.add(lblJobTitle);
				
			txtJobTitle = new JTextField();
			txtJobTitle.setEditable(false);
			txtJobTitle.setColumns(10);
			txtJobTitle.setBounds(564, 137, 260, 30);
			this.add(txtJobTitle);		
		
			JLabel lblTimeCard = new JLabel("Timecards");
			lblTimeCard.setFont(lblEmployeeDetails.getFont().deriveFont(lblEmployeeDetails.getFont().getStyle() | Font.BOLD));
			lblTimeCard.setBounds(380, 190, 111, 23);
			this.add(lblTimeCard);
			
			JLabel lblEnterTime = new JLabel("Clock In:");
			lblEnterTime.setBounds(462, 554, 122, 13);
			this.add(lblEnterTime);
			
			txtEnterTime = new JTextField();
			txtEnterTime.setEditable(true);
			txtEnterTime.setColumns(10);
			txtEnterTime.setBounds(592, 549, 208, 30);
			this.add(txtEnterTime);
			
			JLabel lblTaskName = new JLabel("Task Name:");
			lblTaskName.setBounds(52, 589, 162, 33);
			this.add(lblTaskName);
			
			JTextField txtTaskName = new JTextField();
			txtTaskName.setEditable(true);
			txtTaskName.setColumns(10);
			txtTaskName.setBounds(164, 594, 208, 30);
			this.add(txtTaskName);
			
			JLabel lblTotalHours = new JLabel("Total Hours:");
			lblTotalHours.setBounds(52, 637, 162, 33);
			this.add(lblTotalHours);
			
			txtTotalHours = new JTextField();
			txtTotalHours.setEditable(true);
			txtTotalHours.setColumns(10);
			txtTotalHours.setBounds(164, 638, 208, 30);
			this.add(txtTotalHours);
			
			JLabel lblTaskDescription = new JLabel("Task Description:");
			lblTaskDescription.setBounds(52, 675, 162, 33);
			this.add(lblTaskDescription);
			
			JTextArea txtTaskDesc = new JTextArea();
			txtTaskDesc.setWrapStyleWord(true);
			txtTaskDesc.setLineWrap(true);
			txtTaskDesc.setColumns(10);
			txtTaskDesc.setBounds(164, 685, 636, 30);
			this.add(txtTaskDesc);
			
			JLabel lblOutTime = new JLabel("Clock Out: ");
			lblOutTime.setBounds(462, 589, 109, 32);
			this.add(lblOutTime);
			
			txtOutTime = new JTextField();
			txtOutTime.setEditable(true);
			txtOutTime.setColumns(10);
			txtOutTime.setBounds(592, 594, 208, 30);
			this.add(txtOutTime);
			
			JLabel lblTaskType = new JLabel("Task Type:");
			lblTaskType.setBounds(462, 643, 109, 20);
			this.add(lblTaskType);
			
			JTextField txtTaskType = new JTextField();
			txtTaskType.setEditable(true);
			txtTaskType.setColumns(10);
			txtTaskType.setBounds(592, 642, 208, 30);
			this.add(txtTaskType);
			
			btnUpdate = new JButton("Update");
			btnUpdate.setBounds(818, 325, 101, 33);
			this.add(btnUpdate);
			
			btnCancel = new JButton("Cancel");
			btnCancel.setBounds(818, 398, 101, 33);
			this.add(btnCancel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(42, 271, 760, 247);
			add(scrollPane);
			
			table = new JTable();
			scrollPane.setColumnHeaderView(table);
			
			JLabel lblFrom = new JLabel("From:");
			lblFrom.setBounds(64, 230, 122, 13);
			add(lblFrom);
			
			JLabel lblTo = new JLabel("To:");
			lblTo.setBounds(403, 230, 122, 13);
			add(lblTo);
			
			JLabel lblDate = new JLabel("Date:");
			lblDate.setBounds(52, 554, 122, 13);
			add(lblDate);
			
			UtilDateModel model = new UtilDateModel();
			//model.setDate(20,04,2014);
			// Need this...
			Properties p = new Properties();
			p.put("text.today", "Today");
			p.put("text.month", "Month");
			p.put("text.year", "Year");
			JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
			// Don't know about the formatter, but there it is...
			JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
			datePicker.setBounds(164, 554, 200, 30);
			this.add(datePicker);
			
			JDatePanelImpl datePanel1 = new JDatePanelImpl(model,p);
			// Don't know about the formatter, but there it is...
			JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateComponentFormatter());
			datePicker1.setBounds(118, 230, 200, 30);
			this.add(datePicker1);
			
			JDatePanelImpl datePanel2 = new JDatePanelImpl(model,p);
			// Don't know about the formatter, but there it is...
			JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateComponentFormatter());
			datePicker2.setBounds(443, 230, 200, 30);
			this.add(datePicker2);
			
			JComboBox cbDepartment = new JComboBox();
			cbDepartment.setBounds(564, 79, 260, 30);
			add(cbDepartment);
			
			JButton butSearch = new JButton("Search");
			butSearch.setBounds(321, 79, 82, 30);
			add(butSearch);
			
			JButton button = new JButton("Search");
			button.setBounds(699, 225, 101, 35);
			add(button);
			
			JLabel lblManagerApproval = new JLabel("Manager Approval:");
			lblManagerApproval.setBounds(42, 729, 162, 33);
			add(lblManagerApproval);
			
			JComboBox cbManagerApproval = new JComboBox();
			cbManagerApproval.setBounds(162, 734, 260, 30);
			add(cbManagerApproval);
			
			JButton btnApproval = new JButton("Approval");
			btnApproval.setBounds(452, 734, 101, 33);
			add(btnApproval);
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}			
	}

	private class SaveButtonHandler implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {
		String totalHours =  txtTotalHours.getText();
		
			if(isValidData()) {
//				String result = "Name: " + firstName + " " + "lastName" + "\n" +
//						"Phone: " + phone + " " + "email: " + email;
				JOptionPane.showMessageDialog(null, "Attendance data is saved\n", "Save Attendance", JOptionPane.INFORMATION_MESSAGE);
			}				
		}
	}

	private class CancelButtonHandler implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Operation is cancelled", "Save Peron", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean isValidData() {
		if (!Validator.isInteger(txtTotalHours, "Total Hours "))
			return false;
	
		return true;
	}
}
