package java8;


/*
 * if you are able to pass the function from one place to other as value is called Closures in functional programming.
 */
public class ClosuresDemo {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		doProcess(a, i -> System.out.println(i + b));

	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}

interface Process {
	void process(int i);
}

