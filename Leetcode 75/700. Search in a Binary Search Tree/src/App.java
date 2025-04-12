public class App {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(4, 
                    new TreeNode(2, 
                    new TreeNode(1), 
                    new TreeNode(3)), 
                    new TreeNode(7));
        int val = 2;

        Solution solution = new Solution();
        TreeNode result = solution.searchBST(root, val);

        if (result != null) {
            System.out.println("Found node with value: " + result.val);
        } else {
            System.out.println("Value not found in the BST.");
        }
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
    public TreeNode searchBST(TreeNode root, int val) {
        // If the current node is null or the value matches, return the node
        if (root == null || root.val == val) return root;
        // If the value is smaller, search in the left subtree
        if (root.val > val) return searchBST(root.left, val);
        // Otherwise, search in the right subtree
        return searchBST(root.right, val);
    }
}