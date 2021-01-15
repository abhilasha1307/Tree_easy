package TREE.TREE_easy;

/*
====================================
PROBLEM:) 530
=====================================
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
There are at least two nodes in this BST.
*/

/*
======================================
APPROACH:)
======================================
Since this is a BST, the inorder traversal of its nodes results in a sorted list of values
Thus, the minimum absolute difference must occur in any adjacently traversed nodes. 

use prev to keep track of the inorder predeccessor and min to keep track of the the min difference till the current node

Time : O(N)
Space :O(h)
*/
public class x14_minimum_absolute_difference_in_BST extends helper {

 Integer min = Integer.MAX_VALUE;
 treeNode prev; // to keep track of inorder predeccessor

 public int getMinimumDifference(treeNode root) {

  inorder(root);
  return min;
 }

 public void inorder(treeNode node) {
  if (node == null) {
   return;
  }

  inorder(node.left);
  if (prev != null) {
   min = Math.min(min, node.data - prev.data);
  }

  prev = node;

  inorder(node.right);
 }

 public static void main(String[] args) {
  x14_minimum_absolute_difference_in_BST obj = new x14_minimum_absolute_difference_in_BST();
  treeNode root = new treeNode(5);
  root.left = new treeNode(2);
  root.left.left = new treeNode(1);
  root.left.right = new treeNode(4);
  root.right = new treeNode(8);
  root.right.left = new treeNode(6);
  root.right.right = new treeNode(9);

  System.out.println(obj.getMinimumDifference(root));
 }

}
