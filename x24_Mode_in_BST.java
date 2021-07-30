import java.util.ArrayList;

/*
==========================================================
PROBLEM:) 501
=========================================================
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.

Note: If a tree has more than one mode, you can return them in any order.
*/

/*
==============================================================
APPROACH:)
==============================================================
we will traverse the tree given and for distinct each element, we will count the frequecy(using count variable), and compare it with the max frequency (maxCount here)
If the count is greater than maxCount we replace the value of maxCount with count and empty the list, which held the element with second maximum frequency
If the the value we had previously(the one the root was pointing at, stored in lastVal here), is the same as the current value root points too, we will ++ the count as the same value has appeared again, incresing its frequency by 1
if not, then we put count = 0 and change the value of lastVal to root.val and then increment count by 1 

Time : O(N), N is the number of nodes in the tree
Space : O(H), H is the height of the tree and hence the space in the recursion stack + space taken by arraylist and array. Overall Space will be = O(H)
*/

public class x24_Mode_in_BST extends helper {

 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.right = new treeNode(2);
  root.right.left = new treeNode(2);

  int res[] = findMode(root);
  System.out.print('[');
  for (int i : res) {
   System.out.print(i + " ");
  }

  System.out.print(']');
 }

 private static int count = 0;
 private static int maxCount = 0;
 private static int lastVal = Integer.MIN_VALUE;

 private static ArrayList<Integer> list = new ArrayList<>();

 public static int[] findMode(treeNode root) {
  inOrder(root);
  int[] arr = new int[list.size()];
  int n = 0;

  for (int i : list) {
   arr[n++] = i;
  }
  return arr;
 }

 public static void inOrder(treeNode root) {
  if (root == null) {
   return;
  }

  inOrder(root.left);
  Util(root);
  inOrder(root.right);
 }

 public static void Util(treeNode root) {
  if (lastVal != root.data) {
   count = 0;
   lastVal = root.data;
  }
  count++;

  if (count > maxCount) {
   maxCount = count;
   list.clear();
   list.add(root.data);
  }

  else if (count == maxCount) {
   list.add(root.data);
  }

 }
}
