public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(obj.isSameTree(p, q));
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true; // both nodes are null, trees are the same
        else if(p==null && q!=null) return false; // p is null and q is not, trees are different
        else if(p!=null && q==null) return false; // p is not null and q is, trees are different
        if(p.val==q.val) // values of p and q are the same
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right); // check left and right subtrees
        return false; // values of p and q are different, trees are different
    }
}