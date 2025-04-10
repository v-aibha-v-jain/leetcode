public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, null, 
            new TreeNode(1, 
                new TreeNode(1, 
                    new TreeNode(1, null, 
                        new TreeNode(1, null, 
                            new TreeNode(1))), 
                    null), 
                new TreeNode(1)));
        System.out.println(solution.longestZigZag(root));
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
    int len = 0; // Variable to store the maximum ZigZag length
    public int longestZigZag(TreeNode root) {
        traverse(root.left, 1, 1); // Start traversing left with initial count 1 and direction 1
        traverse(root.right, 1, -1); // Start traversing right with initial count 1 and direction -1
        return len; // Return the maximum ZigZag length
    }
    private void traverse(TreeNode root, int count, int direction) {
        if (root == null) return; // If the node is null, stop traversal
        len = Math.max(count, len); // Update the maximum ZigZag length
        if (direction == -1) { // If the direction is right (-1)
            traverse(root.left, count + 1, 1); // Move to the left child and increase count
            traverse(root.right, 1, -1); // Reset count and move to the right child
        } else { // If the direction is left (1)
            traverse(root.left, 1, 1); // Reset count and move to the left child
            traverse(root.right, count + 1, -1); // Move to the right child and increase count
        }
    }
}