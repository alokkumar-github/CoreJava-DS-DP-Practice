package innerClasses;

import innerClasses.MemberInnerClassDemo.Inner;

/* properties of static innerclass.
 * 1. can define any access specifier.
 * 2. can have static as well as non static member
 * 3. static member are directly access to static/non-static member of that class but non-static member of that class cann't be accessable to static member.
 * 4. even though we define non-static in static inner class,. it become static
 */
public class StaticInnnerClass {
	static int i=69;
	int j=9;
	private String ss="prim";
	
	private void fun1(){
		Inner ii=new Inner();//
		ii.fun1();
		ii.u1=0;//
		Inner.u1=0;// 
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
	 static class Inner{
		int ii=9;
		int y;
		static int u1=9;
		static final int u=9;
		private void fun1(){
			System.out.println("inner class funtion");
		}
		public void fun4(){
			fun1();
			StaticInnnerClass ss=new StaticInnnerClass();
			ss.fun2();
			System.out.println(ss+ "  \t "+i+"\t"+ss.j);
			System.out.println(y);
			System.out.println("inner class funtion4");
		}
		public static void fun6(){
			System.out.println("inner class funtion4");
		}
	}
	 private static class Inner1{
		 
	 }
	public static void main(String[] args) {
		StaticInnnerClass ss=new StaticInnnerClass();
		ss.fun3();
		StaticInnnerClass.Inner si=new StaticInnnerClass.Inner();
		si.fun6();
	}

}
