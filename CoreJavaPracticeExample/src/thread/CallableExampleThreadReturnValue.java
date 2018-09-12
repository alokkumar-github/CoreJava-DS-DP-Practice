package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExampleThreadReturnValue {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		WorkerThreadCallable worker = new WorkerThreadCallable(1000L);
		ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		Future<Long> future = executorService.submit(worker);
		Long returValue = future.get();
		System.out.println("return value :: "+returValue);
		executorService.shutdown();
	}

}

class WorkerThreadCallable implements Callable<Long>{

	Long sleep;
	public WorkerThreadCallable(Long s) {
	this.sleep = s;
		
	}
	@Override
	public Long call() throws Exception {
		System.out.println("in worker thread");
		Thread.sleep(sleep);
		return sleep * 2;
	}
	
	
}