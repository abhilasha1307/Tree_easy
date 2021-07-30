/*
===========================
PROBLEM :)
============================
given the root of a tree, we have to find the height of the tree
*/

import java.util.LinkedList;
import java.util.Queue;

/*
===============================
APPROACH :)
==============================
for every node we will first calulate the height of the left subtree and then the right subtree
and then compare the heights, the greater + 1 (for the current node) is returned back to the previous call (leaf is at height 1,increasing towards leaf to root)
return the height

Time : O(n); every node is visited once
Space : O(h); h is the heigth of the tree (O(n) for skewed tree)
*/
public class p4_height_of_BT extends helper {

 public static void main(String[] args) {

  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(5);

  root.right = new treeNode(3);
  root.right.left = new treeNode(6);
  root.right.right = new treeNode(7);
  root.right.left.left = new treeNode(8);
  root.right.left.right = new treeNode(9);

  root.right.right.left = new treeNode(10);
  root.right.right.right = new treeNode(11);
  root.right.right.left.left = new treeNode(13);
  root.right.right.left.right = new treeNode(12);

  System.out.println(height(root));
 }

 public static int height(treeNode root) {

  if (root == null) {
   return 0;
  }
  int max_left = height(root.left);
  int max_right = height(root.right);

  return 1 + Math.max(max_left, max_right);
 }

 // =================================================================
 // APPROACH:
 // =================================================================
 // Used Level order traversal
 // When we add a node or a said number of nodes in the queue that means the
 // height has
 // gone up by one, as nodes(a said number, nodecount here) exist at the level
 // nodecount is used to see if there are nodes present on the current level and
 // also if they do
 // we add there their children( if they exist) to the queue so that them and
 // their subtrees can be evaluated further
 // if the Queue is empty, or the nodeCount(= Q.size) is zero it means that this
 // is the leaf node level and there will be no further children for any of these
 // nodes

 // Time : O(n)
 // Space : O(h)

 public static int height_2(treeNode node) {
  if (node == null) {
   return 0;
  }

  Queue<treeNode> Q = new LinkedList<>();
  Q.add(node);
  int height = 0;

  while (true) {
   int nodeCount = Q.size();
   if (nodeCount == 0) {
    return height;
   } else
    height++;

   while (nodeCount > 0) {
    treeNode t = Q.poll();
    if (t.left != null)
     Q.add(t.left);
    if (t.right != null)
     Q.add(t.right);
    nodeCount--;
   }
  }

 }
}