/*
Given a string, compute recursively a new string where all the 'x' chars have been removed.
*/

public class noX {
    public static String noX(String str) {
        if (str.length() == 0) {
        return "";
        }
        
        String lastLetter = str.substring(str.length() - 1);
        String lastLetterRemoved = str.substring(0, str.length() - 1);
        String output = "";
        
        if (lastLetter.equals("x")) {
        output = "";
        } else {
        output = lastLetter;
        }
        
        return noX(lastLetterRemoved) + output;
    }

    public static void main(String[] args) {
        System.out.println(noX("xaxb"));
        System.out.println(noX("abc"));
        System.out.println(noX("xx"));
    }
}
