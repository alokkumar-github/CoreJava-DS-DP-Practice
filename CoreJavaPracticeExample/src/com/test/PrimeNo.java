package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeNo {
	int i=0;
	static int j=0;

	public static void main(String[] args) {
		PrimeNo p=new PrimeNo();//divisors other than 1 and itself
		j=9;
		p.i=8;
		System.out.println(p.i);
		System.out.println(p.j);
		PrimeNo p1 = new PrimeNo();
		System.out.println(j);
		System.out.println(p1.i);
		countNoOfOccurrenceOfString("abcdcabcdacbdadbca");
		
		//System.out.println(j%0);
		
//System.out.println(isPrimeNumber(27));
//System.out.println(isPalindrome("aabaa"));
		/*int[] numbers = { 1, 5, 23,5,23, 2, 1, 6, 3, 1, 8, 12, 3 };
		Arrays.sort(numbers);
		for(int i = 0; i < numbers.length; i++) {
		System.out.println(numbers[i]);
		}
		for(int i = 1; i < numbers.length; i++) {
		if(numbers[i] == numbers[i - 1]) {
			System.out.println(""+numbers[i]+" "+numbers[i-1]);
		System.out.println("Duplicate: " + numbers[i]);
		}
		}*/
		//System.out.println(changecase("KuMaR"));
		
		Map <Integer,String> m=new HashMap<Integer, String>();
		m.put(1, "h");
		
		
		
	}
	public static boolean isPrimeNumber(int n){
		System.out.println("Math.sqrt(n):::"+Math.sqrt(n));
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				return false;
			}
		}
		return true; //means number wasn't divisible by any of the number, it's a prime number.
		}
	public static boolean isPalindrome(String inputString){
		char ar[]=inputString.toCharArray();
		for(int i=0,j=ar.length-1;i<(ar.length/2); i++,j--){
		if(ar[i]!=ar[j])
		return false;
		}
		return true;
		}
	public static int findOnlyDuplicateNumberInList(List<Integer> list, int highestNumberInList){
		int sumOfNumbersList = 0;
		for(int n:list){
		sumOfNumbersList =sumOfNumbersList+n;
		}
		int onlyDuplicateNumberInList = sumOfNumbersList - ((highestNumberInList)*(highestNumberInList+1)/2);
		return onlyDuplicateNumberInList;
	}
	public static void countNoOfOccurrenceOfString(String str){
		 
	     String findStr = "b";
	     int lastIndex = 0;
	     int count = 0;
	 
	     while (lastIndex != -1) {
	 
	      lastIndex = str.indexOf(findStr, lastIndex);
	 
	      if (lastIndex != -1) {
	       count++;
	       lastIndex += findStr.length();
	 
	      }
	     }
	     System.out.println(count);
	}
	
}
