import java.io.*;
import java.math.*;
import java.util.*;

public class Accept {

	static Scanner stdin = new Scanner(System.in);
	
	static public int  acceptInputInt() {
		
		int temp;
		boolean condition = false;
		do {
			if(stdin.hasNextDouble()) {
				temp = stdin.nextInt();
				temp = Math.abs(temp);
				condition = true;
				return temp;
			}else {
				System.out.println("Please enter an integer:");
				stdin.next();
			}
		}while(condition == false);
		return 0;
		
	}
	
	static public char  acceptInputChar() {
		
		boolean condition = false;
		char output = 0;
		System.out.println("\ne to exit, any other letter + <Enter> to continue");
		String temp;
		temp = stdin.next();
		do {
			if(temp.length() == 1)
			{
				condition = true;
				output = temp.toLowerCase().charAt(0);
				return output;
			}else {
				System.out.println("Please enter a letter!");
				temp=stdin.next();
			}
			
		}while(condition == true);
		return output;
	}
	
	static public double  acceptInputDouble() {
		
		double temp;
		boolean condition = false;
		do {
			if(stdin.hasNextDouble()) {
				temp = stdin.nextDouble();
				temp=  Math.abs(temp);
				condition = true;
				return temp;
			}else {
				System.out.println("Please enter a decimal:");
				stdin.next();
			}
		}while(condition == false);
		return 0.0;
		
	}
	static public float  acceptInputFloat() {
		
		float temp;
		boolean condition = false;
		do {
			if(stdin.hasNextDouble()) {
				temp = stdin.nextFloat();
				temp = Math.abs(temp);
				condition = true;
				return temp;
			}else {
				System.out.println("Please enter a decimal number:");
				stdin.next();
			}
		}while(condition == false);
		return 0.0f;
	}
	
}
