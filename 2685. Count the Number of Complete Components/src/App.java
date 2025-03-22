import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
class Solution {
    public void dfs(int[] visited, int node, List<List<Integer>> adj) {
        visited[node] = adj.get(node).size(); // Mark the node as visited and store its degree
        for (int x : adj.get(node)) 
            if (visited[x] == 0) 
                dfs(visited, x, adj); // Recursively visit all unvisited neighbors
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(); // Adjacency list to represent the graph
        int[] visited = new int[n]; // Array to track visited nodes
        int comp = 0; // Counter for complete components

        for (int i = 0; i < n; i++) 
            adj.add(new ArrayList<>()); // Initialize adjacency list for each node

        for (int[] x : edges) {
            adj.get(x[1]).add(x[0]); // Add edge to adjacency list
            adj.get(x[0]).add(x[1]); // Add reverse edge for undirected graph
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) { // If the node is not visited
                int[] edg = new int[n]; // Array to track edges in the current component
                dfs(edg, i, adj); // Perform DFS to explore the component

                int noOfNodes = 0; // Count of nodes in the component
                int noOfEdges = 0; // Count of edges in the component

                for (int j = 0; j < n; j++) {
                    if (edg[j] > 0) { // If the node is part of the component
                        noOfNodes++; // Increment node count
                        visited[j] = 1; // Mark node as visited
                    }
                    noOfEdges += edg[j]; // Sum up the edges
                }

                if (((noOfNodes * (noOfNodes - 1))) == noOfEdges) 
                    comp++; // If the component is complete, increment the counter
            }
        }

        return comp; // Return the number of complete components
    }
}