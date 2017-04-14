package thread;

import java.util.ArrayList;

public class MaintainThreadOrderUsingJOIN {

	public static void main(String[] args) throws InterruptedException{{
		System.out.println("In main() method");
		MyRunnable runnable=new MyRunnable();
		Thread thread1=new Thread(runnable);
		Thread thread2=new Thread(runnable);
		thread1.start();
		thread1.join();
		thread2.start();
		thread2.join();
		System.out.println("end main() method");

		ArrayList al=new ArrayList();
	}

}
}
class MyRunnable implements Runnable{
	public void run(){
	for(int i=0;i<3;i++){
		System.out.println("i="+i+",ThreadName="+Thread.currentThread().getName());
	}
	}
}
