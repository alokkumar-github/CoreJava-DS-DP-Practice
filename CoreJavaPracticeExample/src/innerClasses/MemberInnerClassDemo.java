package innerClasses;
/* static import
 *  Nested classes are divided into two categories: static and non-static.
 *   Nested classes that are declared static are called static nested classes. Non-static nested classes are called inner classes.
 * Inner class and nested static class in Java both are classes declared inside another class, known as top level class in Java. In Java terminology, If you declare a nested class static, it will called nested static class in Java while non static nested class are simply referred as Inner Class
 */
public class MemberInnerClassDemo {
/*
 * if class define in another class as a memeber .
 * can be useful in mutilevel inheritence. ex. chart room and event handling.
 * and can achieve modularity . whenever we need to define large no of functions we go for 
 * inner class. example class Mathematics -- class algebra,class geometry,class trigomatry 
 * inner class can access private member of outter class.
 */
	/*
	 * When to use inner classes
	 * Inner classes are used to get functionality which can be get as object better than method.
They can be used in case when a set of multiple operation are required and chances of reusability are good inside class and they have no use outside the class.
Inner classes are made to achieve multiple inheritance also.
Inner classes are used when they are useful in class context.
They are used to separate logic inside class.
So if you have some requirement matching above points than inner class can be used. It is always better to make inner class private to prevent accessing from other classes. In your case use of inner class is helpful to make code readable and separate logic in class.

Nested class does not need any additional or separate file to place.
Nested classes (or inner classes) are comparatively small and tightly coupled with the “parent” class or “outer” class. Avoids lot of helper classes and fits to explain the OOD priciple of containment.
All the code in the same file increases readability and increases performance (like online code). Their importance is growing in the coding and treated as a good practice.
Anonymous inner classes are very useful when you want to define callbacks on the fly.
An object of an inner class can access the implementation of the object that created it- INCLUDING private data
	 */
	static int i=69;
	int j=9;
	private String ss="prim";
	
	private void fun1(){
		Inner ii=new Inner();//
		ii.fun1();
		System.out.println("outter class funtion1");
	}
	private void fun2(){
		System.out.println("outter class funtion2");
	}
	public void fun3(){
		j=89;//
		i=0;//
		System.out.println("outter class funtion3");
	}
	public static void fun5(){
		i=8;//
		MemberInnerClassDemo outter=new MemberInnerClassDemo();
		outter.j=90;//
	}
	class Inner{
		int ii=9;
		int y;
		//static int u=9;// compilation error // Rule : non static member should not have static ; here inner class is non static member
		static final int u=9;
		private void fun1(){
			System.out.println("inner class funtion");
		}
		public void fun4(){
			fun1();
			fun2();
			System.out.println(ss+ "  \t "+i+"\t"+j);
			System.out.println(y);
			System.out.println("inner class funtion4");
		}
	}
	public static void main(String[] args) {
		MemberInnerClassDemo.Inner oi=new MemberInnerClassDemo().new Inner();
		oi.fun4();
	}

}
