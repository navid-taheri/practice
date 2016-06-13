import java.util.LinkedList;
import java.util.Collections;

public class Test{

	public static void main(String[] args){
		LinkedList<Integer> n1 = new LinkedList<Integer>();
		LinkedList<Integer> n2 = new LinkedList<Integer>();

		n1.add(3);
		n1.add(1);
		n1.add(5);

		n2.add(5);
		n2.add(9);
		n2.add(2);
		
		Collections.reverse(n1);
		Collections.sort(n1);
		//LinkedList<Integer> result = add(n1, n2);
		for (int n: n1){
			System.out.print(n);
		}

		
		
	


		
	}

}
