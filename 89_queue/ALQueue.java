/**
Team Three Kevins: Kevin Li, Hamim Seam, Kevin Xiao
APCS
HW89 -- Queue two ways
2022-04-11
time spent: 1 hour
DISCO
    - Dequeueing within arraylists can be done with O(1) time complexity if you simply move the head index to the right and disregard the elements of the list to the left.
    - Doing so exchanges time efficiency for memory space, as dequeued elements aren't removed.
QCC
    - Why isn't this code the same as what we did two homeworks ago?
    - Which should we priorize, time or memory space efficiency?
 **/

import java.util.ArrayList;

public class ALQueue<QUASAR> implements Queue<QUASAR> {
    int head = 0;
    ArrayList<QUASAR> list;

    public ALQueue() {
        list = new ArrayList<QUASAR>();
    }

    public QUASAR dequeue() {
        head++;
        return list.get(head - 1);
    }

    public QUASAR peekFront() {
        return list.get(head);
    }

    public void enqueue(QUASAR x) {
        list.add(x);
        
    }

    public boolean isEmpty() {
        return list.size() - head <= 0;
    }

    public static void main( String[] args )
    {
      
      Queue<String> PirateQueue = new ALQueue<String>();
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
      System.out.println("\nnow dequeuing fr empty queue...\n"); 
      System.out.println( PirateQueue.dequeue() );
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
        ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  
    }//end main
}
