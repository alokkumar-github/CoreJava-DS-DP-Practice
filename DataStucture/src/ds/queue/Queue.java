package ds.queue;

/*
 * A queue is a kind of abstract data type or collection in which the entities 
 * in the collection are kept in order and the only operations on the collection are the addition of entities to the rear terminal position, called as enqueue, and removal of entities from the front terminal position, called as dequeue. The queue is called as First-In-First-Out (FIFO) data structure. In a FIFO data structure, the first element added to the queue will be the first one to be removed. This is equivalent to the requirement that once a new element is added, all elements that were added before have to be removed before the new element can be removed. Often a peek or front operation is also entered, returning the value of the front element without dequeuing it. A queue is an example of a linear data structure, or more abstractly a sequential collection.
 * 
 * Queue Operations:
enqueue: Adds an item onto the end of the queue.
front: Returns the item at the front of the queue.
dequeue: Removes the item from the front of the queue.
Overflow State: A queue may be implemented to have a bounded capacity. If the queue is full and does not contain enough space to accept an entity to be pushed, the queue is then considered to be in an overflow state.
Underflow State: The dequeue operation removes an item from the top of the queue. A dequeue operation either reveals previously concealed items or results in an empty queue, but, if the queue is empty, it goes into underflow state, which means no items are present in queue to be removed.
Efficiency of Queue
The time needed to add or delete an item is constant and independent of the number of items in the queue. So both addition and deletion can be O(1) operation.

 */
public class Queue {
	private int queSize;
	int queArray[];
	int front=0;
	int rear=-1;
	int currentSize=0;
	
	Queue(int size){
		this.queSize=size;
		this.queArray=new int[this.queSize];
	}
	/**
	 * this method adds element at the end of the queue.
	 * @param item
	 */
	public void enqueue(int item){
		if(this.isQueueFull()){
			System.out.println("overFlow unable to add item to queue");
		}
		rear++;
		if(rear==this.queSize-1){
			rear=0;
		}
		queArray[rear]=item;
		currentSize++;
		System.out.println("item is push to queue"+item);
	}
	/**
	 * this method removes an element from the top of the queue
	 */
	public void dequeue(){
		if(this.isQueueEmpty()){
			System.out.println("underflow unable to removet item from queue");
		}
		front++;
		if(front==this.queSize-1){
			System.out.println("Pop item done! Removed:"+queArray[front]);
		}else{
			System.out.println("Pop item done! Removed:"+queArray[front]);
		}
		currentSize--;
	}
	/**
	 * This method checks whether the queue is full or not
	 * @return boolean
	 */
	public boolean isQueueFull(){
		boolean status = false;
		if (currentSize == this.queSize){
			status = true;
		}
		return status;
	}
	
	/**
	 * This method checks whether the queue is empty or not
	 * @return
	 */
	public boolean isQueueEmpty(){
		boolean status = false;
		if (currentSize == 0){
			status = true;
		}
		return status;
	}


}
