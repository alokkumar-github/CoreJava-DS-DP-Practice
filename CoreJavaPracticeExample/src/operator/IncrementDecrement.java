package operator;
/**
 * The incrementation or decrementation will be happened in java from left to right.
 * order of Operator Precedence as Follows.... highest precedence appear at the top
 * 
 * Operator precedence determines the grouping of terms in an expression. 
 * This affects how an expression is evaluated. Certain operators have higher precedence than others; 
 * for example, the multiplication operator has higher precedence than the addition operator −
	For example, x = 7 + 3 * 2; here x is assigned 13, not 20 because operator * has higher precedence than +,
	 so it first gets multiplied with 3 * 2 and then adds into 7.
 * 
 * For operators, associativity means that when the same operator appears in a row, then which operator occurence we apply first. In the following, let Q be the operator
 * a Q b Q c
If Q is left associative, then it evaluates as

(a Q b) Q c

 * We know *,/ and % have same precedence, but according to associativity answer may change.
		For eg: I have exp: 4*8/2%5 so Left associative: (4*8)/2%5 ==> (32/2)%5 ==>16%5 ==>1
	It's important, since it changes the meaning of an expression. 
	Consider the division operator with integer arithmetic, which is left associative
	4 / 2 / 3    <=>    (4 / 2) / 3    <=> 2 / 3     = 0
	
	If it were right associative, it would evaluate to an undefined expression, since you would divide by zero
	4 / 2 / 3    <=>    4 / (2 / 3)    <=> 4 / 0     = undefined
 * 
 * 
 Category											Associativity 
 													
 	[], (parameters), ex++, ex-- postfix(Post-Increment)			Left toright
	prefix Pre-Increment ++ex, --ex, +e, -e, ~, !					Right to left
	new, (type)										Left toright
	*, /, %											Left toright
	+, -											Left toright
	<<, >>, >>>										Left toright
	<, >, <=, >=, instanceof						Left toright
	==, !=											Left toright
	&												Left toright
	^												Left toright
	|												Left toright
	&&												Left toright
	||												Left toright
	?:												Right to left
	=, +=, -=, *=, /=, %=, <<=, >>=, >>>=, &=, ^=, |=	Right to left
	
 
 left shift a<<b = a*2 tothepower b  = a*Math.pow(2,b)
 a>>b Math.Floor(a/2 tothe power b)
  
  The ? Operator(Ternary Operator)
	expression1 ? expression2:expression3

	if expression1 is true expression 2 will be executed otherwise 
         expression3 will be executed
	ex: (x>y) ? {System.out.println(x)}:{System.out.println(y)};
	
	https://stackoverflow.com/questions/2371118/how-do-the-post-increment-i-and-pre-increment-i-operators-work-in-java

	In both cases it first calculates value, but in post-increment it holds old value and after calculating returns it
	Post increment:: first execute the statment then increase the value by one .
 Pre increment :: first increase the value by one then execute the statement.
 
	++a
	
	a = a + 1;
	return a;
	
	a++
	
	temp = a;
	a = a + 1;
	return temp;
	
	ex::::::::
	z = ++x * y++
	evaluated  as:::::::::::::
	the following sequence of operations is allowed:
	
	t0 = y
	t1 = x + 1
	z = t1 * t0
	y = y + 1
	x = x + 1
	
	Interesting facts about Increment and Decrement operators
	1. an be applied to variables only .not in constant
	2. Nesting of both ++ and — operators is not allowed ex. int a = 10;   int b = ++(++a);  System.out.println(b);

 */
public class IncrementDecrement {

	public static void main(String[] args) {
		
		int x1=10;
		int y= x1++ + --x1 - x1++ + x1-- + ++x1 - --x1 + x1++ + ++x1;
		System.out.println("y:: "+y+" x1:: "+x1);
		
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
