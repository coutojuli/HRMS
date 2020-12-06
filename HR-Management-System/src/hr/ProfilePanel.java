package hr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.*;
import business.Employee;
import business.Recruitment;
import data.EmployeeConstants;
import data.EmployeeDAO;
import data.RecruitmentDAO;

public class ProfilePanel extends JPanel{
	//Creation of labels, textbox, and button
	private JLabel lblEmployeeID;
	private JLabel lblStatus;
	private JLabel lblFirstName;
	private JLabel lblPhone;
	private JLabel lblDateOfBirth;
	private JLabel lblStreet;
	private JLabel lblCity;
	private JLabel lblLastName; 
	private JLabel lblEmail;
	private JLabel lblMaritalStatus;
	private JLabel lblProvince;
	private JLabel lblPostalCode;
	private JLabel lblDateOfHire;
	private JLabel lblDepartment;
	private JLabel lblWorkPermit;
	private JLabel lblEmployeeType;
	private JLabel lblSinNumber;
	private JLabel lblJobTitle;
	private JLabel lblExpiryDate;
	private JLabel lblPayRate;
	private JLabel lblEmergencyContact;
	private JLabel lblEmergencyPhone;
	//private JTextField txtEmployeeID;
	//private JTextField txtStatus;
	private JTextField txtFirstName;
	private JTextField txtPhone;
	private JTextField txtDateOfBirth;
	private JTextField txtStreet;
	//private JTextField txtCity;
	private JTextField txtLastName;
	private JTextField txtEmail;
	//private JTextField txtMaritalStatus;
	//private JTextField txtProvince;
	private JTextField txtPostalCode;
	private JTextField txtDateOfHire;
	//private JTextField txtDepartment;
	private JTextField txtWorkPermit;
	//private JTextField txtEmployeeType;
	private JTextField txtSinNumber;
	private JTextField txtJobTitle;
	private JTextField txtExpiryDate;
	private JTextField txtPayRate;
	private JTextField txtEmergencyContact;
	private JTextField txtEmergencyPhone;
	private JButton btnUpdate;
	private JComboBox cbStatus;
	private JComboBox cbMaritalStatus;
	private JComboBox cbProvince;
	private JComboBox cbCity;
	private JComboBox cbDepartment;
	private JComboBox cbEmployeeType;
	private JButton btnSearchR;
	private JButton btnCancel;
	private JButton btnDelete;
	private JComboBox cbRecruitmentId;
	private JComboBox cbEmpId;
	private JLabel lblRecruitmentId;
	private EmployeeDAO database;
	private ResultSet result = null;
	private JButton btnSearchE;
	
