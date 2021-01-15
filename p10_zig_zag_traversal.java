package TREE.TREE_easy;

/*
=========================
PROBELM:)
=========================

Write a function to print ZigZag order traversal of a binary tree. For binary tree [1,2,3,7,6,5,4] the zigzag order traversal will be 1 3 2 7 6 5 4
*/

/*
===========================================
APPROACH:) using stack
===========================================
starting from root and taking level of root to be level =1; it can be observed that for odd levels, node values are from L-R and for even levels R-L
we take 2 stacks, current_level and next_level, a static variable level (starting from 1), an arraylist
push the root int current_level
run the while loop till the current_level stack is not empty
entering the loop we pop out from the current_level stack and add that element in the list
now if the level is odd, we will push the left and the right child of the above popped out node in the next_level stack (only then it will give order R-L as stack is LIFO)
if not we push the right and then the left child of the popped out node in the next_level stack

if after all this current_level is empty (will happen when all the elements of the level we are on are popped out and put in the list) we swap the stacks, so now next_level is current_level and current_level is next_level

Time : O(n)
Space : O(n) + O(n) = O(n)
*/
import java.util.*;

public class p10_zig_zag_traversal extends helper {
 static int level = 1;

 public static ArrayList<Integer> Zig_Zag(treeNode root) {
  ArrayList<Integer> list = new ArrayList<>();
  if (root == null) {
   return list;
  }

  Stack<treeNode> current_level = new Stack<>();
  Stack<treeNode> next_level = new Stack<>();

  current_level.push(root);
  // boolean LtoR = true;

  while (!current_level.isEmpty()) {
   treeNode temp1 = current_level.pop();
   list.add(temp1.data);

   if (level % 2 != 0) {
    if (temp1.left != null) {
     next_level.push(temp1.left);
    }

    if (temp1.right != null) {
     next_level.push(temp1.right);
    }
   }

   else {
    if (temp1.right != null) {
     next_level.push(temp1.right);
    }

    if (temp1.left != null) {
     next_level.push(temp1.left);
    }
   }

   if (current_level.isEmpty()) {
    level++;
    Stack<treeNode> S = current_level;
    current_level = next_level;
    next_level = S;
   }
  }
  return list;
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.left.left = new treeNode(7);
  root.left.right = new treeNode(6);
  root.right.left = new treeNode(5);
  root.right.right = new treeNode(4);

  System.out.println(Zig_Zag(root));
 }

}