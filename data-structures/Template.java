public class Tempale{
    
    public static void main (String[] args){
        Foo<Integer> foo = new Foo<Integer>();
        Integer i = new Integer(3);
        foo.set(i);
        System.out.println(foo.get());
    } 
    
    
}

class Foo <K> {
    
    private K m;
    
    public void set(K m){
        this.m = m;
    }
    
    public K get(){
        return this.m;
    }
    
}