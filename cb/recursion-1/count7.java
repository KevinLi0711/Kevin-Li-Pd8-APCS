/*
Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops). 
Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
*/

public class count7 {
    public static int count7(int n) {
        if (n==0) {
        return 0;
        }
        
        int rightmost = n % 10;
        int rightmostRemoved = n / 10;
        int add = 0;
        
        if (rightmost == 7) {
        add = 1;
        } 
        
        return add + count7(rightmostRemoved);
    }

    public static void main(String[] args) {
        System.out.println(count7(717));
        System.out.println(count7(7));
        System.out.println(count7(123));
    }
}
