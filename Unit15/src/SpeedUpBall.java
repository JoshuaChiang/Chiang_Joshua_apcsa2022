//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables
	private int xSpeed;
	private int ySpeed;
	
	public SpeedUpBall() {
		super(200, 200);
		xSpeed = 3;
		ySpeed = 1;
	}

	public SpeedUpBall(int x, int y) {
		super(x, y);
		xSpeed = 3;
		ySpeed = 1;
	}

	public SpeedUpBall(int x, int y, int xSp, int ySp) {
		super(x, y, xSp, ySp);
	}

	public SpeedUpBall(int x, int y, int w, int h, int xSp, int ySp) {
		super(x, y, xSp, ySp);
	}

	public SpeedUpBall(int x, int y, int w, int h, Color c, int xSp, int ySp) {
		super(x, y, w, h, c, xSp, ySp);
	}

	public void setXSpeed(int xSp) {
		xSpeed = xSp;
	}

	public void setYSpeed(int ySp) {
		ySpeed = ySp;
	}
}

