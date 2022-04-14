/*
Team Three Kevins: Kevin Li, Hamim Seam, Kevin Xiao
APCS
HW91 -- Deque
2022-04-13
time spent: 1 hour
*/

import java.util.ArrayList;
import java.util.Iterator;

public class ALDeque<T> implements Deque<T>{
  ArrayList<T> deque;

  public ALDeque() {
      deque = new ArrayList<T>();
  }
  
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

  public Iterator<T> iterator() {
    return deque.iterator();
  }

  public Iterator<T> descendingIterator() {
    ALDeque<T> temp = new ALDeque();
    for (T element : deque) {
      temp.addFirst(element);
    }
    return temp.iterator();
  }

  public boolean contains(T o) {
    for (T element : deque) {
      if (element.equals(o)) {
        return true;
      }
    }
    return false;
  } 
  /*
  public boolean offerFirst( T element ) {
		
  }

  public boolean offerLast( T element ) {
  
  }
  */
  
}
