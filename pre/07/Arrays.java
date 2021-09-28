public class Arrays{
    public static void main(String[] args){
        double[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3, 4};
        printArray(powArray(a, 2));
        printArray(histogram(b, 5));
        System.out.println(indexOfMax(b));
        printArray(sieve(100));
    }

    public static double[] powArray(double[] a, int power){
        double[] b = new double[a.length];
        for(int i = 0; i < a.length; i++){
            a[i] = a[i] * a[i];
            b[i] = a[i];
        }
        return b;
    }

    public static int[] histogram(int[] scores, int counters){
        int[] counts = new int[counters];
        for (int score : scores) {
            counts[score]++;
        }
        return counts;
    }

    public static int indexOfMax(int[] a){
        int index = 0;
        for(int i = 1; i < a.length; i++){
            if (a[i] > a[i - 1]){
                index = i;
            }
        }
        return index;
    }

    public static boolean[] sieve(int n){
        int[] a = new int[n];
        boolean[] b = new boolean[n];
        for(int i = 0; i < n; i++){
            a[i] = i;
            b[i] = true;
        }
        for(int i = 0; i <= 1; i++){
            b[i] = false;
        }    
        for(int i = 4; i < n; i += 2){
            b[i] = false;
        }     
        for(int i = 6; i < n; i += 3){
            b[i] = false;
        }   
        for(int i = 10; i < n; i += 5){
            b[i] = false;
        }    
        for(int i = 14; i < n; i += 7){
            b[i] = false;
        }
        for(int i = 22; i < n; i += 11){
            b[i] = false;
        }
        for(int i = 26; i < n; i += 13){
            b[i] = false;
        }
        return b; 
    }
    

// I was having trouble with Arrays.toString and it's midnight and I just can't deal with it right now
    public static void printArray(double[] a) {
        System.out.print("{" + a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print(", " + a[i]);
        }
        System.out.println("}");
    }

    public static void printArray(int[] a) {
        System.out.print("{" + a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print(", " + a[i]);
        }
        System.out.println("}");
    }

    public static void printArray(boolean[] a) {
        System.out.print("{" + a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print(", " + a[i]);
        }
        System.out.println("}");
    }
}