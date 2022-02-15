public boolean array220(int[] nums, int index) {
    if (index > nums.length - 2) {
      return false;
    }
      
    boolean x = false;
      
    if (10 * nums[index] == nums[index + 1]) {
      x = true;
    }
      
    return (x || array220(nums, index + 1));
  }
