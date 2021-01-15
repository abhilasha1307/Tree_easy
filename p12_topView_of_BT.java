package TREE.TREE_easy;

import java.util.*;

public class p12_topView_of_BT extends helper {

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

 public static void main(String[] args) {
  /*
   * treeNode root = new treeNode(10); root.left = new treeNode(20);
   * root.left.left = new treeNode(40); root.left.right = new treeNode(60);
   * root.right = new treeNode(30); root.right.left = new treeNode(90);
   * root.right.right = new treeNode(100);
   */

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

}

/*
 * alternative code : static class pair { int first, second;
 * 
 * pair() { }
 * 
 * pair(int i, int j) { first = i; second = j; } }
 * 
 * // map to store the pair of node value and // its level with respect to the
 * vertical // distance from root. static TreeMap<Integer, pair> m = new
 * TreeMap<>();
 * 
 * // function to create a new node static Node newNode(int key) { Node node =
 * new Node(); node.left = node.right = null; node.data = key; return node; }
 * 
 * // function to fill the map static void fillMap(Node root, int d, int l) { if
 * (root == null) return;
 * 
 * if (m.get(d) == null) { m.put(d, new pair(root.data, l)); } else if
 * (m.get(d).second > l) { m.put(d, new pair(root.data, l)); }
 * 
 * fillMap(root.left, d - 1, l + 1); fillMap(root.right, d + 1, l + 1); }
 * 
 * // function should print the topView of // the binary tree static void
 * topView(Node root) { fillMap(root, 0, 0);
 * 
 * for (Map.Entry<Integer, pair> entry : m.entrySet()) {
 * System.out.print(entry.getValue().first + " "); } }
 */
