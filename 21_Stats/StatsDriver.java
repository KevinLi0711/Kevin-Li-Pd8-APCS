/**
   Team KLEH: Kevin Li and Eric He
   APCS
   HW21: STAtisTically Speaking...
   2021-10-20
QCC:
    - What was the intended way for us to implement geoMean?
    - Does java have a special value for integers that's the equivalent of doubles having NaN
DISCO:
    - break; can be used to end loops
    - multiplying by 1/2 does not have the same effect as dividing by 2
    - the Math. methods only work for doubles
 **/

public class StatsDriver{
	public static void main(String args[]){
        //int mean
		System.out.println(Stats.mean(1,3));//return 2
		System.out.println(Stats.mean(1,2));//return 1
        System.out.println(Stats.mean(0,0));//return 0
        System.out.println("\n");
        //double mean
		System.out.println(Stats.mean(0.12,0.34));//return 0.23
        System.out.println("");
        //int max
		System.out.println(Stats.max(1,2));//return 2
        System.out.println(Stats.max(-1,-2));//return -1
        System.out.println(Stats.max(-2,0));//return 0
        System.out.println(Stats.max(0,0));//return 0
        System.out.println(Stats.max(-1,0,1));//return 1
        System.out.println(Stats.max(0,0,0));//return 0
        System.out.println("");
        //double max
		System.out.println(Stats.max(1.2, 2.1));//return 2.1
        System.out.println(Stats.max(-1.2, -2.1));//return -1.2
        System.out.println(Stats.max(-1.2, 0.0));//return 0.0
        System.out.println(Stats.max(-1.2, -1.2));//return -1.2
        System.out.println(Stats.max(-1.2, 0.0, 1.2));//return 1.2
        System.out.println(Stats.max(0.0, 0.0, 0.0));//return 0.0
        System.out.println("");
        //int geoMean
		System.out.println(Stats.geoMean(2,2));//return 2
		System.out.println(Stats.geoMean(2,-2));//return error (this method returns -999 when an error happens)
        System.out.println(Stats.geoMean(3, 4));//return 3
        System.out.println(Stats.geoMean(2, 8));//return 4
        System.out.println(Stats.geoMean(3, 7));//return 4
        System.out.println(Stats.geoMean(12, 4));//return 6
        System.out.println(Stats.geoMean(0, 0));//return 0
        System.out.println(Stats.geoMean(1, 2, 8));//return 2
        System.out.println(Stats.geoMean(2, 3, 5));//return 3
        System.out.println(Stats.geoMean(-2, 3, 5));//return -999
        System.out.println("");
        //double geoMean
		System.out.println(Stats.geoMean(-2.0, -2.0));//return 2.0
		System.out.println(Stats.geoMean(1.2, -2.1));//return error
        System.out.println(Stats.geoMean(2.0, -2.0, -2.0));//return 2.0

	}
}