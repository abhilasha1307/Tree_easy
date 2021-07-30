//height balanced BST
public class x6_check_if_BT_is_BBST extends helper {
 private static boolean isBalancedTree = true;

 public static boolean isBalanced(treeNode root) {
  if (root == null) {
   return true;
  }

  height(root);

  return isBalancedTree;
 }

 public static int height(treeNode node) {
  if (node == null) {
   return 0;
  }

  int l = height(node.left);
  int r = height(node.right);

  if (Math.abs(l - r) > 1) {
   isBalancedTree = false;
   return -2;
  }

  return (1 + Math.max(l, r));

 }

 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.left.right = new treeNode(4);
  root.left.right.left = new treeNode(6);
  root.left.right.left.left = new treeNode(9);
  root.left.right.left.right = new treeNode(8);
  root.left.right.left.left.left = new treeNode(10);
  root.left.right.left.left.right = new treeNode(11);

  root.right = new treeNode(3);
  root.right.left = new treeNode(5);
  root.right.left.right = new treeNode(7);
  System.out.println(isBalanced(root));
 }

}