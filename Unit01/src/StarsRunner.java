//© A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StarsRunner
{
   public static void main(String args[])
   {
      //instantiate a StarsAndStripes object
      StarsAndStripes picture = new StarsAndStripes();
      
      //call the methods needed to make the patterns on the word document
      System.out.println("\n\n");
      picture.printTwentyStars();
      System.out.println("\n\n");
      picture.printTwentyDashes();
      System.out.println("\n\n");
      picture.printTwoBlankLines();
      System.out.println("\n\n");
      picture.printASmallBox();
      System.out.println("\n\n");
      picture.printABigBox();
      
      
   }
}