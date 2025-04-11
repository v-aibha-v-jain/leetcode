import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, 
            new TreeNode(7, 
                new TreeNode(7), 
                new TreeNode(-8)
            ), 
            new TreeNode(0)
        );
        System.out.println("Maximum Level Sum is at Level: " + solution.maxLevelSum(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0; // return 0 if the tree is empty
        Queue<TreeNode> queue = new LinkedList<>(); // queue for level-order traversal
        queue.add(root); // add root to the queue
        int maxLevel = 1; // track the level with the maximum sum
        int maxSum = Integer.MIN_VALUE; // initialize maxSum to the smallest possible value
        int level = 1; // start from level 1
        while (!queue.isEmpty()) {
            int levelSum = 0; // sum of the current level
            int levelSize = queue.size(); // number of nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // remove the front node from the queue
                levelSum += node.val; // add the node's value to the level sum
                if (node.left != null) queue.add(node.left); // add left child to the queue if it exists
                if (node.right != null) queue.add(node.right); // add right child to the queue if it exists
            }
            if (levelSum > maxSum) { // update maxSum and maxLevel if current level sum is greater
                maxSum = levelSum;
                maxLevel = level;
            }
            level++; // move to the next level
        }
        return maxLevel; // return the level with the maximum sum
    }
}