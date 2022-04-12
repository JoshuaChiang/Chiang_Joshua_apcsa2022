//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	
	public Ball(int x, int y)
	{
		super(x,y);
		xSpeed = 1;
		ySpeed = 1;
		
	}
	
	public Ball(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		xSpeed = 1;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h, Color c)
	{
		super(x, y, w, h, c);
		xSpeed = 1;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int wid, int h, Color c, int xSp, int ySp)
	{
		super(x, y, wid, h, c);
		setXSpeed(xSp);
		setYSpeed(ySp);

	}
	
   //add the set methods
   
	public void setXSpeed(int x)
	{
		xSpeed=x;
	}
	
	public void setYSpeed(int y)
	{
		ySpeed=y;
	}
	
   public void moveAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	      setX(getX()+xSpeed);
			//setY
	      setY(getY()+ySpeed);

			//draw the ball at its new location
	      super.draw(window);
   }
   
	public boolean equals(Object obj)
	{
		Ball rhs = (Ball) obj;
		if ( getXSpeed() == rhs.getXSpeed() && getYSpeed() == rhs.getYSpeed() )
		{
			return true;
		}
		return false;

	}   

   //add the get methods
	public int getXSpeed()
	{
		return xSpeed;
	}
	
	public int getYSpeed()
	{
		return ySpeed;
	}

   //add a toString() method
	public String toString()
	{
		String output = "";
		output= getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();
		return output;
	}
}