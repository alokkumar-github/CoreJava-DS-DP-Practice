package thread;

public class JoinDemo extends Thread{

	// private static int x=2;// same output 
	private  int x=2;
	public JoinDemo(){
		x=5;//
		start(); // thead-0 is strated.
	}
	/*
	 * Note::::::: Each thread gets its own copy of the class's instance variables or static variables.so these variable are not thread safe.
	 */
	public JoinDemo(int... i){}
	public void makeItSo() throws InterruptedException { // part of main-thread
		System.out.println("X1::: "+x);
		x=4;
		this.join(); // wait for thread-0 to be terminated.
		System.out.println("X2::: "+x);
		x=x-1;
		System.out.println(x);
	}
	public static void main(String[] args) throws InterruptedException {

		// main-thread
		new JoinDemo().makeItSo(); // 
	}
	public void run(){ //this is thead-0
		x=x*2; //
		int y = 2;// final, volatile,local variable are thread safe.
		System.out.println("X4::: "+x);
	}

}

