/***
Team Three Kevins: Kevin Xiao, Kevin Li, Hamim Seam
APCS
HW84 -- stacks
2022-03-29
time spent: 1 hour
DISCO:
Peek method was not necessary in implementing our algorithm. Utilizing two stacks allowed us to "cancel" characters out with each other to check if they were matching.
QCC:
How to implement recursively? Is it even good to use recursion here?
How to change method to find matching for every character? Do we just have to bash it and make the computer check every character individually or can we store characters in variables?
***/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
      Latkes stack = new Latkes(s.length());
      String letter;
      String output = "";

      for (int i = 0; i < s.length(); i++) {
          letter = s.substring(i, i + 1);
          stack.push(letter);
      }

      while (!stack.isEmpty()) {
          output += stack.pop();
      }

      return output;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
      Latkes original = new Latkes(s.length());
      Latkes stack = new Latkes(s.length());
      String letter;

      for (int i = 0; i < s.length(); i++) {
          letter = s.substring(i, i + 1);
          original.push(letter);
      }

      while (!original.isEmpty()) {
          letter = original.pop();

          if (isCloser(letter)) {
              stack.push(letter);
          } else {
              if (!matching(letter, stack.pop())) {
                  return false;
              }
          }
      }

      return (stack.isEmpty());
  }

  public static boolean isCloser(String a) {
      if (a == null) {
          return false;
      }

      return (a.equals(")") || a.equals("]") || a.equals("}"));
  }

  public static boolean matching(String a, String b) {
      String ab = a + b;

      return (
        ab.equals("()") || ab.equals(")(") || 
        ab.equals("[]") || ab.equals("][") ||
        ab.equals("{}") || ab.equals("}{") );
  }


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    System.out.println(allMatched( "" ) ); //true
    System.out.println(allMatched( "}{][)(" ) ); //false
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class
