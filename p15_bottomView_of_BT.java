import java.util.*;

/*
============================================
PROBLEM:)
============================================
Given a Binary Tree, we need to print the bottom view from left to right. A node x is there in output if x is the bottommost node at its horizontal distance
*/

/*
============================================
APPROACH:)
============================================
opposite of top view, there topmost nodes where printed, if a node with the same a said horizontal distance was already present in the map, the current node; if it has hd = said hd, then it will not be added to the map 
Here the previous node with the same said hd will be overwritten in the map

root has hd = 0;
added to the queue, the nodes are traversed over and added to the queue along with their hd's
if current node has the same hd as some node in the map, the node in the map will be overwritten with the current node's data and hd

Time: O(N)
Space: O(N); map size for skewed tree
*/

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
  System.out.println(bottomView(root));
 }

 public static ArrayList<Integer> bottomView(treeNode root) {
  ArrayList<Integer> list = new ArrayList<>();
  if (root == null)
   return list;

  int hd = 0;

  Map<Integer, Integer> map = new TreeMap<>();

  Queue<treeNode> queue = new LinkedList<treeNode>();

  root.hd = hd;
  queue.add(root);

  while (!queue.isEmpty()) {
   treeNode temp = queue.remove();
   hd = temp.hd;
   map.put(hd, temp.data);

   if (temp.left != null) {
    temp.left.hd = hd - 1;
    queue.add(temp.left);
   }
   if (temp.right != null) {
    temp.right.hd = hd + 1;
    queue.add(temp.right);
   }
  }

  Set<Map.Entry<Integer, Integer>> set = map.entrySet();

  Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
  while (iterator.hasNext()) {
   Map.Entry<Integer, Integer> me = iterator.next();
   list.add(me.getValue());
  }
  return list;

 }

}
