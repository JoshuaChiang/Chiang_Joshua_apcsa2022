//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;

	public RockPaperScissors()
	{
		this(null);
	}

	public RockPaperScissors(String player)
	{
		setPlayers(player);
	}

	public void setPlayers(String player)
	{
		playChoice = player;
		
		int num = (int) Math.random()*2 + 1;
		if (num == 0) {
			compChoice = "R";
		}
		else if (num == 1) {
			compChoice = "P";
		}
		else if (num == 2) {
			compChoice = "S";
		}
	}

	public String determineWinner()
	{
		String winner="";
		if (playChoice.equals(compChoice)) {
			winner = "Draw Game!";
		}
		if ((playChoice.equals("R") && compChoice.equals("P")) || (playChoice.equals("P") && compChoice.equals("S")) || (playChoice.equals("S") && compChoice.equals("R"))) {
			winner = "Computer wins!";
		}
		if ((playChoice.equals("P") && compChoice.equals("R")) || (playChoice.equals("S") && compChoice.equals("P")) || (playChoice.equals("R") && compChoice.equals("S"))) {
			winner = "Player wins!";
		}
		return winner;
	}

	public String toString()
	{
		String output = "player had " + playChoice + "\ncomputer had " + compChoice + "\n!" + determineWinner() + "\n\n";
		return output;
	}
}