/*
=========================================
PROBLEM:) 938
=============================================
Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].

The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.val <= 105
1 <= low <= high <= 105
All Node.val are unique
*/

/*
==============================================
APPROACH:)
===============================================
make a variable 'sum' to store the current node's value if it lies b/w low and high
for every call made, the value of sum is incremented by either a non zero value(when its in the range) or zero
as this is a BST and we are starting at the root, if the root value is less than or equal to high, we can go to right (to find the closest value to the high of the range to add to sum) and similarly if the root value is greater than or equal to low, we go to left subtree

Time: O(n). going through all the nodes in the tree
Space : O(n).
For the recursive implementation, the recursion will consume additional space in the function call stack. In the worst case, the tree is of chain shape, and we will reach all the way down to the leaf node

*/
public class x17_range_sum_of_BST extends helper {

 public static void main(String[] args) {
  treeNode root = new treeNode(8);
  root.left = new treeNode(5);
  root.left.left = new treeNode(4);
  root.left.left.left = new treeNode(3);
  root.left.left.left.left = new treeNode(1);
  root.left.right = new treeNode(6);

  root.right = new treeNode(9);
  root.right.right = new treeNode(10);
  int low = 4;
  int high = 10;

  System.out.println(rangeSumBST(root, low, high));
 }

 public static int rangeSumBST(treeNode root, int low, int high) {
  int sum = 0;
  if (root == null) {
   return 0;
  }

  if (root.data >= low && root.data <= high) {
   sum = root.data;
  }

  if (root.data > low) {
   sum += rangeSumBST(root.left, low, high);
  }

  if (root.data < high) {
   sum += rangeSumBST(root.right, low, high);
  }

  return sum;
 }

}
