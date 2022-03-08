public class Mysterion {

    public static String mystery(int[] arr, int a, int b, int c) {
        int temp;

        int v = arr[c];
        int s = a;

        //initial swap
        arr[c] = arr[b];
        arr[b] = v;

        for (int i = 0; i < b; i ++) {
            if (arr[i] < v) {
                //swap i and s
                temp = arr[i];

                arr[i] = arr[s];
                arr[s] = temp;

                s+=1;
            }
        }

        //final swap
        temp = arr[b];

        arr[b] = arr[s];
        arr[s] = temp;

        //stringify
        String output = "";
        for (int x : arr) {
            output += x;
            output += " ";
        }

        return output;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 12, 3};
        int[] arr1 = {1, 4, 2, 6, 7};
        int[] arr2 = {3, 2, 1, 2, 3};

        System.out.println(mystery(arr, 0, 4, 2)); //target is 5, bounds are indexes 0 and 4
        System.out.println(mystery(arr1, 0, 2, 0)); //target is 1, bounds are indexes 0 and 2
        System.out.println(mystery(arr2, 0, 4, 2)); //target is 1, bounds are indexes 0 and 4
    }
}