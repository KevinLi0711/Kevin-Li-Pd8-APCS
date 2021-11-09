package v0;
/***
 * Team KLEH: Kevin Li and Eric He
 * APCS
 * HW31 -- Counting vowels using methods built from .indexOf()
 * 2021-11-04
 * time spent: .5 hrs
 *
 * DISCO: 
 *  - .indexOf() searches for a substring within a string and gives the position of the first character of the substring
 *  - Position 0 for .indexOf() corresponds to the first character in the string. The second character has a position of 1
 *  - Keyword final prevents you from assigning a value to that method / variable. If you try to compile, you get the error:
 *    cannot assign a value to final variable <varName>
 * 
 * QCC:
 *  - 
 * 
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
  //Q: How does this initialization make your life easier?
  //A: We can reference VOWELS in isAVowel. By checking if the inputted letter is included in VOWELS, we can easily check if said letter is a vowel
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) 
  {
      if (w.indexOf(letter) >= 0) {
          return true;
        } else return false;
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
      if (hasA(VOWELS, letter)) {
          return true;
      } else return false;
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
  {
      int vowelCount = 0;
      for(int letterNum = 1; letterNum <= w.length(); letterNum++) {
          if (isAVowel(w.substring(letterNum, letterNum + 1))) {
              vowelCount++;
          }
      }
      return vowelCount;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ) 
  {
      if (countVowels(w) > 0) {
          return true;
      } else return false;
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) 
  {
    String vowels = "";
    for(int letterNum = 1; letterNum < w.length(); letterNum++) {
        if (isAVowel(w.substring(letterNum, letterNum + 1))) {
            vowels = vowels + w.substring(letterNum, letterNum + 1);
        }
    }
    return vowels;
  }


  public static void main( String[] args ) 
  {
    for(String word : args) {
      System.out.println("hasAVowel \t" + hasAVowel(word));
      System.out.println("allVowels \t" + allVowels(word));
      System.out.println("countVowels \t" + countVowels(word));
    }
  }//end main()

}//end class Pig