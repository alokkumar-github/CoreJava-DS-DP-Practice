package com.test;

public class StringHasUniqueChar {

	public static void main(String[] args) {
		System.out.println(method4("inpt"));
	}

	public static boolean method4(String input) {
		boolean result = false;
		for (char ch : input.toCharArray()) {
			System.out.println("input.indexOf(ch): "+input.indexOf(ch));
			System.out.println("input.lastIndexOf(ch): "+input.lastIndexOf(ch));
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
