public class FastSelect {

    public static int ythSmallest(int[] arr, int lower, int upper, int y) {
        int middle = (lower + upper) / 2;
        int pivot = arr[middle];
        int indexOfPivot = middle;

        //base case
        if (indexOfPivot == y - 1) {
            return pivot;
        }

        //O(n)
        partition(arr, lower, upper, middle);

        //O(n)
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == pivot) {
                indexOfPivot = i;
            }
        }

        //If the index of pivot is less than y, partition the upper half
        if (indexOfPivot < (y - 1)) {
            return ythSmallest(arr, middle, upper, y);
        }
        //If the index of pivot is greater than y, partition the lower half
        else {
            return ythSmallest(arr, lower, middle, y);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 5, 0};
        System.out.println(ythSmallest(arr, 0, 4, 1));
        System.out.println(ythSmallest(arr, 0, 4, 2));
        System.out.println(ythSmallest(arr, 0, 4, 3));
        System.out.println(ythSmallest(arr, 0, 4, 4));
        //System.out.println(ythSmallest(arr, 0, 4, 5)); //this one breaks

    }

    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
        for ( int o : a ) {
        System.out.print( o + " " );
        System.out.println();
        }
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
        int tmp;
        int swapPos;
        for( int i = 0; i < d.length; i++ ) {
            tmp = d[i];
            swapPos = i + (int)( (d.length - i) * Math.random() );
            swap( i, swapPos, d );
        }
    }
    
    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal )
    {
        int[] retArr = new int[s];
        for( int i = 0; i < retArr.length; i++ ) {
            retArr[i] = (int)( maxVal * Math.random() );
        }
        return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------


    /**
    * int mysterion(int[],int,int,int)
    * DESCRIPTION
    * Array is partitioned into two subarrays with a split(element of index splitter).
    * Elements to the left of split is less than split.
    * Elements to the right of split is greater than split. 
    * Split is adjusted to where it should be. 
    *
    *
    * @param arr
    * @param a -- lo -- The beginning index we use for partitioning
    * @param b -- hi -- The end index we use for partitioning 
    * @param c -- splitter -- The index of element that we compare the rest of the elements of the list to. 
    * @return int 
    *
    */
    public static int partition( int arr[], int lo, int hi, int splitter) {
        int split = arr[splitter];
    
        swap(splitter, hi, arr); // split is moved to the end
    
        int s = lo;
    
        for (int i = lo; i < hi; i++){
            if (arr[i] < split){ // compares elements of the list to split
            swap(s, i, arr);
            s += 1;
            }
        }
    
        swap(hi, s, arr); // split put back into place
    
        return s; // returns # of elements before splitIndex
    }//end relativeSort
}