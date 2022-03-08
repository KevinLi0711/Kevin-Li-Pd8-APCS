public class Mysterion {


    /*
    arr is the given array
    a is the start index
    b is the end index
    c is the index of the target

    The method rearranges the numbers in arr between indexes a and b, inclusive

        - the target will be ordered such that it will be
            - in front of all numbers less than itself
            - behind all numbers greater than itself

        - the result is an array in which the target is sorted relative to all other numbers in the array
    */
    public static String relativeSort(int[] arr, int a, int b, int c) {
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
        int[] arr2 = {100, 200, 1, 2, 3};

        System.out.println(relativeSort(arr, 0, 4, 2)); //target is 5, bounds are indexes 0 and 4

        System.out.println(relativeSort(arr1, 0, 4, 2)); //target is 2, bounds are indexes 0 and 4

        System.out.println(relativeSort(arr2, 2, 4, 2)); //target is the second 2, bounds are indexes 2 and 4
    }
}