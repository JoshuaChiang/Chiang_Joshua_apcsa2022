//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		//point pups at a new arry of Dog
		pups = new Dog[size];
		
	}
	
	public void set(int spot, int age, String name)
	{
		//put a new Dog in the array at spot 
		//make sure spot is in bounds	
		pups[spot] = new Dog(age,name);
	}

	public String getNameOfOldest()
	{
		Dog old = pups[0];
		for (int i = 0; i < pups.length; i++) {
			if (pups[i].getAge() > old.getAge()){
				old = pups[i];
			}
		}
		return old.getName();
	}

	public String getNameOfYoungest()
	{
		Dog young = pups[0];
		for (int i = 0; i < pups.length; i++) {
			if (pups[i].getAge() < young.getAge()){
				young = pups[i];
			}
		}
		return young.getName();
	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}