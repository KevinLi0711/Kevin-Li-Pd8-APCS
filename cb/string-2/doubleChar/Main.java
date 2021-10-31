// https://codingbat.com/prob/p165312

public class Main {
    public static void main(String[] args) {
        System.out.println(doubleChar("The")); // "TThhee"
        System.out.println(doubleChar("AAbb")); // "AAAAbbbb"
        System.out.println(doubleChar("Hi-There")); // "HHii--TThheerree"
    }

    /**
     * Given a string, return a string where for every char in the original,
     * there are two chars.
     */
    public static String doubleChar(String str) {
        int letterNum = 0;
        String finalString = "";
        while (letterNum < str.length()) {
          finalString = finalString + 
          str.substring(letterNum, letterNum + 1) + 
          str.substring(letterNum, letterNum + 1);
          letterNum++;
        }
        return finalString;
    }
}
