import java.util.*;

/*
========================================
PROBLEM:)
=======================================
Given a Binary Tree, print right view of it. Right view of a Binary Tree is set of nodes visible when tree is visited from right side.
*/

/*
==========================================
APPROACH:)
==========================================
similar to left view of BT
difference: calling is done for right subtree first and then left subtree

Time: O(N) N = number of nodes in the tree
Space: O(N) ; skewed tree 
*/
public class p14_rightView_of_BT extends helper {
 int max_level = 0;

 void rightView_two(ArrayList<Integer> result, treeNode root, int level) {
  if (root == null) {
   return;
  }
  if (max_level < level) {
   result.add(root.data);
   max_level = level;
  }

  // Recur for left and right subtrees
  rightView_two(result, root.right, level + 1);
  rightView_two(result, root.left, level + 1);

 }

 ArrayList<Integer> rightView(treeNode root) {
  ArrayList<Integer> result = new ArrayList<Integer>();
  rightView_two(result, root, 1);
  return result;

 }

 public static void main(String args[]) {
  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(5);
  root.right.left = new treeNode(6);
  root.right.right = new treeNode(7);
  root.right.left.right = new treeNode(8);

  p14_rightView_of_BT obj = new p14_rightView_of_BT();
  System.out.println(obj.rightView(root));

 }
}