	//Database
	public EmployeeDAO database() {
		try
		{
			database = new EmployeeDAO();
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
	
	//Constructor
	
	public ProfilePanel() {
		this.initialize(); //To create the components
		
		try {
			database = new EmployeeDAO();
			//database = this.database;
			database.PopulateProfileCb(cbRecruitmentId, cbCity, cbStatus, cbMaritalStatus, cbProvince, cbDepartment, cbEmployeeType,cbEmpId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		btnUpdate.addActionListener(new UpdateButtonHandler(database));
		btnSearchR.addActionListener(new SearchButtonHandlerR(database));
		btnSearchE.addActionListener(new SearchButtonHandlerE(database));
		btnCancel.addActionListener(new CancelButtonHandler(database));
		btnDelete.addActionListener(new DeleteButtonHandler(database));
	}
	
	private void initialize () {
		//Creating an object and calling the constructor
		lblEmployeeID = new JLabel("Employee ID: ");
		lblStatus = new JLabel("Status: "); 
		lblFirstName = new JLabel("First Name: ");
		lblPhone = new JLabel("Phone: ");
		lblDateOfBirth = new JLabel("Date of Birth: ");
		lblStreet = new JLabel("Street: ");
		lblCity = new JLabel("City: ");
		lblLastName = new JLabel("Last Name: ");
		lblEmail = new JLabel("Email: ");
		lblMaritalStatus = new JLabel("Marital Status: ");
		lblProvince = new JLabel("Province: ");
		lblPostalCode = new JLabel("Postal Code: ");
		lblDateOfHire = new JLabel("Date of Hire: ");
		lblDepartment = new JLabel("Department: ");
		lblWorkPermit = new JLabel("Work Permit: ");
		lblEmployeeType = new JLabel("Type: ");
		lblSinNumber = new JLabel("Sin Number: ");
		lblJobTitle = new JLabel("Job Title: ");
		lblExpiryDate = new JLabel("Expiry Date: ");
		lblPayRate = new JLabel("Pay Rate: ");
		lblEmergencyContact = new JLabel("Emergency Contact: ");
		lblEmergencyPhone = new JLabel("Emergency Phone: ");
		cbEmpId = new JComboBox();
		//txtStatus = new JTextField();
		txtFirstName = new JTextField();
		txtPhone = new JTextField();
		txtDateOfBirth = new JTextField();
		txtStreet = new JTextField();
		//txtCity = new JTextField();
		txtLastName = new JTextField();
		txtEmail = new JTextField();
		//txtMaritalStatus = new JTextField();
		//txtProvince = new JTextField();
		txtPostalCode = new JTextField();
		txtDateOfHire = new JTextField();
		//txtDepartment = new JTextField();
		txtWorkPermit = new JTextField();
		//txtEmployeeType = new JTextField();
		txtSinNumber = new JTextField();
		txtJobTitle = new JTextField();
		txtExpiryDate = new JTextField();
		txtPayRate = new JTextField();
		txtEmergencyContact = new JTextField();
		txtEmergencyPhone = new JTextField();
		btnUpdate = new JButton("Update");
		cbStatus = new JComboBox();
		cbMaritalStatus = new JComboBox();
		cbProvince = new JComboBox();
		cbCity = new JComboBox();
		cbDepartment = new JComboBox();
		cbEmployeeType = new JComboBox();
		btnSearchR = new JButton("Search");
		btnCancel = new JButton ("Cancel");
		btnDelete = new JButton ("Delete");
		cbRecruitmentId = new JComboBox();
		lblRecruitmentId = new JLabel("Recruitment ID: ");
		btnSearchE = new JButton("Search");
		
		//Creating the grid Layout for the panel
		this.setLayout(null);
		
		//Adding the components to the panel
		// setBounds(x,y,width,height)
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel1.setLayout(null);
		panel1.setBounds(10, 30, 950, 429);
		this.add(panel1);
		
		lblEmployeeID.setBounds(29, 115, 90, 30);
		panel1.add(lblEmployeeID);
		cbEmpId.setBounds(130, 115, 198, 30);
		//txtEmployeeID.setEditable(false);
		panel1.add(cbEmpId);
		btnSearchR.setBounds(349, 30, 80, 30);
		panel1.add(btnSearchR);
		lblStatus.setBounds(499, 115, 90, 30);
		panel1.add(lblStatus);
		cbStatus.setBounds(599, 115, 300, 30);
		panel1.add(cbStatus);
		//txtStatus.setBounds(600, 30, 200, 30);
		btnUpdate.setBounds(598,30,80,30);
		panel1.add(btnUpdate);
		//panel1.add(txtStatus);
		lblFirstName.setBounds(29, 174, 90, 30);
		panel1.add(lblFirstName);
		txtFirstName.setBounds(129, 174, 300, 30);
		panel1.add(txtFirstName);
		lblLastName.setBounds(499, 174, 90, 30);
		panel1.add(lblLastName);
		txtLastName.setBounds(599, 174, 300, 30);
		panel1.add(txtLastName);
		lblPhone.setBounds(29, 224, 90, 30);
		panel1.add(lblPhone);
		txtPhone.setBounds(129, 224, 300, 30);
		panel1.add(txtPhone);
		lblEmail.setBounds(499, 224, 90, 30);
		panel1.add(lblEmail);
		txtEmail.setBounds(599, 224, 300, 30);
		panel1.add(txtEmail);
		lblDateOfBirth.setBounds(29, 274, 90, 30);
		panel1.add(lblDateOfBirth);
		txtDateOfBirth.setBounds(129, 274, 300, 30);
		panel1.add(txtDateOfBirth);
		lblMaritalStatus.setBounds(499, 274, 90, 30);
		panel1.add(lblMaritalStatus);
		cbMaritalStatus.setBounds(599, 274, 300, 30);
		//txtMaritalStatus.setBounds(600, 200, 300, 30);
		panel1.add(cbMaritalStatus);
		lblStreet.setBounds(29, 324, 90, 30);
		panel1.add(lblStreet);
		txtStreet.setBounds(129, 324, 300, 30);
		panel1.add(txtStreet);
		lblProvince.setBounds(499, 324, 90, 30);
		panel1.add(lblProvince);
		cbProvince.setBounds(599, 324, 300, 30);
		panel1.add(cbProvince);
		lblCity.setBounds(29, 374, 90, 30);
		panel1.add(lblCity);
		cbCity.setBounds(129, 374, 300, 30);
		panel1.add(cbCity);
		lblPostalCode.setBounds(499, 374, 90, 30);
		panel1.add(lblPostalCode);
		txtPostalCode.setBounds(599, 374, 300, 30);
		panel1.add(txtPostalCode);
		
		lblRecruitmentId.setBounds(29, 30, 90, 30);
		panel1.add(lblRecruitmentId);
		
		cbRecruitmentId.setBounds(130, 30, 198, 30);
		panel1.add(cbRecruitmentId);
		
		btnCancel.setBounds(819, 30, 80, 30);
		panel1.add(btnCancel);
		
		btnDelete.setBounds(707, 30, 80, 30);
		panel1.add(btnDelete);
		
		btnSearchE.setBounds(349, 115, 80, 30);
		panel1.add(btnSearchE);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2.setLayout(null);
		panel2.setBounds(10, 470, 950, 231);
		this.add(panel2);		
		lblDateOfHire.setBounds(35, 28, 90, 30);
		panel2.add(lblDateOfHire);		
		txtDateOfHire.setBounds(135, 28, 300, 30);
		panel2.add(txtDateOfHire);
		lblSinNumber.setBounds(505, 28, 90, 30);
		panel2.add(lblSinNumber);
		txtSinNumber.setBounds(605,28, 300, 30);
		panel2.add(txtSinNumber);
		lblDepartment.setBounds(35, 78, 90, 30);
		panel2.add(lblDepartment);
		cbDepartment.setBounds(135, 78, 300, 30);
		panel2.add(cbDepartment);
		lblJobTitle.setBounds(505, 78, 90, 30);
		panel2.add(lblJobTitle);
		txtJobTitle.setBounds(605,78, 300, 30);
		panel2.add(txtJobTitle);
		lblWorkPermit.setBounds(35, 128, 90, 30);
		panel2.add(lblWorkPermit);
		txtWorkPermit.setBounds(135, 128, 300, 30);
		panel2.add(txtWorkPermit);
		lblExpiryDate.setBounds(505, 128, 90, 30);
		panel2.add(lblExpiryDate);
		txtExpiryDate.setBounds(605,128, 300, 30);
		panel2.add(txtExpiryDate);
		lblEmployeeType.setBounds(35, 178, 90, 30);
		panel2.add(lblEmployeeType);
		cbEmployeeType.setBounds(135, 178, 300, 30);
		panel2.add(cbEmployeeType);
		lblPayRate.setBounds(505, 178, 90, 30);
		panel2.add(lblPayRate);
		txtPayRate.setBounds(605,178, 300, 30);
		panel2.add(txtPayRate);
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(BorderFactory.createLineBorder(Color.black));
		panel3.setLayout(null);
		panel3.setBounds(10, 708, 950, 66);
		this.add(panel3);
		
		lblEmergencyContact.setBounds(35, 17, 120, 30);
		panel3.add(lblEmergencyContact);
		txtEmergencyContact.setBounds(165, 17, 270, 30);
		panel3.add(txtEmergencyContact);
		lblEmergencyPhone.setBounds(505, 17, 120, 30);
		panel3.add(lblEmergencyPhone);
		txtEmergencyPhone.setBounds(625,17, 280, 30);
		panel3.add(txtEmergencyPhone);
	}
	
	private class UpdateButtonHandler implements ActionListener{
			//Update Action on Employee profile
			//Update here does not modify approved recruitment data
			
			EmployeeDAO database;
			public UpdateButtonHandler(EmployeeDAO database)
			{
				this.database = database;
			} 
			
			public void actionPerformed(ActionEvent e) {

				Employee employee = new Employee();
				
				if(isValidData())
				{
					int rec_id = 0;
					if(cbRecruitmentId.getSelectedItem() != null)
					{
						rec_id = Integer.parseInt(String.valueOf(cbRecruitmentId.getSelectedItem()));
					}
					int emp_id = Integer.parseInt(String.valueOf(cbEmpId.getSelectedItem()));
					String firstName = txtFirstName.getText();
					String phone = txtPhone.getText();
					String dob = txtDateOfBirth.getText();
					String street = txtStreet.getText();
					String city = String.valueOf(cbCity.getSelectedItem());
					String status = String.valueOf(cbStatus.getSelectedItem());
					String lastName = txtLastName.getText();
					String email = txtEmail.getText();
					String maritalStatus = String.valueOf(cbMaritalStatus.getSelectedItem());
					String province = String.valueOf(cbProvince.getSelectedItem());
					String postalcode = txtPostalCode.getText();
					String doh = txtDateOfHire.getText();
					String dept_name = String.valueOf(cbDepartment.getSelectedItem());
					int permit = Integer.parseInt(txtWorkPermit.getText());
					String job_type = String.valueOf(cbEmployeeType.getSelectedItem());
					int sin  = Integer.parseInt(txtSinNumber.getText());
					String job_title = txtJobTitle.getText();
					String expiry_date = txtExpiryDate.getText();
					int pay_rate = Integer.parseInt(txtPayRate.getText());
					String emergency_contact = txtEmergencyContact.getText();
					int emergency_phone = Integer.parseInt(txtEmergencyPhone.getText());
					int add_id = GenerateAddressID(employee);
					
					employee.setEmpId(emp_id);
	        		employee.setFirstName(firstName);
	    			employee.setLastName(lastName);
	    			employee.setEmail(email);
	    			employee.setPhone(phone);
	    			employee.setDob(dob);
	    			employee.setMaritalStatus(maritalStatus);
	    			employee.setStatus(status);
	    			employee.setDepartment(dept_name);
	    			employee.setDoh(doh);
	    			employee.setEmployeeType(job_type);
	    			employee.setPayRate(pay_rate);
	    			employee.setEmergencyContact(emergency_contact);
	    			employee.setEmergencyPhone(String.valueOf(emergency_phone));
	    			employee.setExpiryDate(expiry_date);
	    			employee.setSinNumber(sin);
	    			employee.setPermit(String.valueOf(permit));
	    			employee.setJobTitle(job_title);
	    			employee.setRecruitentID(rec_id);
	    			employee.setCity(city);
	    			employee.setStreet(street);
	    			employee.setProvince(province);
	    			employee.setPostalCode(postalcode);
					employee.setAddressID(add_id);
	
    			try
				{
					if(database.UpdateEmployeeData(employee) == 1 && database.UpdateAddressData(employee) == 1)
					{
						result = database.getResultSet();
						JOptionPane.showMessageDialog(null, "Employee with Id " + emp_id + " updated.", "Update Action", JOptionPane.INFORMATION_MESSAGE);
						clearProfile();
						database.PopulateProfileCb(cbRecruitmentId, cbCity, cbStatus, cbMaritalStatus, cbProvince, cbDepartment, cbEmployeeType,cbEmpId);
					}
				}
    			catch(SQLException sqle)
				{
					JOptionPane.showMessageDialog(null, sqle.getMessage());
				}		
			}
		}
	}

	private class SearchButtonHandlerE implements ActionListener{
			
			EmployeeDAO database;
			public SearchButtonHandlerE(EmployeeDAO database) {
				this.database = database;
			}
			public void actionPerformed(ActionEvent e) 
			{
				if(isValidID())
				{
					Employee employee = new Employee();
					int emp_id = Integer.parseInt(String.valueOf(cbEmpId.getSelectedItem()));
					employee.setEmpId(emp_id);
					result = null;
					
					try 
					{
						result = database.ShowProfileDataE(employee);
						populateProfile(result, employee);
					}catch (SQLException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Search Action: Employee Id " + emp_id + " successful", "Search Action", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		
	private class SearchButtonHandlerR implements ActionListener{
					
					EmployeeDAO database;
					public SearchButtonHandlerR(EmployeeDAO database) {
						this.database = database;
					}
					public void actionPerformed(ActionEvent e) 
					{
						Employee employee = new Employee();
						int rec_id = Integer.parseInt(String.valueOf(cbRecruitmentId.getSelectedItem()));
						employee.setRecruitentID(rec_id);
						result = null;
						
						try 
						{
							result = database.ShowProfileDataR(employee);
							populateProfile(result, employee);
						}catch (SQLException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Search Action: Candidate Id " + rec_id + " successful", "Search Action", JOptionPane.INFORMATION_MESSAGE);
					}
				}
		
	private class DeleteButtonHandler implements ActionListener{
			
			EmployeeDAO database;
			public DeleteButtonHandler(EmployeeDAO database) {
				this.database = database;
			}
			public void actionPerformed(ActionEvent e) 
			{
				if(isValidID())
				{
					//Delete employee that has the selected employee id
					//Delete function only deletes from profile - not recruitment
					
					Employee employee = new Employee();
					int emp_id = Integer.parseInt(String.valueOf(cbEmpId.getSelectedItem()));
					employee.setEmpId(emp_id);
					
					try
					{
						if (database.DeleteProfileData(employee) > 0)
						{
							result = database.getResultSet();
							clearProfile();
							JOptionPane.showMessageDialog(null, "Employee with Id " + emp_id + " deleted." , "Delete Action",JOptionPane.INFORMATION_MESSAGE);
							database.PopulateProfileCb(cbRecruitmentId, cbCity, cbStatus, cbMaritalStatus, cbProvince, cbDepartment, cbEmployeeType,cbEmpId);
						}
					}catch(SQLException sqle)
					{
						JOptionPane.showMessageDialog(null, sqle.getMessage());
					}
				}
			}
		}

	private class CancelButtonHandler implements ActionListener{
			
			EmployeeDAO database;
			public CancelButtonHandler(EmployeeDAO database)
			{
				this.database = database;
			}
			
			public void actionPerformed(ActionEvent e) 
			{
				clearProfile();
				JOptionPane.showMessageDialog(null, "Operation is cancelled : Fields are cleared", "Cancel Action", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	private void clearProfile()
	{
				
		cbRecruitmentId.setSelectedItem(null);
		cbEmpId.setSelectedItem(null);
		txtFirstName.setText("");
		txtPhone.setText("");
		txtDateOfBirth.setText("");
		txtStreet.setText("");
		cbCity.setSelectedItem(null);
		cbStatus.setSelectedItem(null);
		txtLastName.setText("");
		txtEmail.setText("");
		cbMaritalStatus.setSelectedItem(null);
		cbProvince.setSelectedItem(null);
		txtPostalCode.setText("");
		txtDateOfHire.setText("");
		cbDepartment.setSelectedItem(null);
		txtWorkPermit.setText("");
		cbEmployeeType.setSelectedItem(null);
		txtSinNumber.setText("");
		txtJobTitle.setText("");
		txtExpiryDate.setText("");
		txtPayRate.setText("");
		txtEmergencyContact.setText("");
		txtEmergencyPhone.setText("");	
	}
			
	public boolean isValidData() {
				if (!Validator.isComboBox(cbEmpId, "Employee ID "))
					return false;
				if (!Validator.isInteger(txtPhone, "Phone "))
					return false;
				if (!Validator.isInteger(txtPayRate, "Pay Rate "))
					return false;
				if (!Validator.isInteger(txtEmergencyPhone, "Emergency Phone"))
					return false;
				if (!Validator.isInteger(txtSinNumber, "Sin Number"))
					return false;
				if (!Validator.isInteger(txtWorkPermit, "Work Permit"))
					return false;
				if (!Validator.isPresent(txtFirstName, "First Name"))
					return false;
				if (!Validator.isPresent(txtDateOfBirth, "Date of Birth"))
					return false;
				if (!Validator.isPresent(txtStreet, "Street"))
					return false;
				if (!Validator.isPresent(txtLastName, "Last Name"))
					return false;
				if (!Validator.isPresent(txtEmail, "Email"))
					return false;
				if (!Validator.isPresent(txtPostalCode, "Postal Code"))
					return false;
				if (!Validator.isPresent(txtDateOfHire, "Date of Hire"))
					return false;
				if (!Validator.isPresent(txtJobTitle, "Job Title"))
					return false;
				if (!Validator.isPresent(txtExpiryDate, "Expiry Date"))
					return false;
				if (!Validator.isPresent(txtEmergencyContact, "Emergency Contact"))
					return false;
				//if (!Validator.isComboBox(cbRecruitmentId, "Recruitment ID"))
					//return false;
				if (!Validator.isComboBox(cbCity, "City"))
					return false;
				if (!Validator.isComboBox(cbStatus, "Status"))
					return false;
				if (!Validator.isComboBox(cbMaritalStatus, "Marital Status"))
					return false;
				if (!Validator.isComboBox(cbProvince, "Province"))
					return false;
				if (!Validator.isComboBox(cbDepartment, "Department"))
					return false;
				if (!Validator.isComboBox(cbEmployeeType, "Employee Type"))
					return false;
				return true;
			}
		
	public boolean isValidID()
		{
			//Case: Recruitment Id is present or Employee Id is present
			if(!Validator.isComboBox(cbEmpId, "Employee Id "))
				return false;
			return true;
		}
		
	private void populateProfile(ResultSet result,Employee employee) throws SQLException
	{
		cbRecruitmentId.setSelectedItem(employee.getRecruitmentID());
		cbEmpId.setSelectedItem(String.valueOf(employee.getEmpId()));
		txtFirstName.setText(employee.getFirstName());
		txtPhone.setText(employee.getPhone());
		txtDateOfBirth.setText(GenerateDateFormat(employee.getDob()));
		txtStreet.setText(employee.getStreet());
		cbCity.setSelectedItem(employee.getCity());
		cbStatus.setSelectedItem(employee.getStatus());
		txtLastName.setText(employee.getLastName());
		txtEmail.setText(employee.getEmail());
		cbMaritalStatus.setSelectedItem(employee.getMaritalStatus());
		cbProvince.setSelectedItem(employee.getProvince());
		txtPostalCode.setText(employee.getPostalCode());
		txtDateOfHire.setText(GenerateDateFormat(employee.getDoh()));
		cbDepartment.setSelectedItem(employee.getDepartment());
		txtWorkPermit.setText(employee.getPermit());
		cbEmployeeType.setSelectedItem(employee.getEmployeeType());
		txtSinNumber.setText(String.valueOf(employee.getSinNumber()));
		txtJobTitle.setText(employee.getJobTitle());
		txtExpiryDate.setText(GenerateDateFormat(employee.getExpiryDate()));
		txtPayRate.setText(String.valueOf((int)(employee.getPayRate())));
		txtEmergencyContact.setText(employee.getEmergencyContact());
		txtEmergencyPhone.setText(employee.getEmergencyPhone());
	}

	public int GenerateAddressID(Employee employee)
	{
		try {
			database.SelectAddressId(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int add_id = employee.getAddressID();
		int nextAdd_id = add_id + 1;
		
		return nextAdd_id;
	}
	
	public String GenerateDateFormat(String dateObj)
	{
		String newDate = null;
		
		if(dateObj != null)
		{
			String NEW_FORMAT = "dd-MON-yy";
			String OLD_FORMAT = "yyyy-MM-dd HH:mm:ss";
			
			String oldDateString = dateObj;
			String dd = oldDateString.substring(8, 10);
			String mm = oldDateString.substring(5, 7);
			String yy = oldDateString.substring(2, 4);
			
			switch(mm) {
			  case "01":
				mm = "JAN";
			    break;
			  case "02":
			    mm = "FEB";
			    break;
			  case "03":
			    mm = "MAR";
			    break;
			  case "04":
			    mm = "APR";
			    break;
			  case "05":
			    mm = "MAY";
			    break;
			  case "06":
			    mm = "JUN";
			    break;
			  case "07":
			    mm = "JUL";
			    break;
			  case "08":
			    mm = "AUG";
			    break;
			  case "09":
			    mm = "SEP";
			    break;
			  case "10":
			    mm = "OCT";
			    break;
			  case "11":
			    mm = "NOV";
			    break;
			  case "12":
			    mm = "DEC";
			    break;
			  default:
				  
			}	
			newDate = dd + "-" + mm + "-" + yy;
		}		
		return newDate;
	}
}
