import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ALDeque<T> implements Deque<T>{
  ArrayList<T> deque = new ArrayList<T>();
  
  public void addFirst( T element) {
    deque.add(0, element);
  }
  
  public void addLast( T element ) {
    deque.add(element);
  }

  public T removeFirst() {
    T output = deque.get(0);
    deque.remove(0);
    return output;
  }
  
  public T removeLast() {
    T output = deque.get(deque.size() - 1);
    deque.remove(deque.size() - 1);
    return output;
  }
    
  public T peekFirst() {
    return deque.get(0);
  }
  
  public T peekLast() {
    return deque.get(deque.size() - 1);
  }
  
  public int size() {
    return deque.size();
  }

  public T pollFirst() {
	if (!deque.isEmpty()) {
      return removeFirst();
    }
    return null;
  }
  
  public T pollLast() {
    if (!deque.isEmpty()) {
      return removeLast();
    }
    return null;
  }

  public T getFirst() {
    return deque.get(0);
	}
  
  public T getLast() {
    return deque.get(deque.size() - 1);
  }


  public static void main(String[] args) {
      ALDeque kevin = new ALDeque<>();

      System.out.println(kevin.peekFirst());
  }

  /*
  public boolean offerFirst( T element ) {
		
  }

  public boolean offerLast( T element ) {
  
  }
  */
  
}