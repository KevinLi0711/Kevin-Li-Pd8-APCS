/*
Gatekeeping Gaslighting Girlbosses: Kevin Xiao, Lauren Lee, Kevin Li
APCS
HW96: BSTs is the Perfect Place for Shade
2022-05-10
time spent: .9 hours
*/
/*
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 *
 */


public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );
    if (_root == null){
    	_root = newNode;
    } else {
    	insert(_root, newNode);
    }

  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if (newNode.getValue() < stRoot.getValue()){
    	if (stRoot.getLeft() == null){
      	stRoot.setLeft(newNode);
      } else{
      	insert(stRoot.getLeft(), newNode);
      }
    } else if (newNode.getValue() >= stRoot.getValue()){
    	if (stRoot.getRight() == null){
      	stRoot.setRight(newNode);
      } else{
      	insert(stRoot.getRight(), newNode);
      }
    }

  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    System.out.print(currNode.getValue());
  	if (currNode.getLeft() != null) {
    	preOrderTrav(currNode.getLeft());
    }

    if (currNode.getRight() != null) {
    	preOrderTrav(currNode.getRight());

    }

  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav(_root);
  }
  public void inOrderTrav( TreeNode currNode )
  {

  	if (currNode.getLeft() != null) {
    	inOrderTrav(currNode.getLeft());
    }
    System.out.print(currNode.getValue());
    if (currNode.getRight() != null) {
    	inOrderTrav(currNode.getRight());
    }

  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav(_root);
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if (currNode.getLeft() != null) {
    	postOrderTrav(currNode.getLeft());
    }
    if (currNode.getRight() != null) {
    	postOrderTrav(currNode.getRight());
    }
    System.out.print(currNode.getValue());

  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  /*****************************************************
   * TreeNode search(int)
   * returns pointer to node containing target,
   * or null if target not found
   *****************************************************/
  TreeNode search( int target )
  {
    TreeNode currNode = _root;
    while (currNode.getValue() != target){
      if(target < currNode.getValue() && currNode.getLeft() != null){
        currNode = currNode.getLeft();
      }
      else if (target > currNode.getValue() && currNode.getRight() != null) {
        currNode = currNode.getRight();
      } else{
        return null;
      }
    }
    return currNode;
  }


  /*****************************************************
   * int height()
   * returns height of this tree (length of longest leaf-to-root path)
   * eg: a 1-node tree has height 1
   *****************************************************/
  public int height()
  {
    BST curr = new BST();
    curr._root = _root;
    while(curr._root.getLeft() != null || curr._root.getRight() != null){
      if (curr._root.getLeft() != null){
        curr._root = curr._root.getLeft();
        return curr.height()+1;
      } else {
        curr._root = curr._root.getRight();
        return curr.height()+1;
      }
    }
    return 0;

  }


  /*****************************************************
   * int numLeaves()
   * returns number of leaves in tree
   *****************************************************/
  public int numLeaves()
  {
    BST left = new BST();
    BST right = new BST();
    left._root = _root;
    right._root = _root;
    int leaves = 0;
    if(left._root.getLeft() != null){
      left._root = left._root.getLeft();
      leaves = leaves + left.numLeaves();
    }
    if(right._root.getRight() != null){
      right._root = right._root.getRight();
      leaves = leaves + right.numLeaves();
    }
    if(_root.getRight() == null && left._root.getLeft() == null){
      return 1;
    }
    return leaves;
  }



  //main method for testing
  public static void main( String[] args )
  {
      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );

      System.out.println( "\n-----------------------------");
      System.out.println( "pre-order traversal:" );
      arbol.preOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "in-order traversal:" );
      arbol.inOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "post-order traversal:" );
      arbol.postOrderTrav();

      System.out.println( "\n-----------------------------");

      System.out.println("testing height....");
      System.out.println(arbol.height() + " ... should be 2");

      System.out.println( "\n-----------------------------");
      System.out.println("testing search....");
      System.out.println(arbol.search(4).getValue());
      System.out.println(arbol.search(2).getValue());
      System.out.println(arbol.search(5).getValue());
      System.out.println(arbol.search(6).getValue());
      System.out.println(arbol.search(1).getValue());
      System.out.println(arbol.search(3).getValue());
      System.out.println(arbol.search(9));

      System.out.println( "\n-----------------------------");
      System.out.println("testing numLeaves....");
      System.out.println(arbol.numLeaves() + "... should be 3");

      BST a = new BST();

      a.insert( 4 );
      a.insert( 2 );
      a.insert( 5 );
      System.out.println(a.numLeaves() + "... should be 2");

      BST b = new BST();
      b.insert( 6 );
      b.insert( 3 );
      b.insert( 1 );
      System.out.println(b.numLeaves() + " ...should be 1");
      /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
