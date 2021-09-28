public class Methods{
    public static boolean isDivisible(int n, int m){
        if (n % m == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args){
        System.out.println(isDivisible(7, 7));
        System.out.println(isTriangle(3, 4, 5));
        System.out.println(ack(1, 2));
    }

    public static boolean isTriangle(int a, int b, int c){
        if (
            (a + b < c) || 
            (a + c < b) ||
            (b + c < a)) {
            return false;
        } else {
            return true;
        }
    }

    public static int ack(int m, int n){
        if (m == 0){
            return (n + 1); 
        } 
        if (n == 0){
            return ack(m - 1, 1);
        } else return ack(m - 1, ack(m, n - 1));
    }
}