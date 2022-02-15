/*
Given an array of ints, compute recursively if the array contains a 6. 
We'll use the convention of considering only the part of the array that begins at the given index. 
In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
*/

public class array6 {
    public static boolean array6(int[] nums, int index) {
        if (index > nums.length - 1) {
        return false;
        }
        
        boolean x = false;
        
        if (nums[index]==6) {
        x = true;
        }
        
        return (x || array6(nums, index + 1));
        
    }

    public static void main(String[] args) {
        int[] a1 = {1, 6, 4};
        System.out.println(array6(a1, 0));
        int[] a2 = {1, 4};
        System.out.println(array6(a2, 0));
        int[] a3 = {6};
        System.out.println(array6(a3, 0));
    }
}
