public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(10, 
            new TreeNode(5, 
                new TreeNode(3, new TreeNode(3), new TreeNode(-2)), 
                new TreeNode(2, null, new TreeNode(1))
            ), 
            new TreeNode(-3, null, new TreeNode(11))
        );
        int targetSum = 8;
        System.out.println(solution.pathSum(root, targetSum)); // Output: 3
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
    int ans = 0; // Initialize the count of paths that sum to the target

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0; // If the tree is empty, return 0
        traverser(root, targetSum, 0); // Check paths starting from the current root
        pathSum(root.left, targetSum); // Recursively check paths in the left subtree
        pathSum(root.right, targetSum); // Recursively check paths in the right subtree
        return ans; // Return the total count of valid paths
    }

    void traverser(TreeNode root, int target, long sum) {
        if (root == null) return; // If the node is null, stop recursion
        sum += root.val; // Add the current node's value to the running sum
        if (sum == target) ans++; // If the running sum equals the target, increment the count
        traverser(root.left, target, sum); // Continue checking paths in the left subtree
        traverser(root.right, target, sum); // Continue checking paths in the right subtree
    }
}