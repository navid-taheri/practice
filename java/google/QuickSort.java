
public class QuickSort{
	public static void main(String[] a){

// Create a random array:
		int[] array = new int[] {3,7,8,5,2,1,9,5,4};

		int[] result = sort(array);

		for (int i: result){
			System.out.println(i);
		}
	}

/*
Sort function (input: array to be sorted) retun sortedArray
	if length is one return array
	Set the last index as the pivot index
	Loop forward on array indexes:
		if element i is greater than pivot: 
			reserve the pivot value
			move the element i to the pivot place 
			if pivot is next to i:	
				put pivot value in place of i
			else:
				put pivots nieghbour in place of i
				move pivot index one cell back
	

	split array: array1, pivot value, array2
		if array1 size is > 1, array1 = sort(array1)
		if array2 size is > 1, array2 = sort(array2)

	return concat: array1 + pivot value + array2

*/
	static int[] sort(int[] array){
		if (array.length == 1)
			return array;

		int pivotIndex = array.length - 1;
		int pivotValue = array[pivotIndex];
		
		for (int i = 0; i < array.length; i++){
			if (array[i] > pivotValue){
				array[pivotIndex] = array[i];
				if (pivotIndex == i+1) {
					array[pivotIndex] = array[i];
					array[i] = pivotValue;
					pivotIndex = i;

				} else if (pivotIndex > i+1) {
					array[pivotIndex] = array[i];
					array[i] = array[pivotIndex -1];

					array[pivotIndex -1] = pivotValue;
					pivotIndex = pivotIndex -1;
					
					
				}
				 
			}
					
		}

		int size = array.length;

		if (size <= 2) {
			return array;
		} 

		int array1Size = pivotIndex; 
		int[] array1 = new int[array1Size];
		for (int i = 0; i < array1Size; i++){
			array1[i] = array[i];
		}
		if (array1Size > 1){
			array1 = sort(array1);
		}
		
		int array2Size = array.length - pivotIndex + 1;  
		int[] array2 = new int[array2Size];
		for (int i = 0 ; i < array2Size; i++){
			array2[i] = array[i+pivotIndex+1];
		}
		if (array2Size > 1){
			array1 = sort(array);
		}

		int[] result = new int[size];
		int index = 0;

		for (int i = 0; i < array1.length; i++){
			result[index] = array1[i];
			index++;
		}

		result[index] = pivotValue;
		index ++;

		for (int i = 0; i < array2.length; i++){
			result[index] = array2[i];
			index++;
		}

		return result;

	}


} 
