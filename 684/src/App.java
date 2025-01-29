public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] edges = {{1,2},{1,3},{2,3}};
        int[] result = obj.findRedundantConnection(edges);
        System.out.println(result[0] + " " + result[1]);
    }
}
class Solution {
    int[] parent; // Array to store the parent of each node

    public void union(int x, int y) {
        int p = findparent(y); // Find the parent of y
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == p) parent[i] = parent[x]; // Update parent of all nodes with parent p to parent of x
        }
    }

    public int findparent(int x) {
        return parent[x]; // Return the parent of x
    }

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1]; // Initialize parent array
        int[] ans = new int[2]; // Array to store the redundant connection
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1]; // Get the nodes of the edge
            if (parent[a] == 0 && parent[b] == 0) {
                parent[a] = a; // Initialize parent of a
                parent[b] = a; // Initialize parent of b to a
            } else if (parent[a] != 0 && parent[b] == 0) {
                parent[b] = parent[a]; // Set parent of b to parent of a
            } else if (parent[b] != 0 && parent[a] == 0) {
                parent[a] = parent[b]; // Set parent of a to parent of b
            } else if (parent[a] != parent[b]) {
                union(a, b); // Union the sets of a and b
            } else {
                ans[0] = a; // Redundant connection found
                ans[1] = b; // Redundant connection found
            }
        }
        return ans; // Return the redundant connection
    }
}