//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class TotalRowRunner
{
	public static void main( String args[] ) throws Exception
	{
		int[][] list = {{1,2,3},{5,5,5,5}};
		TotalRow test = new TotalRow();
		System.out.println(test.getRowTotals(list));	
		
		int[][] list2 = {{1,2,3},{5},{1},{2,2}};
		TotalRow test2 = new TotalRow();
		System.out.println(test2.getRowTotals(list2));
		
		int[][] list3 = {{1,2},{5,5},{5,5},{4,5,6,7},{123124,12312}};
		TotalRow test3 = new TotalRow();
		System.out.println(test.getRowTotals(list3));
	}
}



