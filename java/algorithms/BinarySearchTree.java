//    3
//   / \
//  1   4
//   \   \
//    2   5

// Preorder: 1,2,3,4,5

// javac BinarySearchTree.java && java -Xmx1g -Xss1g BinarySearchTree

// search 	log n
// write 	log n
// traverse	n
 
import java.util.ArrayList;
import java.util.Random;

public class BinarySearchTree{

	public static void main(String[] a){

		BinarySearchTree btree = new BinarySearchTree();
		Node three = btree.setRoot(new Node(100000));
		/*		
		int i;
		Random random = new Random();
		for (i = 0; i < 10; i++){
			btree.add(random.nextInt(10));
		}

		*/
		
		int i;
		
		long startFilling = System.currentTimeMillis();
		for (i = 0; i <= 100000; i++){
			btree.add(i*2);
		}
		long endFilling = System.currentTimeMillis();
/*
		for (Node n: btree.traverseInOrder()){
			System.out.println(n.getValue());
		}
*/
		long startSearching = System.currentTimeMillis();
		Node result = btree.search(200000, btree.getRoot());
		long endSearching = System.currentTimeMillis();

		System.out.println("Filling: 	" );
		System.out.println(endFilling - startFilling);
		System.out.println("Searching: 	" );
		System.out.println(endSearching - startSearching);

	}

	public ArrayList<Node> traverseInOrder(){
		ArrayList<Node> inorderList = new ArrayList<Node>();
		
		considerInOrder(this.getRoot(), inorderList);
		return inorderList;
	}
		
	private void considerInOrder (Node a, ArrayList<Node> list){
		if (a.left != null) {
			considerInOrder(a.left, list);
		} 
		
		list.add(a);		

		if (a.right != null){
			considerInOrder(a.right, list); 
		} 
		
		return; 		

	}


	Node root;

	public Node getRoot(){
		return this.root;	
	}

	public Node setRoot(Node root){
		this.root = root;
		return root;
	}


	public void add(int a){
		Node n = new Node(a);
		considerAdd(n, this.getRoot());
	}

// Is the new Node Less than the root?
	// Yes, Is there a left node?
		// Yes, Consider left child node
		// No, add the node as the left node
	// No, Is there a right node?
		// Yes, Consider right child node
		// No, add the node as the right node
	private void considerAdd(Node newNode, Node parent){
		if (newNode.getValue() < parent.getValue()){
			if (parent.left != null) {
				considerAdd(newNode, parent.left);	
			} else {
				parent.setLeft(newNode);			
			}
			
		} else {
			if (parent.right != null) {
				considerAdd(newNode, parent.right);	
			} else {
				parent.setRight(newNode);		
			}
		}
	}

// Is the root eqaul the query value?
//	Yes, return the root node!
// Is the root bigger than the query?
// 	Yes, Is there a left branch? 
//		Yes, consider the left child.
//			Did it succeed?
//				Yes, return result
//		No, return null
//	No, Is there a right branch?
//		Yes, consifer the right child.
//			Did it succeed?
//				Yes, return result
//		No, return null	
//


	private Node search(int i, Node parent){
		if (i == parent.getValue()){
			return parent;
		}

		if (i < parent.getValue()){
			if (parent.left != null) {
				Node result = search(i, parent.left);
				if (result != null){
					return result;				
				}	
			} else {
				return null;			
			}
			
		} else {
			if (parent.right != null) {
				Node result = search(i, parent.right);
				if (result != null){
					return result;				
				}	
			} else {
				return null;		
			}
		}
		return null;
	}
	
	public String toString(){
		return "Binary Tree: " + this.root;
	}

}

class Node {
	
	public Node(int a){
		this.value = a;
	}

	int value;
	Node parent = null;
	Node left = null;
	Node right = null;

	public int getValue(){
		return this.value;	
	}

	public void setParent(Node parent){
		this.parent = parent;	
	}

	public void setLeft(Node left){
		this.left = left;
	}

	public void setRight(Node right){
		this.right = right;
	}

	public String toString(){
		if (this.left == null && this.right == null){
			return " " + this.value + " ";
		}
		return this.value + ":[" + this.left + ", " + this.right + "]";
	}



}


