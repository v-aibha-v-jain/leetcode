import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        TreeNode root1 = new TreeNode(3, 
            new TreeNode(5, 
                new TreeNode(6), 
                new TreeNode(2, 
                    new TreeNode(7), 
                    new TreeNode(4)
                )
            ), 
            new TreeNode(1, 
                new TreeNode(9), 
                new TreeNode(8)
            )
        );

        TreeNode root2 = new TreeNode(3, 
            new TreeNode(5, 
                new TreeNode(6), 
                new TreeNode(7)
            ), 
            new TreeNode(1, 
                new TreeNode(4), 
                new TreeNode(2, 
                    new TreeNode(9), 
                    new TreeNode(8)
                )
            )
        );

        Solution solution = new Solution();
        System.out.println(solution.leafSimilar(root1, root2));
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(); // list to store leaf values of root1
        List<Integer> list2 = new ArrayList<>(); // list to store leaf values of root2
        getlist(root1, list1); // populate list1 with leaf values of root1
        getlist(root2, list2); // populate list2 with leaf values of root2
        if (list1.equals(list2)) return true; // check if both lists are identical
        return false; // return false if lists are not identical
    }

    public boolean getlist(TreeNode root, List<Integer> list) {
        if (root == null) return false; // return false if the node is null
        boolean left = getlist(root.left, list); // recursively check the left subtree
        boolean right = getlist(root.right, list); // recursively check the right subtree
        if (!left && !right) list.add(root.val); // add the leaf node value to the list
        return true; // return true to indicate the node has been processed
    }
}