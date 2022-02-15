public int countHi(String str) {
    if (str.length()<2) {
        return 0;
      }
      
      String lastTwoLetters = str.substring(str.length() - 2);
      String lastLetterRemoved = str.substring(0, str.length() - 1);
      int add = 0;
      
      if (lastTwoLetters.equals("hi")) {
        add = 1;
      }
      
      return add + countHi(lastLetterRemoved);
  }
  
