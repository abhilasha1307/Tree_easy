package TREE.TREE_easy;

/*
=============================================
PROBELM:) Given a Binary Tree, find sum of all right leaves in it.
==============================================
*/

/*
==========================================
APPROACH:)
==========================================
for a given root, we check if it has a right child and also if that right child is a leaf node
if yes, we will add this value and call the root.left on the current root, to take sum of right leaves in the left subtree of the current node

if no, we keep going left till we find the desired leaf or hit null and then do the same thing for right subtree.

Time : O(N)
Space :O(h)
*/
public class p9_sum_of_right_leaf_nodes extends helper {

 public static int Sum(treeNode root) {
  if (root == null) {
   return 0;
  }

  else if (root.right != null && (root.right.left == null && root.right.right == null)) {
   return (root.right.data + Sum(root.left));
  }

  else {

   return (Sum(root.left) + Sum(root.right));
  }
 }

 public static void main(String[] args) {

  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(5);
  root.left.left.right = new treeNode(2);
  root.right.right = new treeNode(8);
  root.right.right.left = new treeNode(6);
  root.right.right.right = new treeNode(7);

  System.out.println(Sum(root));

 }
}
