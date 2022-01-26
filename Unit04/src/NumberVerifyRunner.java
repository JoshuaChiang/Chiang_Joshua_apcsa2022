//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class NumberVerifyRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		//add in input
		System.out.println("Example");
		System.out.println("5 is odd :: " + NumberVerify.isOdd(5));
		System.out.println("5 is even :: " + NumberVerify.isEven(5));
		System.out.println("\n");
		System.out.print("\n");
		
		//add in more test cases
		System.out.println("Enter a whole number ::");
		int num = keyboard.nextInt();
		System.out.println(num+" is odd :: " + NumberVerify.isOdd(num));
		System.out.println(num+" is even :: " + NumberVerify.isEven(num));
		System.out.println("\n");
		
		System.out.println("Enter a whole number ::");
		int num2 = keyboard.nextInt();
		System.out.println(num2+" is odd :: " + NumberVerify.isOdd(num2));
		System.out.println(num2+" is even :: " + NumberVerify.isEven(num2));
		System.out.println("\n");
		
		System.out.println("Enter a whole number ::");
		int num3 = keyboard.nextInt();
		System.out.println(num3+" is odd :: " + NumberVerify.isOdd(num3));
		System.out.println(num3+" is even :: " + NumberVerify.isEven(num3));
		System.out.println("\n");
		
		System.out.println("Enter a whole number ::");
		int num4 = keyboard.nextInt();
		System.out.println(num4+" is odd :: " + NumberVerify.isOdd(num4));
		System.out.println(num4+" is even :: " + NumberVerify.isEven(num4));
	}
}