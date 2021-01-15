package TREE.TREE_easy;
/*
==============================
PROBLEM:)
===============================
Given a tree's root, print the inorder traversal for the tree recursively
*/

/*
==============================
APPROACH:)
==============================
here we make a function inOrder which is returning an arraylist
making a list first so that even if there are no nodes in the tree, we can return an empty list (type ArrayList)
in inorder traversal we print the left subtree first, then the root and then the right subtree

so we repeteadly make calls for root.left till we hit null and then come back to the previous call and add the data of the node to list
at each call a new list is made and so when coming back from null to root, we do the addAll operation so that the elements encountered in the way at different calls are still stored in the same list (sublists from each call are stored in the list)

same is done for the right subtree

time : O(n) [every node is visited once]
space : O(h) 
h is the height of the tree
*/

import java.util.ArrayList;

public class p1_recursive_inorder extends helper {

 public static ArrayList<Integer> inOrder(treeNode root) {
  ArrayList<Integer> list = new ArrayList<Integer>();
  if (root == null)
   return list;
  list.addAll(inOrder(root.left));
  list.add(root.data); // adding the leftmost leaf of the tree
  list.addAll(inOrder(root.right));
  return list;
 }

 public static void main(String[] args) {

  treeNode root = new treeNode(10);
  root.left = new treeNode(20);
  root.right = new treeNode(30);
  root.left.left = new treeNode(40);
  root.left.right = new treeNode(60);
  root.right.left = new treeNode(50);

  System.out.println(inOrder(root));
 }
}
