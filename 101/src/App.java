public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(obj.isSymmetric(root));
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true; // if the root is null, the tree is symmetric
        return diffroot(root.left, root.right); // check if left and right subtrees are symmetric
        }
        public boolean diffroot(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null) return true; // both nodes are null, symmetric
        if(n1 == null || n2 == null) return false; // one node is null, the other is not, not symmetric
        if(n1.val == n2.val) // values of the nodes are equal
            return diffroot(n1.left, n2.right) && diffroot(n1.right, n2.left); // check the subtrees
        return false; // values of the nodes are not equal, not symmetric
    }
}