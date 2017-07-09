package java8;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//https://www.youtube.com/playlist?list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3
/*
 * why Lambdas--- Enable functional programming , readable maintainable and concise code,
 * 					 enable support for parallel processing, easy to use Apis and libraries.
 * Lambdas Express ::: just a function which don't belong to class(i.e which exist in isolation)
 * 					 and this function(block of codes) is treated as value. 
 * ex. ablokcode={ ..........}
 * 
 * 3. type inference
 * 
 * 4. java.util.function - out of box interfaces define to support the FunctionType for lambdas expression.functional interface
 * 
 * 5. exception handling in lambdas
 * 
 * 6. This reference in lambdas
 * 
 * 7. MethodReference
 * 
 * 8. Closures
 * 
 * 9. 
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
