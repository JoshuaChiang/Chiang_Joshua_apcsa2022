//(c) A+ Computer Science 
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance;

	public Distance()
	{
		setCoordinates(0,0,0,0);
	}

	public Distance(int x1, int y1, int x2, int y2)
	{
		setCoordinates(x1,y1,x2,y2);
	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		x1=xOne;
		y1=yOne;
		x2=xTwo;
		y2=yTwo;
	}

	public void calcDistance()
	{
		distance = Math.sqrt((xTwo-xOne)*(xTwo-xOne)+(yOne-yTwo)*(yOne-yTwo));
	}
	
	public double getDistance()
	{
		return distance;
	}
	
	public void print()
	{
		System.out.println("distance == "+String.format("%.3f",distance));
	}
	
	//complete print or the toString

	public String toString()
	{
		return "";
	}
}