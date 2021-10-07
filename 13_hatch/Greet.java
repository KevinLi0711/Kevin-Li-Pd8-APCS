/*Team GTKL (Kevin Li + Kirby and Gabriel Thompson + Iggy)
APCS
HW13 -- add a constructor to class BigSib
2021-10-06
*/
/*
DISCO:
  - You can make a constructor by defining a function without a return type, with the same arguments that you 
  want to be the arguments in the class instance declaration. Inside of this constructor, you write all of the
  things you want the class to do when an instance is created (typically setting variables to the arguments of 
  the constructor)
  - You need to create instance variables and then set those instance variables equal to the parameters 
  required for your constructor
  - You can redefine a class variable by setting it to be a new instance of the class
  - We need to change the instance variable from a static one to a non-static one in order for the constructor 
  to work

QCC:
  - Why don't constructors have return types (or anything else besides protection and name?)
  - When you create a new class constructor, do you need to redefine every variable?
 */
public class Greet {
    public static void main( String[] args ) {
      BigSib richard = new BigSib("Word up", "freshman");
      System.out.println(richard.greet());

      richard = new BigSib("Salutations", "Dr. Spaceman");
      System.out.println(richard.greet());

      richard = new BigSib("Hey ya", "Kong Fooey");
      System.out.println(richard.greet());
      
      richard = new BigSib("Sup", "mom");
      System.out.println(richard.greet());
    } //end main()
  } //end Greet