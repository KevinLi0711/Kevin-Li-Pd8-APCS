/***
 * class Latkes
 * v1
 * SKELETON
 * Implements a stack of Strings using an encapsulated array
 * 
Team Three Kevins: Kevin Xiao, Kevin Li, Hamim Seam
APCS
HW83 -- latkes yum
2022-03-28
time spent: .5 hours

 **/

/***
    DISCO
        -We found using the end of the array as the top of the stack to be most convenient, as we can easily pop and push by adding onto or removing the last element.
	    Had we used the start of the array, we'd have to shift the rest of the elements (akin to pulling a pancake off the bottom of a stack of them).
    QCC
        - With the way we implemented push, there isn't really any pushing going on. We just treat the end of the array as the top. 
        But Nafiz on Piazza mentioned that adding to the beginning of the array would be more true to the name. 
        If we did it that way, what would be the advantage?
	    - How might one go about implementing recursive functionality to Latkes?
***/

public class Latkes
{
  private String [] _stack;
  private int _stackSize;


  //constructor
  public Latkes( int initCapacity )
  {
    _stack = new String[initCapacity];
    _stackSize = 0;
  }// O(1)


  //means of insertion
  public void push( String s )
  {
    if (isFull()){
        String[] temp = new String[_stackSize *2];
        for (int i = 0; i < _stackSize; i++){
            temp[i] = _stack[i];
        }
        _stack = temp;
    }
    _stack[_stackSize] = s;
    _stackSize++;
  }// O(1) amortized


  //means of removal
  public String pop( )
  {
    if (isEmpty()){
        return "null";
    }
     String temp = _stack[_stackSize-1];
    _stackSize--;
      return temp;
  }// O(1)


  //chk for emptiness
  public boolean isEmpty()
  {
    return (_stackSize == 0);
  }// O(1)


  //chk for fullness
  public boolean isFull()
  {
    return _stackSize == _stack.length;
  }// O(1)


  //main method for testing
  public static void main( String[] args )
  {
   

    Latkes tastyStack = new Latkes(10);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");

    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );

    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );
       /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
