/*
Gatekeeping Gaslighting Girlbosses: Kevin Xiao, Lauren Lee, Kevin Li
APCS
HW99: Some Are More Equal Than Others, Codified
2022-05-13
time spent: 0.5 hours
*/

public interface PriorityQueue{
    /*
    adds an item to this priority queue
    */
    public void add(int x);

    /*
    Returns true if this stack is empty, otherwise returns false.
    */
    public boolean isEmpty();

    /*
    Returns the smallest item stored in this priority queue without removing it
    */
    public int peekMin();

    /*
    Removes and returns the smallest item stored in this priority queue
    */
    public int removeMin();
}
