package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	public static Node root;
	public BinaryTree() {
	this.root=null;
	}
	/*
	 * Very much sim­i­lar to find() operation.
To insert a node our first task is to find the place to insert the node.
Take cur­rent = root .
start from the cur­rent and com­pare root.data with n
if current.data is greater than n that means we need to go to the left of the root.
if current.data is smaller than n that means we need to go to the right of the root.
if any point of time cur­rent is null that means we have reached to the leaf node,
 insert your node here with the help of par­ent node. 
	 */
	public void insert(int n){
		Node newNode =new Node(n);
		if(root==null){
			root=newNode;
			return;
		}
		Node current=root;
		Node parent=null;
		while(true){
			parent=current;
			if(n<current.data){
				current=current.left;
				if(current==null){
					parent.left=newNode;
					return;
				}
			}else{
				current=current.right;
				if(current==null){
					parent.right=newNode;
					return;
				}
			}
		}
	}
	public void display(Node root){
		// these are Depth first search/traverse
		// inorder [root,left,right]
		// preorder[left,root,right]
		//postorder[left,right,root]
		if(null!=root){
			display(root.left);
			display(root.right);
			System.out.println("\t"+root.data);
		}
	}
	// prints in level order/ breadth first  
	 public static void levelOrderTraversal(Node root) {  
	  Queue<Node> queue=new LinkedList<Node>();  
	  queue.add(root);  
		  while(!queue.isEmpty()){  
		     Node tempNode=queue.poll();  
		   System.out.printf("%d ",tempNode.data);  
		   if(tempNode.left!=null)  
		    queue.add(tempNode.left);  
		   if(tempNode.right!=null)  
		    queue.add(tempNode.right);  
		  }  
	 }  

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.insert(10);bt.insert(8);bt.insert(1);bt.insert(4);
		bt.insert(6);bt.insert(2);bt.insert(11);bt.insert(9);
		bt.insert(20);bt.insert(25);bt.insert(15);bt.insert(16);
		System.out.println("OriginalTree::::");
		bt.display(root);
		System.out.println("root:::"+root.data);
		levelOrderTraversal(root);
	}

}

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data=data;
		left=null;
		this.right=null;
		
	}
}