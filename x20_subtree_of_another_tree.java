/*
===============================================
PROBLEM:) 572
================================================
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. 
A subtree of s is a tree consists of a node in s and all of this node's descendants. 
The tree s could also be considered as a subtree of itself.
*/

/*
=====================================================
APPROACH:)
=====================================================
here we are given two trees, to find if one is subtree of another their nodes should be in same relative positions
so we start comparing from root of tree 's' and root of tree 't', if we find that it is a subtree, we return true from the 'check' function
if not, then we check for it in the left subtree and right subtree, if we find it in either, we return true, else false

if s is null or t is null then t is not a subtree of the bigger tree, s we return false
if they both are null at the same time, we return true
if their values are same at the same time, then for that one node, we return true.

Time : O(m*n). In worst case(skewed tree) traverse function takes O(m*n) time.
in the  case where we dont find the 't' in 's', we will be checking all the nodes of 's' for all the nodes of 't' and so, we get O(m*n) 
m is the nodes in tree 't'. n is the nodes in tree 's'. 

Space : O(n). The depth of the recursion tree can go upto nn. nn refers to the number of nodes in s (bigger tree).
*/

public class x20_subtree_of_another_tree extends helper {
 public static boolean isSubtree(treeNode s, treeNode t) {

  if (s == null || t == null) {
   return false;
  }

  if (check(s, t))
   return true;

  return isSubtree(s.left, t) || isSubtree(s.right, t); // x

 }

 public static boolean check(treeNode s, treeNode t) {
  if (s == null && t == null) {
   return true;
  }

  if (s == null || t == null) {
   return false;
  }

  return (s.data == t.data && check(s.left, t.left) && check(s.right, t.right));
 }

 public static void main(String[] args) {
  treeNode s = new treeNode(3);
  s.left = new treeNode(4);
  s.right = new treeNode(5);
  s.left.left = new treeNode(1);
  s.left.right = new treeNode(2);
  s.left.right.left = new treeNode(0);

  treeNode t = new treeNode(4);
  t.left = new treeNode(1);
  t.right = new treeNode(2);
  t.right.left = new treeNode(0);

  System.out.println(isSubtree(s, t));
 }

}
