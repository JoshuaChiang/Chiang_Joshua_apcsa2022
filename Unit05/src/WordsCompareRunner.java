//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
		WordsCompare word = new WordsCompare();
		word.setWords("abe", "ape");
		out.print(word);
		
		WordsCompare word2 = new WordsCompare();
		word2.setWords("giraffe", "gorilla");
		out.print(word2);
		
		WordsCompare word3 = new WordsCompare();
		word3.setWords("one", "two");
		out.print(word3);
		
		WordsCompare word4 = new WordsCompare();
		word4.setWords("fun", "funny");
		out.print(word4);
		
		WordsCompare word5 = new WordsCompare();
		word5.setWords("123", "19");
		out.print(word5);
		
		WordsCompare word6 = new WordsCompare();
		word6.setWords("193", "1910");
		out.print(word6);
		
		WordsCompare word7 = new WordsCompare();
		word7.setWords("goofy", "godfather");
		out.print(word7);
		
		WordsCompare word8 = new WordsCompare();
		word8.setWords("funnel", "fun");
		out.print(word8);
	}
}
