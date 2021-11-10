package v0;
/***
/*
Team KLEH: John Gupta-She, Kevin Li, Eric He
APCS
L00 -- Etterbay Odingcay Oughtray Ollaborationcay
2021-11-9
time spent:.5 hours on v5, 5 hours total
DISCO: Helper functions are helpful, keeping things organized helps a ton!
QCC: N/A

HOW WE UTILIZED SCANNER DEMO (v4): Experimented with the format of demoscanner.java
WHAT CAUSES RUNTIME ERROR IN THE SCANNER DEMO: the second System.out.println. When it is removed, the error disappears with it.
Our guess is that running System.out.println( sc.next() ); once clears the queue and either leaves nothing for the second line to print out

NEW IN v1: Combined oink code with given skeletons
NEW IN v2: Made engToPig consider if y is a vowel when translating
NEW IN v3: Made engToPig capitalize the first letter of output if the first letter of input was capital
NEW IN v4: Added scanner and created method that can translate sentences
NEW IN v5: Accounts for punctuation in phrases

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