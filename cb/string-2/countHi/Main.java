// https://codingbat.com/prob/p147448

public class Main {
    public static void main(String[] args) {
        System.out.println(countHi("abc hi ho")); // 1
        System.out.println(countHi("ABChi hi")); // 2
        System.out.println(countHi("hihi")); // 2
    }

    /**
     * Return the number of times that the string "hi" appears anywhere in the
     * given string.
     */
    public static int countHi(String str) {
        int letterNum = 0;
        int hiCount = 0;
        while (letterNum <= str.length() - 2) {
            if (str.substring(letterNum, letterNum + 2).equals("hi")) {
                hiCount = hiCount + 1;
            }
            letterNum++;
        }
        return hiCount;
    }
}
