package hw2;

import java.util.LinkedList;

/* ***********************************************************************
 * A simple BST with int keys and no values
 *
 * Complete each function below.
 * Write each function as a separate recursive definition (do not use more than one helper per function).
 * Depth of root==0.
 * Height of leaf==0.
 * Size of empty tree==0.
 * Height of empty tree=-1.
 *
 * TODODone: complete the functions in this file.
 * DO NOT change the Node class.
 * DO NOT change the name or type of any function (the first line of the function)
 *
 * Restrictions:
 *  - no loops (you cannot use "while" "for" etc...)
 *  - only one helper function per definition
 *  - no fields (static or non static).  Only local variables
 *************************************************************************/
public class MyIntSET {
	private Node root;
	private static class Node {
		public final int key;
		public Node left, right;
		public Node(int key) { this.key = key; }
	}


	// the number of nodes in the tree
	public int size() {
		// TODODone
		return size(root);
	}
	
	private int size(Node n) {
		if (n == null)
			return 0;
		int left = size(n.left);
		int right = size(n.right);
		return left + right + 1;
	}

	// Recall the definitions of height and depth.
	// in the BST with level order traversal "41 21 61 11 31",
	//   node 41 has depth 0, height 2
	//   node 21 has depth 1, height 1
	//   node 61 has depth 1, height 0
	//   node 11 has depth 2, height 0
	//   node 31 has depth 2, height 0
	// height of the whole tree is the height of the root

	// the height of the tree
	// 20 points
	public int height() {
		// TODODone
		return height(root);
	}
	
	private int height(Node n) {
		if (n == null) return -1;
		int left = height(n.left);
		int right = height(n.right);
		int deeper;
		if (left <= right) deeper = right;
		else deeper = left;
		return deeper + 1;
	}

	// the number of nodes with odd keys
	// 20 points
	public int sizeOdd() {
		// TODODone
		return sizeOdd(root);
	}
	
	private int sizeOdd(Node n){
		if (n == null) return 0;
		int left = sizeOdd(n.left);
		int right = sizeOdd(n.right);
		if (n.key % 2 != 0) return 1 + left + right;
		return left + right;
	}

	
	// tests if this tree and that tree look the same (i.e. have the same keys
	// in the same locations).  It is NOT enough that the trees contain the same
	// keys.
	// 20 points
	public boolean treeEquals(MyIntSET that) {
		// TODODone
		return treeEquals(root, that.root);
	}
	
	private boolean treeEquals(Node n, Node tN){
		if (n == null || tN == null){
			if (n == null && tN == null) return true;
			return false;
		}
		if (n.key == tN.key) {
			return (treeEquals(n.left, tN.left) && treeEquals(n.right, tN.right));
		}
		return false;
	}
	
	
	// The next three functions compute the size of the tree at depth k.
	// It should be the case that for any given k,
	//
	//   sizeAbove(k) + sizeAt(k) + sizeBelow(k) = size()
	//
	// The words "above" and "below" assume that the root is at the "top".
	//
	// Suppose we have with size N and height H (so max depth also H).
	// For such a tree, we expect
	//
	//   sizeAboveDepth (-1)  = 0
	//   sizeAtDepth    (-1)  = 0
	//   sizeBelowDepth (-1)  = N
	//
	//   sizeAboveDepth (0)   = 0
	//   sizeAtDepth    (0)   = 1
	//   sizeBelowDepth (0)   = N-1
	//
	//   sizeAboveDepth (H+1) = N
	//   sizeAtDepth    (H+1) = 0
	//   sizeBelowDepth (H+1) = 0
	//
	// the number of nodes in the tree, at exactly depth k
	// include node n if depth(n) == k
	// 10 points
	public int sizeAtDepth(int k) {
		// TODODone
		return sizeAtDepth(root, k, 0);
	}
	
