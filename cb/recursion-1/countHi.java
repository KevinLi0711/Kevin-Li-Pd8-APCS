/* 
Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
*/

public class countHi {
    public static int countHi(String str) {
        if (str.length()<2) {
            return 0;
        }
        
        String lastTwoLetters = str.substring(str.length() - 2);
        String lastLetterRemoved = str.substring(0, str.length() - 1);
        int add = 0;
        
        if (lastTwoLetters.equals("hi")) {
            add = 1;
        }
        
        return add + countHi(lastLetterRemoved);
    }

    public static void main(String[] args) {
        System.out.println(countHi("xxhixx"));
        System.out.println(countHi("xhixhix"));
        System.out.println(countHi("hi"));
    }
}
  
