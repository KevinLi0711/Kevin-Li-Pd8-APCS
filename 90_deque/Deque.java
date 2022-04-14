/*
Team Three Kevins: Kevin Li, Hamim Seam, Kevin Xiao
APCS
HW91 -- Deque
2022-04-13
time spent: 1 hour
*/

import java.util.Iterator;

public interface Deque<T> {
    public void addFirst( T element );
    public void addLast( T element );

    public T removeFirst();
    public T removeLast();

    public T peekFirst();
    public T peekLast();

    public int size();

    public T pollFirst();
    public T pollLast();

    public T getFirst();
    public T getLast();

    public Iterator<T> iterator();
    public Iterator<T> descendingIterator();

    public boolean contains(Object o);

    public boolean removeFirstOccurence(Object o);
    public boolean removeLastOccurence(Object o);

    /*
    public boolean remove(Object o);
    public boolean offerFirst( T element );
    public boolean offerLast( T element );
    */

}
