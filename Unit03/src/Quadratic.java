//(c) A+ Computer Science
// www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class Quadratic
{
	private int a, b, c;
	private double rootOne;
	private double rootTwo;

	public Quadratic()
	{
		setEquation(0,0,0);
		rootOne=rootTwo=0.0;
	}

	public Quadratic(int quadA, int quadB, int quadC)
	{
		setEquation(quadA, quadB, quadC);
		rootOne=rootTwo=0.0;
	}

	public void setEquation(int quadA, int quadB, int quadC)
	{
 	}

	public void calcRoots( )
	{
		rootOne = (-b + sqrt(b^(2)-(4*a*c))/2*a);
	}

    public void print()
    {
    }
    
    //complete either print or the toString()

	public String toString()
	{
		return "";
	}
}