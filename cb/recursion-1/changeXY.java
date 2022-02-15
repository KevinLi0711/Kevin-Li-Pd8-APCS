public String changeXY(String str) {
    if (str.length()==0) {
      return "";
    }
    String lastLetter = str.substring(str.length() - 1);
    String lastLetterRemoved = str.substring(0, str.length() - 1);
    String output = "";
    
    if (lastLetter.equals("x")) {
      output = "y";
    } else {
      output = lastLetter;
    }
    
    return changeXY(lastLetterRemoved) + output;
  }
  
