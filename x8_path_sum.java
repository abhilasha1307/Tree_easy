package TREE.TREE_easy;

/*
====================================================
PROBLEM:) 112
====================================================
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.
*/

/*
===================================================
APPROACH:)
===================================================
for current node, we subtract the value of this node from sum and check if we find a node along some path(dfs) of the tree such that sum-root.data = 0 and this node is a leaf node
if yes we return yes
if during checking, we reach null, that means the said path will not give path sum = sum given, so we return null
either left of right subtree (or both, but we wont get to check both, the first path sum will return true) can return the path sum so we use || and not &&

Time : O(n)
Space : O(h)
*/
public class x8_path_sum extends helper {

 public static boolean hasPathSum(treeNode root, int sum) {

  if (root == null) {
   return false;
  }

  else if (sum - root.data == 0 && root.left == null && root.right == null) {
   return true;
  }

  return (hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data));

 }

 public static void main(String[] args) {
  treeNode root = new treeNode(5);
  root.left = new treeNode(4);
  root.right = new treeNode(8);
  root.left.left = new treeNode(11);
  root.left.left.left = new treeNode(7);
  root.left.left.right = new treeNode(2);
  root.right.left = new treeNode(13);
  root.right.right = new treeNode(4);
  root.right.right.right = new treeNode(1);

  int sum = 22;
  System.out.println(hasPathSum(root, sum));

 }

}
