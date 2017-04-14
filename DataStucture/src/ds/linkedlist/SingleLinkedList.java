package ds.linkedlist;


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