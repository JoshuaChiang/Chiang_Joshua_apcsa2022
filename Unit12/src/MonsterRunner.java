//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		
		//ask for name and size
		System.out.println("Enter 1st monster's name : ");
		String name1 = keyboard.next();
		System.out.println("Enter 1st monster's size : ");
		int size1 = keyboard.nextInt();
		
		//instantiate monster one
		Monster monster1 = new Skeleton(name1,size1);
		
		//ask for name and size
		System.out.println("Enter 2nd monster's name : ");
		String name2 = keyboard.next();
		System.out.println("Enter 2nd monster's size : ");
		int size2 = keyboard.nextInt();
		
		//instantiate monster two
		Monster monster2 = new Skeleton(name2,size2);
		
		if(monster1.isBigger(monster1) == true) {
			System.out.println("Monster one is bigger than than Monster two");
			
		} else {
			System.out.println("Monster one is smaller than Monster two");
		}
		if(monster1.namesTheSame(monster2) == true) {
			System.out.println("Monster one has the same name as Monster two");
		} else {
			System.out.println("Monster one doesn't have the same name as Monster two");
		}
	}
}