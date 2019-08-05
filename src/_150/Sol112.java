package _150;
import java.util.*;
public class Sol112 {
    /*
    112. Path Sum
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such
    that adding up all the values along the path equals the given sum.
     */

    /*
    Approach 1: Recursion
    The most intuitive way is to use a recursion here.
    One is going through the tree by considering at each step the node itself and its
    children. If node is not a leaf, one calls recursively hasPathSum method for its
    children with a sum descreased by the current node value.
    If node is a leaf, one checks if the current sum is zero, i.e. if the initial sum
    was discovered.
     */

    public boolean hasPathSum(TreeNode root, int sum){
        if (root == null){
            return false;
        }

        sum -= root.val;
        if ((root.left == null) && (root.right == null)){
            return sum == 0; // check the result
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
    // O(N)

    /*
    Approach 2: Iterations
    Algorithm: we could also convert the above recursion into iteration, with the help of
    stack. DFS would be better than BFS here since it works faster except the worst case.
    In the worst case the path root->leaf with the given sum is the last considered one
    and in this case DFS results in the same productivity as BFS.
    The idea is to visit each node with the DFS strategy, while updating the remaining sum
    to cumulate at each visit.
    1. start from a stack which contains the root nodes and the corresponding remaining sum
    which is sum - root.val.
    2. proceed to the iterations: pop the current node out of the stack and return true, if
    the remaining sum is 0 and we are on the leaf node.
    3. if the remaining sum is not zero or we are not on the leaf yet then we push the child
    nodes and corresponding remaining sums into stack.
     */

    public boolean hasPathSum_Iteration(TreeNode root, int sum){
        if (root == null){
            return false;
        }

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<Integer> sum_stack = new LinkedList();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        TreeNode node;
        int curr_sum;
        while (!node_stack.isEmpty()){
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();
            if ((node.right == null) && (node.left == null) && (curr_sum == 0)){
                return true;
            }
            if (node.right != null){
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }
            if (node.left != null){
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
        }
        return false;
    }
}
