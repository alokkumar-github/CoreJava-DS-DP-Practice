package thread;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		List<Integer> sharedList = new ArrayList<>();
		Thread t1 = new Thread(new Producer1(sharedList));
		Thread t2 = new Thread(new Consumer1(sharedList));
		t1.start();
		t2.start();

	}

}

class Producer1 implements Runnable {
	List<Integer> sharedList;

	public Producer1(List<Integer> l) {
		this.sharedList = l;
	}

	@Override
	public void run() {
		synchronized (sharedList) {
			while (true) {
				if (sharedList.size() > 0) {
					try {
						sharedList.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					produce();
				}
			}
		}

	}

	private void produce() {
		for (int i = 0; i <5; i++) {
			sharedList.add(i);
			System.out.println("producer is producing " + i);
		}
		sharedList.notifyAll();
	}
}

class Consumer1 implements Runnable {

	List<Integer> sharedList;

	Consumer1(List<Integer> l) {
		this.sharedList = l;
	}

	@Override
	public void run() {
		synchronized (sharedList) {
			while (true) {
				if (sharedList.size() == 0) {
					try {
						sharedList.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					consume();
				}
			}
		}
	}

	private void consume() {
		while (!sharedList.isEmpty()) {
			// sharedList.remove(0);
			System.out.println("consumer is consumeing " + sharedList.remove(0));
		}
		sharedList.notifyAll();
	}

}