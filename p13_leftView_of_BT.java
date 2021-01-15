package TREE.TREE_easy;

import java.util.*;

//A simple solution is to do level order traversal and print the first node in every level.

public class p13_leftView_of_BT extends helper {
 static int max_level = 0;

 void leftView_two(ArrayList<Integer> result, treeNode root, int level) {
  if (root == null) {
   return;
  }
  if (max_level < level) {
   result.add(root.data);
   max_level = level;
  }

  // Recur for left and right subtrees
  leftView_two(result, root.left, level + 1);
  leftView_two(result, root.right, level + 1);

 }

 ArrayList<Integer> leftView(treeNode root) {
  ArrayList<Integer> result = new ArrayList<Integer>();
  leftView_two(result, root, 1);

  return result;
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(12);
  root.left = new treeNode(10);
  root.right = new treeNode(30);
  root.right.left = new treeNode(25);
  root.right.right = new treeNode(40);

  p13_leftView_of_BT obj = new p13_leftView_of_BT();
  System.out.print(obj.leftView(root));
 }

}