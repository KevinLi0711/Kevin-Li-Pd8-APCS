/*
Team Three Kevins: Kevin Li, Hamim Seam, Kevin Xiao
APCS
HW91 -- Deque
2022-04-13
time spent: 1 hour
*/

import java.util.Iterator;

public class MRKPirateBae {
    
    public static void main(String[] args) {
      ALDeque kevin = new ALDeque<>();

      System.out.println(kevin.peekFirst()); //null
      System.out.println(kevin.peekLast()); //null
      System.out.print("\n");

      kevin.addFirst("hello");
      System.out.println(kevin);
      kevin.addFirst("hi");
      kevin.addLast("hey");
      System.out.println(kevin);
      System.out.print("\n");

      System.out.println(kevin.peekFirst()); //hi
      System.out.println(kevin.peekLast()); //hey

      kevin.pollLast();
      System.out.println(kevin);
      kevin.pollFirst();
      System.out.println(kevin);
      System.out.print("\n");

      ALDeque kevin2 = new ALDeque<String>();

      kevin2.addFirst("a");
      kevin2.addFirst("b");
      kevin2.addFirst("c");

      Iterator<String> itr = kevin2.iterator();

      while (itr.hasNext()) {
        System.out.println(itr.next());
      }

      System.out.print("\n");
      ALDeque kevin3 = new ALDeque<String>();

      kevin3.addFirst("a");
      kevin3.addFirst("b");
      kevin3.addFirst("c");

      Iterator<String> itr2 = kevin3.descendingIterator();

      while (itr2.hasNext()) {
        System.out.println(itr2.next());
      }

      System.out.println(kevin3.contains("b"));
      System.out.println("\n");

      ALDeque kevin4 = new ALDeque<Integer>();

      kevin4.addLast(3);
      kevin4.addLast(2);
      kevin4.addLast(3);
      kevin4.addLast(4);
      kevin4.addLast(3);
      kevin4.addLast(5);

      System.out.println(kevin4);
      kevin4.removeFirstOccurence(3);
      System.out.println(kevin4);
      kevin4.removeLastOccurence(3);
      System.out.println(kevin4);

      }
}
