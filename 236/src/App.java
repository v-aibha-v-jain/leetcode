public class App {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // TreeNode with value 5
        TreeNode q = root.right; // TreeNode with value 1

        Solution solution = new Solution();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root; // if root is null or root is p or q, return root
        TreeNode left = lowestCommonAncestor(root.left, p, q); // recursively find LCA in the left subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q); // recursively find LCA in the right subtree
        if(left == null) return right; // if left is null, return right
        else if(right == null) return left; // if right is null, return left
        else return root; // if both left and right are not null, return root
    }
}