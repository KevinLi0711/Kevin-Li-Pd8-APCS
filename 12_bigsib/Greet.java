/*Kevin Li and Gabriel Thompson
APCS
HW12 -- Create a BigSib class that you can then use to create BigSibs with individual greetings
2021-10-5
DISCO:
 - In order to declare a variable in a class, and have it be accessed by functions,
   it must be declared as a 'static' variable, denoted by writing 'static' before
   its declarations (e.g. 'static String helloMsg')
 - To create an instance of a class in Java, you need to use a constructor, and
   this can be done by writing '[CLASS NAME] [INSTANCE NAME] = new [CLASS NAME]();'
   This will create an instance of the class under the variable name [INSTANCE NAME]
 - You can give instances of classes names, instead of just referring to them
   literally through dot notation.
QCC:
 - What does 'static' mean, in both the context of defining variables and defining
   functions?
 - In the same way that you can call functions in instances of classes, can you
   retrieve of and set variables?
 - Why are files that are meant to be ran as stand-alone programs rather than
   utilized as classes all written with the same 'public class' statements that
   files written for classes have? Are all Java programs classes, the same way that
   classes like BigSib are? Is this what Java means by their .class files?
/** */

public class Greet {
    public static void main( String[] args ) {
      String greeting;
  
      BigSib richard = new BigSib();

      richard.setHelloMsg("Word up");
      greeting = richard.greet("freshman");
      System.out.println(greeting);

      richard.setHelloMsg("Salutations");
      greeting = richard.greet("Dr. Spaceman");
      System.out.println(greeting);

      richard.setHelloMsg("Hey ya");
      greeting = richard.greet("Kong Fooey");
      System.out.println(greeting);

      richard.setHelloMsg("Sup");
      greeting = richard.greet("mom");
      System.out.println(greeting);
      
    } //end main()
  } //end Greet