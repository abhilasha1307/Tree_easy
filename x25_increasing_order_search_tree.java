// O(N) time, O(H) space
public class x25_increasing_order_search_tree extends helper {
 public static void main(String[] args) {
  treeNode root = new treeNode(5);
  root.left = new treeNode(3);
  root.left.left = new treeNode(2);
  root.left.left.left = new treeNode(1);
  root.right = new treeNode(4);

  root.right = new treeNode(6);
  root.right.right = new treeNode(8);
  root.right.right.left = new treeNode(7);
  root.right.right.right = new treeNode(9);

  treeNode result = increasingBST(root);
  printTree(result);
 }

 public static void printTree(treeNode node) {
  if (node != null) {
   printTree(node.left);
   System.out.print(node.data + " ");
   printTree(node.right);
  }
 }

 static treeNode curr;

 public static treeNode increasingBST(treeNode root) {
  treeNode ans = new treeNode(0);
  curr = ans;
  insert(root);
  return ans.right;
 }

 // relinking

 public static void insert(treeNode node) {
  if (node == null) {
   return;
  }
  insert(node.left);
  node.left = null;
  curr.right = node;
  curr = node;
  insert(node.right);
 }

}
