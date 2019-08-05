package _150;
import javafx.util.Pair;

import java.util.LinkedList;

public class Sol111 {
    /*
    111. Minimum Depth of Binary Tree
    Easy
    Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the shortest path from the root
    node down to the nearest leaf node.
    Note: A leaf is a node with no children.
     */

    /*
    Approach 1: Recursion
    The intuitive approach is to solve the problem by recursion. Here is an example with DFS/ depth
    first search strategy.
     */

    public int minDepth(TreeNode root){
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)){
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null){
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null){
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }
    /*
    Time complexity: it is O(N), because we visit each node exactly once.
    Space complexity: in the worst case, the tree is completely unbalanced, it will be O(N).
    But in the best case, the space complexity would be log(N).
     */

    /*
    Approach 2: DFS Iteration
    We could also convert the above recursion into iteration, with the help of stack.
    The idea is to visit each leaf with the DFS strategy, while updating the minimum
    depth when we reach the leaf node.
    1. we start from a stack which contains the root node and the corresponding depth which is 1.
    2. we proceed to the iterations: pop the current node out of the stack and push the child
    nodes. The minimum depth is updated at each leaf node.
    ----import javafx.util.Pair;
     */
    public int minDepth_DFSIteration(TreeNode root){
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();

        if (root == null){
            return 0;
        }
        else {
            stack.add(new Pair(root, 1));
        }

        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();

            int current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)){
                min_depth = Math.min(min_depth, current_depth);
            }
            if (root.left != null){
                stack.add(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null){
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return min_depth;
    }
    /*
    Time complexity: O(N)
    Space complexity: O(N)
     */

    /*
    Approach 3: BFS Iteration
    The drawback of the DFS approach is that all nodes should be visited to ensure that
    the minimum depth would be found. Therefore, this results in a O(N) complexity. One
    way to optimize that complexity is to use the BFS strategy.
    We iterate the tree level by level, and the first leaf we reach corresponds to the
    minimum depth. As a result, we do not need to iterate all nodes.
     */
    public int minDepth_BFSIteration(TreeNode root){
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null){
            return 0;
        }
        else {
            stack.add(new Pair(root, 1));
        }

        int current_depth = 0;
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)){
                break;
            }
            if (root.left != null){
                stack.add(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null){
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return current_depth;
    }
    /*
    Time complexity: O(N)
    Space complexity: O(N)
     */
}
