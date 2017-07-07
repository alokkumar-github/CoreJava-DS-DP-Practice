package java8;
// function programing.
// stram api
// static and default function in interface
public class Test001 {
	public static void main(String[] args) {
		A obj;
		/*obj = new A() {
			public void show() { // this replace the class X
				System.out.println("Hello");
			}
		};*/
		obj = () -> { // this replace the Anonymous inner class
			System.out.println("Hello");
		};
		obj = () -> System.out.println("Hello");
		obj.show();
		B obj1;
		obj1 = (i, j) -> System.out.println("Hello " + i + " " + j);
		obj1.show1(1, "ss");
	}
}

interface A {
	void show();
}

interface B {
	void show1(int i, String s);
}

/*class X implements A {
	@Override
	public void show() {
		System.out.println("Hello");

	}
}*/