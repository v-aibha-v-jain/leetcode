import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        Solution solution = new Solution();
        List<Integer> result = solution.rightSideView(root);
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>(); // Initialize the result list
        int level = 0; // Start from level 0
        recursiveCall(root, level, res); // Call the recursive function
        return res; // Return the result list
    }

    public void recursiveCall(TreeNode root, int level, List<Integer> res) {
        if (root == null) return; // If the node is null, return
        if (level == res.size()) res.add(root.val); // If the current level is equal to the size of the result list, add the node value
        recursiveCall(root.right, level + 1, res); // Recur for the right subtree
        recursiveCall(root.left, level + 1, res); // Recur for the left subtree
    }
}