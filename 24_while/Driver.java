/*
Gabriel Thompson and Kevin Li
APCS
HW24 - Get It While You Can
2021-10-25
time spent: .8 hours
QCC:
    - What is it about classes that makes us use .equals() to compare them instead of using == like with integer variables?
DISCO: 
    - We internalized the structure of while lopps while working on until divisible. The While loops don't run simultaneously
    - To call methods from main, those methods must be static
*/

public class Driver {

    public static void main( String[] args ) {
      Coin c1 = new Coin();
      Coin c2 = new Coin();

      untilHeads(c1, 2000);
      printSummary(c1);

      untilDivisible(c1, 2005);
      printSummary(c1);

      untilMatches(c1, c2, 8789);
      printSummary(c1);
      printSummary(c2);
    }//end main()

    public static void printSummary( Coin c ) {
        System.out.println(" --- SUMMARY --- ");
        System.out.println(" Flip count: " + c.getFlipCtr());
        System.out.println(" Heads count: " + c.getHeadsCtr());
        System.out.println(" Tails count: " + c.getTailsCtr());
        System.out.println(" Current Face: " + c.getUpFace());
        System.out.println(" Value: " + c.getValue());
        System.out.println(" --- SUMMARY --- \n");
        
    }

    public static void untilHeads( Coin c, int numHeads ) {
        int headCount = 0;
        
        while ( headCount < numHeads) {
            if (c.flip() == "heads") {
                headCount++;
            }
        }
    }

    public static void untilDivisible( Coin c, int birthYear ) {
        while (c.getFlipCtr() < 65536) {
            c.flip();
        }
        while (c.getFlipCtr() % birthYear != 0) {
            c.flip();
        }
    }

    public static void untilMatches( Coin c1, Coin c2, int matches) {
        int numMatches = 0;

        while (numMatches < matches) {
            c1.flip();
            c2.flip();
            if ( c1.equals(c2) ) {
                numMatches++;
            }
        }
        System.out.println(numMatches + " matches");
    }
}
//end class
