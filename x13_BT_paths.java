package TREE.TREE_easy;
//do using dtring bulder

//string concatenation is too costly. Takes O(n) to copy one character

/*
=================================================
PROBLEM:) 257
=================================================
Given a binary tree, return all root-to-leaf paths.

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]
*/

/*
===================================================
APPROACH:)
====================================================
we will make a list of string type and store every path as a string in the list
to helper function, we pass root, an empty string and the list

for a node, we check if it has a left subtree, to go left, but here add the node.data and -> to the extising string to update the string with the current node and then call it for its 
left child
similarly we add the right children/subtrees

if the current node is a leaf, we will add the update the string with node.data (current node) and then add this new string to the list. This will make the string empty and we can start with the new BT path

Time : O(n^2) for worst case.
skewed tree is the worst case and since we are concatenating one path at a time and copying one character takes O(n) time, so for n elements (placed like a LL) it will take O(n^2)
Best case : O(n logn); when its a full BT and one path is of length logn and and the for each nodes in the path, copying takes O(n) time

Space : O(height of the tree) + O(number of paths) (for arraylist to store). so overall linear in worst case
height can be O(log n) too, it will O(log n) + O(m) for this
*/

/*
=========================================================
ITERATIVE APPROACH:) iterative dfs
=========================================================
public static List<String> binaryTreePaths(treeNode root) {
  List<String> list = new ArrayList<String>();
  Stack<treeNode> sNode = new Stack<treeNode>();
  Stack<String> sStr = new Stack<String>();

  if (root == null)
   return list;
  sNode.push(root);
  sStr.push("");
  while (!sNode.isEmpty()) {
   treeNode curNode = sNode.pop();
   String curStr = sStr.pop();

   if (curNode.left == null && curNode.right == null)
    list.add(curStr + curNode.data);
   if (curNode.left != null) {
    sNode.push(curNode.left);
    sStr.push(curStr + curNode.data + "->");
   }
   if (curNode.right != null) {
    sNode.push(curNode.right);
    sStr.push(curStr + curNode.data + "->");
   }
  }
  return list;
 }


*/

/*
===================================================
iterative bfs
===================================================
public static List<String> binaryTreePaths(treeNode root) {
  List<String> list = new ArrayList<String>();
  Queue<treeNode> qNode = new LinkedList<treeNode>();
  Queue<String> qStr = new LinkedList<String>();

  if (root == null)
   return list;
  qNode.add(root);
  qStr.add("");
  while (!qNode.isEmpty()) {
   treeNode curNode = qNode.remove();
   String curStr = qStr.remove();

   if (curNode.left == null && curNode.right == null)
    list.add(curStr + curNode.data);
   if (curNode.left != null) {
    qNode.add(curNode.left);
    qStr.add(curStr + curNode.data + "->");
   }
   if (curNode.right != null) {
    qNode.add(curNode.right);
    qStr.add(curStr + curNode.data + "->");
   }
  }
  return list;
 }

*/
import java.util.ArrayList;
import java.util.List;

public class x13_BT_paths extends helper {

 public static List<String> binaryTreePaths(treeNode root) {

  List<String> res = new ArrayList<>();

  if (root == null) {
   return res;
  }
  helper_function(root, "", res);

  return res;
 }

 public static void helper_function(treeNode root, String str, List<String> res) {
  if (root.left == null && root.right == null) {
   res.add(str + root.data); // after this steps str goes back to being empty
  }

  if (root.left != null) {
   helper_function(root.left, str + root.data + "->", res);
  }

  if (root.right != null) {
   helper_function(root.right, str + root.data + "->", res);
  }
 }

 public static void main(String[] args) {

  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.left.right = new treeNode(5);

  System.out.println(binaryTreePaths(root));

 }
}
