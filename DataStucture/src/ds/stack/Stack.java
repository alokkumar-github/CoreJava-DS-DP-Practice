package ds.stack;

/*
 * A Stack is an abstract data type or collection where in Push,the addition of data elements to the collection, and Pop, the removal of data elements from the collection, are the major operations performed on the collection. The Push and Pop operations are performed only at one end of the Stack which is referred to as the 'top of the stack'.
In other words,a Stack can be simply defined as Last In First Out (LIFO) data structure,i.e.,the last element added at the top of the stack(In) should be the first element to be removed(Out) from the stack.
Stack Operations:
Push: A new entity can be added to the top of the collection.
Pop: An entity will be removed from the top of the collection.
Peek or Top: Returns the top of the entity with out removing it.
Overflow State: A stack may be implemented to have a bounded capacity. If the stack is full and does not contain enough space to accept an entity to be pushed, the stack is then considered to be in an overflow state.
Underflow State: The pop operation removes an item from the top of the stack. A pop either reveals previously concealed items or results in an empty stack, but, if the stack is empty, it goes into underflow state, which means no items are present in stack to be removed.
A stack is a restricted data structure, because only a small number of operations are performed on it. The nature of the pop and push operations also means that stack elements have a natural order. Elements are removed from the stack in the reverse order to the order of their addition. Therefore, the lower elements are those that have been on the stack the longest.
Efficiency of Stacks
In the stack, the elements can be push or pop one at a time in constant O(1) time. That is, the time is not dependent on how many items are in the stack and is therefore very quick. No comparisons or moves are necessary.

 */
/*
 * using arrayList
 */
public class Stack {

	private int[] stackArray;
	private int stackSize;
	private int top;
	
	Stack(int max){
		this.stackSize=max;
		stackArray=new int[this.stackSize];
		top=-1;
	}
	
	public void push(int r) throws Exception{
		if(this.isStackFull()){
				throw new Exception("Stack is already Full . can not add Element.");
				//System.out.println("stack is full. increase the capacity.");
				//this.increaseSize();
		}
		stackArray[++top]=r;
		System.out.println("Adding::"+r);
	}
	public int pop() throws Exception{
		if(this.isEmpty()){
				throw new Exception("Stack is Empty . can not delete the Element");
		}
		int c=stackArray[top--];
		System.out.println("Deleting Entry :::"+c);
		return c;
	}
	public int peek(){
		int c=stackArray[top];
		System.out.println("peek Element ::"+c);
		return c;
	}
	public boolean isEmpty(){
		return (top == -1);
	}
	public boolean isStackFull(){
		return (top==this.stackSize-1);
	}
	// Increase the stack size dynamically.
	public void increaseSize(){
		int[] newStarkArray=new int[this.stackSize*2];
		for(int i=0;i>this.stackSize;i++){
			newStarkArray[i]=this.stackArray[i];
		}
		this.stackArray=newStarkArray;
		this.stackSize=newStarkArray.length;
	}
	
}
