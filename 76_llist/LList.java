/***
Team Three Kevins: Kevin Xiao, Kevin Li, Hamim Seam (honorary Kevin)
APCS
HW76 -- Creating List using nodes
time spent: .6 hours
 * class LList
 * Implements a linked list of LLNodes, each containing String data

 DISCO:
 -The list we are implementing have most of the same properties as the interface list we implemented within orderedarraylist
 -Java Garbage Collector is pacman the great incarnated.
 -Traversing this type of list is reminiscent of using Scanner on a text file
 -Getting and setting elements in an LList has an order of O(n), while they are O(1) in typical Java arrays
 
 QCC:
 -Why is this important to us?
 -Considering that retrieving a value at an array's index is O(1) while its O(n) for our LLNodes...
 Is there a more convenient way to use temp or an alternative when we need to traverse longer spans of nodes?
 (ex: a swap method would need to access to two nodes' locations)
 -How might this nodal form of a list affect using sorts and seearches?
 -When might this kind of list be more beneficial than typical Java arrays, if ever?
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