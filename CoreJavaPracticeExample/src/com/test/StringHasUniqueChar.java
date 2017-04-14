package com.test;

public class StringHasUniqueChar {

	public static void main(String[] args) {
		System.out.println(method4("inpiut"));
	}

	public static boolean method4(String input) {
		boolean result = false;
		for (char ch : input.toCharArray()) {
			if (input.indexOf(ch) == input.lastIndexOf(ch)) {
				result = true;
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

}
