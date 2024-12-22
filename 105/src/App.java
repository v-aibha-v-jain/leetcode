import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
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
    int preOrderIdx; // index for preorder traversal
    Map<Integer, Integer> mapping; // map to store value to index mapping for inorder traversal

    public TreeNode buildTree(int[] preOrder, int[] inorder) {
        mapping = new HashMap<>(); // initialize the map
        for(int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i); // fill the map with inorder values and their indices
        }
        preOrderIdx = 0; // initialize preorder index
        return helper(preOrder, 0, inorder.length - 1); // build the tree using helper function
    }

    public TreeNode helper(int[] preOrder, int start, int end) {
        if(start > end) return null; // base case: if start index is greater than end index, return null
        int rootval = preOrder[preOrderIdx++]; // get the current root value from preorder traversal
        TreeNode root = new TreeNode(rootval); // create a new tree node with the root value
        int mid = mapping.get(root.val); // get the index of the root value in inorder traversal
        root.left = helper(preOrder, start, mid - 1); // recursively build the left subtree
        root.right = helper(preOrder, mid + 1, end); // recursively build the right subtree
        return root; // return the root node
    }
}