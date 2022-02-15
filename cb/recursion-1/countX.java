public int countX(String str) {
    if (str.length()==0) {
      return 0;
    }
    
    String lastLetter = str.substring(str.length() - 1);
    String lastLetterRemoved = str.substring(0, str.length() - 1);
    int add = 0;
    
    if (lastLetter.equals("x")) {
      add = 1;
    }
    
    return add + countX(lastLetterRemoved);
  }
