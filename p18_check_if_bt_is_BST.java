package TREE.TREE_easy;

/*
==============================================
PROBLEM:)
==============================================
check if the given binary tree and BST
*/

/*
===============================================
APPROACH:)
===============================================
for any node, if node.data < node.left.data and node.data > node.right.data, return false
a single leaf node, is a BST

Time : O(n)
Space : O(h)
*/

public class p18_check_if_bt_is_BST extends helper {
  static boolean isBST(treeNode root) {
    if (root.left == null && root.right == null)
      return true;

    if (root.data < root.left.data || root.data > root.right.data)
      return false;

    return (isBST(root.left) && isBST(root.right));
  }

  public static void main(String args[]) {

    treeNode root = new treeNode(5);
    root.left = new treeNode(1);
    root.right = new treeNode(4);
    root.right.left = new treeNode(3);
    root.right.right = new treeNode(6);

    if (isBST(root))
      System.out.println("IS BST");
    else
      System.out.println("Not a BST");
  }

}
