package thread;

import java.util.concurrent.atomic.AtomicLong;

/*// volatile keyword here makes sure that the changes made in one thread are immediately reflect in other thread
   volatile int sharedVar = 6;
   
 * volatile vs synchronized:
Before we move on let’s take a look at two important features of locks and synchronization.

Mutual Exclusion: It means that only one thread or process can execute a block of code (critical section) at a time.
Visibility: It means that changes made by one thread to shared data are visible to other threads.

Java’s synchronized keyword guarantees both mutual exclusion and visibility.
If we make the blocks of threads that modifies the value of shared variable synchronized only one thread can enter the block and changes made by it will be reflected in the main memory. 
In some cases we may only desire the visibility and not atomicity. Use of synchronized in such situation is an overkill and may cause scalability problems. Here volatile comes to the rescue.
 Volatile variables have the visibility features of synchronized but not the atomicity features.
 
 
 What is the difference between volatile and atomic variables? 
 In short – a volatile variable is a variable, which can be changed from anywhere at any time, 
 and thus cannot be optimized away. One consequence is that all the threads see the changes in them at once,
but don’t actually set a lock on them. Atomic variables, on the other hand, are guaranteed to update all the threads and don’t allow to change their values asynchronously.and 
It provides non-blocking(i.e asynchronously) variable change by multiple threads.

https://dzone.com/articles/why-non-blocking
Non-blocking applications are written in a way that threads never block – whenever a thread would have to block on I/O (e.g. reading/writing from/to a socket), 
it instead gets notified when new data is available. How is that implemented is out of the scope of this post. Non-blocking applications are normally implemented with message passing (or events). “Asynchronous” is related to that (in fact, in many cases it’s a synonym for “non-blocking”), as you send your request events and then get response to them in a different thread, at a different time – asynchronously.
 And then there’s the “reactive” buzzword, which I honestly can’t explain – on one hand there’s the reactive functional programming, which is rather abstract;
  on the other hand there’s the reactive manifesto which defines 3 requirements for practically every application out there (responsive, elastic, resilient) and one implementation detail (message-driven), which is there for no apparent reason. And how does the whole thing relate to non-blocking/asynchronous programming – probably because of the message-driven thing, but often the three go together in the buzzword-driven marketing jargon.

Reactive Systems are :
Responsive: The system responds in a timely manner if at all possible. 
Resilient: The system stays responsive in the face of failure.
Elastic: The system stays responsive under varying workload.
Message Driven: Reactive Systems rely on asynchronous message-passing to establish a boundary between components that ensures loose coupling, isolation and location transparency. 
 */

class Visit{
	public static AtomicLong visit = new AtomicLong(0); //The java.util.concurrent.atomic package defines classes that support atomic operations on single variables
	//public static int visit;
}

public class AtomicPackage implements Runnable {
	
	public void run() {
		
//		synchronized(Visit.class) {
//			int visit = ++Visit.visit;
//			System.out.println(visit+" ");
//		}
		// or use atomic
		Long visit = Visit.visit.incrementAndGet();
		System.out.println(visit+" ");
	}

	public static void main(String[] args) {
		
		for(int i=0;i<25;i++) {
			Thread t = new Thread(new AtomicPackage());
			t.start();
		}

	}

}
