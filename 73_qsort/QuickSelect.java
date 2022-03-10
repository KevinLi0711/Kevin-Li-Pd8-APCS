/*
Team Three Kevins: Kevin Xiao, Kevin Li, Hamim Seam (honorary Kevin)
APCS
HW72 -- Fast Select
2022-03-08
time spent: 1 hour
ALGO
    1. Partition the array using the number at the middle index as a pivot
    2. Find the index of the pivot after the partition
    3. If the index is less than y - 1, 
        partition the array using the index of the pivot + 1 as the lower bound, and keeping the upper bound the same
       
       If the index is greater than y - 1
        partition the array using the index of the pivot as the upper bound, and keeping the lower bound the same
    4. Repeat steps 1 - 3 until the index of the pivot is equal to y - 1
        Then return the pivot
BEST CASE SCENARIO
    The best case scenario would be if the yth smallest is in the middle of the array. 
    The recursive loop would only run once, making it O(n)
WORST CASE SCENARIO
    The worst case scenario would be if each recursion chose a new pivot that's close in value to the first pivot (ex: the new pivot is the first value greater than the old one)
    For small arrays, it's possible for every value to be chosen as a pivot, or for the number of pivots chosen to equal n, which would make this O(n^2)
    but for larger arrays, O(nlogn) seems inevitable because it's almost guaranteed that some values will be jumped over
DISCO
    Using partition on the yth smallest value places that value at index y - 1
QCC
    Is there exit early for fastselect like there is in bubble sort?
    Is fastselect amortized?
    What other ways can partitioned be used?
*/

public class QuickSelect {

    public static int partitions = 0;

    public static int ythSmallest(int[] arr, int lower, int upper, int y) {
        int middle = (lower + upper) / 2;
        int pivot = arr[middle];
        int indexOfPivot = middle;

        //O(n)
        partition(arr, lower, upper, middle);
        partitions += 1;
        //System.out.println(pivot); 

        //O(n)
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == pivot) {
                indexOfPivot = i;
            }
        }

        //base case
        if (indexOfPivot == (y - 1)) {
            return pivot;
        } 
        else

        //If the index of pivot is less than y, partition the upper half
        if (indexOfPivot < (y - 1)) {
            return ythSmallest(arr, indexOfPivot + 1, upper, y);
        }
        //If the index of pivot is greater than y, partition the lower half
        else {
            return ythSmallest(arr, lower, indexOfPivot, y);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        int[] arr1 = {4, 2, 9, 5, 0};
        int[] arr2 = {4, 2, 9, 5, 0};
        int[] arr3 = {4, 2, 9, 5, 0};
        int[] arr4 = {4, 2, 9, 5, 0};
        int[] arr5 = {4, 2, 9, 5, 0};

        System.out.println("smallest: " + ythSmallest(arr, 0, 2, 1));
        System.out.print("arr after " + partitions + " partitions: ");
        printArr(arr);
        partitions = 0;

        System.out.println("smallest: " + ythSmallest(arr1, 0, 4, 1));
        System.out.print("arr1 after " + partitions + " partitions: ");
        printArr(arr1);
        partitions = 0;

        System.out.println("2nd smallest: " + ythSmallest(arr2, 0, 4, 2));
        System.out.print("arr2 after " + partitions + " partitions: ");
        printArr(arr2);
        partitions = 0;

        System.out.println("3rd smallest: " + ythSmallest(arr3, 0, 4, 3));
        System.out.print("arr3 after " + partitions + " partitions: ");
        printArr(arr3);
        partitions = 0;
        
        System.out.println("4th smallest: " + ythSmallest(arr4, 0, 4, 4));
        System.out.print("arr4 after " + partitions + " partitions: ");
        printArr(arr4);
        partitions = 0;

        System.out.println("5th smallest: " + ythSmallest(arr5, 0, 4, 5)); 
        System.out.print("arr5 after " + partitions + " partitions: ");
        printArr(arr5);
        partitions = 0;

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
        //System.out.println();
        }
        System.out.println("\n");
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
