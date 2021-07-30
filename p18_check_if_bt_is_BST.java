/*
==============================================
PROBLEM:)
==============================================
check if the given binary tree and BST
*/

/*
===============================================
APPROACH:)
===============================================
for any node, if node.data < node.left.data and node.data > node.right.data, return false
a single leaf node, is a BST

Time : O(n)
Space : O(h)
*/

/*
=============================================================
APPROACH:) when the tree is skewed
=============================================================
public static boolean isBST(treeNode root)
{
  return isBSTUtil(root, null,null);
}

public static boolean isBSTUtil(treeNode node, treeNode l, treeNode r)
{
  if(node == null)
  {
    return true;
  }
  if(l!=null && l.data>=node.data)
  {
    return false;
  }

  if(r!= null && r.data<= node.data)
  {
    return false;
  }

  return(isBSTUtil(root.left,l,root) && isBSTUtil(root.right,root,r));
}
*/

/*

APPROACH 2:) when the tree is skewed
public static boolean isBST(treeNode root)
{
  return(isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
}

public static boolean isBSTUtil(treeNode root, int min, int max)
{
  if(root == null)
  {
    return true;
  }

  if(root.data<= min || root.data>=max)
  {
    return false;
  }

  return(isBSTUtil(root.left, min, root.data) && isBSTUtil(root.right, root.data, max));
}
*/

public class p18_check_if_bt_is_BST extends helper {
  static boolean isBST(treeNode root) {
    if (root.left == null && root.right == null)
      return true;

    if (root.data < root.left.data || root.data > root.right.data)
      return false;

    return (isBST(root.left) && isBST(root.right));
  }

  public static void main(String args[]) {

    treeNode root = new treeNode(5);
    root.left = new treeNode(1);
    root.right = new treeNode(4);
    root.right.left = new treeNode(3);
    root.right.right = new treeNode(6);

    if (isBST(root))
      System.out.println("IS BST");
    else
      System.out.println("Not a BST");
  }

}
