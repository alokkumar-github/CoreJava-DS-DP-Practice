package java8;

public class TypeInferenceDemo {

	public static void main(String[] args) {
		printLambda(s -> s.length()); // int getLength(String s);
	}

	public static void printLambda(StringLengthLambda l) {
		System.out.print(l.getLength("Hello Lambda"));
	}

	interface StringLengthLambda {
		int getLength(String s);
	}
}
