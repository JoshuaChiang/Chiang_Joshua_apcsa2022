//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;

	//add constructors
   public Perfect() {
	   setPerfect(0);
   }
   
   public Perfect(int i) {
	   setPerfect(i);
   }

	//add a set method
   public void setPerfect(int i) {
	   number = i;
   }

	public boolean isPerfect()
	{
		int i = 1;
		int total = 0;
		while(i<number) {
			if(number % i == 0) {
				total += i;
			}
			i++;
		}
		if (total == number) {
			return true;
		}
		return false;
	}

	//add a toString
	public String toString() {
		if (isPerfect() == true) {
			return number + " is perfect.";
		} 
		return number + " is not perfect.";
	}
	
}