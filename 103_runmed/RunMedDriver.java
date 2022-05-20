/**
   driver file for testing class RunMed

   (RunMed provides for calculating a running median
   of a stream of input ints)

   USAGE: Runnable as-is.
   Uncomment RunMed-specific lines below once RunMed is implemented.
   Compile, run fr same dir as RunMed.java

   to feed numbers manually:
   $ java RunMed

   to feed in prepared set:
   $ java RunMed < input.nums
   (input.nums provided; must be in same dir)

   -------------------------
   Gatekeeping Girlboss Gremlins: Lauren Lee, Kevin Li, Kevin Xiao
   APCS
   HW103 -- Erica’s Friends, Hugo, and The One in the Middle
   time spent: 1 hours
*/

import java.util.Scanner;

public class RunMedDriver
{
  public static void main( String[] args )
  {

    RunMed r = new RunMed();

    int n;
    double median = 0;
    int count = 0;
    Scanner sc = new Scanner( System.in );

    while( sc.hasNextInt() ) {
      try {
        n = sc.nextInt();
        //System.out.print("read " + n + "\n");

        count++;
        //System.out.print("this many ints have been seen: " + count + "\n");

        r.add(n);
        //System.out.println("minVals: " + r.minVals);
        //System.out.println("maxVals: " + r.maxVals);
        median = r.getMedian();
        //System.out.print("median is now " + median + "\n");
      } catch (Exception e) {
        System.err.println("BOOP! probs w yer input:\n"+e);
      }
    }

    System.out.println(median);

  }//end main

}//end class
