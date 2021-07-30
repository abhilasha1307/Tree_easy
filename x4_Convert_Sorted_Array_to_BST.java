public class x4_Convert_Sorted_Array_to_BST extends helper {

 public static class treeNode {
  int data;
  int height;
  treeNode left, right;

  treeNode(int d) {
   data = d;
   height = 1;
   left = right = null;
  }

 }

 treeNode root;

 public static treeNode sortedArrayToBST(int[] nums) {

  x4_Convert_Sorted_Array_to_BST obj = new x4_Convert_Sorted_Array_to_BST();
  int i = 0;
  while (i < (nums.length)) {
   obj.root = insert(obj.root, nums[i]);
   i++;
  }

  return obj.root;
 }

 static treeNode insert(treeNode node, int key) {
  if (node == null) {
   return (new treeNode(key));
  }

  else if (key > node.data) {
   node.right = insert(node.right, key);
  }

  else if (key < node.data) {
   node.left = insert(node.left, key);
  }

  node.height = 1 + max(height(node.left), height(node.right));

  int balancefactor = getbalance(node);

  if (balancefactor > 1 && key < node.left.data)
   return rightRotate(node);
  // Right Right Case
  if (balancefactor < -1 && key > node.right.data)
   return leftRotate(node);
  // Left Right Case
  if (balancefactor > 1 && key > node.left.data) {
   node.left = leftRotate(node.left);
   return rightRotate(node);
  }
  // Right Left Case
  if (balancefactor < -1 && key < node.right.data) {
   node.right = rightRotate(node.right);
   return leftRotate(node);
  }

  return node;
 }

 static int height(treeNode node) {
  if (node == null) {
   return 0;
  }

  return node.height;
 }

 static int max(int p, int q) {
  return (p > q) ? p : q;
 }

 static int getbalance(treeNode temp) {
  if (temp == null) {
   return 0;
  }

  return (height(temp.left) - height(temp.right));
 }

 static treeNode leftRotate(treeNode x) {
  treeNode y = x.right;
  treeNode t2 = y.left;

  y.left = x;
  x.right = t2;

  x.height = 1 + max(height(x.left), height(x.right));
  y.height = 1 + max(height(x.left), height(x.right));

  return y;
 }

 static treeNode rightRotate(treeNode y) {
  treeNode x = y.left;
  treeNode t1 = x.right;

  x.right = y;
  y.left = t1;

  x.height = 1 + max(height(x.left), height(x.right));
  y.height = 1 + max(height(y.left), height(y.right));

  return x;
 }

 static void inorder(treeNode node) {
  if (node != null) {
   inorder(node.left);
   System.out.print(node.data + " ");
   inorder(node.right);
  }
 }

 public static void main(String[] args) {
  int[] arr = new int[] { -10, -3, 0, 5, 9 };

  treeNode result = sortedArrayToBST(arr);

  inorder(result);
 }
}

/*
 * public static TreeNode sortedArrayToBST(int[] nums) {
 * 
 * return treeMaker(nums, 0, nums.length - 1);
 * 
 * }
 * 
 * public static TreeNode treeMaker(int[] arr, int l, int h) {
 * 
 * if (l > h) { return null; }
 * 
 * int m = (l + h) / 2;
 * 
 * TreeNode root = new TreeNode(arr[m]); root.left = treeMaker(arr, l, m - 1);
 * root.right = treeMaker(arr, m + 1, h); return root;
 * 
 * }
 * 
 */

/*
 * public TreeNode sortedArrayToBST(int[] nums) { TreeNode node = null; if (nums
 * == null || nums.length == 0) { return node; }
 * 
 * Queue<TreeNode> nodes = new LinkedList<>();
 * 
 * int middle, from, to;
 * 
 * middle = (nums.length - 1) / 2; node = new TreeNode(nums[middle]);
 * nodes.add(node);
 * 
 * Queue<Integer> indexes = new LinkedList<>(); indexes.add(0);
 * indexes.add(middle - 1); indexes.add(middle + 1); indexes.add(nums.length -
 * 1);
 * 
 * while (!nodes.isEmpty()) { int size = nodes.size(); for (int i = 0; i < size;
 * i++) { TreeNode current = nodes.poll();
 * 
 * for (int k = 0; k < 2; k++) { from = indexes.poll(); to = indexes.poll();
 * 
 * if (from <= to) { middle = (from + to) / 2;
 * 
 * if (k == 0) { current.left = new TreeNode(nums[middle]);
 * nodes.add(current.left); } else { current.right = new TreeNode(nums[middle]);
 * nodes.add(current.right); }
 * 
 * indexes.add(from); indexes.add(middle - 1); indexes.add(middle + 1);
 * indexes.add(to); } } } }
 * 
 * return node; }
 */

/*
 * public class Solution { class Node{ // need another class to store multi
 * information int low, up; // means the TreeNode covers [low, up], low and up
 * are all index TreeNode t; Node(int l, int p, TreeNode node){ low = l; up = p;
 * t = node; } } public TreeNode sortedArrayToBST(int[] num) { if(num == null ||
 * num.length == 0) return null; Stack<Node> stack = new Stack<Node>(); //
 * initialize TreeNode root = new TreeNode(num[(num.length-1)/2]); Node rootNode
 * = new Node(0,num.length-1,root); stack.push(rootNode); // iteration
 * while(!stack.isEmpty()){ Node node = stack.pop(); int middle =
 * (node.low+node.up)/2; // cut half for [low, up]
 * 
 * // [low, middle-1] if(middle-1 >= node.low){ TreeNode leftnode = new
 * TreeNode(num[(middle-1+node.low)/2]); node.t.left = leftnode; Node left = new
 * Node(node.low, middle-1, leftnode); stack.push(left); } // [middle+1, up]
 * if(middle+1 <= node.up){ TreeNode rightnode = new
 * TreeNode(num[(middle+1+node.up)/2]); node.t.right = rightnode; Node right =
 * new Node(middle+1, node.up, rightnode); stack.push(right); } } return root; }
 * }}
 */