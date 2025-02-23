import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeNode root = solution.constructFromPrePost(preorder, postorder);
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
    int id = 0; // Initialize id to 0
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // Create a map to store postorder indices
        int n = postorder.length; // Get the length of postorder array
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i); // Populate the map with postorder values and their indices
        }
        return makeTree(preorder, map, Integer.MAX_VALUE); // Start constructing the tree
    }

    public TreeNode makeTree(int[] preorder, HashMap<Integer, Integer> map, int rootvalid) {
        if (id >= preorder.length) // If id exceeds preorder length, return null
            return null;
        int a = preorder[id]; // Get the current value from preorder
        if (map.get(a) > rootvalid) { // If the current value's index in postorder is greater than rootvalid, return null
            return null;
        }
        id++; // Increment id
        TreeNode root = new TreeNode(); // Create a new TreeNode
        root.val = a; // Set the value of the node
        root.left = makeTree(preorder, map, map.get(a)); // Recursively construct the left subtree
        root.right = makeTree(preorder, map, map.get(a)); // Recursively construct the right subtree
        return root; // Return the constructed tree node
    }
}