//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
	public static int go( List<Integer> ray )
	{
		if (ray.size() > 1) {
			for (int i = 0; i < ray.size(); i++) {
				if (ray.get(i) % 2 == 1) {
					for (int k = ray.size() - 1; k > i; k--) {
						if (ray.get(k) % 2 == 0) {
							return k - i;
						}
					}
					return -1;
				}
			}
				
		}
		return -1;
	}
}