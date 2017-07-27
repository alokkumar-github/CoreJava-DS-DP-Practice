package Core;

import java.util.*;

public class PermutationExample {
 
	public static void main(String[] args) {
		String s = "1234";
		System.out.println("String : " + s);
		System.out.println("Permutations: " + permutation(s));
	}
 
	public static Set<String> permutation(String str) {
		Set<String> result = new HashSet<String>();
	
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			result.add("");
			return result;
		}
 
		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = permutation(rem);
		
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				result.add(charAdd(newString, firstChar, i));
			}
		}
		return result;
	}
 
	public static String charAdd(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}
 
}
/*
 * Permutations are for lists (order matters) and combinations are for groups (order doesn’t matter).
 * C(n,k) =n!/k!(n-k) where k<=n 
 * P(n,k)=n!/(n-k)! where k<=n
 */
/**
Here is a quick simple Algorithm which computes all Permutations of a String Object in Java.

First take out the first char from String and permute the remaining chars
If String = "123"
First char = 1 and remaining chars permutations are 23 and 32.
Now we can insert first char in the available positions in the permutations.
23 -> 123, 213, 231
32 -> 132, 312, 321
*/