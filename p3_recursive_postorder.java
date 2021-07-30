import java.util.ArrayList;

/*
===========================
PROBLEM:)
===========================
Given a tree's root, print the pOSTorder traversal for the tree recursively
*/

/*
==============================
APPROACH:)
==============================
similar to inorder and preorder
in postorder we print the left subtree first and then the right subtree and in the end the root

time : O(n) [every node is visited once]
space : O(h) 
h is the height of the tree
*/

public class p3_recursive_postorder extends helper {
 public static void main(String[] args) {
  treeNode root = new treeNode(19);
  root.left = new treeNode(10);
  root.right = new treeNode(8);
  root.left.left = new treeNode(11);
  root.left.right = new treeNode(13);

  System.out.println(postorder(root));
 }

 public static ArrayList<Integer> postorder(treeNode root) {
  ArrayList<Integer> result = new ArrayList<Integer>();

  if (root != null) {
   result.addAll(postorder(root.left));
   result.addAll(postorder(root.right));
   result.add(root.data);
  }
  return result;
 }
}
