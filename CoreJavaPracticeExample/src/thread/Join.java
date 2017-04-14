package thread;

public class Join extends Thread{

	private int x=2;
	public Join(){
		x=5;//
		start(); // thead-0 is strated.
	}
	/*
	 * 
	 */
	public Join(int... i){}
	public void makeItSo() throws InterruptedException { // part of main-thread
		System.out.println("X::: "+x);
		x=4;
		this.join(); // wait for thread-0 to be terminated.
		x=x-1;
		System.out.println(x);
	}
	public static void main(String[] args) throws InterruptedException {

		// main-thread
		new Join().makeItSo(); // 
	}
	public void run(){ //this is thead-0
		x=x*2; //
	}

}

