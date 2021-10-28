/*
Team KLEH: Kevin Li and Eric He
APCS
HW26 -- GCD Three Ways
2021-10-28
time spent: 3.5 hours

DISCO:
    - Using (a != b) as a boolean expression for starting a while loop in gcdEW was much easier than trying to get (a = b) to 
    start a loop because the while loop will break if the boolean expression is false
    - Flowcharts are really helpful in planning loops
QCC:
    - Is there a way to make a while loop run if the boolean expression returns false?
    - The fact that the assignment said gcd() was supposed to be easy is concerning because it took so much time. What was the easy way?
ALGO:

*/
public class Stats {
    public static void main( String[] args ) {
        System.out.println(gcd(8, 12));
        System.out.println(gcdER(96, 34));
        System.out.println(gcdEW(7, 35));
    }

    public static int gcd(int a, int b) {
        int count = 1;
        int gcd = 1;
        while (count < (Math.min(a, b)) ) {
            if ( ((a % count) == 0) & ((b % count) == 0) ) {
                gcd = count;
                count ++;
            } else {
                count++;
            }
        }
        return gcd;
    }

    public static int gcdER(int a, int b) {
        if (a == b) {
            return a;
        } else {
            if (a > b) {
                return gcdER(a - b, b);
            } else {
            return gcdER(b - a, a);
        }
    }
}

    public static int gcdEW(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int mean(int a, int b) {
        int avg = (a + b) / 2;
        return avg;
    }
  
    public static double mean(double a, double b) {
        double avg = (a + b) / 2;
        return avg;
    }
  
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }else return b;
    }
  
    public static double max(double a, double b) {
        if (a > b) {
            return a;
        }else return b;
    }
  
    public static int geoMean(int a, int b) {
        int product = (a * b);
        int gm = -1;
        
        for(int i = 0; i < product; i++){
            if ( (i * i) > product) {
                break;
            }
            gm = i;
        }
        if (product == 0){
            gm = 0;
        }else {
            if ( (product - ( (gm - 1) * (gm - 1))) < ( (gm * gm) - product) ){
            gm = gm - 1;
            }
        }
        if (gm < 0){
            gm = -999;
        }
        return gm;
    }
  
    public static double geoMean(double a, double b) {
        double gm = Math.sqrt(a * b);
        return gm;
    }
  
    public static int max(int a, int b, int c) {
        int maxNum = 0;
        if ((a >= b) && (a >= c)) {
            maxNum = a;
        }
        if ((b >= a) && (b >= c)) {
            maxNum = b;
        }
        if ((c >= a) && (c >= b)) {
            maxNum = c;
        }
        return maxNum;
    }
  
    public static double max(double a, double b, double c) {
        double maxNum = 0;
        if ((a >= b) && (a >= c)) {
            maxNum = a;
        }
        if ((b >= a) && (b >= c)) {
            maxNum = b;
        }
        if ((c >= a) && (c >= b)) {
            maxNum = c;
        }
        return maxNum;
    }
    /*
    public static int geoMean(int a, int b, int c) {
        int product = (a * b * c);
        int gm = -1;
        
        for(int i = 0; i < product; i++){
            if ( (i * i * i) > product) {
                break;
            }
            gm = i;
        }
        if ( (product - ( (gm - 1) * (gm - 1))) < ( (gm * gm) - product) ){
            gm = gm - 1;
        }
        if (gm < 0){
            gm = -999;
        }
        return gm;
    }
    */
    public static double geoMean(double a, double b, double c) {
        double product = a * b * c;
        double cbrt = 1.0 / 3.0;

        System.out.println(product);
        double gm = Math.pow(product, cbrt);
        return gm;
    }
  }//end class