//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class DistanceRunner
{
	public static void main( String[] args )
	{
		//add test cases
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter x1 :: ");
		int x1 = keyboard.nextInt();


		System.out.print("Enter y1 :: ");
		int y1 = keyboard.nextInt();

		System.out.print("Enter x2 :: ");
		int x2 = keyboard.nextInt();


		System.out.print("Enter y2 :: ");
		int y2 = keyboard.nextInt();

		Distance dist = new Distance(x1, y1, x2, y2);
		dist.calcDistance();
		dist.print();
		
		
		System.out.print("Enter x1 :: ");
		int x12 = keyboard.nextInt();


		System.out.print("Enter y1 :: ");
		int y12 = keyboard.nextInt();

		System.out.print("Enter x2 :: ");
		int x22 = keyboard.nextInt();


		System.out.print("Enter y2 :: ");
		int y22 = keyboard.nextInt();

		Distance dist2 = new Distance(x12, y12, x22, y22);
		dist2.calcDistance();
		dist2.print();
		
		
		System.out.print("Enter x1 :: ");
		int x13 = keyboard.nextInt();


		System.out.print("Enter y1 :: ");
		int y13 = keyboard.nextInt();

		System.out.print("Enter x2 :: ");
		int x23 = keyboard.nextInt();


		System.out.print("Enter y2 :: ");
		int y23 = keyboard.nextInt();

		Distance dist3 = new Distance(x13, y13, x23, y23);
		dist3.calcDistance();
		dist3.print();
	}
}