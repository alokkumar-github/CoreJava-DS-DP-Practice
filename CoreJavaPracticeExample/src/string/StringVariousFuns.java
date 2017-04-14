package string;
/*
 * A string is group of character . use String class to represent these group of charcter.
 * 
 * immutable and final
 * 1. String constant Pool / intern
 * 2. why String is immutable .
 * 	-- use with string pool cache.//Because java uses the concept of string literal.
 * 									Suppose there are 5 reference variables,
 * 									all referes to one object "sachin".
								  If one reference variable changes the value of the object, 
								  it will be affected to all the reference variables.
								   That is why string objects are immutable in java.
 * -- thred safe
 * -- cache hashcode
 * 3. 
 */
		
public class StringVariousFuns {

	static final String SUCCESS="success";
	public static void main(String[] args) {
		//String Pool / intern;
		
		// why string is immutable.
		
		String s1="hello";
		System.out.println(s1.substring(s1.length())); //this will not throw StringIndexOutOfBoundsException exception.
		//System.out.println(s1.substring(33));// this will
		
		String s2=new String("hello").intern();
		//System.out.println(s1==s2); // on removing intern will get false.
		System.out.println(s1==s2);// true
		
		System.out.println();
		
		// till 1.6 substring proven to be memeory leak ( ex. s3 will refer to s1 char arrary. and it w'nt be gabeage collected). from 1.7 on it's fixed.
		
		String s3=s1.substring(2,s1.length());
		System.out.println(s3+" lenthis "+s1.length());
		
		//Once string object is created its data or state can't be changed
		//but a new string object is created.
			String s="Sachin";  
			String s5="Sachin";
		   s=s.concat(" Tendulkar");  
		   System.out.println(s+" "+s5);  
		
		// Best practice to..
		
		String s4=someOperation();
		//if(s4.equals(SUCCESS)){ // here you will get NullPointerException . // similary for this also if (mayBeNullObj != null) { // to avoid NullPointerException
		if(SUCCESS.equals(s4)){ // this is the best practice.
			System.out.println("operation Success");
		}else{
			System.out.println("Operation failed");
		}
		// not to store password in String .. use char[] or other 
			
		// avoid using + to concat to string ; use stringbuilder instead
		String s6="Sachin"+" Tendulkar";  
		   System.out.println(s6);//Sachin Tendulkar  
		   // The Java compiler transforms above code to this:
		   //String s6=(new StringBuilder()).append("Sachin").append(" Tendulkar).toString();  
	}
	private static String someOperation() {
		return null;
	}

}
