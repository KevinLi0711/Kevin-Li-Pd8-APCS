public class Mysterion {
    public void sort(int[] arr, int a, int b, int c) {
        int v = arr[c];

        //swap arr[c] and arr[b]
        int temp = arr[b];
        arr[b] = arr[c];
        arr[c] = temp;
    }
}