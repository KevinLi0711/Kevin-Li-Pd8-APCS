public int sumDigits(int n) {
    if (n == 0) {
      return 0;
    }
    
    int rightmost = n % 10;
    int rightmostRemoved = n / 10;
    
    return rightmost + sumDigits(rightmostRemoved);
  }