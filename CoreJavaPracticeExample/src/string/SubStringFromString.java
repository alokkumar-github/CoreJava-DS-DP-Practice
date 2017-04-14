package string;

import java.util.Scanner;

public class SubStringFromString {

	public static void main(String[] args) {
		//System.out.println(find("i am alok kumar","k"));
		 System.out.println("i am alok kumar".contains("alok"));
		 String string, sub;
	      int i, c, length;
	 
	      Scanner in = new Scanner(System.in);
	      System.out.println("Enter a string to print it's all substrings");
	      string  = in.nextLine();
	 
	      length = string.length();   
	 
	      System.out.println("Substrings of \""+string+"\" are :-");
	 
	      for( c = 0 ; c < length ; c++ )
	      {
	         for( i = 1 ; i <= length - c ; i++ )
	         {
	            sub = string.substring(c, c+i);
	            //System.out.println(sub);
	            if(sub.equalsIgnoreCase("alok")){
	            	System.out.println("ksdjgflkadgjl");
	            }
	         }
	      }
	   }
	
	public static void find(String inst ,String oust){
		System.out.println(inst.indexOf(oust));
		//return inst.indexOf(oust)>-1;
		 inst.compareTo(oust);
		 System.out.println(inst.contains(oust));
	}

}
