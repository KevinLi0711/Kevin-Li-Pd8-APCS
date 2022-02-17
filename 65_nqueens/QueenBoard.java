/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments preceding each method where necessary.
 * 2. Implement solver method.
 */

public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve()
  {
    return solveH(0);
  }

  public boolean solve(int startingRow)
  {
    addQueen(startingRow, 0);
    return solveH(1);
  }


  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
    if (col == _board.length) {
    	return true;
    }
    	
    for (int row = 0; row < _board.length; row++) {
    	if (addQueen(row, col)) {
            if (solveH(col + 1)) {
                return true;
            }
    	} 
        removeQueen(row, col);
    }

    return false;

  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */

    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        if (_board[r][c] <= 0) {
            ans += "_" + "\t";
        } else 
        if (_board[r][c] == 1) {
            ans += "Q" + "\t";
        } else 
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    System.out.println(ans);
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * Attempts to place a queen at the given row and column
   * precondition: 
   *    row and column are both less than size
   * postcondition: 
   *    if placement successful, _board[row][col] = 1
   * all tiles to the right, diagonally up right, and diagonally down right of the given coordinates decrement by 1
   * returns true
   * if placement unsuccessful
   *    returns false
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * Attempts to place a remove at the given row and column
   * precondition: 
   *    row and column are both less than size
   * postcondition: 
   * if removal successful, _board[row][col] = 0
   *    all tiles to the right, diagonally up right, and diagonally down right of the given coordinates increment by 1
   *    returns true
   * if placement unsuccessful
   *    returns false
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   * returns a string of a board containing the elements of _board in their proper row and column
   * precondition: 
   *    an instance of QueenBoard exists and invokes this method
   * postcondition: 
   *    returns a string of every element in _board in a square
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    /** should be...
       0	0	0	0	0	
       0	0	0	0	0	
       0	0	0	0	0	
       0	0	0	0	0	
       0	0	0	0	0	
    */

    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    /** should be...
       0	1	-1	-2	-1	
       0	0	-2	0	0	
       0	-1	0	-1	0	
       1	-1	-1	-1	-2	
       0	-1	0	0	0	
    */

    b.removeQueen(3,0);
    System.out.println(b);
    /** should be...
       0	1	-1	-1	-1	
       0	0	-1	0	0	
       0	0	0	-1	0	
       0	0	0	0	-1	
       0	0	0	0	0	 
    */
    
    QueenBoard solve = new QueenBoard(8);
    System.out.println(solve.solve(6));
    System.out.println(solve);
    solve.printSolution();
  }

}//end class
