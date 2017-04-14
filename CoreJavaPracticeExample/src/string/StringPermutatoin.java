package string;

import java.util.HashSet;
import java.util.Set;

public class StringPermutatoin {

	public static void main(String[] args) {
		
		String str="MAN";
		char[]c=str.toCharArray();
		int initialIndex=0;
		int lastIndex=str.length()-1;
		System.out.println(crunchifyPermutation(str));
		//strPermutation(c, initialIndex, lastIndex);
	}

	public static Set<String> crunchifyPermutation(String str) {
		Set<String> crunchifyResult = new HashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			crunchifyResult.add("");
			return crunchifyResult;
		}
 
		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		System.out.println("rem\t"+rem);
		Set<String> words = crunchifyPermutation(rem);
		System.out.println("words\t"+words);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				crunchifyResult.add(crunchifyCharAdd(newString, firstChar, i));
			}
		}
		System.out.println("retrun crunchifyResult\t"+crunchifyResult);
		return crunchifyResult;
	}
 
	public static String crunchifyCharAdd(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		String temp=first + c + last;
		System.out.println(temp);
		return temp;
	}
}
