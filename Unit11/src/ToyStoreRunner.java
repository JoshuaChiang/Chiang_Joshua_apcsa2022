//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStoreRunner
{
	public static void main( String args[] )
	{
		ToyStore b = new ToyStore();
		b.loadToys("sorry bat sorry sorry train train teddy teddy ball ball");
		out.println(b);
		out.println("max == " + b.getMostFrequentToy());

	}
}