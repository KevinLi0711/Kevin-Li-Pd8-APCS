public class Commafier {
    public static void main(String[] args) {
        System.out.println(commafyR(239));
    }
    /*
    Trace for commafyR(123456789):
    commafyR(123456) + "," + "789"
    commafyR(123) + "," + "456" + "," + "789"
    "123" + "," + "456" + "," + "789"
    = "123,456,789"
    */
    public static String commafyR(int number) {
        String numberString = Integer.toString(number);
        if (numberString.length() <= 3) {
            return numberString;
        }
        return commafyR(Integer.parseInt(reduceStringByX(numberString, 3))) + "," + lastXChar(numberString, 3);
    }

    public static String commafyF(int number) {
        return "";
    }
    //returns a substring of the input String which removes the last x characters
    public static String reduceStringByX(String s, int x) {
        return s.substring(0, s.length() - x);
    }
    //returns a substring of the input String which consists of the last x characters
    public static String lastXChar(String s, int x) {
        return s.substring(s.length() - x, s.length());
    }
}