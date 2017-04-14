package thread;
/*
 * The volatile modifier tells the JVM that a thread accessing the variable must
always reconcile its own private copy of the variable with the master copy in
memory.
 */
public class ThreadA implements InterfaceA{

	@Override
	public void funInterfaceA() {
		System.out.println("implemented in ThreadA Class");
	}
	ThreadA(){
		
	}
	ThreadA(InterfaceA a){
		a=new ThreadA();
	}
	public static void startA(){
		System.out.println("startA fucntion of ThreadA class ");
	}

}
