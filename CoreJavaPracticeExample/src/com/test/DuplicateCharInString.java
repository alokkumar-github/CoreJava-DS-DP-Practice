package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharInString {
	 public static void findDuplicateChars(String str){
         
	        Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
	        char[] chrs = str.toCharArray();
	        for(Character ch:chrs){
	            if(dupMap.containsKey(ch)){
	                dupMap.put(ch, dupMap.get(ch)+1);
	            } else {
	                dupMap.put(ch, 1);
	            }
	        }
	        Set<Character> keys = dupMap.keySet();
	        for(Character ch:keys){
	            if(dupMap.get(ch) > 1){
	                System.out.println(ch+"--->"+dupMap.get(ch));
	            }
	        }
	    }
	     
	 public static void duplicate() {
		 String str = "w3schools";
		  int cnt = 0;
		  char[] inp = str.toCharArray();
		  System.out.println("Duplicate Characters are:");
		  for (int i = 0; i < str.length(); i++) {
		   for (int j = i + 1; j < str.length(); j++) {
		    if (inp[i] == inp[j]) {
		     System.out.println(inp[j]);
		     cnt++;
		     break;
		    }
		   }
		  }
		 }
	    public static void main(String a[]){
	        findDuplicateChars("12341");
	        duplicate();
	    }
}
