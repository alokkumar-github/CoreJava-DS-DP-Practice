package enum_demo;
/*
 * By Default interface method is always public abstract and no keyword other then this.
 * and public static final variable. since it is static final so variable must be initialize.
 * 
 * arguments : The things you specify between the parentheses when you're
invoking a method:
doStuff("a", 2); // invoking doStuff, so a & 2 are arguments

parameters : The things in the method's signature that indicate what the
method must receive when it's invoked: void doStuff(String s, int a) { }
 */
public interface EnumInterface {

	public static final int i=10;
	int j=0;
	static int k=10;
	final int f=9;
	void f1();
	public abstract int f2(int i);
	public void f3();
}
