package TREE.TREE_easy;

/*
=======================================================
PROBLEM:) 111
=======================================================
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
*/

/*
=======================================================
APPROACH:)
========================================================
for a node, we will go to its left subtree(if present) and return the height from there and then right subtree and return the height
we take the minimum of the height (if both the subtrees were available) or just return the height of the present subtree after adding one for the current node
height of leaf node is taken as 1

Time : O(n)
Space : O(h)
*/

/*
==============================================
BFS APPROACH WITH QUEUE:)
==============================================
public static int minDepth(treeNode root)
{

 if(root == null)
 {
  return 0;
 }
 Queue<treeNode> Q = new LinkedList<>();
 int level = 1;
 int size = 0;
 treeNode t = null;

 Q.add(root);
 while(!Q.isEmpty())
 {
  size = Q.size();
  for(int i = 0; i<size; i++)
  {
   t = Q.poll();
   if(t.left == null && t.right == null)
   {
    return level;
   }

   if(t.left != null)
   {
    Q.add(t.left);
   }

   if(t.right != null)
   {
    Q.add(t.right);
   }
  }

  level++;
 }
  return level;
}

Time : O(n)
Space : O(space occupied by Queue)
*/

public class x7_minimum_depth_of_BT extends helper {

 public static int minDepth(treeNode root) {
  if (root == null) {
   return 0;
  }
  if (root.left == null && root.right == null) {
   return 1;
  }

  if (root.left == null) {
   return minDepth(root.right) + 1;
  }

  if (root.right == null) {
   return minDepth(root.left) + 1;
  }

  return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
 }

 public static void main(String[] args) {

  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.left.right = new treeNode(4);
  root.left.right.left = new treeNode(6);
  root.left.right.left.left = new treeNode(9);
  root.left.right.left.right = new treeNode(8);
  root.left.right.left.left.left = new treeNode(10);
  root.left.right.left.left.right = new treeNode(11);

  root.right.left = new treeNode(5);
  root.right.left.right = new treeNode(7);

  System.out.println(minDepth(root));

 }
}
