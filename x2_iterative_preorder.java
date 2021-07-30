/*
============================================================
PROBLEM:) 144
============================================================
Given the root of a binary tree, return the preorder traversal of its nodes' values.

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

/*
===========================================================
APPROACH:)
===========================================================
make a stack and a temp treeNode variable
while either stack is not empty or temp is not null 
while temp is not null we add the element to the list, push it to the stack and then go left (till temp != null)
when temp is null(stack is not empty) we pop the element and go to the right of this node to add the elements to the right of this node(if not null)

the stack will empty when we have traversed the entire tree
return list

Time : O(n)
Space : O(n) + O(n) = O(n) (stack and list; worst case skew tree)
*/
import java.util.ArrayList;
import java.util.Stack;

public class x2_iterative_preorder extends helper {

 public static ArrayList<Integer> preorder(treeNode root) {
  ArrayList<Integer> result = new ArrayList<Integer>();

  Stack<treeNode> S = new Stack<treeNode>();
  treeNode t1 = root;

  while (t1 != null || !S.isEmpty()) {
   while (t1 != null) {
    result.add(t1.data);
    S.push(t1);
    t1 = t1.left;
   }

   t1 = S.pop();

   t1 = t1.right;
  }

  return result;
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(3);
  root.left = new treeNode(6);
  root.right = new treeNode(9);
  root.left.right = new treeNode(12);
  root.right.left = new treeNode(11);

  System.out.println(preorder(root));

 }
}
