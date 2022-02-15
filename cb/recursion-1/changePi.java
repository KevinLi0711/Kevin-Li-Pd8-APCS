/*
Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".
*/

public class changePi {
    public static String changePi(String str) {
        if (str.length()<2) {
        return str;
        }
        
        String lastLetter = str.substring(str.length() - 1);
        String lastTwoLetters = str.substring(str.length() - 2);
        String lastLetterRemoved = str.substring(0, str.length() - 1);
        String output = "";
        
        if (lastTwoLetters.equals("pi")) {
        output = "3.14";
        lastLetterRemoved = lastLetterRemoved.substring(0, lastLetterRemoved.length() - 1);
        } else {
        output = lastLetter;
        }
        
        return changePi(lastLetterRemoved) + output;
        
    }

    public static void main(String[] args) {
        System.out.println(changePi("xpix"));
        System.out.println(changePi("pipi"));
        System.out.println(changePi("pip"));
    }
}
