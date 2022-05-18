import java.util.ArrayList;

/**
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 * 
Gatekeeping Gaslighting Girlbosses: kevin Li, Lauren Lee, Kevin Xiao
APCS
HW102 -- Heap on Heapin On
2022-05-17
time spent: 1 hour

DISCO
    - We can use nulls to keep a balanced tree
    - We should look at helper functions before coding
QCC
    - Can we do this on a linked list?
 */

//import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
      _heap = new ArrayList<Integer>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
      return _heap.toString();
  }//O(?)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
      return (_heap.size() <= 0);
  }//O(?)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
      return _heap.get(1);
  }//O(?)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * index of parent: (p - 1) / 2
   * Add the value as a leaf by placing it at the end of the array
   * Keep swapping with the node with its parent until the node is greater than its parent
   */
  public void add( Integer addVal )
  {
      _heap.add(addVal);
      Integer index = _heap.size() - 1;

      while (addVal < _heap.get( (index - 1) / 2)) {
          swap(index, (index - 1) / 2);
          index = (index - 1) / 2;
      }
  }//O(?)


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * Set the first value in the array to the last value in the array
   * Keep swapping the node downward with the lesser child until the children are less than the node
   */
  public Integer removeMin()
  {

    if (_heap.size() == 1) {
        return _heap.remove(0);
    }

    if (_heap.size() == 0) {
        return null;
    }

      Integer returnVal = _heap.get(0);
      Integer replacement = _heap.remove(_heap.size() - 1); //replacement is last element in array
      _heap.set(0, replacement);

      Integer index = 0;
      Integer temp;
      //Integer minChild = minChildPos(index);

      while (minChildPos(index) != -1 && replacement > _heap.get(minChildPos(index)) ) {
          if (minChildPos(index) < 0 || minChildPos(index) >= _heap.size() - 1) {
              return returnVal;
          }

          temp = minChildPos(index);
          swap(index, minChildPos(index));
          index = temp;
        }

      return returnVal;

  }//O(?)


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
      int left = 2 * pos + 1;
      int right = 2 * pos + 2;
      
      if ( left >= _heap.size() && right >= _heap.size()) {
          return -1;
      }

      if (left >= _heap.size()) {
          return 2 * pos + 2;
      }

      if (right >= _heap.size()) {
        return 2 * pos + 1;
      }
      //
      if (minOf(_heap.get(left), _heap.get(right)).compareTo(_heap.get(left)) == 0 ) {
          return 2 * pos + 1;
      } else {
          return 2 * pos + 2;
      } 
  }//O(?)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {
      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
