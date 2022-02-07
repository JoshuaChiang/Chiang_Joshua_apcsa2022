//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		setNum(num);


	}

	public void setNum(int num)
	{
		number = num;


	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = 0;
		for(int i = 1; i <= number; i++) {
			if(a % i == 0 && b % i == 0 && c % i == 0) {
				max = i;
			}
			
		}
			
		return max;
	}

	public String toString()
	{
		String output="";






		return output+"\n";
	}
}