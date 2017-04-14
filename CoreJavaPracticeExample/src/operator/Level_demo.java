package operator;
/*
Label is not a key word .it is an ordinary variable 
which must be preceeded before a statement or method or  block.

U can give more than one labels for a single statement

<label> should not be given before a declarative statement.

label name can be duplicated without overlapping.

If u are using a Continue statement with Label, that label should be placed  before loops.

 */
public class Level_demo {

	public static void main(String[] args) {
		b1: System.out.println("hai");
	 	//c: int i=10;    //is Invalid
			int i=0;
	 	a: d: i=10;//is Valid

	 	/*
	 	 * If we specify any number it will treated as an int 
	 	 * but if we specify any . at the end it will be treated as double
	 	 */
	 	float f=(float)999999999999999999999999999999999999.;
		System.out.println("Hello World!"+f);
		
		boolean b2=true;
		float f1=7.0f;
		double d=8;
		//System.out.println(b+f+d);   //is invalid
		System.out.println(""+b2+f1+d); //is valid
		int a,b,c;
		a=b=c=20;
		/*
		 * In adding from left to right if any of the variables is String from that 
  next  will be converted to string.

		 */
		System.out.println(a+b+c); //-->60
		System.out.println(""+a+b+c);// -->202020
		System.out.println(1+2+"3");//-->33
		System.out.println("1"+2+3);// -->123
		System.out.println(4+1.08);// -->5.08
		System.out.println('a'+1);// -->98
		
		/*
		 * To store values one should follow the sequence

			byte ---> short ---> int  ---> long ---> float ---> double
			        char         ---> int  ---> long ---> float ---> double
			
			To place higher data type in to lower data type we should typecast it. 
			but to place lower data type into higher data type no need to type cast.
			
			If we want to store a higher datatype values into lower data type 
			values with out typecasting that should be final and also that shold
			 be in the range of the lower data types.
			
			Note: It is not appliacble to Float & Double data types.

		 */

		/*
		 * It is a compile-time error if the character following a backslash 
		 * in an escape is not an ASCII b, t, n, f, r, ", ', \\, 0, 1, 2, 3, 4, 5, 6, or 7
		 */
		 int aa = '\'';
	      int cc = '\"';
	       int dd = '\f';
	       //ee = '\z';
	       System.out.println(aa);
	       
	       /*
	        * Literal is a constant.
	        * The 16 bit coding scheme employed in Java programming is Unicode 
				Unicode literals are denoted as  where X is a hexadecimal value.  
	        */
	       System.out.println(\u000A);
	}

}
