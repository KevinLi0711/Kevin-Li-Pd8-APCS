/**
   Clyde "Thluffy" Sinclair
   APCS
   HW20 --
   2021-10-21
   TASK:
   Implement each method without typecasting.
   xtra: harmonic mean is the reciprocal of the
   arithmetic mean of the reciprocals
 **/

public class Stats {

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

    public static double geoMean(double a, double b, double c) {
        double product = a * b * c;
        double cbrt = 1.0 / 3.0;

        System.out.println(product);
        double gm = Math.pow(product, cbrt);
        return gm;
    }
  
  
    //main method for testing functionality
    public static void main( String[] args ) {
  
    }
  
  }//end class