public class LLQueue<QUASAR> implements Queue<QUASAR>
{
  //instance variables
  private LLNode<QUASAR> _front, _end;
  private LLNode<QUASAR> _queue;
  private int _size;


  // default constructor creates an empty queue
  public LLQueue()
  {
     _size = 0;
     _front = _queue;
     _end = _queue;
  }


  public void enqueue( QUASAR enQVal )
  {
  LLNode<QUASAR> temp = new LLNode<QUASAR>(enQVal, null);
   if (isEmpty()){
      _queue = temp;
      _front = _queue;
      _end = _queue;
   } else{
      _end.setNext(temp);
      _end = _end.getNext();
   }
   _size ++;
  }//O(1)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public QUASAR dequeue()
  {
   QUASAR temp = _front.getCargo();
   _front = _front.getNext();
   _size --;
   return temp;
  }//O(1)


  public QUASAR peekFront()
  {
   return _front.getCargo();
  }//O(?)




  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)
 
 public class LLNode<QUASAR>{
    //instance vars
    private QUASAR _cargo;
    private LLNode _nextNode;

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
  }//end LLNode class



  //main method for testing
  public static void main( String[] args )
  {
    
    Queue<String> PirateQueue = new LLQueue<String>();
    System.out.println("\nnow enqueuing..."); 
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");
    System.out.println("\nnow testing toString()..."); 
    System.out.println( PirateQueue ); //for testing toString()...
    System.out.println("\nnow dequeuing..."); 
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n"); 
    System.out.println( PirateQueue.dequeue() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
