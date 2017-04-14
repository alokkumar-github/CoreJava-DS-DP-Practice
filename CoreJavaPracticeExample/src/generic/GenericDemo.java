package generic;

import java.util.ArrayList;
import java.util.List;

/*
 * There are mainly 3 advantages of generics
 * 1)	Type-safety : We can hold only a single type of objects in generics. It doesn’t allow to store other objects.
 2)	Type casting is not required: There is no need to typecast the object.
 3)	Compile-Time Checking: It is checked at compile time so problem will not 
 occur at runtime. The good programming strategy says it is far better
 to handle the problem at compile time than runtime.
 */
public class GenericDemo {
	public static void accept(ArrayList<?> arr){ // ArrayList<Object> give comilation error
		for(Object o:arr){						// ? mean any type.
			System.out.println(o);
		}
	}
		
	public static void main(String[] args) {
		//List< ? extends Number > -  List can contain Number or its subtypes.
		//List< ? super Number > - List can contain Number or its supertypes.
		//Set<?> set = new HashSet<?>(); // compilation errror . not from java 7.
		ArrayList<String> aa=new ArrayList<String>();
		aa.add("a"); 
		aa.add("e");
		accept(aa);
		
		MyGen<Integer> m = new MyGen<Integer>();
		m.add(2);
		// m.add("alok");//Compile time error
		System.out.println(m.get());
		
		MyGen<String> m1 = new MyGen<String>();
		m1.add("alok");
		System.out.println(m1.get());
		
		
		
		/// wildCard in Generic
		List<Rectangle> list1=new ArrayList<Rectangle>();  
		list1.add(new Rectangle());  
		  
		List<Circle> list2=new ArrayList<Circle>();  
		list2.add(new Circle());  
		list2.add(new Circle());  
		  
		drawShapes(list1);  
		drawShapes(list2);  
		
		// Generic method or class doesn't accept primitive type.
		int i[]= {1,5,6,7,8};
		//printArray(i); /// error
		Integer []il={4,65,7,9,};
		
		printArray(il);
		
		Double d[]={1.1,4.5,6.0,0.0};
		printArray(d);
		Character c[]={'g','j','p'};
		printArray(c);
		
		
	}	
	// creating a method that accepts only child class of Shape
		public static void drawShapes(List<? extends Shape> lists) {
			for (Shape s : lists) {
				s.draw();// calling method of Shape class by child class instance
			}
		}
	// create generic method that can accept any type of argument.
	public static <E> void printArray(E[] elements) {
		for (E element : elements) {
			System.out.println(element);
		}
		System.out.println();
	}

	public static <E, F> void printA(E element1, F element2) {
		/*
		 * for ( E element : elements){ System.out.println(element ); }
		 */
		System.out.println("emelement::::" + element1);
	}

}

/*
 * Type Parameters
 * 
 * The type parameters naming conventions are important to learn generics
 * thoroughly. The commonly type parameters are as follows:
 * 
 * T - Type E - Element K - Key N - Number V - Value
 */
class MyGen<T> {
	T obj;

	void add(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}
	// constructor
	/*
	 * MyGen(T obj){ this.obj=obj; }
	 */
}

/*
 * Wildcard in Java Generics
 * 
 * The ? (question mark) symbol represents wildcard element. It means any type.
 * If we write <? extends Number>, it means any child class of Number e.g.
 * Integer, Float, double etc. Now we can call the method of Number class
 * through any child class object.
 */
abstract class Shape {
	abstract void draw();
	Shape(String s){
		System.out.println("this is Shape Class Constructor");
	}
	Shape(){
		
	}
}

class Rectangle extends Shape {
	public Rectangle() {
		super(null);// call immediate super class constructor.
		System.out.println("this is Rectangle class contructor");
	}
	void draw() {
		System.out.println("drawing rectangle");
	}
}

class Circle extends Shape {
	Circle(String s) {
		super(s);
		//this("r",6);
	}
	int i;String s;
	Circle() {
		//this("r",6);
	}
	Circle(String s,Integer i) {
		this();
	}
	
	void draw() {
		System.out.println("drawing circle");
	}
}
interface a{
	// interface can not have constructor.
}
abstract class abstDemo implements a{
	abstDemo(){
		System.out.println("abstract class of abstDemo");
	}
	abstDemo(String s){
		
	}
	
}
class absd extends abstDemo{
	absd(){
		super();
	}
}

//////////////////////////////////////////
 class MyWildcardEx {
	 
    public static void main(String a[]){
         
        MyEmployeeUtil<CompAEmp> empA
                    = new MyEmployeeUtil<CompAEmp>(new CompAEmp("Ram", 20000));
        // this <> This feature, known as type inference ;because the compiler infers the type(s) from the left hand side
        // infer ie (guess, counslusion base of somthing)
        //MyEmployeeUtil<CompAEmp> empA1= new MyEmployeeUtil<>(new CompAEmp("Ram", 20000));
        MyEmployeeUtil<CompBEmp> empB
                    = new MyEmployeeUtil<CompBEmp>(new CompBEmp("Krish", 30000));
        MyEmployeeUtil<CompAEmp> empC
                    = new MyEmployeeUtil<CompAEmp>(new CompAEmp("Nagesh", 20000));
        System.out.println("Is salary same? "+empA.isSalaryEqual(empB));
        System.out.println("Is salary same? "+empA.isSalaryEqual(empC));
    }
}
 
class MyEmployeeUtil<T extends Emp>{
     
    private T emp;
     
    public MyEmployeeUtil(T obj){
        emp = obj;
    }
     
    public int getSalary(){
        return emp.getSalary();
    }
     // MyEmployeeUtil<T> mean you can compare with same instance (ie CompAEmp or CompBEmp)
    // MyEmployeeUtil<?> mean you can compare with difference instance (ie CompAEmp and CompBEmp)
    public boolean isSalaryEqual(MyEmployeeUtil<?> otherEmp){
         
        if(emp.getSalary() == otherEmp.getSalary()){
            return true;
        }
        return false;
    }
     
    //// create some utility methods to do employee functionalities
    //
    //
    //
}
 
class Emp{
     
    private String name;
    private int salary;
     
    public Emp(String name, int sal){
        this.name = name;
        this.salary = sal;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
 
class CompAEmp extends Emp{
     
    public CompAEmp(String nm, int sal){
        super(nm, sal);
    }
}
 
class CompBEmp extends Emp{
     
    public CompBEmp(String nm, int sal){
        super(nm, sal);
    }
}
