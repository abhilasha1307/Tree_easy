import java.util.ArrayList;
import java.util.List;

/*
====================================================
PROBLEM :) 872
====================================================
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
For example, in the given tree [3,5,1,6,2,9,8,null,null,7,4], the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

The number of nodes in each tree will be in the range [1, 200].
Both of the given trees will have values in the range [0, 200].
*/

/*
====================================================
APPROACH:) 
====================================================
We make 2 lists to store the leaf nodes of the two trees given.
and then we compare the contents of these two list with 'equals' function
if all the elements in the two lists are same, the trees are leaf similar, else not

Time : O(L1 + L2).
Space : O(L1 + L2).
*/

public class x19_leaf_similar_trees extends helper {

 public static boolean leafSimilar(treeNode root1, treeNode root2) {

  List<Integer> l1 = new ArrayList<>();
  List<Integer> l2 = new ArrayList<>();

  dfs(root1, l1);
  dfs(root2, l2);

  return l1.equals(l2);
 }

 public static void dfs(treeNode root, List<Integer> list) {
  if (root != null) {
   if (root.left == null && root.right == null) {
    list.add(root.data);
   }

   dfs(root.left, list);
   dfs(root.right, list);
  }
 }

 public static void main(String[] args) {
  treeNode root1 = new treeNode(3);
  root1.left = new treeNode(5);
  root1.right = new treeNode(1);
  root1.left.left = new treeNode(6);
  root1.left.right = new treeNode(2);
  root1.left.right.left = new treeNode(7);
  root1.left.right.right = new treeNode(4);
  root1.right.left = new treeNode(9);
  root1.right.right = new treeNode(8);

  treeNode root2 = new treeNode(3);
  root2.left = new treeNode(5);
  root2.right = new treeNode(1);
  root2.left.left = new treeNode(6);
  root2.left.right = new treeNode(7);
  root2.right.left = new treeNode(4);
  root2.right.right = new treeNode(2);
  root2.right.right.left = new treeNode(9);
  root2.right.right.right = new treeNode(8);

  System.out.println(leafSimilar(root1, root2));
 }

}
