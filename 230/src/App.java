import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;
        int res = obj.kthSmallest(root, k);
        System.out.println(res);
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
    PriorityQueue<Integer> ans = new PriorityQueue<>(); // Min-heap to store node values

    public int kthSmallest(TreeNode root, int k) {
        dfs(root); // Perform DFS to populate the priority queue
        System.out.println(ans + " ans size is " + ans.size()); // Debugging statement to print the priority queue and its size
        int res = 0; // Variable to store the k-th smallest element
        int n = ans.size(); // Get the size of the priority queue
        for (int i = 1; i <= n; i++) {
            if (i != k) {
                System.out.println("poll called"); // Debugging statement to indicate poll operation
                ans.poll(); // Remove the smallest element from the priority queue
            } else if (i == k) {
                res = ans.peek(); // Get the k-th smallest element
                System.out.println("peek called"); // Debugging statement to indicate peek operation
            }
            System.out.println(i == k); // Debugging statement to check if current index is k
        }
        return res; // Return the k-th smallest element
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return; // Base case: if the node is null, return
        }
        ans.add(root.val); // Add the current node's value to the priority queue
        dfs(root.left); // Recursively traverse the left subtree
        dfs(root.right); // Recursively traverse the right subtree
    }
}