import java.util.ArrayList;
import java.util.Collections;

/*
========================================
PROBLEM:)
========================================
Given a Binary Tree of size N, find all the nodes which don't have any sibling. 
Root node can not have a sibling.
*/

/*
===========================================
APPROACH:)
===========================================
to check if a node is a single child, we have to check (being on the parent node of the said node) if parent node has one (either left or right subtree) as null
if yes, we add the non null side to the list 
dft through the tree and return the list

if list is empty, add -1  to list and return this list
else, sort the list and return

Time : O(n)
Space : O(h)
*/

public class p19_print_all_nodes_with_no_siblings extends helper {
 public static ArrayList<Integer> noSibling(treeNode root) {

  ArrayList<Integer> list = new ArrayList<>();
  check(root, list);

  if (list.size() == 0) {
   list.add(-1);
  } else {
   Collections.sort(list);
  }

  return list;
 }

 public static void check(treeNode node, ArrayList<Integer> list) {
  if (node == null) {
   return;
  }

  if (node.left != null && node.right == null) {
   list.add(node.left.data);
  }

  if (node.right != null && node.left == null) {
   list.add(node.right.data);
  }

  check(node.left, list);
  check(node.right, list);

 }

 public static void main(String[] args) {
  /*
   * treeNode root = new treeNode(1); root.left = new treeNode(20); root.left.left
   * = new treeNode(110);
   */

  treeNode root = new treeNode(1);
  root.right = new treeNode(20);
  root.right.left = new treeNode(110);
  root.right.left.right = new treeNode(200);
  root.right.left.right.left = new treeNode(250);

  System.out.println(noSibling(root));
 }

}
