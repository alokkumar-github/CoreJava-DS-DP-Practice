package operator;
/**
 * The incrementation or decrementation will be happened in java from left to right.
 * order of Operator Precedence as Follows.... 
 
 	[], (parameters), ex++, ex--
	++ex, --ex, +e, -e, ~, !
	new, (type)
	*, /, %
	+, -
	<<, >>, >>>
	<, >, <=, >=, instanceof
	==, !=
	&
	^
	|
	&&
	||
	?:
	=, +=, -=, *=, /=, %=, <<=, >>=, >>>=, &=, ^=, |=

 * Post increment:: first execute the statment then increase the value by one .
 * Pre increment :: first increase the value by one then execute the statement.
 * 
 * 
 * The ? Operator(Ternary Operator)
	expression1 ? expression2:expression3

	if expression1 is true expression 2 will be executed otherwise 
         expression3 will be executed
	ex: (x>y) ? {System.out.println(x)}:{System.out.println(y)};

 */
public class IncrementDecrement {

	public static void main(String[] args) {
		int i=6,j=8,k=7;
		i=j++ + ++i + + + + k -- -i;
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		System.out.println("Hello World!\t"+i +j+k);
		int a1=2;
		int b1=a1++; // a1 first assign to b1 then increment by 1
		System.out.println(a1+" "+b1+" "+a1++);
		int h=5,d = 5,l=5;
		int g=d + + + +h -- -l;
		System.out.println("hju::"+g);
		d=1;
		int p=d + + + + d;
		System.out.println(p);
		
		int u=2,v=3;
		
		int x= u++;
		int m=++v;
		
		System.out.println(x+" "+m+" "+u+" "+v);
		int d1=3;
		int p1=d1 - - - - d1;
		System.out.println("ggg::"+p1);
		int aa=4;
		int aa1 =aa - - --aa;
		System.out.println("aa1="+aa1);
		int d2=3;
		p1=d2---d2;
		System.out.println(p1);
		int hh=2;
		System.out.println("modd::"+hh%10);
		System.out.println("dive::"+hh/10);
		String s="sdfdjk";
		System.out.println(s.length());
		//System.out.println(s.charAt(s.length()));//java.lang.StringIndexOutOfBoundsException: String index out of range: 6
		System.out.println(s.charAt(s.length()-1));
		int a[]=new int[5]; System.out.println(a.length); 
		System.out.println(a[5-1]);
		//System.out.println(a[5]);// java.lang.ArrayIndexOutOfBoundsException: 5
	}

}
