package hr;
import java.sql.Date;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.JTextComponent;

public class Validator {
	
	public static boolean isPresent(JTextComponent c, String title) {

		if(c.getText().length() == 0 ) {
			showMessage(String.valueOf(c), title + " is a required field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		else
		return true;
	}
	
	public static boolean isComboBox(JComboBox c , String title)
	{
		if(c.getSelectedItem() == null ) {
			showMessage(String.valueOf(c), title + " is a required field. \nPlease select an item.");
			c.requestFocusInWindow();
			return false;
		}
		else
		return true;
	}
	
	public static boolean isRadio(ButtonGroup c , String title)
	{
		if(c.getSelection() == null) {
			showMessage(String.valueOf(c), title + " is a required field. \nPlease select an item.");
			return false;
		}
		else
		return true;
	}
	
	public static boolean isInteger(JTextComponent c, String title) {
		
		try {
			int i = Integer.parseInt(c.getText());
			return true;
		}
		catch(NumberFormatException e) {
			showMessage(String.valueOf(c), title + "must be integer.\nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
	}
	
	public static boolean isDouble(JTextComponent c, String title) {
		
		try {
			double d = Double.parseDouble(c.getText());
			return true;
		}
		catch(NumberFormatException e) {
			showMessage(String.valueOf(c), title + "must be valid number.\nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
	}
	
	public static boolean chkDate(Date c1, Date c2, String title) {
		
		try {

			return true;
		}
		catch(Exception e) {
			
			return false;
		}
	}
	
	public static void showMessage(String c, String message) {
		JOptionPane.showMessageDialog(null,message, "Validation Error", JOptionPane.ERROR_MESSAGE);
	}
	
}
