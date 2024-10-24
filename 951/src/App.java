public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root1 = new TreeNode(1, 
            new TreeNode(2, 
                new TreeNode(4), 
                new TreeNode(5, new TreeNode(7), new TreeNode(8))
            ), 
            new TreeNode(3, 
                new TreeNode(6), 
                null
            )
        );

        TreeNode root2 = new TreeNode(1, 
            new TreeNode(3, 
                null, 
                new TreeNode(6)
            ), 
            new TreeNode(2, 
                new TreeNode(4), 
                new TreeNode(5, new TreeNode(8), new TreeNode(7))
            )
        );

        boolean result = obj.flipEquiv(root1, root2);
        System.out.println(result);
    }
}
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true; // if both are null, return true
        if (root1 == null || root2 == null || root1.val != root2.val) return false; // if one of them is null or the values are different, return false
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
               (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)); // check if the subtrees are equivalent
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