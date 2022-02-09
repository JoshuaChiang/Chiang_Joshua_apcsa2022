//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		char response;
		
		//add in a do while loop after you get the basics up and running
		
			String player = "";

			out.print("Do you want to play?");
			response = keyboard.next().charAt(0);
			do {
				out.print("\npick your weapon [R,P,S] :: ");
				player = keyboard.next();
				RockPaperScissors game2 = new RockPaperScissors();
				game2.setPlayers(player);
				out.print(game2 + "Do you want to play again?");
				response = keyboard.next().charAt(0);
			} while (response == 'y');
			}
}



