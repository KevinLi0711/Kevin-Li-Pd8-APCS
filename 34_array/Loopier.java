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
    public static int[] array = new int[5];

    public static void randomIntArray(int[] array) {
        for(int x = 0; x < array.length; x++) {
            array[x] = random.nextInt();
        }
    }

    public static String printArray(int[] array) {
        String result = "[";
        int x = 0;

        while(x < array.length - 1) {
            result = result + array[x] + ", ";
            x++;
        }
        result = result + array[x] + "]";
        return result;
    }
    public static void main(String args[]) {
        System.out.println(random.nextInt());
        randomIntArray(array);
        System.out.println(printArray(array));
        System.out.println(array.length);
    }
}