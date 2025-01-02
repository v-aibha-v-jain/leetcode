import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> result = obj.averageOfLevels(root);
        System.out.println(result);
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>(); // Initialize the list to store the average of each level
        if (root == null) // If the root is null, return the empty list
            return list;
        Queue<TreeNode> q = new LinkedList<>(); // Initialize the queue for level order traversal
        q.add(root); // Add the root node to the queue
        while (!q.isEmpty()) { // While there are nodes to process
            int s = q.size(); // Get the number of nodes at the current level
            double sum = 0; // Initialize the sum of values at the current level
            for (int i = 0; i < s; i++) { // Iterate through all nodes at the current level
            TreeNode node = q.poll(); // Remove the node from the queue
            if (node.left != null) // If the left child exists, add it to the queue
                q.add(node.left);
            if (node.right != null) // If the right child exists, add it to the queue
                q.add(node.right);
            sum += node.val; // Add the node's value to the sum
            }
            list.add(sum / s); // Calculate the average and add it to the list
        }
        return list; // Return the list of averages
    }
}