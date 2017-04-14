package com.test;

public class StringLowerToUpperAndViceVersa {

	public static void main(String[] args) {
		System.out.println(changecase("KuMaR"));

	}
	static String changecase(String inputString) {
		char ar[]=inputString.toCharArray();
		for (int i = 0; i < ar.length; i++) {
		if (ar[i]>=65 && ar[i] <=90) { //convert upperCase to lowerCase
		ar[i] += 32;
		} else if(ar[i]>=97 && ar[i] <=122){ //convert lowerCase to upperCase.
		ar[i] -=32;
		}
		}
		return new String(ar);
		}
}
