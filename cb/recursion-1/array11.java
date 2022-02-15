public int array11(int[] nums, int index) {
    if (index > nums.length - 1) {
      return 0;
    }
      
    int add = 0;
      
    if (nums[index]==11) {
      add = 1;
    }
      
    return add + array11(nums, index + 1);
  }
