public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] grid = {{0,1},{1,0}};
        Node result = obj.construct(grid);
        System.out.println(result);
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

class Solution {
    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length); // Start solving from the top-left corner of the grid
    }

    Node solve(int[][] grid, int i, int j, int size) {
        Node newNode = new Node(); // Create a new node
        if (size == 1) { // Base case: if the size is 1, it's a leaf node
            newNode.val = grid[i][j] == 1; // Set the value of the node based on the grid value
            newNode.isLeaf = true; // Mark the node as a leaf
            return newNode; // Return the leaf node
        }
        int offset = size / 2; // Calculate the offset for dividing the grid into quadrants
        boolean val = true; // Initialize the value of the node
        boolean isLeaf = false; // Initialize the isLeaf flag
        Node topLeft = solve(grid, i, j, offset); // Solve for the top-left quadrant
        Node topRight = solve(grid, i, j + offset, offset); // Solve for the top-right quadrant
        Node bottomLeft = solve(grid, i + offset, j, offset); // Solve for the bottom-left quadrant
        Node bottomRight = solve(grid, i + offset, j + offset, offset); // Solve for the bottom-right quadrant
        boolean allTrue = topLeft.val && topRight.val && bottomLeft.val && bottomRight.val; // Check if all quadrants are true
        if (allTrue) {
            boolean allLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf; // Check if all quadrants are leaf nodes
            if (allLeaf)
                isLeaf = true; // Mark the node as a leaf if all quadrants are leaf nodes
            val = true; // Set the value to true
        }
        boolean notAllFalse = topLeft.val || topRight.val || bottomLeft.val || bottomRight.val; // Check if not all quadrants are false
        if (!notAllFalse) {
            boolean allLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf; // Check if all quadrants are leaf nodes
            if (allLeaf)
                isLeaf = true; // Mark the node as a leaf if all quadrants are leaf nodes
            val = false; // Set the value to false
        }
        newNode.val = val; // Set the value of the new node
        newNode.isLeaf = isLeaf; // Set the isLeaf flag of the new node
        if (!isLeaf) {
            newNode.topLeft = topLeft; // Set the top-left child
            newNode.topRight = topRight; // Set the top-right child
            newNode.bottomLeft = bottomLeft; // Set the bottom-left child
            newNode.bottomRight = bottomRight; // Set the bottom-right child
        }
        return newNode; // Return the new node
    }
}