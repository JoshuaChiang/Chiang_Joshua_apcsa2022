//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>(size);
		for (int i = 0; i < size; i++) {
			add(new Alien(50*i, 100, 30, 30, 1));
		}
		moveEmAll();
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien a : aliens) {
			if (a.getX() + a.getWidth() >= 800) {
				a.setY(a.getY() + 25);
				a.setX(750);
				a.setSpeed(a.getSpeed() * -1);
			}	
			else if (a.getX() <= 0) {
				a.setY(a.getY() + 25);
				a.setX(50);
				
				a.setSpeed(a.getSpeed() * -1);
			}
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		for (Alien a : aliens) {
			a.setX(a.getX() + a.getSpeed());
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for (int i = 0; i < shots.size(); i++) {
			Ammo am = shots.get(i);
			for (int j = 0; j < aliens.size(); j++) {
				if ((am.getX() >= aliens.get(j).getX() && am.getX() <= aliens.get(j).getX() + 
				aliens.get(j).getWidth()) || (am.getX() + am.getWidth() >= aliens.get(j).getX() && 
				am.getX() + am.getWidth() <= aliens.get(j).getX() + aliens.get(j).getWidth())) {
					if ((am.getY() >= aliens.get(j).getY() && am.getY() <= aliens.get(j).getHeight()
							+ aliens.get(j).getY()) || (am.getY() + am.getHeight() >= aliens.get(j).getY()
							&& am.getY() + am.getHeight() <= aliens.get(j).getY() + aliens.get(j).getHeight())) {
						aliens.remove(j);
					}
				}			
			}
		}	
	}
	
	public int getSize() {
		return aliens.size();
	}
	
	public Alien get(int i) {
		return aliens.get(i);
	}

	public String toString()
	{
		return "";
	}
}
