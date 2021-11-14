/*
<Frist> <Lsat>
APCS
HW<nn> -- <Title/Topic/Summary... (Aim for concision, brevity, CLARITY. Write to your future self...)>
<yyyy>-<mm>-<dd>
time spent: <elapsed time in hours, rounded to nearest tenth>
DISCO
    - For each loops cannot be used to fill arrays. If you were to use 
        for(int x : array){
            array[x] = random.nextInt();
        }
        only the first value in the array will be filled
    - array.length exists and it returns the number of values in the array
*/
import java.util.Random;

public class Loopier{
    public static Random random = new Random();

    public static void randomIntArray(int[] a) {
        for(int x = 0; x < a.length; x++) {
            a[x] = random.nextInt();
        }
    }

    public static String printArray(int[] a) {
        String result = "[";
        int x = 0;

        while(x < a.length - 1) {
            result = result + a[x] + ", ";
            x++;
        }
        result = result + a[x] + "]";
        return result;
    }

    public static int linSearch(int[] a, int target) {
        for(int x = 0; x < a.length; x++) {
            if (a[x] == target) {
                return x;
            }
        }
        return -1;
    }

    public static int linSearchR(int[] a, int target) {
        return -1;
    }

    public static int freq(int[] a, int target) {
        return -1;
    }

    public static int freqR(int[]a, int target) {
        return -1;
    }
    public static void main(String args[]) {
        int[] a = new int[5];

        randomIntArray(a);
        System.out.println(printArray(a));

        int[] b = {1, 2, 3, 4, 5};
        System.out.println(linSearch(b, 4));
    }
}