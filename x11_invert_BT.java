/*
=======================================
PROBLEM :)  226
=======================================
Invert a BT
*/

/*
========================================
APPROACH:) 
========================================
We make nodes right and left to store the right and left subtree of the current node, and then overwrite root.left = right and root.right = left

Time : O(n)
Space : O(h)
*/

/*
=============================================
ITERATIVE SOLUTION :)
==============================================
public static treeNode invertTree(treeNode root) {

  if (root == null) {
   return root;
  }

  Queue<treeNode> Q = new LinkedList<>();
  Q.add(root);

  while (!Q.isEmpty()) {
   treeNode current = Q.poll();
   treeNode t = current.left;
   current.left = current.right;
   current.right = t;

   if (current.left != null) {
    Q.add(current.left);
   }

   if (current.right != null) {
    Q.add(current.right);
   }
  }

  return root;
 }

 Time : O(n)
 Space : O(n); all nodes in one level of BT in the queue, for a full BT, leaf level has maximum nodes
*/
public class x11_invert_BT extends helper {
  public static treeNode invertTree(treeNode root) {

    if (root == null) {
      return root;
    }

    treeNode right = invertTree(root.right);
    treeNode left = invertTree(root.left);

    root.left = right;
    root.right = left;

    return root;

  }

  public static void inorder(treeNode node) {
    if (node != null) {
      inorder(node.left);
      System.out.print(node.data + " ");
      inorder(node.right);
    }
  }

  public static void main(String[] args) {

    treeNode root = new treeNode(4);
    root.left = new treeNode(2);
    root.right = new treeNode(7);
    root.left.left = new treeNode(1);
    root.left.right = new treeNode(3);
    root.right.left = new treeNode(6);
    root.right.right = new treeNode(9);

    treeNode res = invertTree(root);

    inorder(res);
  }

}
