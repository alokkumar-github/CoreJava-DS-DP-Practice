package operator;
/*
 *1. using new operator
 *2. using Factory method.
 *3. using Object clone() method.
 *4. using newInstence method. 
 *constructor can't ever, ever, ever, have a return type…ever! not even void 	
 *Constructors can't be marked static (they
are after all associated with object instantiation), they can't be marked final
or abstract (because they can't be overridden).
 */
public class ObjectCreateDemo {
	int i;
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			Class c=Class.forName("com.test.ObjectCreateDemo");
			ObjectCreateDemo ocd=(ObjectCreateDemo)c.newInstance();
			System.out.println(ocd.i);

	}
	/*
	 * Can we execute a java program without a main() method?
	 * Prior to Java 7:
		Yes, sequence is as follows:
		jvm loads class
		executes static blocks
		looks for main method and invokes it
	 */
	/*
	 * static block , then main method , instance block , constuctor , then user defined method
	 */

}
