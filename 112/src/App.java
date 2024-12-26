public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        boolean result = obj.hasPathSum(root, targetSum);
        System.out.println(result);
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return childnodes(root, 0, targetSum);
    }
    boolean childnodes(TreeNode root,int sum,int targetSum){
        if(root!=null){
            if(root.left==null&&root.right==null) return targetSum==sum+root.val;
            else return childnodes(root.left,sum+root.val,targetSum)||childnodes(root.right,sum+root.val,targetSum);
        }
        else return false;
    }
}