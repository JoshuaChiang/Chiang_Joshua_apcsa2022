/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card test = new Card("jack", "spades", 11);
		Card test2 = new Card("jack", "spades", 11);
		Card test3 = new Card("5", "hearts", 5);
		
		System.out.println("test1");
		System.out.println("suit:: " + test.suit());
		System.out.println("rank:: " + test.rank());
		System.out.println("pointValue:: " + test.pointValue());
		System.out.println("Matches test2:: " + test.matches(test2));
		System.out.println("Matches test3:: " + test.matches(test3));
		System.out.println("Card is:: " + test);
		System.out.println("\n");
		
		System.out.println("test2");
		System.out.println("suit:: " + test2.suit());
		System.out.println("rank:: " + test2.rank());
		System.out.println("pointValue:: " + test2.pointValue());
		System.out.println("Matches test1:: " + test2.matches(test));
		System.out.println("Matches test3:: " + test2.matches(test3));
		System.out.println("Card is:: " + test2);
		System.out.println("\n");
		
		System.out.println("test3");
		System.out.println("suit:: " + test3.suit());
		System.out.println("rank:: " + test3.rank());
		System.out.println("pointValue:: " + test3.pointValue());
		System.out.println("Matches test1:: " + test3.matches(test));
		System.out.println("Matches test2:: " + test3.matches(test2));
		System.out.println("Card:: " + test3);
		System.out.println("\n");
	}
}
