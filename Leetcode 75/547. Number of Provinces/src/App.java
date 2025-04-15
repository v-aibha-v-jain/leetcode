import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Solution solution = new Solution();
        int result = solution.findCircleNum(isConnected);
        System.out.println("Number of Provinces: " + result);
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        // Convert adjacency matrix to adjacency list
        List<List<Integer>> adj = adjListConvertion(isConnected);
        int vertex = adj.size(); // Number of vertices
        boolean vis[] = new boolean[vertex]; // Visited array to track visited nodes
        int ans = 0; // Count of connected components (provinces)
        for (int i = 0; i < vertex; i++) {
            if (!vis[i]) { // If the node is not visited
                ans++; // Increment the count of provinces
                dfsHelper(adj, i, vis); // Perform DFS to mark all connected nodes
            }
        }
        return ans; // Return the total number of provinces
    }

    public void dfsHelper(List<List<Integer>> adjList, int node, boolean[] vis) {
        vis[node] = true; // Mark the current node as visited
        for (Integer it : adjList.get(node)) { // Traverse all adjacent nodes
            if (!vis[it]) // If the adjacent node is not visited
                dfsHelper(adjList, it, vis); // Recursively visit the adjacent node
        }
    }

    public List<List<Integer>> adjListConvertion(int[][] isConnected) {
        int n = isConnected.length; // Number of rows (nodes)
        int m = isConnected[0].length; // Number of columns
        List<List<Integer>> adj = new ArrayList<>(); // Adjacency list representation
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>()); // Initialize adjacency list for each node
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 1 && i != j) // If there's a connection and it's not self-loop
                    adj.get(i).add(j); // Add the connection to the adjacency list
            }
        }
        return adj; // Return the adjacency list
    }
}