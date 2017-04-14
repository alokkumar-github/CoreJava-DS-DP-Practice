package innerClasses;
/*
 * Define a class to function ,just as a local variable.
 */
public class LocalInnerClass {

	static{
		int i;
		System.out.println("inside staicblock");
	}
	
	/*
	 * if we have many constructor in a class and every consturctors has common statments.
	 * instead of repeating those statment in each constructor . put it into non-static block
	 * in this way we will avoid duplicate in code.
	 */
	{
		int j;
		System.out.println("inside non-static block");
	}
	
	LocalInnerClass(){
		System.out.println("inside constructor");
	}
	public static void main(String[] args) {
		System.out.println("inside main");
		LocalInnerClass s=new LocalInnerClass();
		
	}

}
