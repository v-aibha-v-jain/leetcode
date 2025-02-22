import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        String t = "1-2--3--4-5--6--7";
        Solution obj = new Solution();
        TreeNode root = obj.recoverFromPreorder(t);
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
    public TreeNode recoverFromPreorder(String t) {
        TreeNode root = null; // Initialize root as null
        Stack<Node> stack = new Stack<>(); // Stack to keep track of nodes and their depths
        int value = 0, depth = 0; // Initialize value and depth
        t += '-'; // Append '-' to the end of the string to handle the last node
        for (char c : t.toCharArray()) { // Iterate through each character in the string
            if (c == '-' && value != 0) { // If current character is '-' and value is not zero
                TreeNode node = new TreeNode(value); // Create a new TreeNode with the current value
                while (!stack.empty() && stack.peek().depth >= depth) // Pop from stack until the top has a smaller depth
                    stack.pop();
                if (!stack.empty()) { // If stack is not empty
                    TreeNode parent = stack.peek().node; // Get the parent node from the top of the stack
                    if (parent.left == null) parent.left = node; // Assign to left child if it's null
                    else parent.right = node; // Otherwise, assign to right child
                } 
                else root = node; // If stack is empty, this node is the root
                Node n = new Node(node, depth); // Create a new Node with the current TreeNode and depth
                stack.push(n); // Push the new Node onto the stack
                depth = 0; // Reset depth
                value = 0; // Reset value
            }
            if (c == '-') depth++; // Increment depth for each '-'
            else value = value * 10 + (c - '0'); // Calculate value from digits
        }
        return root; // Return the root of the tree
    }

    class Node {
        TreeNode node; // TreeNode reference
        int depth; // Depth of the TreeNode

        Node(TreeNode node, int depth) {
            this.node = node; // Initialize node
            this.depth = depth; // Initialize depth
        }
    }
}