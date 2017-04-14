package thread;
/*
 * create the thread without extending Thread or implementing Runnable
 */
public class AnonymusThread {

	public static void main(String[] args) {
		// without extending the Thread class.
		new Thread(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println("Thread::"+i);
				}
			}
		}.start();
		for(int i=0;i<10;i++){
			System.out.println("main::"+i);
		}
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<10;i++){
					System.out.println("Runnable::"+i);
				}
			}
			
		}).start();
	}

}
