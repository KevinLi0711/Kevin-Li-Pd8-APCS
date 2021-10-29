public class Rof {
    public static void main(String args[]) {
        System.out.println(fenceF(7));
        System.out.println(reverseF("testing"));
        System.out.println(reverseR("desserts"));
    }

    public static String fenceF(int posts) {
        String result = "|";
        for(int postsPlanted = 1; postsPlanted < posts; postsPlanted++) {
            result = result + "--|";
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

