package TREE.TREE_easy;

/*
========================================
PROBLEM:)
=======================================
Print level order for the given tree (breadth first traversal using queue)
*/

/*
========================================
APPROACH:) RECURSIVE APPROACH
=======================================
we make a list to store the elements for level order traversal
for the recursive approach, we will need the height of the tree
we will use a loop starting from 1 (level of root) to height

for each i (i represents levels in the tree) we call givenOrder function which will return the list of the value of nodes at a level from left to right
when i or level is one we just put root.data in the list and return the list
for i>1, we first go to left and decrement the level by one and then to right and decrement the level by one (we want nodes from left to right)
do this till level = height and return the list

Time : O(n^2)
givenOrder take O(n) time and level order calls givenOrder function height times (in worst case height is n) 
Space : O(h). 
*/

/*
===================================================
ITERATIVE APROACH : USING QUEUE
======================================================
public static List<Integer> level_order(treeNode root)
{
 Queue<treeNode> Q = new LinkedList<>();
 List<Integer> list = new ArrayList<>();

 Q.add(root);

 while(!Q.isEmpty())
 {
  treeNode temp = Q.poll();
  list.add(temp.data);

  if(temp.left != null)
  {
   Q.add(temp.left);
  }

  if(temp.right != null)
  {
   Q.add(temp.right);
  }
 }

 return list;
}

in the above approach we make a queue (treeNode type) and add the root to it and then use a loop which works till the queue is not empty
in the loop we take the first element out of the queue (FIFO) and put it in the list
for this element, if the left and right child are present, we add them to the queue in that order

Time : O(n)
Space : O(n)
n is the number of nodes in the BT
*/

import java.util.ArrayList;

public class p8_level_order_traversal extends helper {

 public static ArrayList<Integer> levelOrder(treeNode root) {
  ArrayList<Integer> list = new ArrayList<Integer>();
  int h = height(root);

  for (int i = 1; i <= h; i++) {
   list.addAll(givenOrder(root, i));
  }

  return list;
 }

 public static int height(treeNode root) {
  if (root == null) {
   return 0;
  }

  else {
   int left_height = height(root.left);
   int right_height = height(root.right);

   if (left_height > right_height) {
    return (left_height + 1);
   } else {
    return (right_height + 1);
   }
  }
 }

 public static ArrayList<Integer> givenOrder(treeNode temp, int level) {
  ArrayList<Integer> result = new ArrayList<>();
  if (temp == null) {
   return result;
  }

  else if (level == 1) {
   result.add(temp.data);
  }

  else {
   result.addAll(givenOrder(temp.left, level - 1));
   result.addAll(givenOrder(temp.right, level - 1));
  }

  return result;
 }

 public static void main(String[] args) {

  treeNode root = new treeNode(10);
  root.left = new treeNode(20);
  root.right = new treeNode(30);
  root.left.left = new treeNode(40);
  root.left.right = new treeNode(60);

  System.out.println(levelOrder(root));
 }
}
