/*
Given an array of ints, compute recursively the number of times that the value 11 appears in the array. 
We'll use the convention of considering only the part of the array that begins at the given index. 
In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
*/

public class array11 {
    public static int array11(int[] nums, int index) {
        if (index > nums.length - 1) {
        return 0;
        }
        
        int add = 0;
        
        if (nums[index]==11) {
        add = 1;
        }
        
        return add + array11(nums, index + 1);
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 11};
        System.out.println(array11(a1, 0));
        int[] a2 = {11, 11};
        System.out.println(array11(a2, 0));
        int[] a3 = {1, 2, 3, 4};
        System.out.println(array11(a3, 0));
    }
}
