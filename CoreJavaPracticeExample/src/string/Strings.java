package string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * String class is immutable & final 
 * & can’t be instantiated but the reference to the String is mutable
 *
 */
public class Strings {
	public static void main(String[] args) 
	{
		String str1 = new String("sunil");
		String str2 = new String("sunil");

		HashMap hm = new HashMap();
		hm.put(str1,"hello");
		hm.put(str2,"bye");
		System.out.println(hm);
		
		StringBuilder sb1 = new StringBuilder("sunil");
		StringBuilder sb2 = new StringBuilder("sunil");
		System.out.println(sb1.equals(sb2));
		System.out.println(sb1.toString().equals(sb2.toString()));//use this approach to compare

		System.out.println(sb1.hashCode()+":"+sb2.hashCode());//return different value
		
		HashMap hm1 = new HashMap();
		hm1.put(sb1,"hello");//sb1 and sb2 will return different HashCode 
		hm1.put(sb2,"bye");// StringBuffer/StringBuilder does not override hashCode/equals methods
		System.out.println(hm1);
		
		String r1 = "Rakesh";
		String r2 = "Rakesh";
		String r3 = "Rakesh".intern();
		if ( r1 == r2 ){
		    System.out.println("r1 and r2 are same");  // 1.
		}

		if ( r1 == r3 ){
		    System.out.println("r1 and r3 are same" );  // 2.
		}
		
		
		if("String".trim()=="String".trim())
			System.out.println("Equal");
		else
			System.out.println("Not Equal");

		if(" String".trim()=="String".trim())
			System.out.println("Equal");
		else
			System.out.println("Not Equal");

		if("STRING".toUpperCase()=="STRING".toUpperCase())
			System.out.println("Equal");
		else
			System.out.println("Not Equal");

		if("String".replace('t','t')=="String")
			System.out.println("Equal");
		else
			System.out.println("Not Equal");

		if("String".substring(0,6)=="String".trim())
			System.out.println("Equal");
		else
			System.out.println("Not Equal");

		if("String".substring(0)=="String")
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		
		// String ss=new String(null);//U can’t pass null to String constructor because 
		//String has two constructors that can hold null i.e; Character array & byte array
		
		//U can construct a String with any char & byte of arrays
		
		String s31=new String(new byte[]{1,3,77});
		System.out.println(s31);
		//If startIndex > count/endinedx it gives StringIndexOutofBoundsException at runtime.
		// and count is out of range then also same exception
		//String substring(int startindex,int count/endIndex);
		String s41="RamLakshman".substring(11,11);// RamLakshaman
											    //1234567891011 --count/length
												//012345678910	-- index
		System.out.println(s41);
		//In StringBuffer Class equals() method will return true if == true 
		
		String s1="alok";
		String s2="alok";
		String s3=new String("alok");
		String s4=new String("alok");
		String s5=new String("asf");
		System.out.println(s1==s2);// if the address of two String object are same
		System.out.println(s3==s4);
		System.out.println(s4.equals(s3));// Ture if the contents of the object are same and these
		System.out.println(s1.equals(s2));	// object are related to same class EvenTHough the address are different.
		
		// + operator work as a concatination operator if atleast one operand supplied to + operator
		// is String object.
		// Addition + left to right, if any String is found out from then String concatination start.
		
		System.out.println(1+2+"3"+6+4);
		System.out.println(3+"jk"+5*2);// * operator precedence over + operator
		go(0, "Hi");
		go(1, "Hi","Hello","bye");
	
	}
	/*While using the varargs, you must follow some rules otherwise program code won't compile. The rules are as follows:

There can be only one variable argument in the method. void method(String... a, int... b){}//Compile time error
Variable argument (varargs) must be the last argument. void method(int... a, String b){}//Compile time error 
	 */
	public static void go(int x, String... y){ //NOTE::: if go(String... y,int x)
		System.out.println(y[y.length-1]+" ");
	}
}
