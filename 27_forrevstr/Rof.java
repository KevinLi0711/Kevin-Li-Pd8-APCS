/*
<Frist> <Lsat>
APCS
HW27 -- FOR the Love of Strings
2021-10-28
time spent: .7 hours

DISCO:
    - return statements cause a method to stop and cause the code after the return statement to not be run. 
    This is a reason for the error: Unreachable code and is why recursive loops end with returning a base case
QCC:
*/
public class Rof {
    public static void main(String args[]) {
        System.out.println(fenceF(7));
        System.out.println(reverseF("testing"));
        System.out.println(reverseR("desserts"));
    }

	public static String fenceF(int posts) {
		String result = "|";
		for (int x = 1; x < posts; x++) {
			result += "--|";
		}
		return result;
	}

	public static String reverseF(String s) {
		String result = "";
		for (int x = s.length(); x > 0; x--) {
			result += s.substring(x - 1, x);
		}
		return result;
	}

    public static String reverseR(String s) {
        if(s.length() == 0) {
            return "";
        }
        return lastLetter(s) + reverseR(reduceLetter(s));
    }

    public static String reduceLetter(String s) {
        return s.substring(0, s.length() - 1);
    }

    public static String lastLetter(String s) {
        return s.substring(s.length() - 1, s.length());
    }
}

