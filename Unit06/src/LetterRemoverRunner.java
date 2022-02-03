//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemoverRunner
{
	public static void main( String args[] )
	{
		//add test cases	
		LetterRemover test = new LetterRemover("I am Sam I am", 'a');
		test.removeLetters();
		out.println(test+ "\n");
		
		LetterRemover test2 = new LetterRemover("ssssssssxssssesssssesss", 's');
		test2.removeLetters();
		out.println(test2 + "\n");
		
		LetterRemover test3 = new LetterRemover("qwertyqwertyqwerty", 'a');
		test3.removeLetters();
		out.println(test3+ "\n");
		
		LetterRemover test4 = new LetterRemover("abababababa", 'b');
		test4.removeLetters();
		out.println(test4+ "\n");
		
		LetterRemover test5 = new LetterRemover("abaababababa", 'x');
		test5.removeLetters();
		out.println(test5+ "\n");
	}
}