/*
=============================================
PROBLEM:)
=============================================
Check if the given BT is a max heap
Heap is an almost complete BT
almost complete tree means that leaves are present in the last level and/or penultimate level
if all the leaves are present in one level then they should be filled from left to right
Max-Heap: key present at the root node must be greatest among the keys present at all of it’s children. The same property must be recursively true for all sub-trees in that Binary Tree.
*/

/*
================================================
APPROACH:)
================================================
To check if a BT is a heap we have to count the number of nodes in the BT. number of nodes will help in checking if the tree is an almost complete BT
to check that, we check every node of the tree by assigning index to every node along the way, if for an node, its index >=  number of nodes tree is not a heap
for root i = 0 and left and right child its 2*i+1 and 2*i +2 

after this we check for every element, its left and right subtree has <= values
leaf node is always a heap
if for a node node.right is null, we check if node.data >= node.left.data. if yes, return true
if for a node, condition (node.data>= node.left.data && node.data >= node.right.data) is satisfied only then we to check further in the left and right subtree of that node, else return false

if a tree is an almost complete/complete BT and is a max heap too (question asks for max heap). return true, else false

Time : O(N)
Space : O(h)
*/
public class p17_check_if_BT_is_heap extends helper {

  static int countNodes(treeNode root) {
    if (root == null)
      return 0;
    return (1 + countNodes(root.left) + countNodes(root.right));
  }

  static boolean isCompleteUtil(treeNode root, int index, int number_nodes) {
    if (root == null)
      return true;

    if (index >= number_nodes) // when at last level the leaves are not present from left to right, but in some
                               // other fashion
      return false;

    return isCompleteUtil(root.left, 2 * index + 1, number_nodes)
        && isCompleteUtil(root.right, 2 * index + 2, number_nodes);

  }

  static boolean isHeapUtil(treeNode root) {

    if (root.left == null && root.right == null) // a single node or leaf node is always a heap
      return true;

    if (root.right == null) {
      return root.data >= root.left.data;
    }

    else {
      if (root.data >= root.left.data && root.data >= root.right.data)
        return isHeapUtil(root.left) && isHeapUtil(root.right);
      else
        return false;
    }
  }

  static boolean isHeap(treeNode root) {
    if (root == null)
      return true;

    int node_count = countNodes(root);

    if (isCompleteUtil(root, 0, node_count) && isHeapUtil(root))
      return true;
    return false;
  }

  public static void main(String args[]) {

    treeNode root = new treeNode(10);
    root.left = new treeNode(9);
    root.right = new treeNode(8);
    root.left.left = new treeNode(7);
    root.left.right = new treeNode(6);
    root.right.left = new treeNode(5);
    root.right.right = new treeNode(4);
    root.left.left.left = new treeNode(3);
    root.left.left.right = new treeNode(2);
    root.left.right.left = new treeNode(1);

    if (isHeap(root)) {
      System.out.println("its a heap");
    } else
      System.out.println("its not a heap");
  }

}
