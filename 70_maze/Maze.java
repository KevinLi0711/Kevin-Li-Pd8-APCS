// Luminosity: Salaj Rijal, Kevin Li
// APCS pd8
// HW 70 -- Maze Solving -- Solve a Maze using DFS
// 2022-3-7
// time spent: 2 hrs

/***
 * SKEELTON for
 * class MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 * 
 * USAGE: 
 * $ java Maze [path/to/mazefile]
 * (mazefile is ASCII representation of a maze, using symbols below)
 *
 * ALGORITHM for finding exit from starting position:
 * 
 * Check if the next move will lead to an exit. If it does, congratulations the maze is solved! If not, then check if the 
 * next move lands on a valid path. If not, then stop exploring that path. If it is valid, then go on that path. Once on the next path, check if going up
 * will lead to an exit. If not, check if going right will lead to an exit. If not, then check if going left will lead to an exit. If not, then check if going
 * down will lead to an exit. If none of these directions work, then the path you are currently on is invalid, so mark it down and go back one step. Rinse and Repeat.  
 *  
 * 
 * DISCO
 * 
 * 1. A precondition is that there is a buffer for the mazes
 * 2. Check if next move is exit first and then check if on path.
 * 
 * QCC
 * 
 * 1. What is the point of _solved? 
 * 2. How can we improve our algorithm?
 * 
 ***/

//enable file I/O
import java.io.*;
import java.util.*;

class MazeSolver
{
  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  public int h, w; // height, width of maze
  private boolean _solved;

  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
  final private char HERO =           '@';
  final private char PATH =           '#';
  final private char WALL =           ' ';
  final private char EXIT =           '$';
  final private char VISITED_PATH =   '.';
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    _maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
      Scanner sc = new Scanner( new File(inputFile) );

      System.out.println( "reading in file..." );

      int row = 0;

      while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          _maze[i][row] = line.charAt( i );

        h++;
        row++;
      }

      for( int i=0; i<w; i++ )
        _maze[i][row] = WALL;
      h++;
      row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    _solved = false;
  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, ESC
    //emacs shortcut: M-x quoted-insert, ESC

    int i, j;
    for( i=0; i<h; i++ ) {
      for( j=0; j<w; j++ )
        retStr = retStr + _maze[j][i];
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   **/
  public void solve( int x, int y )
  {
    delay( FRAME_DELAY ); //slow it down enough to be followable
    
    //check if solved
    if( _maze[x][y] == EXIT ) {
        //do we need to add code to move player here
        _solved = true;
    } 
    
    //deactivate if solved
    if ( _solved ) {
      System.out.println("MAZE SOLVED!");
      System.exit(0);
    }

    //check if not on a path
    if( !onPath(x, y) ) {
        return;
    }
    
    //otherwise, recursively solve maze from next pos over,
    //after marking current location
    else {
      //set current tile to hero tile
      _maze[x][y] = HERO;
      System.out.println( this ); //refresh screen

      solve(x - 1, y); //up
      solve(x, y - 1); //left
      solve(x, y + 1); //right
      solve(x + 1, y); //down

      //if none of the above moves leads to a solve then mark paths
      _maze[x][y] = VISITED_PATH;
      System.out.println( this ); //refresh screen
    }
    
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) {
    return _maze[x][y] == PATH;  
  }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    String mazeInputFile = null;

    try {
      mazeInputFile = args[0];
    } catch( Exception e ) {
      System.out.println( "Error reading input file." );
      System.out.println( "USAGE:\n $ java Maze path/to/filename" );
    }

    if (mazeInputFile==null) { System.exit(0); }

    MazeSolver ms = new MazeSolver( mazeInputFile );

    //clear screen
    System.out.println( "[2J" );

    //display maze
    System.out.println( ms );

    // ThinkerTODO: comment next line out when ready to randomize startpos
    //ms.solve( 0, 0 );

    //drop our hero into maze at random location on path
    int startX = (int) ( Math.random() * ms.w );
    int startY = (int) ( Math.random() * ms.h );

    //continously loop until valid position found
    while( ! ms.onPath(startX, startY) ){
      startX = (int) ( Math.random() * ms.w );
      startY = (int) ( Math.random() * ms.h );
    }

    ms.solve( startX, startY );
  }//end main()

}//end class Maze