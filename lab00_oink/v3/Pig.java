//Made engToPig capitalize the first letter of ourput if the first letter of input was capital
package v3;

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
        return countPunc(w) > 0;
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

    public static String engToPig( String w ) {

        String ans = "";
        int vPos = w.indexOf( firstVowel(w) );
        int vPos2 = w.indexOf( firstNonYVowel(w) );

        if (yIsVowel(w)) {
            ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
        }
        else {
            ans = w.substring(vPos2) + w.substring(0,vPos2) + "ay";
        }

        if (beginsWithVowel(w) && !(firstVowel(w).toLowerCase().equals("y"))) {
            return w + "way";
        }

        if (isUpperCase(w.substring(0, 1))) {
            ans = ans.toLowerCase();
            ans = capitalize(ans);
        }

        return ans;
    }

    public static void main( String[] args ) {
        for( String word : args ) {
            System.out.println( "---------------------" );
            System.out.println( "allVowels \t" + allVowels(word) );
            System.out.println( "firstVowel \t" + firstVowel(word) );
            System.out.println( "firstNonYVowel \t" + firstNonYVowel(word) );
            System.out.println( "countVowels \t" + countVowels(word) );
            System.out.println( "hasNonYVowel \t" + hasNonYVowel(word) );
            System.out.println( "yIsVowel \t" + yIsVowel(word) );
            System.out.println( "---------------------" );
            System.out.println( "beginsWithUpper \t" + beginsWithUpper(word) );
            System.out.println( "---------------------" );
            System.out.println( "allPunc \t" + allPunc(word));
            System.out.println( "countPunc \t" + countPunc(word));
            System.out.println( "hasPunc \t" + hasPunc(word));
            System.out.println( "---------------------" );
            System.out.println( "engToPig \t" + engToPig(word) );
            System.out.println( "---------------------" );
    }

  }//end main()

}//end class Pig