import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class Pay 
{
	private double hoursWorked;
	private double rate;
	private int straightTimeHours; 

	public Pay() {
		
	}
	
	public double calc_payroll() {
		double result;
		if(straightTimeHours == 0) {
			result= hoursWorked*rate ;
			
		}else {
			
			if(hoursWorked>straightTimeHours)
			{
				result = straightTimeHours*rate +  (hoursWorked-straightTimeHours)*1.77*rate;
			}else {
				result= hoursWorked*rate ;
			}
			
		}
	
		
		return result;
	}
	public double tax(double input) {
		
		double output = 0;
		if(0<=input  && input <=399.99)
		{
			output = .07;
		}else if (399.99<input  && input <=899.99) {
			output =  0.1;
		}else  if(input > 899.99){
			output =  .16;
		}
		
		return output;
	}
	
	
	public void setHours(double input) {
		hoursWorked = input;
	}
	
	public void setRate(double input) {
		rate = input;
	}
	public void setHrsStr(double input) {
		straightTimeHours = (int)input;
	}
	public double getHours() {
		return hoursWorked;
	}
	public double getRate() {
		return rate;
	}
	public int getHrsStr() {
		return straightTimeHours;
	}
	
}
