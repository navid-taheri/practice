import java.lang.StringBuffer;

public class LinkedList{
    
    public static void main(String[] a){
        
        benchmark(10);
        //System.out.println(n.toString());
    }
    
    static void benchmark(int m){
        long fromTime = System.currentTimeMillis();
        Node n = new Node(0);
        int i;
        for (i = 1; i < m; i++){
            
            n.append(i);
            
        }
        long toTime = System.currentTimeMillis();
        System.out.println(n);
        Node newHead = n.delete(3);
        System.out.println(n);
        System.out.println(toTime-fromTime);
    }
    
    
    
}

class Node{
    public Node(int data){
        this.data = data;
        
    }
    Node next = null;
    int data;
    
    public void append(int d){
        
        Node end = new Node(d);
        Node n = this;
        while (n.next != null){
            n = n.next;
        }
        n.next = end;
        
    }
    
    public String toString(){
        Node n = this;
        //ArrayList<String> output = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        sb.append("[ " + n.data + " ");
        //output.add("[ " + n.data + " ");
        while (n.next != null){
            n = n.next;
            sb.append(n.data+ " ");
        }
        sb.append("]");
        
        return new String (sb);
    }
    
    public Node delete(int value){
        Node n = this;
        //check if the first is the match, put the next az the head
        if (n.data == value){
            return n.next;
        }
        
        
        
        //Iterate
            //if next is the match, update next with next.next
        
        while (n.next != null){
            if (n.next.data == value){
                if (n.next.next != null){
                    n.next = n.next.next;
                } else {
                    n.next = null;
                }
            }
            n = n.next;
        }
        return n;
    }
}