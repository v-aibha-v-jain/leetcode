public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(5, 
            new TreeNode(3, 
                new TreeNode(2), 
                new TreeNode(4)
            ), 
            new TreeNode(6, 
                null, 
                new TreeNode(7)
            )
        );

        TreeNode result = sol.deleteNode(root, 3);

        printInOrder(result);
    }
    
    static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null; // If the tree is empty, return null

        if (key < root.val) { // If the key is smaller than the root's value, go to the left subtree
            root.left = deleteNode(root.left, key); // Recursively delete in the left subtree
            return root; // Return the root after deletion
        } else if (key > root.val) { // If the key is greater than the root's value, go to the right subtree
            root.right = deleteNode(root.right, key); // Recursively delete in the right subtree
            return root; // Return the root after deletion
        } else { // If the key matches the root's value
            if (root.left == null) return root.right; // If no left child, return the right child
            else if (root.right == null) return root.left; // If no right child, return the left child
            else { // If the node has two children
                TreeNode min = root.right; // Find the smallest node in the right subtree
                while (min.left != null) { // Traverse to the leftmost node
                    min = min.left; // Move to the left child
                }
                root.val = min.val; // Replace the root's value with the smallest value
                root.right = deleteNode(root.right, min.val); // Delete the smallest node in the right subtree
                return root; // Return the root after deletion
            }
        }
    }
}