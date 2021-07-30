/*
=================================================
PROBLEM:)  235
=================================================
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.
*/

/*
==================================================
APPROACH:)
==================================================
given tree is a BST
so if the values of both p and q are greater than the current node, that means p and q are to the right of the current node, so we make a function call with root.right in it

similarly if both p and q are less than the current node, that means p and q are to the left of the current node, so we make a function call with root.left in it

any of the above conditions are not true that means we have reached the lowest common ancestor of p and q

this can mean three things (its not given whether p > q or <q):

p and q are children of current node (in this case the value of current node is the output)
p is the current node and q can be either the left or right child of p (in this case p is the output, the LCA is p and q)
q is the current node and p is either the left or right child of q  (in this case q is the output, the LCA is p and q)

Time : O(N), p and q are at the leaves at the deepest level and we had to visit all the nodes to get to them
Space : O(N), height of skewed BST (worst case) is N
*/

/*
============================================
RECURSIVE APPROACH:)
============================================
public static treeNode lowestCommonAncestor(treeNode root, treeNode p, treeNode q) 
{
 int pval = p.data;
 int qval = q.data;

 treeNode node = root;
 while(node!=null)
 {
  int parent = node.data;
  if(pval>parent && qval>parent)
  {
   node = node.right;
  }

  else if(pval<parent && qval<parent)
  {
   node = node.left;
  }

  else 
  {
   return node;
  }
 }

 return null;
}

Time : O(N)
Space : O(1)
*/
public class x12_Lowest_Common_Ancestor_of_a_BST extends helper {
 public static treeNode lowestCommonAncestor(treeNode root, treeNode p, treeNode q) {

  if (p.data > root.data && q.data > root.data) {
   return lowestCommonAncestor(root.right, p, q);
  }

  else if (p.data < root.data && q.data < root.data) {
   return lowestCommonAncestor(root.left, p, q);
  }

  else {
   return root;
  }

 }

 public static void main(String[] args) {
  treeNode root = new treeNode(2);
  root.right = new treeNode(6);
  treeNode p = new treeNode(6);
  treeNode q = new treeNode(2);

  System.out.println(lowestCommonAncestor(root, p, q).data);
 }
}
