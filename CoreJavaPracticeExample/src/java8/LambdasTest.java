package java8;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//https://www.youtube.com/playlist?list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3
/*
 * Factor involve the changes in java8. 1 java mostly work with single core, to leverage multicore processor; in multithreaded & concurrency api
 * 										2.increase in demand of amount of data to be process ; parallel processing ; using stream API and functional programming.
 * 
 * why Lambdas--- Enable functional programming , readable maintainable and concise code,
 * 					 enable support for parallel processing, easy to use ApIs and libraries.
 * Lambdas Express ::: just a function which don't belong to class(i.e which exist in isolation)
 * 					 and this function(block of codes) is treated as value. 
 * Lambda expression is perfect for working out functional programming in Java.Lambda expressions basically express instances of functional interfaces.
 * ex. ablockcode={ ..........}
 * Syntax: (parameters) -> expression or (parameters) -> { statements; }
 * 
 * 3. type inference
 * 
 * 4. java.util.function - out of box interfaces define to support the FunctionType for lambdas expression.functional interface
 * 
 * 5. exception handling in lambdas
 * 
 * 6. This reference in lambdas
 * 
 * 7. MethodReference: http://www.baeldung.com/java-8-new-features
 * 
 * 8. Closures:if you are able to pass the function from one place to other as value is called Closures in functional programming.
 * 
 * 9. Function Interface: Any Interface with single abstract method but it can have multiple default methods is called Functional Interface.
 		@FunctionalInterface annotation is used to ensure an interface can’t have more than one abstract method. The use of this annotation is optional.
		The java.util.function package contains many builtin functional interfaces in Java 8.
 * 		java 8 provide support for lambda expressions only with functional interfaces.
 * 
 * 10. Functional Programming in object oriented language :: Function are at the center of functional programming.
	 * Function refer to mathematical function(ie. they don't change anything , just simply map input to output ). ex f(x)=x*2;
		using this function as g(x,y)=f(x)+f(y)
							g(2,3)	= f(2)+f(3) = (2*2)+(3*2) =10 
	Input for fuction should be immutable.function should not involve in modifying outside of its scope.
	so functional programming should focus only on input and output.
 *   Functions are similar to methods in Java. But they differ in certain properties/principle.
	1. Functions should avoid mutable states (That means they should not assign or update any state of an object.)
	2. Functions are stateless.
	
	This is a stateless object:
	class Stateless {
	    void test() {
	        System.out.println("Test!");
	    }
	}
	This is also a stateless object:
	class Stateless {
	    //No static modifier because we're talking about the object itself
	    final String TEST = "Test!";
	
	    void test() {
	        System.out.println(TEST);
	    }
	}
	This object has state, so it is not stateless. However, it has its state set only once, and it doesn't change later,
	this type of objects is called immutable:
	class Immutable {
	    final String testString;
	
	    Immutable(String testString) {
	        this.testString = testString;
	    }
	
	    void test() {
	        System.out.println(testString);
	    }
	}
	
	11. optional<> : to handle run time exception.ex NullPointerException (NPE). 
	12. Stream API.
	
 * 
 */
public class LambdasTest {

	
	public static void main(String[] args) {
		
		Funtion1TypeInterface function1Type = ()->{
			System.out.println("Hello World");
		};
		//functtion2Type = (int a) -> a+2;
		//same as
		// functtion2Type = a -> a+2;
		Funtion3TypeInterface functtion3Type1 = (int a, int b) -> {
			if(a==b) return 0;
			return a+b;
		};
		Funtion3TypeInterface functtion3Type2 = (int a, int b) -> {
			if(a==b) return 0;
			return a+b;
		};
		
		//TaskComparator tc = (a, b) -> { return a > b;};
		TaskComparator tc = new TaskComparator() {
			@Override
			public boolean compareTask(int a, int b) {
				return a > b;
			}
		};
		
		boolean task=tc.compareTask(5, 2);
		System.out.println("task:: "+task);

	}// below are replaced by lambdas and assign the type as above.
	// signture of lambdas should match with 
	// any interface with only one method with same signature.
	// @FunctionalInterface just to make sure that interface contain only one method.
	// use java.util.function package just to use the predefine interface for functionType.
	// ex. Consumer , Predicate
	/*function1Type = public void greeting() {
		System.out.println("Hello world");
	}
	functtion2Type = public int fucnction2(int a) {
		return a+2;
	}
	functtion3Type = public int fucnction3(int a,int b) {
		if(a==b) return 0;
		return a+b;
	}*/
	
	 
}	

@FunctionalInterface
 interface Funtion3TypeInterface {
	public int funtion3Type(int a,int b);
}
 interface Funtion1TypeInterface {
	public void funtion1Type();
}
 
 @FunctionalInterface
 interface TaskComparator{
	 public boolean compareTask(int a, int b);
 }
 
// some more example.........................
class Unit1ExerciseSolutionJava8 {

		public static void main(String[] args) {
			List<Person> people = Arrays.asList(
					new Person("Charles", "Dickens", 60),
					new Person("Lewis", "Carroll", 42),
					new Person("Thomas", "Carlyle", 51),
					new Person("Charlotte", "Bronte", 45),
					new Person("Matthew", "Arnold", 39)
					);
			
			// Step 1: Sort list by last name
			Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
			
			// example Sort list by last name - without lambdas
			/*Collections.sort(people, new Comparator<Person>() {
				@Override
				public int compare(Person o1, Person o2) {
					return o1.getLastName().compareTo(o2.getLastName());
				}
			});*/
			
			// Step 2: Create a method that prints all elements in the list
			System.out.println("Printing all persons");
			printConditionally(people, p -> true);
			// without
			/*System.out.println("Printing all persons");
			printAll(people);
			private static void printAll(List<Person> people) {
				for (Person p : people) {
					System.out.println(p);
				}
				
			}*/
			
			// Step 3: Create a method that prints all people that have last name beginning with C
			System.out.println("Printing all persons with last name beginning with C");
			printConditionally(people, p -> p.getLastName().startsWith("C"));

			System.out.println("Printing all persons with first name beginning with C");
			
			printConditionally(people, p -> p.getFirstName().startsWith("C"));
			
			// without
			/*System.out.println("Printing all persons with last name beginning with C");
			printConditionally(people, new Condition() {
				@Override
				public boolean test(Person p) {
					return p.getLastName().startsWith("C");
				}
			});

			System.out.println("Printing all persons with first name beginning with C");
			printConditionally(people, new Condition() {
				@Override
				public boolean test(Person p) {
					return p.getFirstName().startsWith("C");
				}
			});
			
		}

		private static void printConditionally(List<Person> people, Condition condition) {
			for (Person p : people) {
				if (condition.test(p)) {
					System.out.println(p);
				}
				
			}
			
		}*/
		}
		interface Condition {
			boolean test(Person p);
		}

		private static void printConditionally(List<Person> people, Condition condition) {
			for (Person p : people) {
				if (condition.test(p)) {
					System.out.println(p);
				}
			}
		}
	}
