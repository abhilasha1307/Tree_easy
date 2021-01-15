package TREE.TREE_easy;
/*
===========================
PROBLEM :)
============================
given the root of a tree, we have to find the height of the tree
*/

/*
===============================
APPROACH :)
==============================
for every node we will first calulate the height of the left subtree and then the right subtree
and then compare the heights, the greater + 1 (for the current node) is returned back to the previous call (leaf is at height 1,increasing towards leaf to root)
return the height

Time : O(n); every node is visited once
Space : O(h); h is the heigth of the tree (O(n) for skewed tree)
*/
public class p4_height_of_BT extends helper {

 public static int height(treeNode root) {

  if (root == null) {
   return 0;
  }
  int max_left = height(root.left);
  int max_right = height(root.right);

  if (max_left > max_right) {
   return max_left + 1;
  }

  else {
   return max_right + 1;
  }
 }

 public static void main(String[] args) {

  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(5);
  root.left.left.left = new treeNode(8);
  root.left.left.left.left = new treeNode(9);
  root.left.left.left.right = new treeNode(10);
  root.right.left = new treeNode(6);
  root.right.right = new treeNode(7);

  System.out.println(height(root));

 }

}
