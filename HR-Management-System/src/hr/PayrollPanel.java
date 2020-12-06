package hr;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class PayrollPanel extends JPanel {

	private JTextField txtEmployeeID;
	private JTextField txtDepartment;
	private JTextField txtEmployeeName;
	private JTextField txtJobTitle;
	private JLabel lblEmployeeId;
	private JLabel lblGrossPay;
	private JLabel lblMealVoucherAllowance;
	private JLabel lblSpecialAllowance;
	private JLabel label;
	private JLabel lblFederalTax;
		
	public PayrollPanel() {
		this.initialize();
	}
	
	public void initialize() {
		
		try {
			this.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.setBounds(37, 84, 954, 650);
			this.setLayout(null);
			this.setBorder(new LineBorder(new Color(0, 0, 0)));
			
			JLabel lblEmployeeDetails = new JLabel("Employee Details");
			lblEmployeeDetails.setFont(lblEmployeeDetails.getFont().deriveFont(lblEmployeeDetails.getFont().getStyle() | Font.BOLD));
			lblEmployeeDetails.setBounds(361, 42, 111, 23);
			this.add(lblEmployeeDetails);
			
			lblEmployeeId = new JLabel("Employee ID:");
			lblEmployeeId.setBounds(22, 97, 92, 13);
			this.add(lblEmployeeId);
			
			txtEmployeeID = new JTextField();
			txtEmployeeID.setColumns(10);
			txtEmployeeID.setBounds(150, 93, 148, 30);
			this.add(txtEmployeeID);
			
			JLabel lblEmployeeName = new JLabel("Employee Name:");
			lblEmployeeName.setBounds(22, 161, 101, 14);
			this.add(lblEmployeeName);
			
			txtEmployeeName = new JTextField();
			txtEmployeeName.setEditable(false);
			txtEmployeeName.setColumns(10);
			txtEmployeeName.setBounds(150, 158, 247, 30);
			this.add(txtEmployeeName);
			
			JLabel lblDepartment = new JLabel("Department:");
			lblDepartment.setBounds(506, 97, 76, 14);
			this.add(lblDepartment);
			
			txtDepartment = new JTextField();
			txtDepartment.setEditable(false);
			txtDepartment.setColumns(10);
			txtDepartment.setBounds(683, 97, 250, 30);
			this.add(txtDepartment);
			
			JLabel lblJobTitle = new JLabel("Job Title:");
			lblJobTitle.setBounds(506, 161, 76, 14);
			this.add(lblJobTitle);
				
			txtJobTitle = new JTextField();
			txtJobTitle.setEditable(false);
			txtJobTitle.setColumns(10);
			txtJobTitle.setBounds(683, 161, 250, 30);
			this.add(txtJobTitle);
			
			JLabel lblPayrollDetails = new JLabel("Payroll Details");
			lblPayrollDetails.setFont(lblEmployeeDetails.getFont().deriveFont(lblEmployeeDetails.getFont().getStyle() | Font.BOLD));
			lblPayrollDetails.setBounds(371, 213, 111, 23);
			this.add(lblPayrollDetails);
			
			lblGrossPay = new JLabel("Gross Pay:");
			lblGrossPay.setBounds(22, 271, 122, 13);
			this.add(lblGrossPay);
			
			JTextField txtGrossPay = new JTextField();
			txtGrossPay.setColumns(10);
			txtGrossPay.setBounds(169, 266, 250, 30);
			this.add(txtGrossPay);
			
			lblMealVoucherAllowance = new JLabel("Meal Voucher Allowance:");
			lblMealVoucherAllowance.setBounds(22, 316, 162, 33);
			this.add(lblMealVoucherAllowance);
			
			JTextField txtMealAllowance = new JTextField();
			txtMealAllowance.setColumns(10);
			txtMealAllowance.setBounds(169, 322, 250, 30);
			this.add(txtMealAllowance);
			
			lblSpecialAllowance = new JLabel("Special Allowance:");
			lblSpecialAllowance.setBounds(22, 383, 162, 33);
			this.add(lblSpecialAllowance);
			
			JTextField txtSpecialAllowance = new JTextField();
			txtSpecialAllowance.setColumns(10);
			txtSpecialAllowance.setBounds(169, 382, 250, 30);
			this.add(txtSpecialAllowance);
			
			lblFederalTax = new JLabel("Federal Tax: ");
			lblFederalTax.setBounds(506, 258, 109, 32);
			this.add(lblFederalTax);
			
			JTextField txtFederalTax = new JTextField();
			txtFederalTax.setColumns(10);
			txtFederalTax.setBounds(683, 263, 250, 30);
			this.add(txtFederalTax);
			
			JLabel lblProvincialTax = new JLabel("Provincial Tax:");
			lblProvincialTax.setBounds(506, 317, 109, 20);
			this.add(lblProvincialTax);
			
			JTextField txtProvincialTax = new JTextField();
			txtProvincialTax.setColumns(10);
			txtProvincialTax.setBounds(683, 319, 250, 30);
			this.add(txtProvincialTax);
			
			JLabel lblCppDeduction = new JLabel("CPP deductions");
			lblCppDeduction.setBounds(506, 381, 109, 20);
			this.add(lblCppDeduction);
			
			JTextField txtCppDeductions = new JTextField();
			txtCppDeductions.setColumns(10);
			txtCppDeductions.setBounds(683, 381, 250, 30);
			this.add(txtCppDeductions);
			
			JLabel lblEIDeduction = new JLabel("EI deductions");
			lblEIDeduction.setBounds(506, 441, 121, 20);
			this.add(lblEIDeduction);
			
			JTextField txtEIDeduction = new JTextField();
			txtEIDeduction.setColumns(10);
			txtEIDeduction.setBounds(683, 441, 250, 30);
			this.add(txtEIDeduction);
			

			JLabel lblHoursWorked = new JLabel("Hours /Days Worked:");
			lblHoursWorked.setBounds(22, 442, 162, 33);
			this.add(lblHoursWorked);
			
			JTextField txtHoursWorked = new JTextField();
			txtHoursWorked.setColumns(10);
			txtHoursWorked.setBounds(169, 441, 250, 30);
			this.add(txtHoursWorked);
			
			label = new JLabel("Total");
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
			label.setBounds(28, 530, 148, 20);
			this.add(label);
			
			JTextField txtTotal = new JTextField();
			txtTotal.setEditable(false);
			txtTotal.setColumns(10);
			txtTotal.setBounds(175, 527, 250, 30);
			this.add(txtTotal);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setBounds(308, 93, 89, 30);
			add(btnSearch);
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.setBounds(576, 527, 89, 30);
			add(btnUpdate);
			
			JButton btnPrint = new JButton("Print");
			btnPrint.setBounds(675, 527, 89, 30);
			add(btnPrint);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setBounds(774, 527, 89, 30);
			add(btnCancel);
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}			
	}
	
}
