// https://codingbat.com/prob/p136594

public class Main {
    public static void main(String[] args) {
        System.out.println(xyzThere("abcxyz")); // true
        System.out.println(xyzThere("abc.xyz")); // false
        System.out.println(xyzThere("xyz.abc")); // true
    }

    /**
     * Return true if the given string contains an appearance of "xyz" where the
     * xyz is not directly preceeded by a period (.). So "xxyz" counts but
     * "x.xyz" does not.
     */
    public static boolean xyzThere(String str) {
        if ( (countXyz(str) - countDotXyz(str)) == 0) {
            return false;
        } else return true;
    }

    public static int countXyz(String str) {
        int letterNum = 0;
        int xyzCount = 0;
        while (letterNum <= str.length() - 3) {
            if (str.substring(letterNum, letterNum + 3).equals("xyz")) {
                xyzCount++;
            }
            letterNum++;
        }
        return xyzCount;
    }

    public static int countDotXyz(String str) {
        int letterNum = 0;
        int dotXyzCount = 0;
        while (letterNum <= str.length() - 4) {
            if (str.substring(letterNum, letterNum + 4).equals(".xyz")) {
                dotXyzCount++;
            }
            letterNum++;
        }
        return dotXyzCount;
    }
}


