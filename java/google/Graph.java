import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeSet;
import java.util.HashSet;

/*
Create an instance of the graph
create nodes
create relations 
getRoute between two nodes

TODO: better use of collections api 
TODO: BFS
TODO: DFS
TODO: Template Graph?
TODO: Directed Graph



*/
public class Graph{

	public static void main(String[] args){

		Graph graph = new Graph();

		Node a = graph.addNode("A");
		Node b = graph.addNode("B");
		Node c = graph.addNode("C");
		Node d = graph.addNode("D");
		Node e = graph.addNode("E");
		Node f = graph.addNode("F");
		Node g = graph.addNode("G");
		Node h = graph.addNode("H");

		graph.addVertex(a,d);
		graph.addVertex(a,g);
		graph.addVertex(a,h);
		graph.addVertex(b,c);
		graph.addVertex(b,f);
		graph.addVertex(c,h);
		graph.addVertex(c,g);
		graph.addVertex(e,h);
		graph.addVertex(e,f);
		
		//List<Node> route = graph.getRouteDFS(a,e);

		List<Node> route = graph.traverseBFS(a);
		
		if (route != null) {
			for (Node node: route){
				System.out.print(node.name + " ");
			}
		} else {
			System.out.print("Sorry, No route! afaik");
		}
		
		//System.out.println(graph);

	}

	public List<Node> getRouteDFS(Node start, Node dest){

		LinkedList<Node> stack = new LinkedList<Node>();
		HashSet<String> metNodes = new HashSet<String>();
		
		Node node;
		stack.push(start);

		while (stack.size() != 0){

			node = stack.peek();
			metNodes.add(node.name);
			boolean findChild = false;
			for (Node child: node.neighbors){
				if (! metNodes.contains(child.name)) {
					stack.push(child);
					if (child.name.equals(dest.name)){
						return stack;
					}
					findChild = true;
					break;
				}
			}
			if  (! findChild) {
				stack.pop();	
			}
		}	
		return null;
	} 

	public List<Node> traverseBFS(Node a){
		
		LinkedList<Node> queue = new LinkedList<Node>();
		List<Node> route = new LinkedList<Node>();
		queue.add(a);

		while (queue.size() != 0){
			Node node = queue.remove();
			route.add(node);
			for (Node child: node.neighbors){
				if (! queue.contains (child) && ! route.contains (child)){
					queue.add(child);
				}
			}
		}
		return route;
	}

	List<Node> nodes = new ArrayList<Node>();
	
	public Node addNode(String name){
		Node node = new Node(name);
		nodes.add(node);
		return node;
	}

	public void addVertex(Node a, Node b){
		a.addNeighbor(b);
		b.addNeighbor(a);
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		for (Node n: nodes){
			System.out.println(n);
		}
		return sb.toString();
	}

}

class Node implements Comparable<Node>{
	
	TreeSet<Node> neighbors = new TreeSet<Node>();		
	String name;

	public Node(String name){
		this.name = name;
	}


	public void addNeighbor (Node neighbor){
		this.neighbors.add(neighbor);
	}


	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(this.name + ": ");
		for (Node neighbor: neighbors){	
			sb.append(neighbor.name + " ");
		}
		return sb.toString();
	}


	@Override
	public int compareTo(Node node){
		return this.name.compareTo(node.name);
	}


}





