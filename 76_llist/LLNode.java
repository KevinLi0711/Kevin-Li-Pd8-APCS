/*
Team Three Kevins: Kevin Xiao, Kevin Li, Hamim Seam (honorary Kevin)
APCS
HW 76- We Got a Little Ol' Convoy
2022-03-14
time spent: 0.5 hour
*/

public class LLNode{
    private String cargo;
    private LLNode cdr;
    
    public LLNode(String cargo, LLNode cdr){
      this.cargo = cargo;
      this.cdr = cdr;
    }
    
    public String getCargo(){
      return cargo;
    }
    
    public LLNode getNext(){
      return cdr;
    }
    
    public String toString(){
      return getCargo() + "," + getNext();
    }
    
    public String setCargo(String car){
      String output = this.cargo;
      this.cargo = car;
      return output;
    }
    
    public LLNode setNext(LLNode cdr){
      LLNode output = this.cdr;
      this.cdr = cdr;
      return output;
    }
 
  
  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );
    System.out.println(first.toString());

    //A naive list traversal, has side effects.... ??
    //   while( first != null ) {
    //   System.out.println( first );
    //   first = first.getNext();
    //   }


    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: The node is lost to the void of entropy and cleaned up by the Java Garbage Collector, lost to us for forever.
   
    LLNode temp = first;
    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }

  }//end main

}//end class LLNode