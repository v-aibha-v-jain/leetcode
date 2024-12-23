import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(1, 
                    new TreeNode(4, 
                        new TreeNode(7), 
                        new TreeNode(6)
                    ), 
                    new TreeNode(3, 
                        new TreeNode(8, 
                            new TreeNode(9), 
                            null
                        ), 
                        new TreeNode(5, 
                            new TreeNode(10), 
                            null
                        )
                    )
                );
        int result = obj.minimumOperations(root);
        System.out.println("Minimum operations: " + result);
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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>(); // Initialize a queue to perform level order traversal
        que.add(root); // Add the root node to the queue
        int count = 0; // Initialize the count of operations
        while(!que.isEmpty()){ // While there are nodes to process
            Queue<TreeNode> temp = new LinkedList<>(); // Temporary queue for the next level
            List<Integer> list1 = new ArrayList<>(); // List to store values of the current level
            while(!que.isEmpty()){ // Process all nodes at the current level
            TreeNode node = que.remove(); // Remove the node from the queue
            if(node.left != null){ // If the left child exists
                temp.add(node.left); // Add left child to the temporary queue
                list1.add(node.left.val); // Add left child's value to the list
            }
            if(node.right != null){ // If the right child exists
                temp.add(node.right); // Add right child to the temporary queue
                list1.add(node.right.val); // Add right child's value to the list
            }
            }
            que = temp; // Move to the next level
            List<Integer> list2 = new ArrayList<>(list1); // Copy the current level values
            Collections.sort(list1); // Sort the values to find the correct order
            HashMap<Integer, Integer> map = new HashMap<>(); // Map to store original indices of values
            for(int i = 0; i < list2.size(); i++){ // Populate the map with original indices
            map.put(list2.get(i), i); // Map value to its index
            }
            for(int i = 0; i < list1.size(); i++){ // Iterate through the sorted list
            if(list1.get(i) != list2.get(i)){ // If the value is not in the correct position
                int origIndex = map.get(list1.get(i)); // Get the original index of the value
                map.put(list2.get(i), origIndex); // Update the map with the new index
                list2.set(origIndex, list2.get(i)); // Swap the values to correct the order
                count++; // Increment the count of operations
            }
            }
        }
        return count; // Return the total count of operations
    }
}