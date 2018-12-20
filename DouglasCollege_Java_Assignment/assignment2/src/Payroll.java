
public class Payroll extends Pay 
{
	
	public double calc_payroll() {
	
		//double tempGross = super.calc_payroll();
		double tempTax =  this.tax(super.calc_payroll());
		 double output = super.calc_payroll()*(1-tempTax);
		 return output;
		 //return the net pay rather than gross pay
	}
}
