package operator;
/*
 * How to enable assertion
 * Go to Run->run configuration
select java application in left nav pan.
right click and select New.
select Arguments tab
Add -ea in VM arguments.

There are two ways to use assertion. First way is:
assert expression;  
assert expression1 : expression2;  
 */
import java.util.Scanner;

public class AssertionsDemo {
	Integer value = new Integer (9); //invariant
	//constructor
	public AssertionsDemo(Integer i) {
	//constructor logic goes here
	assert isNegative();
	assert isNegative() : "af";
	}
	// rest of the public and non-public methods goes here. public methods should call
	// assert isNegative(); prior to its return
	// convenient internal method for checking invariants.
	// Returns true if the integer value is negative
	private static boolean isNegative(){
	return false;//value.intValue() < 0 ;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );  
		  System.out.print("Enter ur age ");  
		    
		  int value = scanner.nextInt();  
		  assert value>=18:" Not valid";  
		  
		  System.out.println("value is "+value); 
			

	}

}
