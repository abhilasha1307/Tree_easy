import java.util.*;

/*
====================================================
PROBLEM:)
====================================================
Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. 
Given a binary tree, print the top view of it. The output nodes can be printed in any order.
*/

/*
=================================================
APPROACH:
==================================================
A node x is there in output if x is the topmost node at its horizontal distance. 
Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1

traversing the tree, add root to queue (type: QueueObj which has treeNode and horizontal distance)
while the queue is not empty, for each node we check if it the first node at its horizontal distance, if yes, its added to the map
add the left and the right child to the queue with their horizontal distances.
print the nodes by accessing the value of entries in the Map.

Time: O(N), N is the no. of nodes
Space: O(N), worst case; skewed tree
*/

//TAKE AWAY: HORIZONTAL DISTANCE AND HOW IT IS USED

public class p12_topView_of_BT extends helper {

 public static void main(String[] args) {
  treeNode root = new treeNode(3);
  root.left = new treeNode(6);
  root.left.right = new treeNode(8);
  root.left.right.left = new treeNode(10);
  root.left.right.left.left = new treeNode(12);
  root.left.right.left.right = new treeNode(13);
  root.right = new treeNode(7);
  root.right.left = new treeNode(9);
  root.right.left.right = new treeNode(11);
  root.right.left.right.left = new treeNode(14);
  root.right.left.right.right = new treeNode(15);

  topView(root);
 }

 public static void topView(treeNode root) {
  class QueueObj {
   treeNode node;
   int hd; // horizontal distance

   QueueObj(treeNode node, int hd) {
    this.node = node;
    this.hd = hd;
   }
  }
  Queue<QueueObj> q = new LinkedList<QueueObj>();
  Map<Integer, treeNode> topViewMap = new TreeMap<Integer, treeNode>();

  if (root == null) {
   return;
  } else {
   q.add(new QueueObj(root, 0));
  }

  while (!q.isEmpty()) {
   QueueObj tmpNode = q.poll();
   if (!topViewMap.containsKey(tmpNode.hd)) {
    topViewMap.put(tmpNode.hd, tmpNode.node);
   }

   if (tmpNode.node.left != null) {
    q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
   }
   if (tmpNode.node.right != null) {
    q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
   }

  }
  for (Map.Entry<Integer, treeNode> entry : topViewMap.entrySet()) {
   System.out.print(entry.getValue().data + " ");
  }

 }

}