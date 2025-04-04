public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3, 
            new TreeNode(5, 
                new TreeNode(6), 
                new TreeNode(2, 
                    new TreeNode(7), 
                    new TreeNode(4)
                )
            ), 
            new TreeNode(1, 
                new TreeNode(0), 
                new TreeNode(8)
            )
        );
        TreeNode lca = solution.lcaDeepestLeaves(root);
        System.out.println("LCA of deepest leaves: " + (lca != null ? lca.val : "null"));
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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int d = findD(root); // Find the maximum depth of the tree
        return findLR(root, 1, d); // Find the lowest common ancestor of the deepest leaves
    }
    public TreeNode findLR(TreeNode root, int depth, int d) {
        if (d == depth || root == null) // If current depth equals max depth or node is null, return node
            return root;
        TreeNode left = findLR(root.left, depth + 1, d); // Recur for the left subtree
        TreeNode right = findLR(root.right, depth + 1, d); // Recur for the right subtree
        if (left != null && right != null) return root; // If both left and right are not null, current node is LCA
        else if (left != null) return left; // If only left is not null, return left
        return right; // Otherwise, return right
    }
    public int findD(TreeNode root) {
        if (root == null) // If node is null, depth is 0
            return 0;
        int left = findD(root.left); // Find depth of left subtree
        int right = findD(root.right); // Find depth of right subtree
        return 1 + Math.max(left, right); // Return 1 + maximum of left and right depths
    }
}