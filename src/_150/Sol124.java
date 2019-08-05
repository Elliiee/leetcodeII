package _150;

public class Sol124 {
    /*
    124. Binary Tree Maximum Path Sum
    Hard
    Given a non-empty binary tree, find the maximum path sum.
    For this position, a path is defined as any sequence of nodes from some
    starting node to any node in the tree along the parent-child connections.
    The path must contain at least one node and does not need to go through
    the root.
     */

    /*
    Approach 1: Recursion
    Intuition:
    First of all, let's simplify the problem and implement a function
    max_gain(node) which takes a node as an argument and computes a maximum
    contribution that this node and one/zero of its subtrees could add.
    If one would know for sure that the max path contains root, the problem
    would be solved as max_gain(root).
    But here the max path does not need to go through the root.
    So that means one needs to modify the above function and to check at each
    step what is better:
    to continue the current path or
    to start a new path with the current node as a highest node in this new path
    Algorithm:
    Initiate max_sum as the smallest possible integer and call max_gain(node=root).
    Implement max_gain(node) with a check to continue the old path/to start a
    new path:
    1. base case: if node is null, the max gain is 0
    2. call max_gain recursively for the node children to compute max gain
    from the left and right subtrees:
    3. check to continue the old path or to start a new path
    to start a new path would cost price_newpath = node.val + left_gain + right_gain
    update max_sum if it is better to start a new path
    4. for the recursion return the max gain the node and one/zero of its
    subtrees could add to the current path
     */

    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node){
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where the node is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root){
        max_gain(root);
        return max_sum;
    }

}
