import java.util.LinkedList;

public class Queue{

	public static void main(String[] a){
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);

System.out.println( q.dequeue() );
System.out.println( q.dequeue() );
System.out.println( q.dequeue() );
System.out.println( q.dequeue() );					
			
	}

	LinkedList<Integer> list = new LinkedList<Integer>();

	public void enqueue(int a){
		list.add(a);
	}

	public Integer dequeue(){
		Integer returnValue = null;
		if (list.size() >= 1){
			returnValue = list.get(0);
			list.remove(0);
		}
		return returnValue;
	}
}
