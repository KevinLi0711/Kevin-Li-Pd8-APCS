public boolean array6(int[] nums, int index) {
    if (index > nums.length - 1) {
      return false;
    }
    
    boolean x = false;
    
    if (nums[index]==6) {
      x = true;
    }
    
    return (x || array6(nums, index + 1));
    
  }
