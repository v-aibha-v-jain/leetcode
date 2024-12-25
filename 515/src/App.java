import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(1, 
            new TreeNode(3, new TreeNode(5), new TreeNode(3)), 
            new TreeNode(2, null, new TreeNode(9))
        );
        List<Integer> result = obj.largestValues(root);
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>(); // list to store the largest values
        if(root == null){
            return ans; // return empty list if root is null
        }
        Queue<TreeNode> q = new LinkedList<>(); // queue for level order traversal
        q.add(root); // add root to the queue
        while(!q.isEmpty()){
            int n = q.size(); // number of nodes at current level
            int currMax = Integer.MIN_VALUE; // initialize current level max to minimum value
            for(int i = 0; i < n; i++){
                TreeNode curr = q.poll(); // get the next node in the queue
                currMax = Math.max(currMax, curr.val); // update current level max
                if(curr.left != null){
                    q.add(curr.left); // add left child to the queue if it exists
                }
                if(curr.right != null){
                    q.add(curr.right); // add right child to the queue if it exists
                }
            }
            ans.add(currMax); // add current level max to the result list
        }
        return ans; // return the list of largest values
    }
}