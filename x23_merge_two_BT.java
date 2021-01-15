package TREE.TREE_easy;

//try with iterative
/*
==============================================
PROBLEM:)  617
==============================================
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Note: The merging process must start from the root nodes of both trees.
*/

/*
===========================================
APPROACH:)
===========================================
We will change one of the trees to be a merged version of the two given trees(here t1)
if both the nodes are not null, we assign their added value to t1.data
if t1 is null and t2 is not null at the same moment, we will assign the non null part to t1 
and if t1 is not null but t2 is, we assign the non null part (t1) to t1

we do this for both left and right subtrees and then return t1

Time : O(n), total n nodes are being traversed, n is the minimum number of nodes from the given two trees

Space : O(n)
The depth of the recursion tree can go upto n in case of a skewed tree. In average case, depth will be O(logn).
here n is the maximum nodes there are in any of the two trees
*/
public class x23_merge_two_BT extends helper {

 public static treeNode mergeTrees(treeNode t1, treeNode t2) {
  if (t1 == null) {
   return t2;
  }

  if (t2 == null) {
   return t1;
  }

  t1.data += t2.data;

  t1.left = mergeTrees(t1.left, t2.left);
  t1.right = mergeTrees(t1.right, t2.right);

  return t1;
 }

 public static void inorder(treeNode root) {
  if (root != null) {
   inorder(root.left);
   System.out.print(root.data + " ");
   inorder(root.right);
  }
 }

 public static void main(String[] args) {
  treeNode t1 = new treeNode(1);
  t1.left = new treeNode(3);
  t1.right = new treeNode(2);
  t1.left.left = new treeNode(5);

  treeNode t2 = new treeNode(2);
  t2.left = new treeNode(1);
  t2.right = new treeNode(3);
  t2.left.right = new treeNode(4);
  t2.right.right = new treeNode(7);

  inorder(mergeTrees(t1, t2)); // 5 4 4 3 5 7
 }

}
