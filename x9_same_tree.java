package TREE.TREE_easy;

/*
=============================================================== 
PROBLEM:) 100
===============================================================
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
*/

/*
==============================================================
APPROACH:)
==============================================================
for a node, if value in both the trees are same, the tree is same tree for that one node
we have to check this for left and right subtree too from here on
if for any node, q reaches null and p doesnt (or vice versa), this means that both trees are structurally different and so return false
if for any node, the values are different, return false

Time : O(n)
Space : O(h)
*/

/*
==========================================================
QUEUE SOLUTION :)
==========================================================
public static boolean isSameTree(treeNode p, treeNode q)
{
 Queue<treeNode> queue =  new LinkedList<>();
 if(p == null && q == null)
 {
  return true;
 }

 if(p == null || q == null)
 {
  return false;
 }

 queue.add(p);
 queue.add(q);

 while(!queue.isEmpty())
 {
  treeNode one = queue.poll();
  treeNode two = queue.poll();
  if(one == null && two == null)
  {
   continue;
  }
  if(one == null || two == null)
  {
   return false;
  }
  if(one.data  != two.data)
  {
   return false;
  }

  queue.offer(one.left);
  queue.offer(one.right);
  queue.offer(two.left);
  queue.offer(two.right);
 }

 return true;
}

Time : O(n)
Space : O(log n) or O(n)
*/
public class x9_same_tree extends helper {
 public static boolean isSameTree(treeNode p, treeNode q) {

  if (p == null && q == null) {
   return true;
  }

  if ((p != null && q == null) || (q != null && p == null)) {
   return false;
  }

  else if (p.data != q.data) {
   return false;
  }

  return ((p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
 }

 public static void main(String[] args) {

  treeNode root1 = new treeNode(1);
  root1.left = new treeNode(2);
  root1.right = new treeNode(3);

  treeNode root2 = new treeNode(1);
  root2.left = new treeNode(2);
  root2.right = new treeNode(3);

  System.out.println(isSameTree(root1, root2));
 }
}
