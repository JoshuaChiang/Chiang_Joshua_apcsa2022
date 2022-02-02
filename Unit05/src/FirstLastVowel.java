//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
   public String go( String a )
	{
	   char ch = a.charAt(0);
	   char ch2 = a.charAt(a.length()-1);
	   if("aeiouAEIOU".indexOf(ch) != -1 || "aeiouAEIOU".indexOf(ch2) != -1) {
		   return "yes";
	   }
	   return "no";
	}
}