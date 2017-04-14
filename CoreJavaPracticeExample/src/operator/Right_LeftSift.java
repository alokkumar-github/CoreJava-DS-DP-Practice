package operator;

/**
 * 
 * Bitwise Operators
 *--------------------

     & --> bitwise and 
      | --> bitwise or
     ~ --> bitwise Not
     ^  			--> logical xor
    &=            	--> bitwise And  and assignment
    >> 			--> right shift means cut that many digits existing at right in         
              binary.
    << 			--> left shift means add that many digits existing at left in binary.

      x XOR y = (x ^ y) U (x' ^  y)
      x XNOR y = (xUy')^(x'Uy)

BitwiseOperations are applied to Integral types Only{byte,short,int,long,char}

sign fill Operators menas RightShift
Zero fill means Unsigned RightShift

 *
 *Binary -Negative integer for  -42
 
          +42 =>1 0 1 0 1 0
          Change it into 8 bytes  0 0 1 0 1 0 1 0
           Take Complement       1 1 0 1 0 1 0 1
           Add  '1'  to it               1 1 0 1 0 1 1 0   => is Binary form of -42
           
  *1) if a=64 (i.e int a=64)
	byte b= (byte)(a<<2) 	means  add that many digit from left 
          b=(byte)(1000000<<(2%32))=(byte)(100000000)
	therefore, b=256.

	Shortcut : a<<b  --> a*2^b

	ii)	if a=64 (i.e int a=64)
		byte b= (byte)(a>>2) means    cut that many digit from right or add that many from right
	          b=(byte)(1000000>>2)=(byte)(0010000)
		b=16.
	
		Shortcut : a>>b  --> Math.floor( a/2^b )
		
	* Unsigned Right Shift (>>>)

             -42 >>> 23
		   -42>>>23 %32



* In Unsigned RightShift if u give  a positive integer it will work as 
  An ordinary rightshift
  
  



 */
public class Right_LeftSift {
	public static void main(String[] args) {
		double d=42.789;
		System.out.println(d%10);//O/P:	2.789
		System.out.println(d%2);
		

		double d1=42.789;
		System.out.println(d1/10);//	O/P:	4.2789
		System.out.println(d1/2);

		System.out.println(12>>3);
		System.out.println(Math.floor(12/8));
		
		int d2=789;
		System.out.println(d2/10);//	O/P:	78
		System.out.println(d2%10);
		
		System.out.println('c'&'f');
		System.out.println(60&13); // 00111100 & 00001101 = 00001100 ie 12
		System.out.println(60^13);//  00111100 ^ 00001101   =    00110001\\\
		
		/*
		 * |,or 
		 * 
		 */
				
		/*
		 * If there is a division by zero statement then  
		 * it will check whether the result is double, 
		 * if so it will give "infinity" as outoput 
		 * otherwise it will raise  an ArithmeticException.
		 * 
		 * While operating division -0.0 is different from 0.0 but -0 is same as 0 
			In modulo (remainder) operation 
			it will not bother about the sign of denominator
			 but it will work according to the data type of denominator .

		 */
		System.out.println(10.0/-0);
		System.out.println(10.0/-0.0);
		System.out.println(10.0%0);
		System.out.println(10.0%-0.0);
		/*
		 * Double.NaN ==Double.NaN gives false because NaN may be any non numbers like Float.NaN but while comparing Wraper classObject containg these values on comparison (.equals) will give true.
		* Any Operation on NaN gives NaN only
		* 
		* All prmitive number types in java are signed
		 */
		System.out.println(Double.NaN==Double.NaN);
		System.out.println(Float.NaN==Float.NaN);
		Double d11=Double.NaN;
		System.out.println(d11.equals(Double.NaN));
		
		
		System.out.println(12^12);
	}

}
