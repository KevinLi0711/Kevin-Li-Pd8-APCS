/*
Team Three Kevins: Hamim Seam, Kevin Li, Kevin Xiao
APCS
HW87 -- Queue Linked List
2022-04-03
time spent: .5 hours

DISCO
    - If we use single linked nodes, then either add or remove has to be O(n) because we'll need to iterate
QCC
    - Why not use double linked nodes?
*/

public class NodeQueue<QUASAR> implements Queue<QUASAR>
{

  LLNode<QUASAR> _head;
  LLNode<QUASAR> _tail;
  int _size;

  public NodeQueue()
  {
    _head = null;
    _tail = null;
    _size = 0;
  }

  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public QUASAR dequeue()
  {
    if (_size <= 0) {
        throw new IndexOutOfBoundsException("List is empty");
    }

    QUASAR tmp = _head.getCargo();

    _head = _head.getNext();
    _size--;
    return tmp;
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x )
  {
    if (isEmpty()) {
        _head =  new LLNode<QUASAR>(x, null);
        _tail = _head;
        _size++;
        return;
    }  

    _tail.setNext(new LLNode<QUASAR>(x, null));
    _tail = _tail.getNext();
    _size++;
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty()
  {
    return _size <= 0;
  }

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront()
  {
    return _head.getCargo();
  }

  public String toString() {
    String output = "front -> ";
    LLNode<QUASAR> tmp = _head;
    for (int i = 0; i < _size; i++) {
        output += tmp.getCargo() + " ";
        tmp = tmp.getNext();
    }
    return output;
  }


  public static void main(String[] args) {
    NodeQueue<Object> test = new NodeQueue<Object>();
    //test.dequeue();
    test.enqueue(1);
    while (!test.isEmpty()) {
        System.out.println(test);
        System.out.println("Next element is: " + test.peekFront());
        System.out.println("Removed: " + test.dequeue());
    }
    System.out.println(test + "\n");

    NodeQueue<Object> cart = new NodeQueue<Object>();
    cart.enqueue(5);
    cart.enqueue(true);
    cart.enqueue("potatoes");

    while (!cart.isEmpty()) {
      System.out.println(cart);
      System.out.println("Next element is: " + cart.peekFront());
      System.out.println("Removed: " + cart.dequeue());
    }
    System.out.println(test + "\n");

    NodeQueue<Integer> yes = new NodeQueue<Integer>();
    yes.enqueue(5);
    yes.enqueue(7);
    yes.enqueue(1);
    yes.enqueue(1);
    yes.enqueue(9);
    int sum = 0;
    while (!yes.isEmpty()) {
        sum += yes.dequeue();
    }
    System.out.println("sum: " + sum);

  }

  public class LLNode<QUASAR> {
  //instance vars
  private QUASAR _cargo;
  private LLNode<QUASAR> _nextNode;

  // constructor
  public LLNode( QUASAR value, LLNode<QUASAR> next )
  {
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public QUASAR getCargo()
  {
    return _cargo;
  }

  public LLNode<QUASAR> getNext()
  {
    return _nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public QUASAR setCargo( QUASAR newCargo )
  {
    QUASAR foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public LLNode<QUASAR> setNext( LLNode<QUASAR> newNext )
  {
    LLNode<QUASAR> foo = getNext();
    _nextNode = newNext;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toQUASAR
  public String toString()
  {
    return _cargo.toString();
  }

  }

}
