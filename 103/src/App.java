import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // Initialize the result list
        if (root == null) return result; // Return empty list if root is null
        Queue<TreeNode> queue = new LinkedList<>(); // Initialize the queue for BFS
        queue.add(root); // Add root to the queue
        boolean leftToRight = true; // Flag to control the zigzag order
        while (!queue.isEmpty()) { // While there are nodes to process
            int levelSize = queue.size(); // Number of nodes at the current level
            Deque<Integer> currentLevel = new LinkedList<>(); // Deque to store current level nodes
            for (int i = 0; i < levelSize; i++) { // Process all nodes at the current level
            TreeNode currentNode = queue.poll(); // Get the next node from the queue
            if (leftToRight) currentLevel.addLast(currentNode.val); // Add node value to the end if left to right
            else currentLevel.addFirst(currentNode.val); // Add node value to the front if right to left
            if (currentNode.left != null) queue.add(currentNode.left); // Add left child to the queue if it exists
            if (currentNode.right != null) queue.add(currentNode.right); // Add right child to the queue if it exists
            }
            result.add(new ArrayList<>(currentLevel)); // Add current level to the result
            leftToRight = !leftToRight; // Toggle the zigzag order
        }
        return result; // Return the final zigzag level order traversal
    }
}