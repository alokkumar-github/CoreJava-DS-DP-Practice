package thread;

import java.util.concurrent.Executor;

/*
 * Thread which is already under execution can be prevented by 3 way.
 * 1.	sleep  by time
 * 2.	join   conditionly
 * 3.	wait , notify  unconditionaly
 */
public class Join_Demo {

	
	public static void main(String[] args) {
		
		Thr1 t1=new Thr1();
		//Thr2 t2=new Thr2();
		Thr3 t3=new Thr3(t1);
		//t1.start();t2.start();t3.start();
		
	}

}
class Thr1 extends Thread{
	Thr1(){
		start();
	}
	int sum;
	public void run(){
		System.out.println("Begin of run - Thread1");
		for(int i=0;i<37;i++){
			sum=sum+i;
			System.out.println("run of thread1::::"+i);
		}
	}
}
class Thr2 extends Thread{
	Thr2(){
		start();
	}
	public void run(){
		for(int i=0;i<300;i++){
			System.out.println("run of thread2::"+i);
		}
	}
}
class Thr3 extends Thread{
	Thr1 thread1;
	Thr3(Thr1 thread1){
		this.thread1=thread1;
		start();
	}
	public void run(){
		for(int i=400;i<437;i++){
			System.out.println("run of thread3::"+i);
			if(i==422){
				try {
	// puts the current thread(here thread3) on wait 
					//until the thread(here thread1) on which it’s called is dead.
					//If the thread is interrupted, it throws InterruptedException.				
					thread1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int x=thread1.sum-i;
				System.out.println("sum::"+thread1.sum);
				System.out.println("diffrence:::"+x);
			}
		}
	}
}