/*
===================================
PROBLEM:)
===================================
Find sum of all leaf nodes of a given BT
*/

/*
=========================================
APPROACH:)
=========================================
we return the value of the nodes to previous call if its a leaf nodes
we store the sum of leaf nodes of the left subtree in v1 and sum of leaf nodes of right subtree in the v2 and add then retrun this to the previous call

Time : O(n)
Space : O(h)
*/
public class p6_sum_of_all_leaf_nodes extends helper {
 public static void main(String[] args) {

  treeNode root = new treeNode(10);
  root.left = new treeNode(20);
  root.right = new treeNode(30);
  root.left.left = new treeNode(40);
  root.left.right = new treeNode(60);
  root.right.left = new treeNode(90);

  System.out.println(sum_leaf_nodes(root));
 }

 public static int sum_leaf_nodes(treeNode root) {
  if (root == null) {
   return 0;
  }

  else if (root.left == null && root.right == null) {
   return (root.data);
  }

  return (sum_leaf_nodes(root.left) + sum_leaf_nodes(root.right));
 }

}
