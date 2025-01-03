import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = solution.levelOrder(root);
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // Initialize the result list
        if(root == null) return result; // Return empty list if root is null
        Queue<TreeNode> queue = new LinkedList<>(); // Initialize the queue
        queue.offer(root); // Add root to the queue
        while(!queue.isEmpty()){ // While there are nodes to process
            int size = queue.size(); // Get the number of nodes at the current level
            List<Integer> list = new ArrayList<>(); // List to store values of the current level
            for(int i = 0; i < size; i++){ // Process all nodes at the current level
            TreeNode temp = queue.poll(); // Remove the node from the queue
            list.add(temp.val); // Add the node's value to the list
            if(temp.left != null) queue.offer(temp.left); // Add left child to the queue if it exists
            if(temp.right != null) queue.offer(temp.right); // Add right child to the queue if it exists
            }
            result.add(list); // Add the current level's list to the result
        }
        return result; // Return the result list
    }
}