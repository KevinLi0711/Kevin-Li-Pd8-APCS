/*
Team Three Kevins: Kevin Li, Kevin Xiao, Hamim Seam
APCS
HW81 iterator vs foreach
2022-03-23
time spent: .6 hours

DISCO 
    - to initialize an iterator, you use .iterator() on the set you want to iterate across
    - .iterator() is undefined for Integers
    - .next() is like moving up one node in a linked list
    - .iterator() is defined for List, and is part of the List interface
    - remove() removes the last element returned by next()

QCC

*/

/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    for(Integer i : L) {
        if (i.equals(key)) {
            return true;
        }
    }
    return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    Iterator<Integer> i = L.iterator();

    while (i.hasNext()) {
        if (i.next().equals(key)) {
            return true;
        }
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    List<Integer> list = new ArrayList<Integer>();

    for (Integer i : L) {
        if (i % 2 == 1) {
            list.add(i);
        }
    }

    return list;
    
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    Iterator<Integer> i = L.iterator();
    List<Integer> list = new ArrayList<Integer>();

    Integer x;

    while (i.hasNext()) {
        x = i.next();

        if (x % 2 == 1) {
            list.add(x);
        }
    }

    return list;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    Iterator<Integer> i = L.iterator();

    while (i.hasNext()) {
        if (i.next() % 2 == 0) {
            i.remove();
        }
    }
  }


  public static void main( String [] args )
  {

    //var type: List   obj type: ArrayList
    List<Integer> L = new ArrayList<Integer>();

    for( int i = 0; i < 10; i++ )
      L.add(i);


    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop
    for (Integer i : L) {
        System.out.print(i + ", ");
    }
    System.out.print("\n");

    // b) explicitly using an iterator
    Iterator i = L.iterator();
    while (i.hasNext()) {
        System.out.print(i.next() + ", ");
    }

    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
