import java.util.Map;
import java.util.HashMap;

public class Anagram {
    public static void main(String[] a){
    
        String text1 = "abcd";
        String text2 = "adcb";
        
        //initiate a hashtable where key is a unique char of the first strign and the value is the occurance of the charin the sting
        Map<Character,Integer> hm = new HashMap<Character,Integer>();
        
        //translate the first string to the hash
        int i;
        for (char c: text1.toCharArray()){
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c)+1);
            } else {
                 //if one char does not exist in the hashtable the answer is no
                hm.put(c, 1);
            }
        }
        
        //iterate over the second string and decrease the value of the corresponding keys in the hashtable
        for (char c: text2.toCharArray()){
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c)-1);
            } else {
                System.out.println("Sorry man!");
                return;
            }
        }
        
        //// by the end of reading the second string if all values of hashtable is 0 then the answer is yes
        for (Character c: hm.keySet()) {
            if (hm.get(c) != 0) {
                System.out.println("Sorry man!");
                return;
            }
            
        }
        System.out.println("Yeeeeeh!");
    }
}

