package overload_override;

public class InheritenceAndTypeCast {

	public static void main(String[] args) {
		
		int i=Integer.parseInt(args[0].trim());
		A a1=new A();
		/*
		 * //superClass refrence - subClass object.
				// if superclass refrence=subclass object and calling function of 
				 * superclass it will first check the sub-most class's fuction override,
				 *  if not found then immediate subclass and so on.
				// here we are acheiving dynamic polymorphism(we can acheive using inhertence)
				 *  since execution of function is decided on run time.
									
		 */
		if(i>10 && i<20){
			a1=new B();
			
		}
		if(i>20){
			a1=new C();
			a1.functionA(i); //o/p: inside class B
			
			/*
			 * / only funtion can be overriden not the variable .
					//so i of class A is = 70; not class C
			 */
			a1.i=70; 
		}
		
		/*
		 * since Class C extends Class A , 
		 * Object of class A will be created in association with Object of Class C.
		 * Even though we use A a2=new C(); , the Object of class A will be assign to 
		 * reference a2. 
		 */
		A a2=new C(); // so we can access funtion of class A. 
					// for overrided method class C will be in invoked
		A a4=new D();
		a4.functionA(0);
		// you cann't access sub class member.
		// if you want .... need to type cast : reference of super class into its equivalent 
		// reference of sub class. ex: D d1=(D)a4;
		D d1=(D)a4;
		d1.funD();
		
		A a5=(A)d1;
		
		//D d2=(D) new A(); // exception throw ::: java.lang.ClassCastException:
		
		A a3=new A();
		//a3.functionA(0); // o/p : fun1 of class A
		
		if(a4 instanceof A){ // instanceof : To check whether an object is of a particular type
							// variable on the left side of the operator passes the IS-A test for the class or interface type on the right 	side
			D d3=(D)a4;
			d3.funD();
		}
		
		// Type cast ::  refrence of interface to refrence of class
		F ff=new G();
		ff.ff();
		
		// Type Cast :: refrerence of interfface to reference of interface.
		
		E e=(E)ff; // e can access his own member only.
		e.e();
		
		G gg=(G)ff;
		gg.gg();
		
		X x=new C();
		x.funx();//
		System.out.println(X.j);
	}

}
interface X{
	// by default static final.
	public static final int j = 10;
	void funx();
}
abstract interface XX{
	void funx();
	String n= "aaa";
}
class A implements X,XX{
	int i;
	void functionA(int i){
		System.out.println("inside class A");
	}
	void fun1(){
		System.out.println("fun1 of class A");
	}
	public void funx(){
		System.out.println("funx impleememt");
	}
}
class B extends A{
	int i;
	void functionA(int i){
		System.out.println("inside class B");
	}
	void funB(){
		System.out.println("funB of class B");
	}
}
class C extends B{
	int i;
	void funtionA(int i){
		System.out.println("inside class C");
	}
	public void funC(){
		System.out.println("inside funC of class C");
	}
}
class D extends C{
	int i;
	void funtionA(int i){
		System.out.println("inside class D");
	}
	public void funD(){
		System.out.println("inside funD of class D");
	}
}

interface E1{}
interface E{
	public void e();
}
interface F extends E,E1{
	public void ff();
}
class G implements F{

	@Override
	public void ff() {
		System.out.println("implemented funtion ff");
		
	}
	public void gg(){
		System.out.println("funtion of gg of Class G");
	}
	@Override
	public void e() {
		
	}
}
class F1 implements E,E1,F{

	@Override
	public void ff() {
		// TODO Auto-generated method stub
		System.out.println("inside F1 class - ff()");
	}

	@Override
	public void e() {
		// TODO Auto-generated method stub
		
	}
	public final void e1() {
		System.out.println("inside F1 class - final  e1()");
	}
	
}


class Run extends AdsClass{
	//Run() throws Exception {} // contructor can also declared using thorws clause
	int y;
	public static void main(String[] args) {
		E a = new F1();
		 AdsClass a1 = new Run(); 
		 a1.f1();
		 new Run().f222();
		 new Run().e1();// we can invoke final method from inherited subclass. but not override
		 new Run().f222(1,false);
	}
	@Override
	protected void f22() throws Exception {
		// TODO Auto-generated method stub
		
	}
	public void ff() throws RuntimeException {//this is override; can throws any unchecked exception, irrespective of super class overriden method 
		System.out.println("inside Run Class override - ff()");
	}
	protected void f222(){
		System.out.println("inside Run Class - f222()");
		ff();// or this.ff();
		super.ff();
	}
	protected void f222(int i,boolean b){ // order of parametres matter
		System.out.println("inside Run Class - f222(int i,boolean b)");
	}
}

//abstract class extends only one class(that would be either Concrete or abstract class
// abstract class can have main method ( the entry point to JVM to begin execution)
abstract class AdsClass extends F1 {
	public static void main(String[] args) {
		E a = new F1();
		// AdsClass a1 = new F1(); // need to typecast
		
	}
	// we can define final for concrete method of abstract class
	public final void f1() {
		System.out.println("inside final - f1()");
	}
	 void f222(int i,boolean b){
		System.out.println("inside AdsClass - f222(int i,boolean b)");
	}
	static int i; int j; final int y=9;
	
	protected abstract void f22() throws Exception;// modifier like final , static ,private not allowed to abstract method or class - result compilaton error
	AdsClass(){}
	private AdsClass(int i){} // can declare default , parameterize constructor. private modifier also
	// static field , concrete  methods allowed.overloading , overriding also
	// abstract class can be defined either only abstract method(s) or concrete method(s)
}

/*
 * 
 * we can classify typecasting into 4 categories.
 * 1. primited data type to primitive data type.
 * 2. refreence of super class - refrenece of sub class
 * 3. refreence of interface - reference of sub class
 * 4. reference of interface - reference of interface
 */
/*
 * same name local variable hide instance variable . to overcome use this.
 * instance variable with same name in subclass hide super class instance variable with same name . to overcome use super
 **/
