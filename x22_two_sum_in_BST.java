package TREE.TREE_easy;

import java.util.ArrayList;
import java.util.List;

/*
=========================================
PROBLEM:) 653
=========================================
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
*/

/*
==========================================
APPROACH:)
==========================================
here we make use of the fact that we are given a BST and inorder traversal will give a dorted list
so we make a list and then store the elements of tree in inorder fashion
after that we use Binary search to solve the problem(two sum problem)

if we find the said target as sum of two numbers in the list, return true; else false

Time : O(n). We need to traverse over the whole tree once to do the inorder traversal. Here, nn refers to the number of nodes in the given tree.
Space : O(n). The sorted listlist will contain nn elements.
*/

/*
====================================
HASHSET SOLUTION :)
=====================================


*/

public class x22_two_sum_in_BST extends helper {

 public static boolean findTarget(treeNode root, int k) {
  List<Integer> list = new ArrayList<>();
  inorder(root, list);

  int low = 0;
  int high = list.size() - 1;

  while (low < high) {
   int sum = list.get(low) + list.get(high);
   if (sum == k) {
    return true;
   }

   else if (sum < k) {
    low++;
   }

   else {
    high--;
   }
  }
  return false;
 }

 public static void inorder(treeNode root, List<Integer> list) {
  if (root != null) {
   inorder(root.left, list);
   list.add(root.data);
   inorder(root.right, list);
  }
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(5);
  root.left = new treeNode(3);
  root.right = new treeNode(6);
  root.left.left = new treeNode(2);
  root.left.right = new treeNode(4);
  root.right.right = new treeNode(7);

  int k = 28;

  System.out.println(findTarget(root, k));
 }
}
