public class Loops{
    public static void main(String[] args){
        System.out.println(power(3, 4));
        System.out.println(factorial(4));
        System.out.println(myexp(1, 10));
        double x = .1;
        double y = -.1;
        while (x <= 100){
            check(x);
            x = x * 10;
        }
        // -.1, and -1 give accurate outputs but the output for -10 and -100 are very off. The output for -10 and -100 are negative and the actual answers are positive
        while (y >= -100){
            check(y);
            y = y * 10;
        }
    }

    public static double power(double x, int n){
        int i = 1;
        double result = x;
        while (i < n){
            result = result * x;
            i++;
        }
        return result;
    }


    public static int factorial(int x){
        int result = x;
        if ((x == 0) || (x == 1)){
            return 1;
        }
        while (x > 1){
            result = result * (x - 1);
            x--;
        }
        return result;
    }

    public static double myexp(double x, int n){
        int i = 0;
        double result = 0;
        double numerator = 1;
        double denominator = 1;
        while (i < n){
            result = result + (numerator) / (denominator);
            i++;
            numerator = numerator * x;
            denominator = denominator * i;
        }
        return result;
    }

    public static void check(double x){
        System.out.println(x + "\t" + myexp(x, 18) + "\t" + Math.exp(x));
    }
}