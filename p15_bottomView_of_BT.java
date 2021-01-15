package TREE.TREE_easy;

import java.util.*;

public class p15_bottomView_of_BT {
 public static class treeNode {
  int data;
  int hd;
  treeNode left, right;

  treeNode(int d) {
   data = d;
   hd = Integer.MAX_VALUE;
   left = right = null;
  }
 }

 public static ArrayList<Integer> bottomView(treeNode root) {
  ArrayList<Integer> list = new ArrayList<>();
  if (root == null)
   return list;

  // Initialize a variable 'hd' with 0 for the root element.
  int hd = 0;

  // TreeMap which stores key value pair sorted on key value
  Map<Integer, Integer> map = new TreeMap<>();

  // Queue to store tree nodes in level order traversal
  Queue<treeNode> queue = new LinkedList<treeNode>();

  // Assign initialized horizontal distance value to root
  // node and add it to the queue.
  root.hd = hd;
  queue.add(root);

  // Loop until the queue is empty (standard level order loop)
  while (!queue.isEmpty()) {
   treeNode temp = queue.remove();

   // Extract the horizontal distance value from the
   // dequeued tree node.
   hd = temp.hd;

   // Put the dequeued tree node to TreeMap having key
   // as horizontal distance. Every time we find a node
   // having same horizontal distance we need to replace
   // the data in the map.
   map.put(hd, temp.data);

   // If the dequeued node has a left child add it to the
   // queue with a horizontal distance hd-1.
   if (temp.left != null) {
    temp.left.hd = hd - 1;
    queue.add(temp.left);
   }
   // If the dequeued node has a right child add it to the
   // queue with a horizontal distance hd+1.
   if (temp.right != null) {
    temp.right.hd = hd + 1;
    queue.add(temp.right);
   }
  }

  // Extract the entries of map into a set to traverse
  // an iterator over that.
  Set<Map.Entry<Integer, Integer>> set = map.entrySet();

  // Make an iterator
  Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

  // Traverse the map elements using the iterator.
  while (iterator.hasNext()) {
   Map.Entry<Integer, Integer> me = iterator.next();
   list.add(me.getValue());
  }
  return list;

 }

 public static void main(String[] args) {
  treeNode root = new treeNode(20);
  root.left = new treeNode(8);
  root.right = new treeNode(22);
  root.left.left = new treeNode(5);
  root.left.right = new treeNode(3);
  root.right.left = new treeNode(4);
  root.right.right = new treeNode(25);
  root.left.right.left = new treeNode(10);
  root.left.right.right = new treeNode(14);
  bottomView(root);
 }

}
