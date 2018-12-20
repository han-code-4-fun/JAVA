import java.text.DecimalFormat;
import java.util.concurrent.BlockingDeque;

import javax.swing.JOptionPane;

import com.sun.glass.ui.TouchInputSupport;
import com.sun.xml.internal.ws.api.Component;

public  class MSG 
{

	static public void confirmUpdate()
	{
		JOptionPane.showMessageDialog(
				null, 
				"Update Complete", 
				"Confirmation	",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	static public void noBookSelect()
	{
		JOptionPane.showMessageDialog(null,
				"No Books selected, Pleas select  a Book title ", "Not Allowed",  
				JOptionPane.ERROR_MESSAGE);
	}
	
	static public void purchase(DecimalFormat twoDecimal, double totalPrice)
	{
		JOptionPane.showMessageDialog(
				null, 
				"Total: $"+twoDecimal.format(totalPrice)+" has been charged to you card, Thank you",
				"Confirmation",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	static public int confirmPurchase()
	{
		int output = 0;
		output=JOptionPane.showConfirmDialog(null, 
				"Are You Sure?",
				"WARNING",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE
				);
		return output;
	}
	static public void noFormat()
	{
		JOptionPane.showMessageDialog(null, 
				"This title is NOT available in any format, Please Select Another", 
				"Not Allowed",JOptionPane.ERROR_MESSAGE);	
	}
	static public void noTitleSelect()
	{
		
		JOptionPane.showMessageDialog(null, 
				"Please select a book title", "no selection", JOptionPane.ERROR_MESSAGE);
		
	}
	static public void wrongPasswd()
	{
		JOptionPane.showMessageDialog(
				null, 
				"Wrong Password, Please re-enter", 
				"Not Allowed", 
				JOptionPane.ERROR_MESSAGE);
	}
	public static void wrongCreditCard() {
		JOptionPane.showMessageDialog(null,
				"please enter a valid credit card ", "Not Allowed", 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static int lastConfirmationbeforeBuy() {
		int output;
		output=JOptionPane.showConfirmDialog(
				null, "Are You SURE?",
				"WARNING",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE
				);
		return output;
	}
		
	
}
