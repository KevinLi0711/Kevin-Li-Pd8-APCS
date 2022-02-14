public class nonsense {
  
    /**
     * Returns the ending punctuation of a string, or the empty string if there is none 
     */
    
    final static String vowels = "AEIOU";
    final static String consonants = "BCDFGHJKLMNPQRSTVWXYZ";
      
    public static String getPunctuation( String word )
    { 
      String punc = "";
      for(int i=word.length()-1; i >= 0; i--){
        if(!Character.isLetterOrDigit(word.charAt(i))){
          punc = punc + word.charAt(i);
        } else {
          return punc;
        }
      }
      return punc;
    }
    
      /**
     * Returns the word after removing any beginning or ending punctuation
     */
    public static String removePunctuation( String word )
    {
      while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
      {
        word = word.substring(1);
      }
      while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
      {
        word = word.substring(0, word.length()-1);
      }
      
      return word;
    }
    
    public static boolean hasA( String w, String letter ) 
    {
        if (w.indexOf(letter) >= 0) {
            return true;
          } else return false;
    }
    
    public static String removeVowels(String phrase) {
      String noVowels = "";
      String nextWord = "";
      //phrase += " "; 
      
      while(phrase.length() > 0 && phrase.indexOf(" ") != -1) {
        nextWord = phrase.substring(0, phrase.indexOf(" "));
        noVowels += removeVowelsHelper(nextWord);
        noVowels += " ";
        phrase = phrase.substring(phrase.indexOf(" ") + 1);
      }
      
      noVowels += removeVowelsHelper(phrase);
      
      return noVowels;
    }
    
    public static String removeVowelsHelper(String word) {
      String output = "";
      String letter;
      
      for(int i = 0; i < word.length(); i++) {
        letter = word.substring(i, i + 1);
        if(!hasA(vowels, letter.toUpperCase())) {
          output += word.charAt(i);
        }
      }
      return output;
    }
    
    public static void main(String args[]) {
      System.out.println(removeVowels("Broken Couch."));
      System.out.println(removeVowels("Super Powered!"));
      System.out.println(removeVowels("Pokemon Kobra Tiger potatoe."));
      System.out.println(removeVowels("Queue;"));
    }
  }