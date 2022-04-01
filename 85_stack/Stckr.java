/***
 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static void main( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    //Stack<Object> cakes = new ALStack<Object>();
    Stack<Object> cakes = new LLStack<Object>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    cakes.push("leo");
    cakes.push(85);
    cakes.push(true);

    while (!cakes.isEmpty()) {
        System.out.println(cakes.peekTop());
	    System.out.println(cakes.pop());
    }

    for (int i = 0; i < 1000; i++) {
        cakes.push(i);
        System.out.print(cakes.peekTop());
    }

    //...

  }//end main

}//end class
