public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(obj.maxDepth(root));
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
    public int maxDepth(TreeNode root) {
        if (root == null) // if the root is null, the depth is 0
            return 0;
        // return 1 (for the root) plus the maximum depth of the left and right subtrees
        return 1 + (Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
}