import java.util.HashSet;
import java.util.Set;

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

class FindElements {
    Set<Integer> set;
    
    public FindElements(TreeNode root) {
        set = new HashSet<>(); // initialize the set to store recovered values
        solve(root, 0); // start recovering values from the root with initial value 0
    }
    
    void solve(TreeNode node, int x) {
        if (node == null) return; // if the node is null, return
        set.add(x); // add the current value to the set
        solve(node.left, 2 * x + 1); // recursively recover the left child value
        solve(node.right, 2 * x + 2); // recursively recover the right child value
    }
    
    public boolean find(int target) {
        return set.contains(target); // check if the target value is in the set
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */