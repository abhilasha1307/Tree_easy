package TREE.TREE_easy;

import java.util.*;

public class x5_BT_Level_Order_Traversal_II extends helper {

 public static ArrayList<ArrayList<Integer>> LOT(treeNode root) {

  Queue<treeNode> queue = new LinkedList<treeNode>();
  ArrayList<ArrayList<Integer>> wrapList = new ArrayList<ArrayList<Integer>>(); // this is new

  if (root == null)
   return wrapList;

  queue.offer(root);
  while (!queue.isEmpty()) {
   int levelNum = queue.size(); // imp for loop
   ArrayList<Integer> subList = new ArrayList<Integer>();
   for (int i = 0; i < levelNum; i++) {
    if (queue.peek().left != null)
     queue.offer(queue.peek().left);
    if (queue.peek().right != null)
     queue.offer(queue.peek().right);
    subList.add(queue.poll().data);
   }
   wrapList.add(0, subList); // zero is the index at which any new list will be added; aage se add ho rha
                             // hai, not back
  }
  return wrapList;

 }

 public static void main(String[] args) {
  treeNode root = new treeNode(3);
  root.left = new treeNode(9);
  root.right = new treeNode(20);
  root.right.left = new treeNode(15);
  root.right.right = new treeNode(7);

  System.out.println(LOT(root));
 }
}

// ALTERNATE CODE :
// 1

/*
 * public List<List<Integer>> levelOrderBottom(TreeNode root) {
 * List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
 * levelMaker(wrapList, root, 0); return wrapList; }
 * 
 * public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
 * if(root == null) return; if(level >= list.size()) { list.add(0, new
 * LinkedList<Integer>()); } levelMaker(list, root.left, level+1);
 * levelMaker(list, root.right, level+1);
 * list.get(list.size()-level-1).add(root.val); }
 */

// 2

/*
 * ArrayList<ArrayList<Integer>> level_nodes = new
 * ArrayList<ArrayList<Integer>>();
 * 
 * if (root == null) { return level_nodes; }
 * 
 * Stack<ArrayList<Integer>> buffer = new Stack<ArrayList<Integer>>(); //
 * Because we want a reversed output
 * 
 * Queue<TreeNode> nodes = new LinkedList<TreeNode>(); nodes.add(root);
 * 
 * while (nodes.size() != 0) {
 * 
 * int level_length = nodes.size(); ArrayList<Integer> vals = new
 * ArrayList<Integer>();
 * 
 * while (level_length != 0) { TreeNode temp = nodes.poll();
 * 
 * if (temp.left != null) nodes.add(temp.left); if (temp.right != null)
 * nodes.add(temp.right);
 * 
 * vals.add(temp.data); level_length--; }
 * 
 * buffer.push(vals); }
 * 
 * while (!buffer.empty()) { level_nodes.add(buffer.pop()); }
 * 
 * return level_nodes;
 */