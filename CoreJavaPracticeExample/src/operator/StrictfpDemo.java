package operator;

import java.util.Scanner;

/*
 * The strictfp keyword is used to force the precision of 
 * floating point calculations (float or double)
 *  in Java conform to IEEE’s 754 standard, explicitly.
 *   Without using strictfp keyword, 
 *   the floating point precision depends on target platform’s hardware,
 *    i.e. CPU’s floating point processing capability.
 *     In other words, using strictfp ensures result of floating point computations 
 *     is always same on all platforms.
The strictfp keyword can be applied for classes, interfaces and methods.
Rules
          strictfp cannot be applied for constructors.
         If an interface or class is declared with strictfp, then all methods and nested types within that interface or class are implicitly strictfp.
          strictfp cannot be applied for interface methods.
 */
public class StrictfpDemo {

	public static void main(String[] args) {
		System.out.println(new StrictFPClass().calculate());
		/*Scanner sc=new Scanner(System.in);  
			System.out.println("Enter your rollno");  
		   int rollno=sc.nextInt();  
		   System.out.println("Enter youargsr name");  
		   String name=sc.next();  
		   System.out.println("Enter your fee");  
		   double fee=sc.nextDouble();  
		   System.out.println("Rollno:"+rollno+" name:"+name+" fee:"+fee);  
		   sc.close();  */
		System.out.println(args.length-1);
		Integer intobj=Integer.valueOf(args[args.length-1]);
		int i=intobj.intValue();
		System.out.println(i);
		//int number = Integer.parseInt(args[0]);
       // assert number <= 10; // stops if number > 10
        System.out.println("Pass");
        System.out.println(new StrictFPClass().calculate());
	}

}
strictfp interface StrictFPInterface {
    double calculate();
    //strictfp double compute();    // compile error
}
strictfp class StrictFPClass {
    double num1 = 10e+102;
    double num2 = 6e+08;
    double calculate() {
        return num1 + num2;
    }
}