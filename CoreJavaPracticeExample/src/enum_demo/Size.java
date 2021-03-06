/**
 * 
 */
package enum_demo;

import java.io.Serializable;

/** ref::: https://crunchify.com/why-and-for-what-should-i-use-enum-java-enum-examples/
 * 1.	enum is Type safe (http://www.securingjava.com/chapter-two/chapter-two-10.html)
 * 2.	All enums implicitly extend java.lang.Enum. Since Java does not support multiple inheritance, an enum cannot extend anything else.
 * 3.	The java enum constants are static and final implicitly.
 * 4.   You can specify values of enum constants at the creation time. MyEnum.values() returns an array of MyEnum’s values.
 * 5. 	Enum can be safely compare using: Switch-Case Statement , == Operator ,.equals() method.
 * 6.	You can not create instance of enums by using new operator in Java because constructor of Enum in Java can only be private and Enums constants can only be created inside Enums itself.
 * 7. 	An enum can be declared outside or inside a class, but NOT in a method.
 * 8.	An enum declared outside a class must NOT be marked static, final , abstract, protected , or private.
 * 
 * 11.	The semicolon at the end of an enum declaration is optional.
 * 12.	enum constructors can NEVER be invoked directly in code. They are always called automatically when an enum is initialized.
 * 
 * 
 * enum cann't be private ,protected.
 * 
 * If you don't declare private compiler internally creates private constructor.
 * Yes, ofcourse! we can have abstract methods and
 *  can provide the implementation of these methods.
 * 
 * 1 enum may implement many 
 * interfaces but cannot extend any class because it internally extends Enum class
 * 2. enum can have fields, constructors and methods.
 * 3. enum can be traversed
 * 4. enum improves type safety and enum can be easily used in switch
 * 
 * Sometimes, a variable should only hold a restricted set of values. For example, you may
sell clothes or pizza in four sizes: small, medium, large, and extra large. Of course, you
could encode these sizes as integers 1, 2, 3, 4, or characters S, M, L, and X. But that is an
error-prone setup. It is too easy for a variable to hold a wrong value (such as 0 or m).
you can define your own enumerated type whenever such a situation arises.
An enumerated type has a finite number of named values

*
*
* The type defined by this declaration is actually a class. The class has exactly four
instances—it is not possible to construct new objects.Therefore, 
you never need to use equals for values of enumerated types. Simply use == to
compare them.
You can, if you like, add constructors, methods, and fields to an enumerated type. Of
course, the constructors are only invoked when the enumerated constants are constructed.
 *
 */
public enum Size implements EnumInterface{

	//SMALL,MEDIUM,,EXTRA_LARGE
	SMALL("S") {// 9.	enum constants can send arguments to the enum constructor, using the syntax BIG(8), where the int literal 8 is passed to the enum constructor.
		@Override
		public int f() {
			return 1;
			
		}
	},	MEDIUM("M") {
		@Override
		public int f() {
			return 2;
			
		}
	},LARGE("L") {
		@Override
		public int f() {
			return 3;
			
		}
	},	EXTRA_LARGE("E") {
		@Override
		public int f() {
			return 4;
			
		}
	};
	
	
	@Override
	public void f1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int f2(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//Declaring Constructors, Methods, and Variables in an enum
	private String abbv;
	private Size(String abbv){// 10.	enum constructors can have arguments, and can be overloaded.
		this.abbv=abbv;
	}

	public String getAbbv(){
		return abbv;
	}

	@Override
	public void f3() {
		// TODO Auto-generated method stub
		
	}
		
	public abstract int f();
	
}
