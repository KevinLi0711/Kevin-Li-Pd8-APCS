// https://codingbat.com/prob/p111624

public class Main {
    public static void main(String[] args) {
        System.out.println(catDog("catdog")); // true
        System.out.println(catDog("catcat")); // false
        System.out.println(catDog("1cat1cadodog")); // true
    }

    /**
     * Return true if the string "cat" and "dog" appear the same number of times
     * in the given string.
     */
    public static boolean catDog(String str) {
        if ( countCat(str) == countDog(str) ) {
            return true;
        } else return false;
    }

    public static int countCat(String str) {
        int letterNum = 0;
        int catCount = 0;
        while (letterNum <= str.length() - 3) {
            if (str.substring(letterNum, letterNum + 3).equals("cat")) {
                catCount = catCount + 1;
            }
            letterNum++;
        }
        return catCount;
    }

    public static int countDog(String str) {
        int letterNum = 0;
        int dogCount = 0;
        while (letterNum <= str.length() - 3) {
            if (str.substring(letterNum, letterNum + 3).equals("dog")) {
                dogCount = dogCount + 1;
            }
            letterNum++;
        }
        return dogCount;
    }
}
