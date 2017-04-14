package ds.queue;

public class DemoQueue {

public static void main(String a[]){
		
		Queue queue = new Queue(4);
		queue.enqueue(4);
		queue.dequeue();
		queue.enqueue(56);
		queue.enqueue(2);
		queue.enqueue(67);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(24);
		queue.dequeue();
		queue.enqueue(98);
		queue.enqueue(45);
		queue.enqueue(23);
		queue.enqueue(435);
	}

}
