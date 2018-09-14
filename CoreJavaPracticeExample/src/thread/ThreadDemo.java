package thread;

public class ThreadDemo {

	public static void main(String[] args) {
		new FirstTask();
		new SecondTask();
		// new Thread(new SecondTask()).start();
		
		// inline way of creating thread.
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("dd:: "+i);
				}
			}
			
		});
		t.start();
		

	}

}

class FirstTask extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("dd:: "+i);
		}
	}
	
	public FirstTask() {
		start();
	}
}

class SecondTask implements Runnable{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("dd:: "+i);
		}
	}
	
	public SecondTask() {
		new Thread(this).start();
	}
}