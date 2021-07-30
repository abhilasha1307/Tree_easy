/*
===========================================
PROBLEM:)993
==========================================
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
*/

/*
===========================================
APPROACH:)
===========================================

Time : O(n)
Space : O(n); skew tree
Space (Avg case) : O(log n)
*/

/*
ALTERNATE CODE :

*/
public class x16_cousins_in_a_BT extends helper {

 public static boolean isCousins(treeNode root, int x, int y) {
  return (isSamelevel(root, x, 1) == isSamelevel(root, y, 1) && !isSibling(root, x, y));
 }

 public static int isSamelevel(treeNode node, int a, int level) {
  if (node == null) {
   return 0;
  }

  if (node.data == a) {
   return level;
  }

  int l = isSamelevel(node.left, a, level + 1);
  if (l != 0) {
   return l;
  }

  return isSamelevel(node.right, a, level + 1);

 }

 public static boolean isSibling(treeNode node, int x, int y) {
  if (node == null) {
   return false;
  }

  if (node.left != null && node.right != null) {
   if ((node.left.data == x && node.right.data == y) || (node.left.data == y && node.right.data == x)) {
    return true;
   }
  }
  boolean res = false;

  if (node.left != null) {
   res = isSibling(node.left, x, y);
  }

  if (res) {
   return res;
  }

  else {
   return isSibling(node.right, x, y);
  }
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.left.left = new treeNode(4);
  root.right = new treeNode(3);
  root.right.right = new treeNode(5);

  int x = 4;
  int y = 5;

  System.out.println(isCousins(root, x, y));
 }

}

// with Queue
/*
 * 
 * public static boolean isCousins(treeNode root, int x, int y) {
 * 
 * Queue<treeNode> Q = new LinkedList<>(); Q.add(root);
 * 
 * int levelX = -1; int levelY = -2; int level = 0; while (!Q.isEmpty()) { int
 * size = Q.size(); for (int i = 0; i < size; i++) { treeNode temp = Q.poll();
 * 
 * if (temp.left != null && temp.right != null) { if (temp.left.data == x &&
 * temp.right.data == y) { return false; }
 * 
 * if (temp.left.data == y && temp.right.data == x) { return false; } }
 * 
 * if (temp.data == x) levelX = level; if (temp.data == y) levelY = level;
 * 
 * if (temp.left != null) { Q.add(temp.left); }
 * 
 * if (temp.right != null) { Q.add(temp.right); } } level++; }
 * 
 * return levelX == levelY; }
 */