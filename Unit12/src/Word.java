//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		this.word=s;
	}

	public String getWord()
	{
		return word;
	}
	
	public int compareTo( Word rhs )
	{		
		if (this.getWord().length()< rhs.getWord().length())
		return -2;
		
		
		else if (this.getWord().length()>rhs.getWord().length())
				return 2;
		else
		{
			return this.getWord().compareTo(rhs.getWord());
		}
		}

	public String toString()
	{
		return "";
	}
}