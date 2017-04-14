package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		/*
		 * String st="jlkjaslkfgjas: kjkdgf : dgjd "; String
		 * st1="jlkjaslkfgjas: kjkdgf : dgjd klklkl "; String st2="klklkl ";
		 * if(st1.contains(st)){ System.out.println("yes");
		 * st1=st1.replaceAll(st, ""); System.out.println(st1); }else{
		 * System.out.println("no"); }
		 */
		/*
		 * int[] array = {1,2}; MyImmutable myImmutableRef = new
		 * MyImmutable(array) ; System.out.println("Before constructing " +
		 * myImmutableRef); array[1] = 5; // change (i.e. mutate) the element
		 * System.out.println("After constructing " + myImmutableRef);
		 */
		DeepCloneTest dc = new DeepCloneTest("First");
		//System.out.println(dc);
		labelTest(8);
		// java 8 lombda 
		//syntex  (argtype arg...) -> { return some expression.. probably using these arguments }

		List names = Arrays.asList("1", "2", "3");
		Stream lengths = names.stream().map(name -> ((String) name).length());
		
		/*for(String s:lengths){
			System.out.println(lengths);
		}*/

	}

	public static void labelTest(int y) {
		outer:
			for (int i = 0; i < 10; i++) {
			while (y > 7) {
				System.out.println("Hello");
				break outer;
			} // end of inner for loop
			System.out.println("Outer loop."); // Won't print
		}// end of outer for loop
	System.out.println("Good-Bye");
	}
}

final class MyImmutable {
	private final int[] myArray;

	public MyImmutable(int[] anArray) {
		// this.myArray = anArray; // wrong
		this.myArray = anArray.clone(); // Defensive copy ; Right way to write
										// an accessor by cloning.
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("Numbers are: ");
		for (int i = 0; i < myArray.length; i++) {
			sb.append(myArray[i] + " ");
		}
		return sb.toString();
	}
}

class DeepCloneTest implements Cloneable {

	private String i;

	public String toString() {
		return this.i;
	}

	public DeepCloneTest(String i) {
		this.i = i;
	}
}

class HashSetCustom {

}