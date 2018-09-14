package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*Executor F/W::::::::::::
 * use Thread pools 
 * Decouple task-submission from thread-creation and managment.
 * each thread in pool executes mutiple task one by one. a task queue hold the tasks
 * Threads are stop when executor service stop. 
 * 
 * Executor this is the main interface in the f/w void execute(Runnable task). main purpose
 * is to decouple the task submission steps from thread creation and running steps .
 * 
 * ExecutorService extends Executor is the interface . it provide life cycle to the executors ie 
 * initialization phase( in this phase , it allocate the required no of threads and start them to if required)
 *  , sevice phase(it provide its service by running the submitted tasks) and 
 *  distuction phase(it shutdown and stop accepting new tasks for running).
 *  
 *  <T>Future submit(Runnable task); 
 *  <T>Future<T> submit(Callable<T> task);
 *  void shutdown(); 
 *  List<Runnable> shutdownNow(); - it attempt to stop all the actively executing tasks and also hold
 *  the processing of all waiting tasks it also retun list of task that had not been run.
 *  
 *   boolean isShutdown();
 *   
 *   Executors class . it is a factory class 
 *   public static ExecutorService newFixedThreadPool(int nThreads) - creating an executor service 
 *   backed by fixed thread pool this mean that at any time at most n threads no. of tasks can run \
 *   concurrently.say nthread =5; that means 5 thread can execute concurrently.
 *    if we submitt say 20 task to this pool. then the first 5 will execute immediatly in parallel,
 *    while the rest 15 tasks will be put in task queue.
 *   
 *      public static ExecutrorService newCachedThreadPool(); -this kind of executor service continues creating thread as long as no thread
 *      is available and there are still some tasks awaiting execution once a thread done executing a task it is reused . ex this kind is 
 *      use for shor-live asyncronous task are to be executed.
 *    public static ExecutorService newSingleThreadExceutor() - sometime we need background thread that should execute tasks one by one from
 *    a queue but should never execute more than one tasks simultanouly. it guarentess that all the tasks will be executed sequencly only.
 *    on more than one task active at any given time.
 *    
 *    public static ExecutorService newSingleTheadScheduledExecutor() - it create single threaded executor that can schedule task form 
 *     the queue one after the other after a given delay or to execute the tasks periodically from the queue.
 *     
 *  if we need some custom thread pools then we can create ThreadPoolExecutor class.
 *  
 *  Future interface - V get() throws interceptedExecption, ExecutionException - you can call the get method on this future instance to get
 *  the value return by the callable  task the call on this get methos gets blocked  till the task has run to complition and has return the
 *  value. also provide boolean isDone() to check the task is done or yet to complete.
 *  
 *  
 *      
 *   
 *  
 */
public class ExecutorDemo {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(3); // this signifies the initializtion phase of executor service
		// task can be submitted by execute method of ExecutorService interface. let us submite 3 tasks
		executorService.submit(new TaskD());
		executorService.submit(new TaskD());
		executorService.submit(new TaskD());
		
		executorService.shutdown(); // Destruction phase

	}

}

class TaskD implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("dd:: "+i);
		}
	}
	
}
