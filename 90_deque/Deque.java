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

    /*
    public boolean offerFirst( T element );
    public boolean offerLast( T element );
    */

}