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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0); // start DFS with initial sum 0
    }
    private int dfs(TreeNode node, int sum) {
        if (node == null) return 0; // if node is null, return 0
        sum = sum * 10 + node.val; // update sum with current node's value
        if (node.left == null && node.right == null) return sum; // if leaf node, return sum
        else return dfs(node.left, sum) + dfs(node.right, sum); // recursively call DFS on left and right children
    }
}