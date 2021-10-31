// https://codingbat.com/prob/p126880

public class Main {
    public static void main(String[] args) {
        System.out.println(endOther("Hiabc", "abc")); // true
        System.out.println(endOther("AbC", "HiaBc")); // true
        System.out.println(endOther("abc", "abXabc")); // true
    }

    /**
     * Given two strings, return true if either of the strings appears at the
     * very end of the other string, ignoring upper/lower case differences (in
     * other words, the computation should not be "case sensitive"). Note:
     * str.toLowerCase() returns the lowercase version of a string.
     */

    public static boolean endOther(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        if ( (a.length() == b.length()) && !a.equals(b) ) {
            return false;
        }
        return compareString(endSubtring(a, b), shorterString(a, b));
    }

    public static String shorterString(String a, String b) {
        if (a.length() < b.length()) {
            return a;
        } else return b;
    }

    public static String endSubtring(String a, String b) {
        if (a.length() > b.length()) {
            return a.substring(a.length() - b.length());
        }
        if (a.length() < b.length()) {
            return b.substring(b.length() - a.length());
        }
        else return a;
    }

    public static boolean compareString(String a, String b) {
        for(int letterNum = 1; letterNum < a.length(); letterNum++) {
            if (compareNthLetter(letterNum, a, b) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareNthLetter(int N, String str1, String str2) {
        if (nthLetter(N, str1).equals(nthLetter(N, str2).toUpperCase())) {
            return true;
        } else 
        if (nthLetter(N, str1).equals(nthLetter(N, str2).toLowerCase())) {
            return true;
        } else return false;
    }

    public static String nthLetter(int N, String str) {
        return str.substring(N - 1, N);
    }
}
