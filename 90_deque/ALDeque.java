/*
Team Three Kevins: Kevin Li, Hamim Seam, Kevin Xiao
APCS
HW91 -- Deque
2022-04-13
time spent: 1 hour
*/

import java.util.ArrayList;
import java.util.Iterator;

import javax.lang.model.element.Element;

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
      return deque.toString();
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

  public boolean contains(Object o) {
    for (Object element : deque) {
      if (element.equals(o)) {
        return true;
      }
    }
    return false;
  } 

  public boolean removeFirstOccurence(Object o) {
    return deque.remove(o);
  }

  public boolean removeLastOccurence(Object o) {
    for (int i = deque.size() - 1; i > 0; i--) {
        if (deque.get(i).equals(o)) {
            deque.remove(i);
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
