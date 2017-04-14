package thread;

public class DeadLockDemo {
	static String s1 = "Alok";
	static String s2 = "Kumar";
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				while (true) {
					synchronized (s1) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						synchronized (s2) {
							System.out.println("First\t" + s1 + "\t" + s2);
						}
					}
				}
			}

		}.start();
		
		new Thread() {
			public void run() {
				while (true) {
					synchronized (s2) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						synchronized (s1) {
							System.out.println("First\t" + s1 + "\t" + s2);
						}
					}
				}
			}

		}.start();

	}

}
