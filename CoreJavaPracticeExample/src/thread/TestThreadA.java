package thread;


public class TestThreadA implements InterfaceA{

	public static void main(String[] args) {

		TestThreadA aa=new TestThreadA();
		ThreadA ta=new ThreadA(aa);
		ta.startA();
		ta.funInterfaceA();
	}

	@Override
	public void funInterfaceA() {
		System.out.println("impleamented in TestThreadA class");
		
	}

	int i=0;
}
