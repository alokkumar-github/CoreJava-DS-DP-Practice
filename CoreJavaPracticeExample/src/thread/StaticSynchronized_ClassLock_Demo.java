package thread;

/*
 * Acquiring lock on class, 2 Ways to acquire
	lock on class in java
 * Thread can acquire lock on class’s class object 
 * 1.by Entering synchronized block or
	2. by entering static synchronized methods.
 */
public class StaticSynchronized_ClassLock_Demo {
	

	public static void main(String[] args) {

		Thread1 tr1=new Thread1();
		Thread2 tr2=new Thread2();
		Thread3 tr3=new Thread3();
		Thread tr4=new Thread4();
		tr1.setName("tr1");
		tr2.setName("tr2");
		tr3.setName("tr3");
		tr4.setName("tr4");
		tr1.start();
		tr2.start();
		tr3.start();
		tr4.start();

	}

}
//Synchronized block on a class lock:
class AccountCommon{
		static void showAccount(String accountName){
			synchronized (AccountCommon.class){
				System.out.println("myAcc:::"+accountName+" and HolderName::"+Thread.currentThread().getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}

//Static Synchronized Method on a class lock
/*class AccountCommon{
	synchronized static void showAccount(String accountName){
		System.out.println("myAcc:::"+accountName+" and HolderName::"+Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
*/
class Thread1 extends Thread{
	public void run(){
		AccountCommon.showAccount("Thread-1");
	}
}

class Thread2 extends Thread{
	public void run(){
		AccountCommon.showAccount("Thread-2");
	}
}

class Thread3 extends Thread{
	public void run(){
		AccountCommon.showAccount("Thread-3");
	}
}

class Thread4 extends Thread{
	public void run(){
		AccountCommon.showAccount("Thread-4");
	}
}

