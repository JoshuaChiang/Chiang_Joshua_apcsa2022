//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;

	public TriangleFive()
	{
		setLetter(' ');
		setAmount(0);
	}

	public TriangleFive(char c, int amt)
	{
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}

	public String toString()
	{
		String output="";
		char a = letter;
		for(int i = 0; i < amount; i++) {
			for(int k = amount; k > i; k--) {
				for(int j = 0; j < k; j++) {
					if(a > 'Z') {
						a = 'A';
					}
					output += a;
				}
				output += " ";
				a++;
			}
			output += "\n";
			a = letter;
		}
		return output;
	}
}