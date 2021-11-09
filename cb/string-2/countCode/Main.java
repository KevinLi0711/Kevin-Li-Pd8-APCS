// https://codingbat.com/prob/p123614

public class Main {
    public static void main(String[] args) {
        /*
        System.out.println(countCode("aaacodebbb")); // 1
        System.out.println(checkCo("aaacodebbb", 3));
        System.out.println(checkE("aaacodebbb", 3));
        System.out.println(countCode("codexxcode")); // 2
        System.out.println(countCode("cozexxcope")); // 2
        */
        for(String x : args) {
            System.out.println(checkCo(x, 0));
        }
    }

    /**
     * Return the number of times that the string "code" appears anywhere in the
     * given string, except we'll accept any letter for the 'd', so "cope" and
     * "cooe" count.
     */
    public static int countCode(String str) {
        int codeCount = 0;
        for(int letterNum = 0; letterNum <= str.length() - 4; letterNum++) {
            if ( checkCo(str, letterNum) && checkE(str, letterNum) ) {
                codeCount++;
            }
        }
        return codeCount;
    }

    public static boolean checkCo(String str, int position) {
        if (str.substring(position, position + 2).equals("co")) {
            return true;
        } else return false;
    }

    public static boolean checkE(String str, int letterNum) {
        if (str.substring(letterNum + 3, letterNum + 4).equals("e")) {
            return true;
        } else return false;
    }
}
