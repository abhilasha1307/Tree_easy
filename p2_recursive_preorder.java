package TREE.TREE_easy;

import java.util.ArrayList;

/*
==============================
PROBLEM:)
==============================
Given a tree's root, print the preorder traversal for the tree recursively
*/

/*
========================
APPROACH:)
========================
similar to inorder
in preorder we print the root first, then the left and finally the right subtree

time : O(n) [every node is visited once]
space : O(h) 
h is the height of the tree
*/

public class p2_recursive_preorder extends helper {

 public static ArrayList<Integer> preorder(treeNode root) {
  ArrayList<Integer> list = new ArrayList<Integer>();

  if (root == null)
   return list;

  list.add(root.data);
  list.addAll(preorder(root.left));
  list.addAll(preorder(root.right));

  return list;
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  /*
   * root.left_child = new treeNode(6); root.right_child = new treeNode(9);
   * root.left_child.right_child = new treeNode(12); root.right_child.left_child =
   * new treeNode(11);
   */

  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(5);
  root.right.left = new treeNode(6);
  root.right.right = new treeNode(7);
  System.out.println(preorder(root));
 }

}
