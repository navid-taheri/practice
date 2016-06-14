import java.util.ArrayList;

public class Stack{
    public static void main(String[] a){
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
        System.out.println(new Integer(1000));
        
    }
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    public void push(int a){
        list.add(a);
    }
    
    public Integer pop(){
        if (list.size() >= 1) {
            Integer topValue = list.get(list.size()-1);
            list.remove(list.size()-1);
            return topValue;
        } else {
            return null;
        }
    }
      
    
    
}