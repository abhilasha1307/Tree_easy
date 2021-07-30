/*
==================================================
PROBLEM:) 700
==================================================
Given the root node of a binary search tree (BST) and a value. 
You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
*/

/*
======================================================
APPROACH:)
======================================================
since its a BST, at every node, we compare the value to be found with node.data
if value > node.data we go to right to search the value else we go left
once found we return the whole subtree which starts at that node and then print the inorder of this returned subtree

Time : O(log n) log n is the height of the tree
if tree is skew tree then, time is O(n)

Space:O(logn)
for skew tree : O(n)
*/
public class x15_search_in_a_BST extends helper {
 public static treeNode searchBST(treeNode root, int val) {
  if (root == null || root.data == val) {
   return root;
  }

  if (val > root.data) {
   return searchBST(root.right, val);
  }

  return searchBST(root.left, val);
 }

 public static void inorder(treeNode root) {
  if (root != null) {
   inorder(root.left);
   System.out.print(root.data + " ");
   inorder(root.right);
  }
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(4);
  root.left = new treeNode(2);
  root.right = new treeNode(7);
  root.left.left = new treeNode(1);
  root.left.right = new treeNode(3);

  int val = 2;
  treeNode res = searchBST(root, val);
  if (res == null) {
   System.out.println("No such value is present in the tree");
  }

  else {
   inorder(res);
  }
 }
}
