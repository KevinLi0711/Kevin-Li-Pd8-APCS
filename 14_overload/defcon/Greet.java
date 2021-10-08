/*Team Duck Trio (Kevin Li, Gloria, Hamim)
APCS
HW14 -- add a second BigSib constructor that takes no parameters and modify the first so it only takes one parameter
2021-10-07
*/
/*
DISCO:
  - You can create constructors that set a default value for instance variables

QCC:
  - Why were there 2 folders for (what I assume) are the 2 variations of BigSib.java? Doesn't separating the constructors 
  into different folders defeat the purpose of overloading?
  - Also if there are 2 BigSib.java files, then which are we meant to bring a hard copy of?
  
 */
public class Greet {
    public static void main( String[] args ) {
      BigSib richard = new BigSib("Word up");
      System.out.println(richard.greet("Freshman"));

      BigSib tracy = new BigSib("Hey there");
      System.out.println(tracy.greet("sir"));
      
    } //end main()
  } //end Greet