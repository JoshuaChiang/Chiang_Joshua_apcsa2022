//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{

   //constructors
	public BlinkyBall()
   {
		super();
   }

   public BlinkyBall(int x, int y)
   {

	   super(x, y);

   }

   public BlinkyBall(int x, int y, int w, int h)
   {
	   super(x, y, w, h);


   }

   public BlinkyBall(int x, int y, int w, int h, int xSp, int ySp)
   {
	   super(x, y, w, h, Color.GREEN, xSp, ySp);
   }

   public BlinkyBall(int x, int y, int w, int h, Color c, int xSp, int ySp)
   {
	   super(x, y, w, h, c, xSp, ySp);

   }

   public Color randomColor()
   {
   	int r = (int) (Math.random()*255);		//use Math.random()
 		int g = (int)(Math.random()*255) ;
 		int b =(int)(Math.random()*255);
 		return new Color(r,g,b);
   }

   public void moveAndDraw(Graphics window)
   {
	   draw(window, Color.GREEN);
	   this.setX(this.getX()+ this.getXSpeed());
	   this.setY(this.getY()+ this.getYSpeed());
	   this.setColor(randomColor());
   }
}