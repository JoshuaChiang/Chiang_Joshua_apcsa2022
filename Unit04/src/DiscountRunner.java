//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class DiscountRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		out.print("Enter the original bill amount :: $");
		double amt = keyboard.nextDouble();
		out.print("Bill after discount :: $");
		out.printf("%.2f", Discount.getDiscountedBill(amt));
		out.println("\n");
		
		out.print("Enter the original bill amount :: $");
		double amt2 = keyboard.nextDouble();
		out.print("Bill after discount :: $");
		out.printf("%.2f", Discount.getDiscountedBill(amt2));
		out.println("\n");
		
		out.print("Enter the original bill amount :: $");
		double amt3 = keyboard.nextDouble();
		out.print("Bill after discount :: $");
		out.printf("%.2f", Discount.getDiscountedBill(amt3));
		out.println("\n");
		
		out.print("Enter the original bill amount :: $");
		double amt4 = keyboard.nextDouble();
		out.print("Bill after discount :: $");
		out.printf("%.2f", Discount.getDiscountedBill(amt4));
		out.println("\n");
	}
}