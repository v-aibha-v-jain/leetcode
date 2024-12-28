public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(obj.maxPathSum(root));
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
    int max = Integer.MIN_VALUE; // initialize max to the smallest possible value

    public int maxPathSum(TreeNode root) {
        getMax(root); // calculate the maximum path sum starting from the root
        return max; // return the maximum path sum
    }

    private int getMax(TreeNode node) {
        int left = 0, right = 0; // initialize left and right path sums to 0

        if (node.left != null) {
            left = Math.max(left, getMax(node.left)); // calculate the maximum path sum for the left subtree
        }

        if (node.right != null) {
            right = Math.max(right, getMax(node.right)); // calculate the maximum path sum for the right subtree
        }

        if (node.val + left + right > max) {
            max = node.val + left + right; // update max if the current path sum is greater
        }

        return node.val + (left > right ? left : right); // return the maximum path sum including the current node
    }
}