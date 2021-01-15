package TREE.TREE_easy;

//height balanced BST
public class x6_check_if_BT_is_BBST extends helper {
 public static boolean isBalanced(treeNode root) {
  if (root == null) {
   return true;
  }

  if (height(root) != -1) {
   return true;
  }

  return false;
 }

 public static int height(treeNode node) {
  if (node == null) {
   return 0;
  }

  int l = height(node.left);
  int r = height(node.right);

  if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
   return -1;
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

/*
 * public boolean isBalanced(TreeNode root) { if(root==null) return true;
 * Stack<TreeNode> stack = new Stack<TreeNode>(); Map<TreeNode, Integer> map =
 * new HashMap<TreeNode, Integer>(); stack.push(root); while(!stack.isEmpty()){
 * TreeNode node = stack.pop(); if((node.left==null || node.left!=null &&
 * map.containsKey(node.left)) &&(node.right==null || node.right!=null &&
 * map.containsKey(node.right))){ int left =
 * node.left==null?0:map.get(node.left); int right =
 * node.right==null?0:map.get(node.right); if(Math.abs(left-right) > 1) return
 * false; map.put(node, Math.max(left, right)+1); }else{ if(node.left!=null &&
 * !map.containsKey(node.left)){ stack.push(node); stack.push(node.left); }else{
 * stack.push(node); stack.push(node.right); } } } return true; }
 * 
 */
