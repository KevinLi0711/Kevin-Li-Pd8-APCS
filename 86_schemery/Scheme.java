/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Split the string by whitespaces, so you get an array of all non-whitespace characters
 *   2. Push the characters, starting from the end of the array to maintain order
 *   3. If the character is an open parens, then evaluate everything between that open parens and the topmost closed parens
 *   4. Pop all the characters that were evaluated, and push the resulting string
 *   5. After all the characters in the array have been pushed, return the top value 
 *
 * STACK OF CHOICE: LLStack by mykolyk from the library
 * b/c when we were deciding, we thought the structure of LinkedList, which uses nodes, might be somehow helpful in separating operations. 
 * it wasn't. At least, not for our algo
 * 
Team Three Kevin: Kevin Xiao, Hamim Seam, Kevin Li
APCS
HW86 -- Return to scheme
2022-03-31
time spent: .8 hours
 **/

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/

  static Stack<String> _stack = new LLStack<String>();

  public static String evaluate( String expr )
  {
    String[] chars = expr.split(" ");
    for (int i = chars.length - 1; i >= 0; i--) {
        if (chars[i].equals("(")) {
            _stack.push(unload( ops(_stack.pop()), _stack ));
        } else {
            _stack.push(chars[i]);
        }
    }

    return _stack.pop();

  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    Integer result = Integer.parseInt(numbers.pop());

    if (op == 1) {
        while (!numbers.peekTop().equals(")")) {
            result += Integer.parseInt(numbers.pop());
        }
    }

    if (op == 2) {
        while (!numbers.peekTop().equals(")")) {
            result -= Integer.parseInt(numbers.pop());
        }
    }

    if (op == 3) {
        while (!numbers.peekTop().equals(")")) {
            result *= Integer.parseInt(numbers.pop());
        }
    }

    numbers.pop(); //remove close parens
    return result.toString();
  }//end unload()

  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }
  */

  public static int ops(String op) {
    if (op.equals("+")) {
        return 1;
    }
    if (op.equals("-")) {
        return 2;
    }
    if (op.equals("*")) {
        return 3;
    }
    return 0;
  }

  //main method for testing
  public static void main( String[] args )
  {

      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
