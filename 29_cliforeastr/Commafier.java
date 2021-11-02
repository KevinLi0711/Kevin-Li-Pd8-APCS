public class Commafier {
    public static void main(String[] args) {
        System.out.println(commafyR(1));
        System.out.println(commafyR(21));
        System.out.println(commafyR(239));
        System.out.println(commafyR(8701));
        System.out.println(commafyR(11257));
        System.out.println(commafyR(1234878937));
    
        System.out.println(commafyF(1));
        System.out.println(commafyF(21));
        System.out.println(commafyF(239));
        System.out.println(commafyF(8701));
        System.out.println(commafyF(11257));
        System.out.println(commafyF(11218057));
    
    }

    public static String commafyR(int number) {
        String numberString = Integer.toString(number);

        if (numberString.length() <= 3) {
            return numberString;
        }
        return commafyR(Integer.parseInt(reduceStringByX(numberString, 3))) + "," + lastXChar(numberString, 3);
    }

    public static String commafyF(int number) {
        String numberString = Integer.toString(number);
        String finalString = "";

        for(int length = numberString.length(); length > 3; length = length - 3) {
            finalString = "," + lastXChar(numberString, 3) + finalString;
            numberString = reduceStringByX(numberString, 3);
        }
        finalString = numberString + finalString;
        return finalString;
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