import java.util.Random;
import java.util.LinkedList;
import java.util.List;

public class BubbleSort{
	public static void main(String[] a){
		
// Create an array of integers with random values.
	int size = 10000;
	//int[] array = new int[size];
	List<Integer> list = new LinkedList<Integer>();

	Random rand = new Random();

	for (int i = 0; i < size; i++){
		//array[i] = rand.nextInt(size * 10);
		list.add(i, rand.nextInt(size * 10));
	}
	
// Show the runsorted array
	for (int i: list){	
		System.out.println(i);
	}	
	System.out.println("***********************");

// Sort the array
	long beforeSorting = System.currentTimeMillis();
	sort(list);
	long afterSorting = System.currentTimeMillis();

	for (int i: list){
		System.out.println(i);
	}


//benchmarkong of how the sort function scales, O(?) ...
	System.out.println(afterSorting - beforeSorting);

// linkedlist vs array?

	
	}

// Loop i from 1 to the size of array:
	// Loop j from 0 to size -2 of the array:
		// If array(j)>j(j+1), swap!
	static void sort (int[] array){
		for (int i = 0; i < array.length; i++ ){
		
			for (int j = 0; j < array.length -1; j++ ){
				
				if ( array[j] > array[j+1]){
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	static void sort (List<Integer> list){
		for (int i = 0; i < list.size(); i++ ){
		
			for (int j = 0; j < list.size() -1; j++ ){
				
				if ( list.get(j) > list.get(j+1)){
					int int1 = list.get(j);
					int int2 = list.get(j+1);
					list.set(j, int2);
					list.set(j+1,int1);
				}
			}
		}
	}



}
