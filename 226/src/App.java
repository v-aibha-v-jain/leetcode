public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(4, 
            new TreeNode(2, new TreeNode(1), new TreeNode(3)), 
            new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );
        TreeNode invertedRoot = obj.invertTree(root);
        printTree(invertedRoot);
    }
    static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) { // if the root is null, return null
            return null;
        }
        TreeNode temp = root.left; // store the left child in a temporary variable
        root.left = root.right; // swap the left child with the right child
        root.right = temp; // assign the temporary variable to the right child
        invertTree(root.left); // recursively invert the left subtree
        invertTree(root.right); // recursively invert the right subtree
        return root; // return the root of the inverted tree
    }
}