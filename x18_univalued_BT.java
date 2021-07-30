/*
==================================================
PROBLEM:) 965
==================================================
A binary tree is univalued if every node in the tree has the same value.
Return true if and only if the given tree is univalued.

The number of nodes in the given tree will be in the range [1, 100].
Each node's value will be an integer in the range [0, 99].
*/

/*
======================================================
APPROACH:)
======================================================
If its a Univalue tree then all the nodes will have the same value, so we make a variable val and assign the root's value in it
then we compare the values from the left and right subtree with this 'val'
if all the values are same, it returns true, else false

Time : O(n); all nodes are visited once, n is the number of nodes
Space : O(h); call stack occupied is same as height of the tree at max; can be O(n) if the tree is skewed
*/
public class x18_univalued_BT extends helper {

 public static boolean isUnivalTree(treeNode root) {
  if (root == null) {
   return true;
  }

  int val = root.data;

  return (check(root.left, val) && check(root.right, val));
 }

 public static boolean check(treeNode root, int val) {
  if (root == null) {
   return true;
  }

  if (root.left == null && root.right == null) { // checking for the leaf node
   if (root.data == val) {
    return true;
   }

   else {
    return false;
   }
  }

  else if (root.data != val) { // when a node's value is not equal to val, but its not a leaf node
   return false;
  }

  return (check(root.left, val) && check(root.right, val));
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.left = new treeNode(1);
  root.left.left = new treeNode(1);
  root.left.right = new treeNode(1);
  root.right = new treeNode(1);
  root.right.right = new treeNode(5);

  System.out.println(isUnivalTree(root));
 }

}
