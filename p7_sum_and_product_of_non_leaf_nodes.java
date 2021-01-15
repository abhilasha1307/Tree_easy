package TREE.TREE_easy;

/*
=========================================
PROBLEM:)
==========================================
find sum and product of non leaf nodes for a given tree
*/

/*
==========================================
APPROACH:)
===========================================
for sum function, we add root.data to its left and right tree calls only if its a non leaf node
for leaf node, we return 0

In product, its same as above, but for leaf nodes we return 1 instead of zero (any number * 1 is the same number)

Time : O(n) for both functions (separately)
Space :O(h)
*/

public class p7_sum_and_product_of_non_leaf_nodes extends helper {

 public static int Sum(treeNode root) {
  if (root == null) {
   return 0;
  }

  else if (root.left == null && root.right == null) {
   return 0;
  }

  else {

   return (root.data + Sum(root.left) + Sum(root.right));
  }
 }

 public static int Product(treeNode root) {
  if (root == null) {
   return 1;
  }

  else if (root.left == null && root.right == null) {
   return 1;
  }

  else {

   return (root.data * Product(root.left) * Product(root.right));
  }
 }

 public static void main(String[] args) {

  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(30);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(6);

  System.out.println(Sum(root));
  System.out.println(Product(root));
 }
}

// ===================================
// alternate code
// ===================================

/*
 * static class Int { int a; }
 * 
 * // Computes the product of non-leaf // nodes in a tree static void
 * findProductSum(Node root, Int prod, Int sum) { // Base cases if (root == null
 * || (root.left == null && root.right == null)) return;
 * 
 * // if current node is non-leaf, // calculate product and sum if (root.left !=
 * null || root.right != null) { prod.a *= root.data; sum.a += root.data; }
 * 
 * // If root is Not null and its one of its // child is also not null
 * findProductSum(root.left, prod, sum); findProductSum(root.right, prod, sum);
 * }
 */