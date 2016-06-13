// 5 6 7 8 9 10 11 12 13 14 15 1 2 3 4

import java.util.ArrayList;

public class BinarySearch{

	/*
		Create an array and add items in order
		Search for an item and return the corresponding index 

	*/

	public static void main(String[] args){

		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for (int i = 40; i < 60; i++){
			array.add(i);
		}

		//for (Integer i: array) {
			//System.out.println(i);
		//}
		
		//System.out.println( search(array, 0, array.size()-1, 57));
		System.out.println( isearch(array, 57));
		
		
	}

	static int isearch (ArrayList<Integer> array, int query){
		int from = 0;
		int till = array.size()-1;
		int m;
		while (from != till){
			m = (from + till)/2;
			if (array.get(m) == query){
				return m;
			}
			else if (array.get(m) < query){
				from = m;
			}
			else if (array.get(m) > query){
				till = m;
			}
		}
		return -1;
	}

	static int search (ArrayList<Integer> array, int from, int till, int query){
		if (from == till){
			return -1;
		}

		int m = (from + till)/2;
		
		if (array.get(m) == query){
			return m;
		} 
		else if (array.get(m) < query){
			return search(array, m, till, query);
		}
		else if (array.get(m) > query){
			return search(array, from, m, query);
		}				
		return -1;
	}


}
