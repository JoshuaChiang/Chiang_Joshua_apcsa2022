//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class Word
{
	private String word;

	public Word()
	{
		setString(null);
	}

	public Word(String s)
	{
		setString(s);
	}

	public void setString(String s)
	{
		word=s;
	}

	public char getFirstChar()
	{
		return word.charAt(0);
	}

	public char getLastChar()
	{
		return word.charAt(word.length()-1) ;
	}

	public String getBackWards()
	{
		String back="";
		String first = String.valueOf(getFirstChar());
		String last = String.valueOf(getLastChar());
		String mid = word.substring(1, word.length()-1);
		back = last + mid + first;
		return back;
	}

 	public String toString()
 	{
 		return getFirstChar() + "\n" + getLastChar() + "\n" + getBackWards() + "\n" + word + "\n";
	}
}