/*
Team KLEH: Kevin Li and Eric He
APCS
HW29 -- Which Way Do You Roll?
2021-11-02
time spent: 1 hour

DISCO:
    - The last paremeter of a for loop is typically x++ or x--, but it can also be set to x = x + 3 or x+=3 to increment by 3
    - The main method creates an array of strings called args, and it seems like any string we enter in the command line 
    after java <filename> gets added to the array
QCC: 
    - Can for each loops use a collection that's not an array? Are there other types of collections?
*/

public class Commafier {
    public static void main(String[] args) {
        /*
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
        */
        for (String number: args) {
            System.out.println(commafyR(Integer.parseInt(number)));
            System.out.println(commafyF(Integer.parseInt(number)));
        }
    
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

        for(int length = numberString.length(); length > 3; length = length-=3) {
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