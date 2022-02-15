/* 
Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10. 
We'll use the convention of considering only the part of the array that begins at the given index. 
In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
*/

public class array220 {
    public static boolean array220(int[] nums, int index) {
        if (index > nums.length - 2) {
        return false;
        }
        
        boolean x = false;
        
        if (10 * nums[index] == nums[index + 1]) {
        x = true;
        }
        
        return (x || array220(nums, index + 1));
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 20};
        System.out.println(array220(a1, 0));
        int[] a2 = {3, 30};
        System.out.println(array220(a2, 0));
        int[] a3 = {3};
        System.out.println(array220(a3, 0));
    }
}
