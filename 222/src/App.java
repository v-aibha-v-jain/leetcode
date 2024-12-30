public class App {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, 
                new TreeNode(4), 
                new TreeNode(5)
            ), 
            new TreeNode(3, 
                new TreeNode(6), 
                null
            )
        );

        Solution solution = new Solution();
        int count = solution.countNodes(root);
        System.out.println("Number of nodes: " + count);
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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        return 1+l+r;
    }
}