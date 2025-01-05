public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(obj.getMinimumDifference(root));
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
    Integer prev = null; // Previous node value in in-order traversal
    int ans = Integer.MAX_VALUE; // Minimum difference initialized to maximum value

    public int getMinimumDifference(TreeNode root) {
        find(root); // Start in-order traversal
        return ans; // Return the minimum difference found
    }

    public void find(TreeNode root) {
        if (root == null) // Base case: if node is null, return
            return;
        find(root.left); // Traverse left subtree
        if (prev != null) { // If previous node exists
            ans = Math.min(ans, root.val - prev); // Update minimum difference
        }
        prev = root.val; // Update previous node value
        find(root.right); // Traverse right subtree
    }
}