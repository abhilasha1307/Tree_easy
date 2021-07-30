/*
========================================
PROBLEM:)
========================================
Sum of all nodes in the given BT
*/

/*
=========================================
APPROACH:)
=========================================
if we reach null return zero
add the current node's value to the all the nodes to its left and all the nodes to its right(preorder traversal) and return the final sum

Time : O(n)
Space :O(h)
*/
public class p5_sum_of_all_nodes_of_BT extends helper {

 public static void main(String[] args) {

  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(5);
  root.right.left = new treeNode(6);
  root.right.right = new treeNode(7);

  System.out.println(sum(root));
 }

 public static int sum(treeNode root) {
  if (root == null)
   return 0;

  return (root.data + sum(root.left) + sum(root.right));
 }

}