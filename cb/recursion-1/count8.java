/* 
Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, 
except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. 
Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
*/

public class count8 {
    public static int count8(int n) {
        if (n==0) {
        return 0;
        }
        
        int rightmost = n % 10;
        int rightmostRemoved = n / 10;
        int rightmostOfRemoved = rightmostRemoved % 10;
        
        int add = 0;
        
        if (rightmost == 8) {
        if (rightmostOfRemoved == 8) {
            add = 2;
        } else {
            add = 1;
        }
        }
        
        return add + count8(rightmostRemoved);
    }

    public static void main(String[] args) {
        System.out.println(count8(8));
        System.out.println(count8(818));
        System.out.println(count8(8818));
    }
}
