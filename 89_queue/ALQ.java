import java.util.ArrayList;

public class ALQ<QUASAR> implements Queue<QUASAR> {
    int head = 0;
    int size = 0;
    ArrayList<QUASAR> list;

    public ALQ() {
        list = new ArrayList<QUASAR>();
    }

    public QUASAR dequeue() {
        head++;
        size--;
        return list.get(head - 1);
    }

    public QUASAR peekFront() {
        return list.get(head);
    }

    public void enqueue(QUASAR x) {
        list.add(x);
        
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public static void main( String[] args )
    {
      
      Queue<String> PirateQueue = new ALQ<String>();
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