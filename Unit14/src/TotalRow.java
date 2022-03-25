//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;

public class TotalRow
{
    public static List<Integer> getRowTotals( int[][] m )
    {
    	ArrayList<Integer> nums = new ArrayList<Integer>(); 
    	int sum = 0;
    	for(int i = 0; i < m.length; i++) {    		
    		for(int j = 0; j < m[i].length; j++) {
    			sum = sum + m[i][j];    		
    		}
    		nums.add(sum);
    		sum = 0;
    	}
		return nums;
    }
}
