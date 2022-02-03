//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class PerfectRunner
{
	public static void main( String args[] )
	{
		//add test cases
		Perfect test = new Perfect(496);
		test.isPerfect();
		out.println(test+ "\n");
		
		Perfect test2 = new Perfect(45);
		test2.isPerfect();
		out.println(test2 + "\n");
		
		Perfect test3 = new Perfect(6);
		test3.isPerfect();
		out.println(test3+ "\n");
		
		Perfect test4 = new Perfect(14);
		test4.isPerfect();
		out.println(test4+ "\n");
		
		Perfect test5 = new Perfect(8128);
		test5.isPerfect();
		out.println(test5+ "\n");
		
		Perfect test6 = new Perfect(1245);
		test6.isPerfect();
		out.println(test6+ "\n");
		
		Perfect test7 = new Perfect(33);
		test7.isPerfect();
		out.println(test7 + "\n");
		
		Perfect test8 = new Perfect(28);
		test8.isPerfect();
		out.println(test8+ "\n");
		
		Perfect test9 = new Perfect(27);
		test9.isPerfect();
		out.println(test9+ "\n");
		
		Perfect test10 = new Perfect(33550336);
		test10.isPerfect();
		out.println(test10+ "\n");
																
	}
}