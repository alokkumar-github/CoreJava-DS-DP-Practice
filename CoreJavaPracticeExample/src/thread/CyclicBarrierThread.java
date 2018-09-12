package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*  https://www.geeksforgeeks.org/java-util-concurrent-cyclicbarrier-java/
 * 
 * CyclicBarrier is used when multiple thread carry out different sub tasks and 
 * the output of these sub tasks need to be combined to form the final output..
 * 
 * Runnable action = ... 
//action to be performed when all threads reach the barrier;
CyclicBarrier newBarrier = new CyclicBarrier(numberOfThreads, action);

Difference between a CyclicBarrier and a CountDownLatch

A CountDownLatch can be used only once in a program(until it’s count reaches 0).

A CyclicBarrier can be used again and again once all the threads in a barriers is released.
 */
public class CyclicBarrierThread {

	public static void main(String[] args) {
		
		CyclicBarrier cb = new CyclicBarrier(4, new Aggregator());
		
		new WorkerThread(1000,cb, "2010");
		//snooze();
		new WorkerThread(2000,cb, "2011");
		new WorkerThread(3000,cb, "2012");
		new WorkerThread(4000,cb, "2013");
		System.out.println("end of main.");

	}
	
	private static void snooze() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class WorkerThread extends Thread {
	CyclicBarrier syncPoin;
	int delay;
	
	public WorkerThread(int d, CyclicBarrier cb, String name) {
		this.delay =d;
		this.syncPoin = cb;
		this.setName(name);
		this.start();
	}
	public void run() {
		System.out.println("enter :: "+getName());
		try {
			this.sleep(delay);
			syncPoin.await();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Aggregator extends Thread {
	
	public void run() {
		System.out.println("In Aggregator....");
	}
	
}