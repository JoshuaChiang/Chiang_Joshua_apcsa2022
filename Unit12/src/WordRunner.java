//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File; 
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("words.dat"));

		int size = file.nextInt();
		file.nextLine();
		
		ArrayList<Word> words = new ArrayList<Word>();
		
		
		while (file.hasNext())
		{
			words.add(new Word(file.next()));
		}
		
		Word[] wordss = words.toArray(new Word[0]);
		Collections.sort(words);
		
		
		for(Word ww:words)
		{
			System.out.println(ww.getWord());
		}











	}
}