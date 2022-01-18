//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class Line
{
	public static double getSlope( int x1, int y1, int x2, int y2 )
	{
		int a = x1;
		int b = x2;
		int c = y1;
		int d = y2;
		return (double) (d-c)/(b-a);
	}

}