	private int sizeAtDepth(Node n, int k, int depth){
		if (n == null) return 0;
		if (k == depth) return 1;
		return (sizeAtDepth(n.left, k, depth + 1)) +(sizeAtDepth(n.right,k, depth + 1));
	}

	// the number of nodes in the tree, "above" depth k (not including k)
	// include node n if depth(n) < k
	// 10 points
	public int sizeAboveDepth(int k) {
		// TODOdone
		return sizeAboveDepth(root, k, 0);
	}
	
	private int sizeAboveDepth(Node n, int k, int depth){
		if (n == null || k == depth) return 0;
		return 1 + (sizeAboveDepth(n.left, k, depth + 1) + (sizeAboveDepth(n.right, k, depth + 1)));
	}

	// tree is perfect if for every node, size of left == size of right
	// hint: in the helper, return -1 if the tree is not perfect, otherwise return the size
	// 10 points
	public boolean isPerfectlyBalancedS() {
		// TODOdone
		return (isPerfectlyBalancedS(root, 0) >= 0);
	}
	
	private int isPerfectlyBalancedS(Node n, int cntr){
		if (n == null) return 0;
		int left = isPerfectlyBalancedS(n.left, cntr);
		int right = isPerfectlyBalancedS(n.right, cntr);
		if (left == right) return left + right + 1;
		return -1;
	}

	
	/*
	 * Mutator functions
	 * HINT: This is easier to write if the helper function returns Node, rather than void
	 * similar to how the delete method from the book works.
	 */

	// remove all subtrees with odd roots (if node is odd, remove it and its descendants)
	// A node is odd if it has an odd key
	// If the root is odd, then you should end up with the empty tree
	// 10 points
	public void removeOddSubtrees () {
		root = removeOddSubtrees(root);
		// TODO
	}
	
	private Node removeOddSubtrees(Node n){
		if (n == null) return n;
		if (n.key % 2 != 0) return null;
		n.left = removeOddSubtrees(n.left);
		n.right = removeOddSubtrees(n.right);
		return n;
	}



	/* ***************************************************************************
	 * Some methods to create and display trees
	 *****************************************************************************/

	// Do not modify "put"
	public void put(int key) { root = put(root, key); }
	private Node put(Node n, int key) {
		if (n == null) return new Node(key);
		if      (key < n.key) n.left  = put(n.left,  key);
		else if (key > n.key) n.right = put(n.right, key);
		return n;
	}
	// This is what contains looks like
	public boolean contains(int key) { return contains(root, key); }
	private boolean contains(Node n, int key) {
		if (n == null) return false;
		if      (key < n.key) return contains(n.left,  key);
		else if (key > n.key) return contains(n.right, key);
		return true;
	}
	// Do not modify "copy"
	public MyIntSET copy () {
		MyIntSET that = new MyIntSET ();
		for (int key : levelOrder())
			that.put (key);
		return that;
	}
	// Do not modify "levelOrder"
	public Iterable<Integer> levelOrder() {
		LinkedList<Integer> keys = new LinkedList<Integer>();
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			if (n == null) continue;
			keys.add(n.key);
			queue.add(n.left);
			queue.add(n.right);
		}
		return keys;
	}
	// Do not modify "toString"
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int key: levelOrder())
			sb.append (key + " ");
		return sb.toString ();
	}
	
	public void prettyPrint() {
		if (root == null)
			System.out.println("<EMPTY>");
		else
			prettyPrintHelper(root, "");
	}
	
	private void prettyPrintHelper(Node n, String indent) {
		if (n != null) {
			System.out.println(indent + n.key);
			indent += "    ";
			prettyPrintHelper(n.left, indent);
			prettyPrintHelper(n.right, indent);
		}
	}

	
	// create a tree from a string
	public static MyIntSET fromString (String ints) {
		MyIntSET set = new MyIntSET ();
		for (String s : ints.split (" "))
			set.put (Integer.parseInt (s));
		return set;
	}
	
}
