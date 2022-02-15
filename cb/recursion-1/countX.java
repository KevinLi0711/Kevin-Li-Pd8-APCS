/*
Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
*/

public class countX {
    public static int countX(String str) {
        if (str.length()==0) {
        return 0;
        }
        
        String lastLetter = str.substring(str.length() - 1);
        String lastLetterRemoved = str.substring(0, str.length() - 1);
        int add = 0;
        
        if (lastLetter.equals("x")) {
        add = 1;
        }
        
        return add + countX(lastLetterRemoved);
    }

    public static void main(String[] args) {
        System.out.println(countX("xxhixx"));
        System.out.println(countX("xhixhix"));
        System.out.println(countX("hi"));
    }
}
