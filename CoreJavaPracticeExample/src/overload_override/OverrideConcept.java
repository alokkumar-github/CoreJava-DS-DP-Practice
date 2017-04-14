
package overload_override;

import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * 
 * Rule for overriding...........
 * 1. only methods declared with the following access modifiers:
 *  2. public, protected and default (in the same package) can be overridden. 
 *  That also means private methods cannot be overridden
 * 
 * 3. Final,static, private methods cannot be overridden.
 * 
 * In case of static method, because a static method is available to all instances of the superclass and its subclasses, 
 * so it’s not permissible to re-implement the static method in a particular subclass
 * 
 * 
 * 
 * 4. The overriding method must not have more restrictive access modifier.
This rule can be understood as follows:
4.1 If the overridden method is has default access, then the overriding one must be default, protected or public.
4.2 If the overridden method is protected, then the overriding one must be protected or public.
4.3 If the overridden method is public, then the overriding one must be only public.

*5 The overriding method must have same return type (or subtype ie  return type can be child class.).
*6. The overriding method must not throw new or broader checked exceptions.
*7 the overriding method may throws fewer or narrower checked exceptions,
*								or any unchecked exceptions.
*ie(Overridden method can throw unchecked exception in case 
*	if parent method throws it or not. You can even not declare
*	 it in signature. But if parent method throws checked exception
*	 you can only specialize this exception 
* 	in the child (throw same exception, it's descendants or none
*  ).http://stackoverflow.com/questions/19925243/exception-in-overriding-methods
* 
* 8. no of and type of parmeter should be same 
* 9. The synchronized modifier has no effect on the rules of overriding.
* 10 The strictfp modifier has no effect on the rules of overriding.
* 
*
*Constructors cannot be overridden.
*
* A static method in a subclass may hide another static one in a superclass, 
* and that’s called hiding.
* 

* Abstract methods must be overridden by the first concrete (non-abstract) subclass.
* 
* Calling another constructor in the same class from another constructor is called constructor chaining. - See more at:
* 
* Rule for overloading...........
* change method signature.(no of argument, type , order of arugment)
* return type doesn't matter.
* throw exception don't matter.
* 
* Rule for constructor.
*  cann't be ooverrided
*  can be overloaded. doesn't have return type.
*  any constructor call it's  super class constructor
*  constructor can have any access specifier.
 */

/*
 * System.gc() is equivalent to Runtime.getRuntime().gc()
 * The only difference is System.gc() is a class method where as Runtime.gc() is an instance method. 
 * So, System.gc() is more convenient.
 */
class Animal {
	int i;
	Animal(){
		
	}
	Animal(int i){
		this();
		this.i=i;
	}
	 public static void display() {
	        System.out.println("Static or class method from animal");
	    }
	 public final void display1(){
		 System.out.println("Non-static or Instance method display1 from Animal");
	 }
    public synchronized void move1() {
    	 System.out.println("in animal ");
    }
 
    protected void eat() {
    	// can not access subclass static or non static element. 
    	// to access we have to create object of subclass
        System.out.println("in animal ");
    }
    
    protected void move() throws IOException {
    	 System.out.println("in animal ");
    }
    public void m1() throws NullPointerException{
    	System.out.println("null point in Animal");
    }
}
public class OverrideConcept extends Animal{
	OverrideConcept(){
		super(6);
	}
	
	 int i=8; // only method can be overrided not variable.
	 public static void display() {
	        System.out.println("Static or class method from OverrideConcept");
	    }
	 
	 @Override
	 public void m1() throws RuntimeException{
			System.out.println("m1()overried in OverriceConcept class");
		}
	/* public final void display1(){// compile time error
		 System.out.println("Non-static or Instance method from Animal");
	 }*/
	 public void move1() {
    	 System.out.println("in OverrideConcept ");
    	// super.move1();
    }
	protected void eat() throws NullPointerException,NumberFormatException{
        System.out.println("eat() in OverrideConcept ");
    }
	protected void move() /*throws FileNotFoundException,NullPointerException*/ { 
		// 11. because the FileNotFoundException is a subclass of the FileIOException: 
		//even don't declare exception. 
		//super.move(); Use the super keyword to invoke the overridden method from a subclass.
		 System.out.println("move() in OverrideConcept ");
		 System.out.println(super.i);
    }
	public static void f1(){
		//super  conn't use super or this from static 
	}
	public static void main(String[] args) {
		OverrideConcept coc2=new OverrideConcept();
		Animal oc=new OverrideConcept();
		//OverrideConcept aa=(OverrideConcept) new Animal(); // runtime error.
		//aa.move1();
		oc.m1();
		oc.eat();
		oc.move1();
		oc.display1();// if you want subclass to acess but not to override super class method
		
		display();// this calls the hiding method
		Animal.display();     
        // because the Animal.display();  is hidden, it requires to use
        // a fully qualified class name to access it.
        
		oc.display();
		coc2.display();
		Animal oc1=new Animal();
		oc1.eat();
		//oc1.move1();
		oc1.display();
		try {
			oc.move();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
//If you make a class final - then it cannot be extended. Making a class final encourages object composition over inheritance.
 class A1{
	private A1(int i){}
	public void m1(){
		System.out.println("ghgh");
	}
	public A1 getInstace(){
		return new A1(0);
	}
}
 /*class B1 extends A1{
	 
 }*/
