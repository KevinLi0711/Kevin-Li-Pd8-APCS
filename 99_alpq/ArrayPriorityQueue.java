/*
Gatekeeping Gaslighting Girlbosses: Kevin Xiao, Lauren Lee, Kevin Li
APCS
HW99: Some Are More Equal Than Others, Codified
2022-05-13
time spent: 0.5 hours
*/

import java.util.ArrayList;
public class ArrayPriorityQueue implements PriorityQueue{

  private ArrayList<Integer> _queue;

  public ArrayPriorityQueue(){
    _queue = new ArrayList<Integer>();
  }

  /*
  pass thru functionality woohoo
  runtime: O(n)
  */
  public void add(int a){
    _queue.add(a);
  }

  /*
  runtime: O(n)
  */
  public boolean isEmpty(){
    return _queue.isEmpty();
  }

  /*
  runtime: O(n)
  */
  public int peekMin(){
    int min = _queue.get(0);
    for(int i = 1; i<_queue.size(); i++){
      if(_queue.get(i) < min){
        min = _queue.get(i);
      }
    }
    return min;
  }

    /*
    runtime: O(n)
    */
    //ArrayList remove() method returns a boolean?
    public int removeMin(){
      return _queue.remove(_queue.indexOf(peekMin()));

    }

    public String toString(){
      return _queue.toString();
    }

    public static void main(String[] args){
      ArrayPriorityQueue poo = new ArrayPriorityQueue();
      poo.add(5);
      poo.add(3);
      poo.add(4);
      poo.add(7);
      poo.add(8);
      poo.add(1);
      System.out.println("poo: "+  poo);

      System.out.println();
      System.out.println("min: " + poo.peekMin());
      System.out.println("removeMin: " + poo.removeMin());
      System.out.println("min: " + poo.peekMin());
      System.out.println("removeMin: " + poo.removeMin());
      System.out.println("min: " + poo.peekMin());
      System.out.println("removeMin: " + poo.removeMin());

      System.out.println();
      System.out.println("poo: "+  poo);
    }
}
