//Clyde Sinclair
//APCS pd0
//HW72 -- QuickSort
//2022-03-09w
//time spent: _h

/***
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 *
 * 2a. Worst pivot choice and associated run time:
 *
 * 2b. Best pivot choice and associated run time:
 *
 * 3. Approach to handling duplicate values in array:
 *
 * DISCO
 *  - The run time of Quick Sort is very dependent on the chosen pivot, and since the pivot is chosen from an unsorted list, 
 *    any algorithmic selection of the pivot is the same as randomly choosing
 *      - We didn't do random even though it sounds easier because we were too far in with our "pick the middle" algo
 * 
 * QCC
 *  - Quicksort looks like it's O(n^2) in the worst case scenario, so what puts this on par with Merge sort?
 **/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
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
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------

   public static int partition( int arr[], int loPos, int hiPos)
  {
    int pvtPos = (loPos + hiPos) / 2;
    int v = arr[pvtPos];

    swap( pvtPos, hiPos, arr);
    int s = loPos;

    for( int i = loPos; i < hiPos; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,hiPos,arr);

    //return final pivot pos
    return s;
  }

  /**
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    qsortHelper(d, 0, d.length-1);

  }
  
  public static void qsortHelper(int [] d, int loPos, int hiPos){
    int pvtPos = (loPos + hiPos) / 2;
    //base case: 
    //If loPos and hiPos ever cross over each other (meaning lo is greater than hi / hi is less than lo)
    if (hiPos <= loPos) {
        return;
    }

    pvtPos = partition(d, loPos, hiPos);
    
    //Partition the left of pvtPos
    qsortHelper(d, loPos, pvtPos - 1);
    //Partition the right of pvtPos
    qsortHelper(d, pvtPos + 1, hiPos);
  }

  //you may need a helper method...


  


  //main method for testing
  public static void main( String[] args )
  {
    
    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);
    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);
    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;
    System.out.println("\narrN init'd to: " );
    printArr(arrN);
    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);
    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);




    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);
    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);
    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );
    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);
    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);
    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);

  }//end main

}//end class QuickSort