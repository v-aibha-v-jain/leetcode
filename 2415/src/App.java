public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(4, 
            new TreeNode(2, new TreeNode(1), new TreeNode(3)), 
            new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );
        TreeNode invertedRoot = obj.reverseOddLevels(root);
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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null) return null; // if the root is null, return null
        reverse(root.left, root.right, 1); // start reversing from level 1
        return root; // return the modified root
        }
        public void reverse(TreeNode leftC, TreeNode rightC, int level) {
        if(leftC==null || rightC==null) return; // if either child is null, return
        if(level%2!=0) { // if the current level is odd
            int lval = leftC.val; // store the left child's value
            leftC.val = rightC.val; // swap the left child's value with the right child's value
            rightC.val = lval; // assign the stored left child's value to the right child
        }
        reverse(leftC.left, rightC.right, level+1); // recursively reverse the next level
        reverse(leftC.right, rightC.left, level+1); // recursively reverse the next level
    }
}