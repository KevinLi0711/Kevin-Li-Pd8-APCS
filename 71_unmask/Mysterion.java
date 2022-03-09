// Suspicious Oranges: Weichen Liu, Kevin Li, Hamim Seam
// APCS pd8
// HW71 -- Tracing a new Sort Algorithm
// 2022-03-07m
// time spent: 0.9 hrs

/***
 * SKEELTON for
 * class Mysterion
 * tests preliminary hypotheses re: utility of mystery algo
 * 
 * <h1>It's a Bird, It's a Plane! It's.... MYSTERION</h1>
 * The Mysterion method ... partitions array into two subarrays. One array to the left of split who has elements of values less than split and one array to the right of split whose elements has values greater than split. 
 * <p>
 * <b>Note:</b> BLAH blah blah, yakkety schmakketty...
 * @author  Trey Parker, Matt Stone
 * @version 3.1415926535897932384626433
 * @since   2022-03-07m 
 *
 * algo as pseudocode:
 * ------------------------------
 *     v = arr[c]
 *     swap arr[c], arr[b]  
 *     s = a
 *     for i in [a..b-1]
 *         if arr[i] < v
 *             swap arr[s], arr[i]
 *             s+=1
 *     swap arr[b], arr[s] 
 * 
 * DISCO
 * - The list is not always sorted when we go through this algorithm. However, we do know that values less than the split is to the left of it and vice versa. 
 *
 * QCC
 * - What are the benefits of returning an integer value for mysterion. 
 *
 * q0: What does it do?
 * a0: List is partitioned into two smaller arrays.
 *     Elements less than the element we want to compare the rest of the element to is moved to the left of the array.
 *     Elements greater than the element we want to compare the rest of the element to is moved to the right of the array.
 *     That element we were comparing the rest of the list to is moved to where it belongs. 
 * 
 * q1: O(?)
 * a1: O(n) because there is one for loop
 ***/


public class Mysterion 
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
  public static int relativeSort( int arr[], int lo, int hi, int splitter)
  {
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



  //main method for testing
  public static void main( String[] args )
  {

    //init test arrays of magic numbers
    int[] arr1 = {1,3,2};
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};
    int[] arr6 = {4, 7, 1, 2, 9};
    int[] arr7 = {8, 7, 2, 11, 13};

    relativeSort(arr1, 0, 2, 1);
    printArr(arr1);

    // run relativeSort on each array,
    // holding a & b fixed, varying c...
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    for( int testC = 0; testC < 5; testC++ ) {
    System.out.println("arr1: ");
    printArr(arr1);
    relativeSort(arr1,0,4,testC);
    System.out.println("after relativeSort w/ a=0,b=4,c=" 
    + testC +"...");
    printArr(arr1);
    System.out.println("-----------------------");

    System.out.println("arr3:");
    printArr(arr3);
    relativeSort(arr3,0,4,testC);
    System.out.println("after relativeSort w/ a=0,b=4,c=" 
    + testC +"...");
    printArr(arr3);
    System.out.println("-----------------------");

    System.out.println("arr4:");
    printArr(arr4);
    relativeSort(arr4,0,4,testC);
    System.out.println("after relativeSort w/ a=0,b=4,c=" 
    + testC +"...");
    printArr(arr4);
    System.out.println("-----------------------");

    System.out.println("arr5:");
    printArr(arr5);
    relativeSort(arr5,0,4,testC);
    System.out.println("after relativeSort w/ a=0,b=4,c=" 
    + testC +"...");
    printArr(arr5);
    System.out.println("-----------------------");
    }
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main

}//end class Mysterion