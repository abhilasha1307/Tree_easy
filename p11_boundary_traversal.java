package TREE.TREE_easy;

import java.util.*;

/*
=========================================
PROBLEM:)
=========================================
Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. The boundary includes left boundary, leaves, and right boundary in order without duplicate nodes. (The values of the nodes may still be duplicates.)

*/

/*
==========================================
APPROACH:)
==========================================
we make 3 functions, one for the left edge of the tree, one for leaves and one for the right edge of the tree
first add the root to array list

call left function and pass root.left and list to the function
we will go only left for a node(almost always), unless a said node doesnt have a left child but has right child and this right child is a boundary element
in this function we will add root.data to list first and then traverse further (ACW direction => top to down on the left edge/ preorder gives top to down)

call leaves function (We will call for left subtree leaves and right subtree leaves separately) 
here we can use either inorder or post order traversal fashion and add the node to the list only when its a leaf

call right function and pass root.right and list
we will go only right for a node(almost always), unless a said node doesnt have a right child but has left child and this left child is a boundary element
we will follow postorder fashion as we want the elements to be in down to top order

Time : O(N) every node is visited, once in at least one function
Space : O(number of boundary elements) [for arraylist]
and call sstack will take up O(h) 
*/

public class p11_boundary_traversal extends helper {

 public static ArrayList<Integer> Boundary(treeNode root) {
  ArrayList<Integer> result = new ArrayList<>();
  if (root == null) {
   return result;
  }

  result.add(root.data);
  Left(root.left, result);
  Leaves(root.left, result);
  Leaves(root.right, result);
  Right(root.right, result);

  return result;
 }

 public static void Left(treeNode node, ArrayList<Integer> list) {
  if (node != null) {
   if (node.left != null) {
    list.add(node.data);
    Left(node.left, list);
   }

   else if (node.right != null) {
    list.add(node.data);
    Left(node.right, list);
   }
  }
 }

 public static void Leaves(treeNode node, ArrayList<Integer> list) {
  if (node != null) {
   Leaves(node.left, list);

   Leaves(node.right, list);

   if (node.left == null && node.right == null) {
    list.add(node.data);
   }

  }
 }

 public static void Right(treeNode node, ArrayList<Integer> list) {
  if (node != null) {
   if (node.right != null) {
    Right(node.right, list);
    list.add(node.data);
   }

   else if (node.left != null) {
    Right(node.left, list);
    list.add(node.data);
   }
  }
 }

 public static void main(String[] args) {

  treeNode root = new treeNode(20);
  root.left = new treeNode(8);
  root.right = new treeNode(22);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(12);
  root.left.right.left = new treeNode(10);
  root.left.right.right = new treeNode(14);
  root.right.right = new treeNode(25);

  /*
   * treeNode root = new treeNode(3); root.left = new treeNode(6); root.left.right
   * = new treeNode(9); root.left.right.left = new treeNode(10);
   * root.left.right.left.left = new treeNode(11); root.left.right.left.right =
   * new treeNode(12); root.right = new treeNode(17); root.right.left = new
   * treeNode(18); root.right.left.right = new treeNode(19);
   * root.right.left.right.left = new treeNode(13); root.right.left.right.right =
   * new treeNode(14);
   */

  System.out.println(Boundary(root));

 }

}
