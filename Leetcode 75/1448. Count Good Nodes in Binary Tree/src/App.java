public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, null, new TreeNode(5)));
        System.out.println(solution.goodNodes(root));
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
    int count = 0; // Initialize count to track good nodes
    public int goodNodes(TreeNode root) {
        nodes(root, root.val); // Start traversal with root node and its value as max
        return count; // Return the total count of good nodes
    }
    private void nodes(TreeNode root, int max) {
        if (root != null) { // Check if the current node is not null
            if (root.val >= max) count++; // If current node value is greater or equal to max, increment count
            nodes(root.left, Math.max(root.val, max)); // Traverse left subtree with updated max
            nodes(root.right, Math.max(root.val, max)); // Traverse right subtree with updated max
        }
    }
}