/*
Team Three Kevins: Kevin Xiao, Kevin Li, Hamim Seam (honorary Kevin)
APCS
HW 76- We Got a Little Ol' Convoy
2022-03-14
time spent: 0.5 hour
*/

public class DLLNode{
    private DLLNode previous;
    private String cargo;
    private DLLNode next;
    
    public DLLNode(DLLNode previous, String cargo, DLLNode cdr){
      this.previous = previous;
      this.cargo = cargo;
      this.next = cdr;
    }
    
    public String getCargo(){
      return cargo;
    }
    
    public DLLNode getPrevious(){
      return previous;
    }

    public DLLNode getNext(){
      return next;
    }
    
    public String setCargo(String car){
      String output = this.cargo;
      this.cargo = car;
      return output;
    }

    public DLLNode setPrevious(DLLNode previous){
      DLLNode output = this.previous;
      this.previous = previous;
      return output;
    }
    
    public DLLNode setNext(DLLNode next){
      DLLNode output = this.next;
      this.next = next;
      return output;
    }

    public String toString(){
        return getCargo() + ", " + getNext();
    }
 
  
  //main method for testing
  public static void main( String[] args )
  {

    //Create a node
    DLLNode first = new DLLNode( null, "cat", null );

    //Create a new node after the first
    first.setNext( new DLLNode( first, "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( first.getNext(), "cow", null ) );
    System.out.println(first.toString());

    //A naive list traversal, has side effects.... ??
    //   while( first != null ) {
    //   System.out.println( first );
    //   first = first.getNext();
    //   }


    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: The node is lost to the void of entropy and cleaned up by the Java Garbage Collector, lost to us for forever.
   
    DLLNode temp = first;
    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }

  }//end main

}//end class LLNode