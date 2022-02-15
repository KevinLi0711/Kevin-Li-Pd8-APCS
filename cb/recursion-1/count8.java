public int count8(int n) {
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
