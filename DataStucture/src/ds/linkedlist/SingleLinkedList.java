package ds.linkedlist;

/*
 * Like arrays, Linked List is a linear data structure. Unlike arrays, 
 * linked list elements are not stored at contiguous location; the elements are linked using pointers.
 * Why Linked List?
	Arrays can be used to store linear data of similar types, but arrays have following limitations.
	1) The size of the arrays is fixed: So we must know the upper limit on the number of elements in advance. Also, generally, 
		the allocated memory is equal to the upper limit irrespective of the usage.
	2) Inserting a new element in an array of elements is expensive, because room has to be created for the new elements and to create room existing 
		elements have to shifted.
	
	For example, in a system if we maintain a sorted list of IDs in an array id[].
	
	id[] = [1000, 1010, 1050, 2000, 2040].
	
	And if we want to insert a new ID 1005, then to maintain the sorted order, we have to move all the elements after 1000 (excluding 1000).
	Deletion is also expensive with arrays until unless some special techniques are used. For example, to delete 1010 in id[], everything after 1010 has to be moved.
	
	Advantages over arrays
	1) Dynamic size
	2) Ease of insertion/deletion
	
	Drawbacks:
	1) Random access is not allowed. We have to access elements sequentially starting from the first node. So we cannot do binary search with linked lists.
	2) Extra memory space for a pointer is required with each element of the list.
	3) Arrays have better cache locality that can make a pretty big difference in performance.
 */
public class SingleLinkedList {

	public static void main(String[] args) {
		SingleLinkedList sll=new SingleLinkedList();
		Node head = new Node(1);
		sll.add(head);
		sll.add(new Node(2));
		sll.add(new Node(3));
		sll.add(new Node(4));
		sll.add(new Node(8));
		//sll.print(head);
		//sll.print(sll.addFirst(new Node(0)));
		//sll.print(sll.deleteFirst(head));
		//sll.print(sll.reverseNode(head));
		//sll.nthNo(head, 2);
		System.out.println(sll.findMiddle().value);

	}

	Node head;
	int size;
	
	// add a Node
	public void add(Node newNode){
		if(head==null){
			head=newNode;
		}else{
			Node temp=head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=newNode; // here temp.next has same refrence as head.next since 
								// we have assign the head to temp.
		}
	}
	public Node addAtPosition(Node head){
		return null;
	}
	public void print(Node head){
		Node temp=head;
		while(temp!=null){
			System.out.println(temp.value);
			temp=temp.next;
		}
	}
	// reverse the LinkedList
	public Node reverseNode(Node head){
		Node preNode=null;
		Node nextNode;
		while(head!=null){
			nextNode=head.next;
			head.next=preNode;
			preNode=head;
			head=nextNode;
		}
		return preNode;
	}
	// find nth node in linkedList.
	public Node nthNo(Node head,int n){
		Node fistptr=head;
		Node secptr=head;
		for(int i=0;i<n;i++){
			fistptr=fistptr.next;
		}
		while(fistptr!=null){
			fistptr=fistptr.next;
			secptr=secptr.next;
		}
		return secptr;
	}
	// delete first node 
	public Node deleteFirst(Node head){
		Node temp=head;
		return head=temp.next;
	}
	public Node deleteAtPosion(Node head,int pos){
		Node preNode=null;
		Node nextNode;
		int i=0;
		while(head!=null){
			if(i==pos){
				
			}
			nextNode=head.next;
			head.next=preNode;
			
			head=nextNode;
			i++;
		}
		return preNode;
	}
	public void addtoLast(Node node){
		if(head==null){
			head=node;
		}else{
			Node temp=head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=node;
		}
		size++;
	}
	public void addToFirst(Node node){
		if(head==null){
			head=node;
		}
		node.next=head;
		head=node;
		
	}
	public void removeFirst(){
		head=head.next;
		size--;
	}
	public void removeLast(){
		Node temp=head;
		while(temp.next.next!=null){//
			temp=temp.next;
		}
		temp.next=null;
		size--;
	}
	public Node findMiddle(){
		Node firstPointer=head;
		Node secondPointer=head;
		int i=0;
		while(firstPointer!=null){
		if(i==0){
			firstPointer=firstPointer.next;
			i=1;
			if(i==1){
				firstPointer=firstPointer.next;
				secondPointer=secondPointer.next;
				i=0;
			 }
			}
		}
		return secondPointer;
	}
}
class Node{
	int value ;
	Node next;
	Node(int value){
		this.value=value;
	}
}