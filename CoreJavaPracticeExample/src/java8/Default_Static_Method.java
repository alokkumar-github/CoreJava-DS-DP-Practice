package java8;

interface C {
	default void m1() {
		System.out.println("left");
	}
}

interface D {
	default void m1() {
		System.out.println("right");
	}
}

public class Default_Static_Method implements C, D, interfaceA, interfaceB  {

	@Override
	public void m1() {
		System.out.println("m1() overridden...");
	}

	public static void main(String[] args) {
		Default_Static_Method obj = new Default_Static_Method();
		obj.m1();
		new Lab3().m1();
		
		//////////////////////////////
		//sum(); // illegal
		// new Lab5().sum(); // illegal
		// Lab5.sum(); // illegal
		interfaceA.sum();

		// interfaceB.sub(); // illegal
		// Lab5.sub(); // illegal
		new Lab5().sub();
	}

}

interface left {
	default void m1() {
		System.out.println("left");
	}
}

interface right {
	default void m1() {
		System.out.println("right");
	}
}

class Lab3 implements left, right { // Ambiguity if not override

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		left.super.m1();
	}
}

interface one {
	default void m1() {
		System.out.println("left");
	}
}

interface two {
	static void m1() {
		System.out.println("right");
	}
}

class Lab31 implements one, two {

}

interface A1 {
	static void m1() {
		System.out.println("left");
	}
}

interface B1 {
	static void m1() {
		System.out.println("right");
	}
}

class Lab32 implements A1, B1 {

}

// calling static methods.

interface interfaceA {
	public static void sum() {
		System.out.println("static method");
	}
	
	static void sum1() { // by default ; only - public.
		System.out.println("static method-2");
	}
}

interface interfaceB {
	public default void sub() {
		System.out.println("default method");
	}
	public default void sub1() {
		System.out.println("default method-2");
	}
	default int sub11() { // by defuaul ; only - public; 
		System.out.println("default method-3");
		return 0;
	}
}

 class Lab5 implements interfaceA, interfaceB {

	public static void main(String[] args) {
		// sum(); // illegal
		// new Lab5().sum(); // illegal
		// Lab5.sum(); // illegal
		interfaceA.sum();

		// interfaceB.sub(); // illegal
		// Lab5.sub(); // illegal
		new Lab5().sub();
	}

}
