public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode result = obj.sortedArrayToBST(nums);
        System.out.println(result.val);
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1); // call helper to construct BST
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null; // base case: no elements to process
        int mid = (left + right) / 2; // find the middle element
        TreeNode root = new TreeNode(nums[mid]); // create a new node with the middle element
        root.left = helper(nums, left, mid - 1); // recursively build the left subtree
        root.right = helper(nums, mid + 1, right); // recursively build the right subtree
        return root; // return the root of the subtree
    }
}