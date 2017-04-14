package overload_override;
/*
 * use to check whether an ojbect can be castd into specific type without throwing classCastException
 * 
 * Downcasting with java instanceof operator
 * --------------------------------------------
 * When Subclass type refers to the object of Parent class, 
 * it is known as downcasting. If we perform it directly, 
 * compiler gives Compilation error.
 *  If you perform it by typecasting, ClassCastException is
 *   thrown at runtime. But if we use instanceof operator, downcasting is possible.
 *   
 *   no explicit cast needed for upcasting. but downcasting it require
 */
public class InstanceOfDemo extends Animal1{
	static void method(Animal1 a) {  
	    if(a instanceof InstanceOfDemo){  
	    	InstanceOfDemo d=(InstanceOfDemo)a;// downcasting an A reference
	    										// to  InstanceOfDemo reference 
	       System.out.println("ok downcasting performed");  
	       //d.method(a); //Recursive: Exception in thread "main" java.lang.StackOverflowError
	    }  
	  }  
	public static void main(String[] args) {
		InstanceOfDemo d=null;  
		  System.out.println(d instanceof InstanceOfDemo);//false  
		  InstanceOfDemo d1=new InstanceOfDemo();  
		  System.out.println(d1 instanceof InstanceOfDemo);//true 
		  System.out.println(d1 instanceof Animal1);//true 
		  
		  Animal1 d3=new InstanceOfDemo(); 
		  //InstanceOfDemo d2= new Animal1();//Compilation error  
			 // InstanceOfDemo d2=(InstanceOfDemo) new Animal1();//If we perform downcasting by 
			  					//typecasting, ClassCastException is thrown at runtime.
		  method(d3);
		  System.out.println(d3 instanceof Animal1);//true 
		  System.out.println(d3 instanceof InstanceOfDemo);//true 
		  
		  Animal1 aa=new Animal1();
		  System.out.println(aa instanceof InstanceOfDemo);//false
		  System.out.println(aa instanceof Animal1);//true
		  
		 
		  
		  
	}

}
 class Animal1{} // Note: only public, abstract & final are permitted to a class ; 
 					// no: static , private , protected to a class

abstract class Animal21 implements aa{
	// abstract class may or may not have abstract method 
	public void fun1(){
		 int j=9;//only final is permitted , not static or any access specifier
	}
	// we can define constuctor . abstract keyword only for class or methods
	public Animal21( int i) {
		
	}
}
abstract class Animal2 extends Animal21 implements aa {
	public Animal2(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	public abstract void fun1();// by defalut public whether or not defined; abstract nd static can not be given at atime 
}
interface aa {
	public abstract void fun1(); // by default pblic abstract
	public static final int x=0; // by default public staic final  so we have to initialize the variabe
	//int y; give error static constant must be initialize
	//public static void funr(); compilation error funtion defination can not be static
}