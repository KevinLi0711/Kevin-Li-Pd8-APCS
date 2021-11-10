/*
Team KLEH: John Gupta-She, Kevin Li, Eric He
APCS
L00 -- Etterbay Odingcay Oughtray Ollaborationcay
2021-11-9
time spent:.5 hours on v5, 5 hours total
DISCO: 
    - Helper functions are helpful, keeping things organized helps a ton! 
    - < and > are redirectors, and they can direct text in one file to be process by a scanner
QCC: N/A

HOW WE UTILIZED SCANNER DEMO (v4): Experimented with the format of demoscanner.java
WHAT CAUSES RUNTIME ERROR IN THE SCANNER DEMO: the second System.out.println. When it is removed, the error disappears with it.
Our guess is that running System.out.println( sc.next() ); once clears the queue and either leaves nothing for the second line to print out

NEW IN v1: Combined oink code with given skeletons
NEW IN v2: Made engToPig consider if y is a vowel when translating
NEW IN v3: Made engToPig capitalize the first letter of output if the first letter of input was capital
NEW IN v4: Added scanner and created method that can translate sentences
NEW IN v5: Accounts for punctuation in phrases
*/

package v5;
import java.util.Scanner;

public class Pig {
    private static final String VOWELS = "aeiouy";
    private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PUNCS = ".,:;!?";
//Uppercase related methods =====================================
    public static boolean isUpperCase( String letter ) {
        return CAPS.indexOf( letter ) != -1;
    }

    public static boolean beginsWithUpper( String w ) {
        return isUpperCase( w.substring(0,1) );
    }

    public static String capitalize( String w ) {
        return ( w.substring(0, 1).toUpperCase() + w.substring(1) );
    }
//Punctuation related methods =====================================
    public static boolean isPunc( String symbol ) {
        return PUNCS.indexOf( symbol ) != -1;
    }

    public static boolean hasPunc( String w ) {
        if (PUNCS.indexOf(w.substring(w.length()-1)) == -1) {
          return false;
        }
        else {
          return true;
        }
    }

    public static String allPunc( String w ) {
        String ans = "";
        for( int i = 0; i < w.length(); i++ ) {
          if ( isPunc( w.substring(i,i+1) ) )
          ans += w.substring( i, i+1 );
          }
        return ans;
    }

    public static int countPunc( String w ) {
        return allPunc(w).length();
    }
//Vowel related methods =====================================
    public static boolean isAVowel( String letter ) {
        return VOWELS.indexOf( letter.toLowerCase() ) != -1;
    }

    public static boolean hasAVowel( String w ) {
        return countVowels(w) > 0;
    }

    public static String allVowels( String w )
    {
      String vowels = "";
      for(int letterNum = 0; letterNum < w.length(); letterNum++) {
          if (isAVowel(w.substring(letterNum, letterNum + 1))) {
              vowels = vowels + w.substring(letterNum, letterNum + 1);
          }
      }
      return vowels;
    }

    public static int countVowels( String w ) {
        return allVowels(w).length();
    }

    public static boolean hasA( String w, String letter ) {
        return w.indexOf( letter ) != -1;
    }

    public static boolean hasNonYVowel( String w ) {
        String x = w.toLowerCase();
        return ( hasA(x, "a") || hasA(x, "e") || hasA(x, "i") || hasA(x, "o") || hasA(x, "u"));
    }

    public static boolean yIsVowel( String w ) {
        return ( hasAVowel(w) && !(hasNonYVowel(w)) );
    }

    public static String firstVowel( String w ) {
        if ( hasAVowel(w) ) {
            return (allVowels(w).substring(0, 1));
        }
        else return "";
    }

    public static String firstNonYVowel( String w ) {
        String x = allVowels(w);

        for (int i = 0; i < countVowels(w); i++) {
            if (!x.substring(i, i + 1).toLowerCase().equals("y") && isAVowel(x.substring(i, i + 1))) {
                return x.substring(i, i + 1);
            }
        }
        return "";
    }

    public static boolean beginsWithVowel( String w ) {
        return isAVowel( w.substring(0,1) );
    }

    public static boolean isEmptyStr( String w ) {

        for(int letterNum = 0; letterNum < w.length(); letterNum++) {
            if (!((w.substring(letterNum, letterNum + 1).equals(" ")))) {
                return false;
            }
        }
        return true;
    }

    public static String engToPig( String w ) {

        if (isEmptyStr(w)) {
            return "";
        }

        if (hasPunc(w)) {
          return engToPig(w.substring(0, w.length()-1)) + w.substring(w.length()-1);
        }
        else {
          String ans = "";
          int vPos = w.indexOf( firstVowel(w) );
          int vPos2 = w.indexOf( firstNonYVowel(w) );
          
          if (yIsVowel(w)) {
              ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
          }
          else {
              ans = w.substring(vPos2) + w.substring(0,vPos2) + "ay";
          }

          if (isUpperCase(w.substring(0, 1))) {
            ans = ans.toLowerCase();
            ans = capitalize(ans);
        }

          if (beginsWithVowel(w) && !(firstVowel(w).toLowerCase().equals("y"))) {
              return w + "way";
          }

          return ans;
        }
    }

    public static String strToPig(String w) {

        int spacePos = w.indexOf(" ");

        if (spacePos == -1) {
            return engToPig(w);
        }
        return engToPig(w.substring(0, spacePos)) + " " + strToPig(w.substring(spacePos + 1));
    }
    public static void main( String[] args ) {

        Scanner sc = new Scanner(System.in);

        while( sc.hasNextLine() ) {
            System.out.println( strToPig(sc.nextLine()) );
        }

    }
  }//end main()

//end class Pig