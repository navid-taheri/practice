import java.util.List;
import java.util.ArrayList;

public class SubSets{
/*
original-set = { ... }

setofsets

fuction({}, 0);

def fuction(input-set, index)
	set-one = input-set
	set-two = input-set + original-set[index]

	if index < original-set.size() -1
		function(set-one, index +1)
		function(set-two, index +1)

	if index == original-set.size() -1
		setofsets.add (set-one)
		setofsets.add (set-two)


*/

	public static void main(String[] args){

		SubSets s = new SubSets();

		s.originalSet.add(1);
		s.originalSet.add(2);
		s.originalSet.add(3);

		s.generateSubSets();

		

	}

	public void generateSubSets() {

		this.getSubSets(new ArrayList<Integer>(), 0);

		for (ArrayList<Integer> subSet: this.subSets){
			for (Integer member: subSet){
				System.out.print(member);
				System.out.print(" ");
			}
			System.out.println();
		}

	}
		
	

	ArrayList<Integer> originalSet = new ArrayList<Integer>();

	ArrayList<ArrayList<Integer>> subSets = new ArrayList<ArrayList<Integer>>();

	void getSubSets(ArrayList<Integer> inputSet, int index){		

		ArrayList<Integer> set1 = new ArrayList<Integer>();
		for (Integer member: inputSet){
			set1.add(member);
		}
	
		ArrayList<Integer> set2 = new ArrayList<Integer>();
		for (Integer member: inputSet){
			set2.add(member);
		}
		set2.add(originalSet.get(index));

		if (index < originalSet.size()-1){
			this.getSubSets(set1, index + 1);
			this.getSubSets(set2, index + 1);
		} else if (index == originalSet.size()-1){
			this.subSets.add(set1);
			this.subSets.add(set2);
		}
		
	}
	
}
