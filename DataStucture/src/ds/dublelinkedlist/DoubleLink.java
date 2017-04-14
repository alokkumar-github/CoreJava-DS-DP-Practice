package ds.dublelinkedlist;

public class DoubleLink {
	
	Link head;
	int size;
	public void addToFirst(int d){
		if(head==null){
			head=new Link(null,d,null);
		}
		Link newLink=new Link(null, d, head);
		head.previous=newLink;
		head=newLink;
		
	}
	public static void main(String[] args) {

	}
}

class Link{
	int value;
	Link previous;
	Link next;
	Link(int value){
		this.previous=null;
		this.value=value;
		this.next=null;
	}
	Link(Link previous,int value,Link next){
		this.previous=previous;
		this.value=value;
		this.next=next;
	}
}