package TREE.TREE_easy;
//iteration 

/*
========================================
PROBLEM:) //669
========================================
Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

The number of nodes in the tree in the range [1, 104].
0 <= Node.val <= 104
The value of each node in the tree is unique.
root is guaranteed to be a valid binary search tree.
0 <= low <= high <= 104
*/

/*
======================================================================================================
APPROACH:)
=======================================================================================================
we have a BST, so if the current node's value is less than the lowest value in the range, we go to right of that node and replace the value with the bigger value
similarly, if the value is greater than the highest value in the range, we go to left
we have to make changes in the left and the right side, so every time we cut off a node, we update the trimmed tree in the main tree by assigning it in the root.left and root.right of the parrent node of the current node 

Time : O(n) every node (assuming there are n nodes in the tree) is visited at most once
Space : O(n); no aux space; just the size of the call stack in the worst case(skew tree)
*/

public class x21_trim_BST extends helper {

 public static treeNode trimBST(treeNode root, int low, int high) {
  if (root == null) {
   return root;
  }

  if (root.data < low) {
   return trimBST(root.right, low, high);
  }

  if (root.data > high) {
   return trimBST(root.left, low, high);
  }

  root.left = trimBST(root.left, low, high);
  root.right = trimBST(root.right, low, high);

  return root;

 }

 public static void inorder(treeNode root) {
  if (root != null) {
   inorder(root.left);
   System.out.print(root.data + " ");
   inorder(root.right);
  }
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(3);
  root.left = new treeNode(0);
  root.right = new treeNode(4);
  root.left.right = new treeNode(2);
  root.left.right.left = new treeNode(1);

  // skew tree
  /*
   * treeNode root = new treeNode(5); root.left = new treeNode(4); root.left.left
   * = new treeNode(3); root.left.left.left = new treeNode(2);
   * root.left.left.left.left = new treeNode(1);
   */

  int low = 2;
  int high = 4;

  inorder(trimBST(root, low, high));

 }

}
