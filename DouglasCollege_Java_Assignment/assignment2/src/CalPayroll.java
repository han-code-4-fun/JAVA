import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CalPayroll extends Pay
{
	Payroll myPayroll = new Payroll();
	NumberFormat dollars = NumberFormat.getCurrencyInstance();
	DecimalFormat dFormat = new DecimalFormat("#%");
	
	public void displayinfo() {
		//invoke method to calculate tax, gross pay, tax applied and net pay and disaplay
		//no input and void
		double grossPay, tax, netPay;
		
		grossPay = this.calc_payroll();
		tax = this.tax(grossPay);
		
		netPay = myPayroll.calc_payroll();
		Screen.scrollScreen('=',60,2);
		System.out.println("Gross pay is: " + dollars.format(grossPay)  );
		System.out.println("Tax is \t    : " + dFormat.format(tax) );
		System.out.println("Net pay is  : " + dollars.format(netPay) );
		
	}
	
	public void acceptPay() {
		char doNext;
		do {
			System.out.println("Payroll Computation\n");
			System.out.println("Enter number of hours worked (00.0) <0 for Quick exit>:");
			myPayroll.setHours(Accept.acceptInputDouble());
			if(myPayroll.getHours() != 0) {
				this.setHours(myPayroll.getHours());
				System.out.println("Enter first number of hours straight (integer or 0 to disable):");
				myPayroll.setHrsStr(Accept.acceptInputDouble());
				this.setHrsStr(myPayroll.getHrsStr());
				System.out.println("Enter hourly rate of worker (00.00):");
				myPayroll.setRate(Accept.acceptInputDouble());
				this.setRate(myPayroll.getRate());
				this.displayinfo();
				
				doNext=Accept.acceptInputChar();
				Screen.scrollScreen();
			}else {
				doNext=Accept.acceptInputChar();
				Screen.scrollScreen();
			}
			
			
		}while(doNext!='e');
		System.out.println("Good bye");
	}
}
