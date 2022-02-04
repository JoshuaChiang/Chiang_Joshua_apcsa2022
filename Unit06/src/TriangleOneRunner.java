//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class TriangleOneRunner
{
	public static void main ( String[] args )
	{
		//add test cases
		TriangleOne test = new TriangleOne("hippo");
		test.print();
		out.println("");
		
		TriangleOne test2 = new TriangleOne("abcd");
		test2.print();
		out.println("");

		TriangleOne test3 = new TriangleOne("it");
		test3.print();
		out.println("");
		
		TriangleOne test4 = new TriangleOne("a");
		test4.print();
		out.println("");
		
		TriangleOne test5 = new TriangleOne("chicken");
		test5.print();
		out.println("");
	}
}