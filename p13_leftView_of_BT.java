import java.util.*;

/*
====================================================
PROBLEM:)
====================================================
Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side.

/*
=====================================================
APPROACH:)
=====================================================
2 variables: level - tells the current level of the tree; max_level - tells the max level that has been visited till now
max_level is static, becoz we have to traverse the left and the right subtree
when traversing the right subtree, level will revisit some old values(less than max_level); these nodes wont be added to list

traverse the left and the right subtree and whenever max_level is less than level(which means we are at a level than we didnt visit before) wee add that node to the list 
and change the maxlevel to level 

Time: O(N) N = number of nodes in the tree
Space: O(N) ; skewed tree 
*/

/*
=================================================================
ITERATIVE: 
=================================================================
public static void left_view(treeNode root){
 if(root == null){
  return;
 }

 Queue<treeNode> Q = new LinkedList<>();
 Q.add(root);

 while(!Q.isEmpty()){
  int size = Q.size();
  for(int i = 1; i<size; i++){
   treeNode temp = Q.poll();
   if(i == 1){
    System.out.print(temp.data + " ");
   }
   if(temp.left != null){
    Q.add(temp.left);
   }
   if(temp.right!=null){
    Q.add(temp.right);
   }
  }
 }
}
*/

public class p13_leftView_of_BT extends helper {

 public static void main(String[] args) {
  treeNode root = new treeNode(12);
  root.left = new treeNode(10);
  root.right = new treeNode(30);
  root.right.left = new treeNode(25);
  root.right.right = new treeNode(40);

  p13_leftView_of_BT obj = new p13_leftView_of_BT();
  System.out.print(obj.leftView(root));
 }

 ArrayList<Integer> leftView(treeNode root) {
  ArrayList<Integer> result = new ArrayList<Integer>();
  leftView_two(result, root, 1);

  return result;
 }

 static int max_level = 0;

 void leftView_two(ArrayList<Integer> result, treeNode root, int level) {
  if (root == null) {
   return;
  }
  if (max_level < level) {
   result.add(root.data);
   max_level = level;
  }

  // Recur for left and right subtrees
  leftView_two(result, root.left, level + 1);
  leftView_two(result, root.right, level + 1);

 }

}