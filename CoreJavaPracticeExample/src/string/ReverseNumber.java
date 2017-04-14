package string;

public class ReverseNumber {

	  public int reverseNumber(int number){
	        int reverse = 0;
	        while(number != 0){
	        	System.out.println(number%10);
	            reverse = (reverse*10)+(number%10);
	            number = number/10;
	        }
	        return reverse;
	    }
	     
	    public static void main(String a[]){
	    	ReverseNumber nr = new ReverseNumber();
	        System.out.println("Result: "+nr.reverseNumber(17868));
	    }
}
