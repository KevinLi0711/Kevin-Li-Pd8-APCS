/***
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  
  For sort()
  1. Create a 2d array, and place each value of the input array into the 2d array
        {5, 1, 8, 4} becomes
    0: [5] 
    1: [1]
    2: [8]
    3: [4]
        Now you have multiple sorted arrays to merge

  2. Store the length of the last array as a variable
    0: [5] 
    1: [1]
    2: [8]
    3: [4] -> listLength = 1

  3. Starting with (index = arr.size - 1), merge the array at index with the array at index - listLength
    0: [5] 
    1: [1]
    2: [8]    (index - listLength)
    3: [4, 8] (index)

  4. Decrement index by 2 * listLength and repeat step 3. Do this until decrementing would make index < 0
    0: [5]    (index - listLength)
    1: [1, 5] (index)
    2: [8]    
    3: [4, 8] 

  5. Set index back to arr.size - 1
    0: [5]    
    1: [1, 5] 
    2: [8]    
    3: [4, 8] (index)

  6. Set listLength equal to the length of the last array again
    0: [5]    
    1: [1, 5] 
    2: [8]    
    3: [4, 8] (listLength = 2)

  7. Repeat above steps until sorted, then return the last array
    0: [5]    
    1: [1, 5]       (index - listLength)
    2: [8]    
    3: [1, 4, 5, 8] (index)

  ***/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
      int[] output = new int[a.length + b.length];
      int indexA = 0;
      int indexB = 0;
      int addIndex = 0;

      while ( (indexA < a.length) && (indexB < b.length) ) {
        if (a[indexA] < b[indexB]) {
            output[addIndex] = a[indexA];
            indexA++;
            addIndex++;
        } else {
            output[addIndex] = b[indexB];
            indexB++;
            addIndex++;
        }
      }

      if (indexA == a.length) {
        for (int i = indexB; i < b.length; i++) {
            output[addIndex] = b[i];
            addIndex++;
        }
      } else
      if (indexB == b.length) {
        for (int i = indexA; i < a.length; i++) {
            output[addIndex] = a[i];
            addIndex++;
        }
    }

    return output;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
      int middle = arr.length / 2;
      int[] left = new int[middle];
      int[] right = new int[arr.length - middle];
      int[] output = new int[arr.length];

      for(int i = 0; i < middle; i++) {
          left[i] = arr[i];
      }

      for(int i = middle; i < arr.length; i++) {
        right[i - middle] = arr[i];
      }

      left = sort(left);
      right = sort(right);

      output = merge(left, right);
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a ) {
      System.out.print( i + ",");
    }
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args )
  {
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};
      int[] arr8 = {3, 19, 2, 75, 87, 7700, 444, 666, 537};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nSorting arr4-7...");
      
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
      printArray( sort( arr8 ) );
      /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
