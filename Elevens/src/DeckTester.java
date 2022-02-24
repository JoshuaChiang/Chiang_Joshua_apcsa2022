/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] rank = {"A","B","C"};
		String[] suit = {"Giraffes","Lions"};
		int[] pointValue = {2,1,6};
		Deck test = new Deck(rank,suit,pointValue);
		
		String[] rank1 = {"D","E","F"};
		String[] suit1 = {"Batman","Superman","WonderWoman"};
		int[] pointValue1 = {8,9,10};
		Deck test1 = new Deck(rank1,suit1,pointValue1);
		
		String[] rank2 = {"G","H","I"};
		String[] suit2 = {"Vi","Jinx","Silco","Vander"};
		int[] pointValue2 = {3,5,7};
		Deck test2 = new Deck(rank2,suit2,pointValue2);
		
		System.out.println(test.isEmpty());
		System.out.println(test.size());
		System.out.println(test.deal());
		System.out.println(test + "\n");
		
		System.out.println(test1.isEmpty());
		System.out.println(test1.size());
		System.out.println(test1.deal());
		System.out.println(test1 + "\n");
		
		System.out.println(test2.isEmpty());
		System.out.println(test2.size());
		System.out.println(test2.deal());
		System.out.println(test2 + "\n");
	}
}
