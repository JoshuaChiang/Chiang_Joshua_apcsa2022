//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	private int num;
	private int den;

	//write two constructors
	public Rational() {
		num=0;
		den=0;
	}
	
	public Rational(int n, int d) {
		setRational(n,d);
	}

	//write a setRational method
	public void setRational(int n, int d) {
		setNum(n);
		setDen(d);
	}
	

	//write  a set method for numerator and denominator
	public void setNum(int n) {
		num = n;
	}
	
	public void setDen(int d) {
		den = d;
	}

	
	public void add(Rational  other)
	{
		//num1/den1 + num2/den2 
		//new numerator = (num1 * den2 + num2 * den1)
		//new denominator = (den1 * den2)
		int newNumerator = getNum() * other.getDen() + other.getNum() * getDen();
		int newDenominator = getDen() * other.getDen();
		setNum(newNumerator);
		setDen(newDenominator);
		


		reduce();
	}

	private void reduce()
	{
		setNum(num/ gcd(num, den));
		setDen(den / gcd(num, den));


	}

	private int gcd(int numOne, int numTwo)
	{
		if(numTwo == 0) {
			return numOne;
		}
		
		return gcd(numTwo, numOne % numTwo);
	}

	public Object clone ()
	{
		return new Rational(getNum(), getDen());
	}


	//ACCESSORS

	//write get methods for numerator and denominator
	public int getNum() {
		return num;
	}
	
	public int getDen() {
		return den;
	}
	
	public boolean equals( Object obj)
	{
		if(compareTo((Rational)obj) == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int compareTo(Rational other)
	{
		if(getNum()*other.den > other.num*getDen()) {
			return 1;
		}
		if(getNum()*other.den > other.num*getDen()) {
			return -1;
		}
		return 0;
	}



	
	//write  toString() method
	
	
}