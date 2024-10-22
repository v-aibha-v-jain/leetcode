import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        Solution solution = new Solution();
        int k = 2; // Example value for k
        long result = solution.kthLargestLevelSum(root, k);
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
    private long[] sums = new long[100000];
    private int maxLevel = 0;

    private void solve(TreeNode root, int lvl) {
        if (root == null) return; // Base case
        sums[lvl] += root.val; // Add the value of the current node to the sum of the current level
        maxLevel = Math.max(maxLevel, lvl); // Update the maximum level
        solve(root.left, lvl + 1); // Recursive call for the left child
        solve(root.right, lvl + 1); // Recursive call for the right child
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        solve(root, 0); // Calculate the sum of each level
        Long[] validSums = new Long[maxLevel + 1]; // Store the sums of each level
        for (int i = 0; i <= maxLevel; i++) {
            validSums[i] = sums[i];
        }
        Arrays.sort(validSums, Collections.reverseOrder()); // Sort the sums in descending order
        return (k > maxLevel + 1) ? -1 : validSums[k - 1]; // Return the k-th largest level sum
    }
}