/***
Team Three Kevins: Kevin Xiao, Kevin Li, Hamim Seam (honorary Kevin)
APCS
HW77 -- Removal
time spent: .6 hours
Quanitity of KTS consumed: 3
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 
 DISCO:
 We actually proposed the idea of having two pointers when we were asked the question of how to deal with losing the node to the left of the list when you pass through
 the list, but we didn't know that was called a double linked list.
 Double linked list makes it so that we don't have to implement temporary variables that make the code more confusing.
 
 QCC:
 Can we make pointers point to the same block to make sublists?
 ALGO ADD:
 0. If the insertion index is 0, then add the new value at the start of the list and return
 1. Move the DLLNode "before" so that it points to the node at the index before the insertion index
 2. Move the DLLNode "after" so that it points to the node after "before"
 3. create a new node that has the inputted value, and which points to "afterIndex"
 4. Point the previous of afterIndex to the new node.
 5. make "before" point to the new node
 6. Point the previous of the new node to the before node.
 
 
 REMOVE ALGO:
 0. If the removal index is 0, then change _head so that it points to the next node
 1. Move "before" so that it points to the node at the index before the removal index
 2. Move "after" so that it points to the node after "before"
 3. Store the current value of "after" in a string called removedNode
 4. Advance "after" by 1 node
 5. make "before" point to "after"
 6. make the after node's previous point to the before node
 7. return removedNode 
 
 ***/
public class LList implements List //interface def must be in this dir
{

  //instance vars
  private DLLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _size = 0;
    _head = null;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    DLLNode temp = new DLLNode(null, newVal, _head);
    _head = temp;
    _size++;

    return true;
  }

  public void add (int index, String newVal) {
      
    if ( index < 0 || index > size() ) {
        throw new IndexOutOfBoundsException();
    }
    
    if (index == 0) {
        add(newVal);
        return;
    }

    DLLNode before = getNode(index - 1);
    DLLNode after = before.getNext();
    DLLNode addedNode;

    addedNode = new DLLNode(before, newVal, after);

    before.setNext(addedNode);
    after.setPrevious(addedNode);
    _size++;

  }

  public String remove (int index) {
    if ( index < 0 || index >= size() ) {
        throw new IndexOutOfBoundsException();
    }

    String removedNode;
    if (index == 0){
	    removedNode = _head.getCargo();
	    _head = _head.getNext();
	    _size--;
	    return removedNode;
    }

    DLLNode before = getNode(index - 1);
    DLLNode after = before.getNext();
    removedNode = "[ " + after.getCargo() + " ]";

    after = after.getNext();
    before.setNext(after);

    if (index != size() - 1) {
        after.setPrevious(before);
    }

    _size--;
    return removedNode;
  }

  public String get( int index )
  {
    if ( index < 0 || index >= size() ) {
        throw new IndexOutOfBoundsException();
    }

    DLLNode temp = getNode(index);

    return temp.getCargo();
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() ) {
        throw new IndexOutOfBoundsException();
    }

    DLLNode temp = getNode(index);
  
    return temp.setCargo(newVal);
  }

  public DLLNode getNode( int index ) {

    DLLNode temp = _head;
    for (int i = 0; i < index; i++) {
        temp = temp.getNext();
    }

    return temp;
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
    DLLNode temp = _head;

    for (int i = 0; i < _size; i++) {
        output += temp.getCargo();
        output += ", ";
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

    System.out.println( "removed item: " + james.remove(2));
    System.out.println(james);

    james.add(2, "a");
    System.out.println("added removed item back");
    System.out.println(james);

    james.add(0, "do");
    System.out.println("added item to index 0");
    System.out.println(james);

    System.out.println( "removed item: " + james.remove(0));
    System.out.println(james);

    System.out.println( "removed item: " + james.remove(3));
    System.out.println(james);

    System.out.println( "removed item: " + james.remove(2));
    System.out.println(james);

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList