//© A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StarsAndStripes
{
   public StarsAndStripes()
   {
      out.println("StarsAndStripes");
      printTwoBlankLines();
   }

   public void printTwentyStars()
   {
	  System.out.println("********************");
   }

   public void printTwentyDashes()
   {
	   System.out.println("--------------------");
   }

   public void printTwoBlankLines()
   {
	   printTwentyDashes();
	   printTwentyDashes();
   }
   
   public void printASmallBox()
   {	
	   printTwentyStars();
	   printTwentyDashes();
	   printTwentyStars();
	   printTwentyDashes();
	   printTwentyStars();
	   printTwentyDashes();
   }
   public void printABigBox()
   { 	
	   printASmallBox();
	   printTwoBlankLines();
	   printASmallBox();
	   printTwoBlankLines();
	   printASmallBox();
	   printTwoBlankLines();
   }   
}