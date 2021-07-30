
// time: O(N)
// Space: O(H)
public class x26_Sum_of_root_to_leaf_Binary_numbers extends helper {

 static class Pair<T> {
  treeNode node;
  Integer value;

  Pair(treeNode node, Integer value) {
   this.node.data = node.data;
   this.value = value;
  }
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.left = new treeNode(0);
  root.left.left = new treeNode(0);
  root.left.right = new treeNode(1);

  root.right = new treeNode(1);
  root.right.left = new treeNode(0);
  root.right.right = new treeNode(1);

  System.out.println(sumRootToLeaf(root));
 }

 static int rootToLeaf = 0;

 public static int sumRootToLeaf(treeNode root) {
  preOrder(root, 0);
  return rootToLeaf;
 }

 public static void preOrder(treeNode root, int currNumber) {
  if (root != null) {
   currNumber = (currNumber << 1) | root.data;

   if (root.left == null && root.right == null) {
    rootToLeaf += currNumber;
   }

   preOrder(root.left, currNumber);
   preOrder(root.right, currNumber);
  }
 }

 // public static int dfs(treeNode root, int val) {
 // if (root == null)
 // return 0;
 // val = val * 2 + root.data;
 // return root.left == root.right ? val : dfs(root.left, val) + dfs(root.right,
 // val);
 // }
}
