import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Random;

public class Anagram2 {
    
    public static void main(String[] a){
        
        System.out.println(check(gen(10), gen(10)));
        System.out.println(check(gen(100), gen(100)));
        System.out.println(check(gen(1000), gen(1000)));
        System.out.println(check(gen(100000), gen(10000)));
       
        
    }
    
    
    static long check (String text1, String text2){
        
        long fromTime = System.currentTimeMillis();
        
        
         if (sort(text1).equals(sort(text2))){
            System.out.println("Yeeeeh :)");
        } else {
            System.out.println("Sorry Man :(");
        }
        
        long toTime = System.currentTimeMillis();
        
        return toTime-fromTime;
        
    }
    
    
    static String gen(int length){
        
        Random random = new Random();
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i <= length; i++){
            char nextChar = (char)('a'+random.nextInt(26));
            list.add(nextChar);
        }
        char[] charArray = new char [list.size()];
        
        int i = 0;
        for (Character c: list){
            charArray[i++] = c;
        }
        return new String(charArray);
        
    }
    
    private static String sort(String text){
        
        char[] charArray = text.toCharArray();
        TreeSet<Character> treeSet = new TreeSet<Character>();
        
        for (char c: charArray){
            treeSet.add(c);
        }
        
        String orderedText = "";
        
        for (Character c: treeSet){
            orderedText += c;
        }
        
        return orderedText;
    }
    
}