/***
Team Three Kevins: Kevin Xiao, Kevin Li, Hamim Seam (honorary Kevin)
APCS
HW76 -- Creating List using nodes
time spent: .6 hours
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _size = 0;
    _head = new LLNode(null, null);
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode temp = _head;
    LLNode newNode = new LLNode(null, null);

    while (temp.getCargo() != null) {
        temp = temp.getNext();
    }
    
    temp.setCargo(newVal);
    temp.setNext(newNode);

    _size++;

    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode temp = _head;
    for(int i = 0; i < index; i++) {
        temp = temp.getNext();
    }

    return temp.getCargo();
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode temp = _head;
    for (int i = 0; i < index; i++) {
        temp = temp.getNext();
    }
  
    return temp.setCargo(newVal);
  }


  //return number of nodes in list
  public int size()
  {
    return _size;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    String output = "[ ";
    LLNode temp = _head;

    for (int i = 0; i < _size; i++) {
        output += temp.getCargo();
        output += " ";
        temp = temp.getNext();
    }

    output += "]";
    return output;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList