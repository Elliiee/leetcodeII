package _150;



public class Sol101 {
    /*
    101 Symmetric Tree
    Easy
    Given a binary tree, check whether it is a mirror of itself (ie. symmetric around its center).
     */

    /*
    Approach 1: Recursive
    A tree is symmetric if the left subtree is a mirror reflection of the right subtree.
    When are two trees a mirror reflection of each other?
    1. their two roots have the same value
    2. the right subtree of each tree, is a mirror reflection of the left subtree of the other tree.
     */
    public boolean isSymmetric(TreeNode root){
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t2.left, t2.right);
    }
}
