/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/


public class RQueue<SWASHBUCKLE> implements Queue<SWASHBUCKLE>
{
  //instance variables
  private LLNode<SWASHBUCKLE> _front, _end;
  private int _size;
  private int randomIndex;

  // default constructor creates an empty queue
  public RQueue()
  {
    _front = null;
    _end = null;
    _size = 0;
  }


  public void enqueue( SWASHBUCKLE enQVal )
  {
    if (isEmpty()) {
        _front = new LLNode<SWASHBUCKLE>(enQVal, null);
        _end = _front;
        _size++;
        return;
    }

    _end.setNext(new LLNode<SWASHBUCKLE>(enQVal, null));
    _end = _end.getNext();
    _size++;
    randomIndex = (int)(Math.random() * _size);
    //sample();

  }//O(?)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public SWASHBUCKLE dequeue()
  {
    LLNode<SWASHBUCKLE> temp = _front;
    SWASHBUCKLE output;

    //if the chosen index is the front of the queue, then just move the front pointer
    if (randomIndex == 0) {
        output = _front.getCargo();
        _front = _front.getNext();
    } else {
        //iterate through the list until you reach the index before the chosen index
        for (int i = 0; i < randomIndex - 1; i++) {
            temp = temp.getNext();
        }

        //store the cargo of the next node as the output
        output = temp.getNext().getCargo();
        //change the pointer so it skips over the node at the chosen index
        temp.setNext(temp.getNext().getNext());
    }

    //if the chosen index is the end, update the end pointer
    if (randomIndex == _size - 1) {
        _end = temp.getNext();
    }

    //update size and the random index
    randomIndex = (int)(Math.random() * _size);
    _size--;
    
    return output;
  }//O(?)


  public SWASHBUCKLE peekFront()
  {
    LLNode<SWASHBUCKLE> temp = _front;
    for (int i = 0; i < randomIndex; i++) {
        temp = temp.getNext();
    }
    return temp.getCargo();
  }//O(?)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   1. Place each node into an array
   *   2. Swap each node with a node at a random index
   *   3. Reconstruct the queue with the nodes in the same order as in the array
   *   4. Update the _front and _end pointers
   **/
  public void sample ()
  {
    LLNode<SWASHBUCKLE>[] nodes = new LLNode[_size];
    LLNode<SWASHBUCKLE> temp = _front;
    LLNode<SWASHBUCKLE> swapTemp;
    int swapIndex;
    
    //place the nodes into an array
    for (int i = 0; i < _size; i++) {
        nodes[i] = temp;
        temp = temp.getNext();
    }

    //swap nodes to randomize order of nodes in array
    for (int i = 0; i < _size; i++) {
        swapIndex = (int)(Math.random() * _size);
        swapTemp = nodes[i];
        nodes[i] = nodes[swapIndex];
        nodes[swapIndex] = swapTemp;
    }

    //reconstruct the queue
    for (int i = 0; i < _size - 1; i++) {
        nodes[i].setNext(nodes[i+1]);
    }
    //make the last element point to null
    nodes[_size - 1].setNext(null);

    //update pointers
    _front = nodes[0];
    _end = nodes[_size - 1];

  }//O(?)

  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String output = "<- front ";
    LLNode<SWASHBUCKLE> tmp = _front;
    for (int i = 0; i < _size; i++) {
        output = tmp.getCargo() + " " + output;
        tmp = tmp.getNext();
    }
    return output;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {
    
    Queue<String> PirateQueue = new RQueue<String>();

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
    System.out.println( "predicted: " + PirateQueue.peekFront() + " \n " + PirateQueue.dequeue() );
    System.out.println( "predicted: " + PirateQueue.peekFront() + " \n " + PirateQueue.dequeue() );
    System.out.println( "predicted: " + PirateQueue.peekFront() + " \n " + PirateQueue.dequeue() );
    System.out.println( "predicted: " + PirateQueue.peekFront() + " \n " + PirateQueue.dequeue() );
    System.out.println( "predicted: " + PirateQueue.peekFront() + " \n " + PirateQueue.dequeue() );
    System.out.println( "predicted: " + PirateQueue.peekFront() + " \n " + PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n"); 
    System.out.println( PirateQueue.dequeue() );

    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
