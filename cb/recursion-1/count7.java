public int count7(int n) {
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
