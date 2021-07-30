/*
==============================================
PROBLEM:)
==============================================
Given a Binary Tree, find diameter of it.
The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).

*/

public class p20_diameter_of_BT extends helper {

 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(5);
  root.right.left = new treeNode(6);
  root.right.right = new treeNode(7);

  p20_diameter_of_BT ob = new p20_diameter_of_BT();
  System.out.println(ob.diameter(root));
 }

 int result = Integer.MIN_VALUE;

 int diameter(treeNode root) {
  height(root);
  return result;
 }

 public int height(treeNode node) {
  if (node == null) {
   return 0;
  }

  int left = height(node.left);
  int right = height(node.right);

  result = Math.max(result, 1 + left + right);
  return (1 + Math.max(left, right));
 }

}
