/*
Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.
*/

public class changeXY {
    public static String changeXY(String str) {
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

    public static void main(String[] args) {
        System.out.println(changeXY("codex"));
        System.out.println(changeXY("xxhixx"));
        System.out.println(changeXY("xhixhix"));
    }
}
    
