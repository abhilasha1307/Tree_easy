package TREE.TREE_easy;

//morris traversal
import java.util.ArrayList;
import java.util.Stack;

/*
====================================================
PROBLEM :) 94
=====================================================
Given the root of a binary tree, return the inorder traversal of its nodes' values.

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

/*
==========================================================
APPROACH:)
==========================================================
make a temp treeNode which points to root at first and stack S (empty)
while either the S is not empty or temp is not null
we make a inner loop to add all the left of every element till we hit null and push it onto stack (while(temp!= null))
when we reach null, we pop the element, add it to list and go to its right to add the right subtree elements if present

this will continue till both the stack is empty and temp == null

return list

Time : O(n)
Space : O(n)
*/
public class x1_iterative_inorder extends helper {

 public static ArrayList<Integer> inOrder(treeNode root) {

  ArrayList<Integer> list = new ArrayList<Integer>();

  Stack<treeNode> S = new Stack<treeNode>(); // treeNode type stack to traverse the subtree of a said popped node

  treeNode temp = root;
  while (temp != null || S.size() > 0) {

   while (temp != null) {
    S.push(temp);
    temp = temp.left;
   }
   temp = S.pop();
   list.add(temp.data);

   temp = temp.right;

  }

  return list;
 }

 public static void main(String[] args) {

  treeNode root = new treeNode(10);
  root.left = new treeNode(20);
  root.right = new treeNode(30);
  root.left.left = new treeNode(40);
  root.left.right = new treeNode(60);
  root.right.left = new treeNode(50);

  System.out.println(inOrder(root));
 }
}
