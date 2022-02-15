/*
Given a non-negative int n, return the sum of its digits recursively (no loops). 
Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
*/

public class sumDigits {
    public static int sumDigits(int n) {
        if (n == 0) {
        return 0;
        }
        
        int rightmost = n % 10;
        int rightmostRemoved = n / 10;
        
        return rightmost + sumDigits(rightmostRemoved);
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(146));
        System.out.println(sumDigits(29));
        System.out.println(sumDigits(12));
    }
}