package TREE.TREE_easy;
//do using one stack

/*
=====================================================
PROBLEM:) 145
=====================================================
Given the root of a binary tree, return the postorder traversal of its nodes' values.

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

/*
=========================================================
APPROACH:)
=========================================================
same as preorder, only difference is that we add elements one on top of other, not one behind other
so this would also mean that we will traverse the right subtree first and then the left subtree
because postorder => L-R-root

Time : O(n)
Space : O(h)
*/

/*
========================================================
USING 2 STACKS
=========================================================
public static ArrayList<Integer> postorder(treeNode root)
{
 Stack<treeNode> S1 = new Stack<>();
  Stack<treeNode> S2 = new Stack<>();
 ArrayList<Integer> list = new ArrayList<>();

 treeNode t = null;
 S1.push(root);
 while(!S1.isEmpty)
 {
  temp = S1.pop();
  S2.push(temp);

  if(temp.left != null)
  {
   S1.push(temp.left);
  }

  if(temp.right != null)
  {
   S1.push(temp.right);
  }
 }

 while(!S2.isEmpty())
 {
  list.add(S2.peek().data);
  S2.pop();
 }

 return list;
}


we make 2 stacks, one in which we will push elements such that popping them will give postorder traversal(S2) and a auxilary stack(S1)
we push the root in S1 and while S1 is not null, we pop an element from S1 and push it on to S2
if the popped element has left and right child, add them in S1 in that order
continue till S1 is not null

while S2 is not null add the element at top of S2 to list and pop it
return list

Time : O(n)
Space : O(n)
*/
import java.util.ArrayList;
import java.util.Stack;

public class x3_iterative_postorder extends helper {

 public static ArrayList<Integer> postorder(treeNode root) {
  ArrayList<Integer> list = new ArrayList<>();

  Stack<treeNode> S = new Stack<treeNode>();

  if (root == null) {
   return list;
  }
  treeNode temp = root;

  while (temp != null || !S.isEmpty()) {
   while (temp != null) {
    list.add(0, temp.data);
    S.push(temp);
    temp = temp.right;
   }

   temp = S.pop();

   temp = temp.left;
  }

  return list;

 }

 public static void main(String[] args) {
  treeNode root = new treeNode(19);
  root.left = new treeNode(10);
  root.right = new treeNode(8);
  root.left.left = new treeNode(11);
  root.left.right = new treeNode(13);

  System.out.println(postorder(root));
 }

}
