//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		StringEquality str = new StringEquality("hello", "goodbye");
		str.checkEquality();
		out.println(str);
		
		StringEquality str2 = new StringEquality("one", "two");
		str2.checkEquality();
		out.println(str2);
		
		StringEquality str3 = new StringEquality("three", "four");
		str3.checkEquality();
		out.println(str3);
		
		StringEquality str4 = new StringEquality("TCEA", "UIL");
		str4.checkEquality();
		out.println(str4);
		
		StringEquality str5 = new StringEquality("State", "Champions");
		str5.checkEquality();
		out.println(str5);
		
		StringEquality str6 = new StringEquality("ABC", "ABC");
		str6.checkEquality();
		out.println(str6);
		
		StringEquality str7 = new StringEquality("ABC", "CBA");
		str7.checkEquality();
		out.println(str7);
		
		StringEquality str8 = new StringEquality("Same", "Same");
		str8.checkEquality();
		out.println(str8);
	}
}