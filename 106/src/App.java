import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = obj.buildTree(inorder, postorder);
        System.out.println(root.val);
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i); // store the index of each value in inorder array
        }
        int n = postorder.length;
        TreeNode root = helper(postorder, inorder, 0, n - 1, 0, n - 1, m); // build the tree using helper function
        return root;
    }

    public TreeNode helper(int[] postorder, int[] inorder, 
    int ps, int pe, int is, int ie, HashMap<Integer, Integer> map) {
        if (ps > pe || is > ie) return null; // base case: if pointers cross, return null
        TreeNode root = new TreeNode(postorder[pe]); // create root node with the last element in postorder
        int root_idx_inorder = map.get(root.val); // find the index of root in inorder array
        int nodes_in_lst = root_idx_inorder - is; // number of nodes in left subtree
        root.left = helper(postorder, inorder, ps, ps + nodes_in_lst - 1, is, root_idx_inorder - 1, map); // build left subtree
        root.right = helper(postorder, inorder, ps + nodes_in_lst, pe - 1, root_idx_inorder + 1, ie, map); // build right subtree
        return root;
    }
}