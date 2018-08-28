package operator;
/*
 * 1. final should not be given to Abstract and interface as it is implemented by other.
 * 2. Syncronize and abstract should not be given once.
 * 3. Native and abstract shoild not be given once as native method already has some defalut implementation.
 * 
 * Asicci
 * A to Z : 65 to 90
 * a to z : 97 to 122
 * 0 to 9 : 48 to 56
 * 
 * Data Type in java..
 * 1. Integer -- . byte ( 8 bits or  1 byte), short (2 byte) , *int (4 byte) , long(8 bytes)
 * 2. Real Number -- ( float ( 4 bytes) , *double (8 byte)
 * 3. character -- char(2 byte) .. use unicode to represent
 * 4. boolean -- 1 bit
 * by defalut .. value .. 0,0.0, ,false
 * 
 * Access Specifier : public , private , protected , defalut
 * Access Modifier : public , abstract(M,C) ,final(variable, method ,class) , static (V,M,object of class),
 * 					 volatile(V), sysncronized, transient(V only class level variable ,  local variable cann't be transient,ooC ) ,native
 * 
 * Identifier : ie variable 
 * Literal : value assing to a variable.
 * Method has no body :- abstract , interface , native
 * variable is transient or static . Object's trainsent variable is not serialized.
 * static final to transient no compiler error
 * static method can not be abstract.
 * 
 * volatile applied only to variable, can be applied to static , not on final,
 *  trainsient and volatile can not be togetheer
 *  
 *  it ask jvm to merge threads private copy of variable to master copy in memory in multi thread environment.
 *  
 *  class : public , Abstract , final
 *  Inner class : public , protected , private , final , static
 *  Annonymous : public , protected , privte , static
 *  Variable : publiv , protected, private, final, abstract, static , native, 
 *  method: public , protected, private, final, static abstract, native , synchronized
 *  contructor : public, protected private
 *  code block : non-static , static , sysnchornized
 *  
 */
		
public class JavaKeyWords {
	int ii;
	JavaKeyWords(){
		/*
		 * use of this :: 1 to point current object from non- static block
		 * 2. To point a construct of a class from contructor of same class.
		 */
		this(9);
	}
	JavaKeyWords(int i){
		this.ii=i;
	}
	public static void main(String[] args) {
		byte b;
		int i=513; // 259
		double d= 324;
		double d1=i;
		float f=9;
		
		/*float f1=d1; int ii=d; int ik=f; erorr
		 * need to explicit typecast since higher value is assign to lower location.
		 */
		
		
		//System.out.println(b); // error initialize local variable. jvm initialize to defalut value to non static variable not to local variable.
		System.out.println(b=(byte)i); // here int value is larger then range of byte.
										// it will reduce to modules . ex. 258%256 = 2
		//System.out.println(i%256);
		System.out.println(i=(int)d); // when floating value assigned to an integer value ; trancation of decimal part.
		System.out.println(d1);
		System.out.println(f);
		

	}

}

class StaticDemo{
	int i;
	static int j;
	void fun2(){
		fun1();// 
		AAA.i=90;
	}
	static void fun1(){
		System.out.println(j);
		
		StaticDemo sd=new StaticDemo();
		System.out.println(sd.i); // in order to refer non static element . we have to create object
	}
	public static void main(String str[]){
		fun1();
		StaticDemo s1= null;
		StaticDemo s= new StaticDemo();
		System.out.println(s1.j);
		s1.fun1();
		s.fun2();
		System.out.println(AAA.i);// when we create context of class from function 
		// then when control come out from function get deleted from RAM. but context still 
		// still preserved
		s1.fun2();// runtime error java.lang.NullPointerException
		
	}
}
class AAA{
	static int i=9;
}