/*
===========================================
PROBLEM:) 101
===========================================
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
i.e, left subtree is mirror image of right subtree
*/

/*
============================================
APPROACH:)
============================================
we make a helper function to compare the left and the right subtree becoz it the tree is symmetric around center then the left subtree is the mirror image of right subtree for all the nodes in the tree
for root.left is node1 and temp.right is node2
condition for symmetry is : node1.val is same as node2.val and;
left of node1 is same as right of node2 and vice versa
while checking if both node1 and node2 hit null we return true, but if only one is null and other is not, we return false

Time : O(n)
Space : O(n)
*/

/*
==================================================
ITERATIVE SOLUTION:)
==================================================
public boolean isSymmetric(treeNode root) 
{ 
 Queue<TreeNode> q = new LinkedList<>();
  q.add(root);
  q.add(root);
  while (!q.isEmpty()) 
  {
   treeNode t1 = q.poll();
   treeNode t2 = q.poll();
   if (t1 == null && t2 == null) continue;
   if (t1 == null || t2 == null) return false;
   if (t1.val != t2.val) return false;
   q.add(t1.left);
   q.add(t2.right);
   q.add(t1.right);
   q.add(t2.left);
  }
  return true;
}

Time : O(N)
Space:O(N)
*/
public class x10_Symmetric_tree extends helper {

  public static boolean isSymmetric(treeNode root) {
    if (root == null) {
      return true;
    }
    return helper_fun(root.left, root.right);
  }

  public static boolean helper_fun(treeNode node1, treeNode node2) {

    if (node1 == null && node2 == null) {
      return true;
    }

    if (node1 == null || node2 == null) {
      return false;
    }

    return ((node1.data == node2.data) && helper_fun(node1.left, node2.right) && helper_fun(node1.right, node2.left));
  }

  public static void main(String[] args) {
    treeNode root = new treeNode(1);
    root.left = new treeNode(2);
    root.right = new treeNode(2);
    root.left.left = new treeNode(3);
    root.left.right = new treeNode(4);

    root.right.left = new treeNode(4);
    root.right.right = new treeNode(3);

    System.out.println(isSymmetric(root));
  }

}
