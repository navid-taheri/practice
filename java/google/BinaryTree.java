//    3
//   / \
//  1   4
//     / \
//    2   5

// Preorder: 1, 3, 2, 4, 5

 
import java.util.ArrayList;

public class BinaryTree{

	
	
	public static void main(String[] a){

		BinaryTree btree = new BinaryTree();

		Node three = btree.setRoot(new Node(3));
		
		Node one  = btree.add(three, 1, "left");
		Node four = btree.add(three, 4, "right");
		Node two  = btree.add(four,  2, "left");
		Node five = btree.add(four,  5, "right");

		for (Node n: btree.traversePreOrder()){
			System.out.println(n.getValue());
		}
		//System.out.println(btree.traverseInOrder());
		//System.out.println(btree.traversePostOrder());

		//System.out.println(btree.toString());

	}

	public ArrayList<Node> traversePreOrder(){
		ArrayList<Node> preorderList = new ArrayList<Node>();
		
		considerPreOrder(this.getRoot(), preorderList);
		return preorderList;
	}
		

// Consider node A (root)
	

// Does it have left branch?
	// Yes, Consider left node
// Meet the A , add to the result.
// Does it have right branch?
	// Yes, Consider right node
// Return the result

		
	 

	private void considerPreOrder (Node a, ArrayList<Node> list){
		if (a.left != null) {
			considerPreOrder(a.left, list);
		} 
		
		list.add(a);		

		if (a.right != null){
			considerPreOrder(a.right, list); 
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


	public Node add(Node parent, int a, String side){

		Node node = new Node(a);
		node.setParent(parent);

		if (side.equals("left")){
			parent.setLeft(node);
		}

		if (side.equals("right")){
			parent.setRight(node);
		}

		return node;
		
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


