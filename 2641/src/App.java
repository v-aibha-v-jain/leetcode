import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        TreeNode result = solution.replaceValueInTree(root);
        printTree(result); // print the tree
    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            System.out.println();
        }
    }
}

class TreeNode { // Definition for a binary tree node.
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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); // BFS
        queue.add(root);  // add root to the queue
        root.val = 0;
        while (!queue.isEmpty()) { // iterate through the tree
            int levelSize = queue.size();
            int levelSum = 0;
            List<TreeNode> currentLevel = new ArrayList<>(); // store the nodes in the current level
            for (int i = 0; i < levelSize; i++) { // iterate through the current level
                TreeNode node = queue.poll();
                currentLevel.add(node); // add the node to the current level
                if (node.left != null) levelSum += node.left.val; // calculate the sum of the current level
                if (node.right != null) levelSum += node.right.val; // calculate the sum of the current level
            }
            for (TreeNode node : currentLevel) { // iterate through the current level
                int siblingSum = 0;
                if (node.left != null) siblingSum += node.left.val; // calculate the sum of the siblings
                if (node.right != null) siblingSum += node.right.val;
                // update the value of the children
                if (node.left != null) {
                    node.left.val = levelSum - siblingSum;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = levelSum - siblingSum;
                    queue.add(node.right);
                }
            }
        }
        
        return root;
    }
}