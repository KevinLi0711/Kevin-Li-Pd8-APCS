import java.util.ArrayList;

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
    if (!deque.isEmpty()) {
      return deque.get(0);
    }
    return null;
  }
  
  public T peekLast() {
    if (!deque.isEmpty()) {
      return deque.get(deque.size() - 1);
    }
    return null;
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

  public String toString() {
      String output = "";
      for (int i = 0; i < deque.size(); i++) {
          output += deque.get(i);
          output += ", ";
      }
      return output;
  }
  public static void main(String[] args) {
      ALDeque kevin = new ALDeque<>();

      System.out.println(kevin.peekFirst()); //null
      System.out.println(kevin.peekLast()); //null

      kevin.addFirst("hello");
      System.out.println(kevin);
      kevin.addFirst("hi");
      kevin.addLast("hey");
      System.out.println(kevin);

      System.out.println(kevin.peekFirst()); //hi
      System.out.println(kevin.peekLast()); //hey

      kevin.pollLast();
      System.out.println(kevin);
      kevin.pollFirst();
      System.out.println(kevin);

  }

  /*
  public boolean offerFirst( T element ) {
		
  }

  public boolean offerLast( T element ) {
  
  }
  */
  
}