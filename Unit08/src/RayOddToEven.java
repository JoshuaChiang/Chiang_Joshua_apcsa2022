//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	public static int go(int[] ray)
	{
		int odd = 0;
		int even = 0;
		
		for(int i = 0; i<ray.length; i++) {
			if(ray[i]%2 != 0) {
				odd = i;
				for(int j = i; j<ray.length;j++) {
					if(ray[j]%2 == 0) {
						even = j;
						return even - odd;
					}
				}
			}
		}
		return -1;
	}
}