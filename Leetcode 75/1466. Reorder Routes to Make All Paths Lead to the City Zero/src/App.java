import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        Solution solution = new Solution();
        int result = solution.minReorder(n, connections);
        System.out.println("Minimum number of edges to reorder: " + result);
    }
}
class Solution {
    public int minReorder(int n, int[][] connections) {
        HashSet<String> set = new HashSet<>(); // To store directed edges as strings
        ArrayList<Integer>[] graph = new ArrayList[n]; // Adjacency list for the graph
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>(); // Initialize adjacency list for each node
        }
        for (int[] e : connections) {
            int u = e[0], v = e[1];
            graph[u].add(v); // Add v to u's adjacency list
            graph[v].add(u); // Add u to v's adjacency list (undirected graph)
            set.add(u + "->" + v); // Store the directed edge u -> v
        }
        Queue<Integer> q = new LinkedList<>(); // Queue for BFS
        q.add(0); // Start BFS from node 0
        int res = 0; // Count of edges to be reordered
        boolean[] vis = new boolean[n]; // Visited array
        while (!q.isEmpty()) {
            int size = q.size(); // Number of nodes at the current level
            while (size-- > 0) {
                int rem = q.remove(); // Remove the front node from the queue
                vis[rem] = true; // Mark the node as visited
                for (int e : graph[rem]) { // Traverse all neighbors of the current node
                    if (!vis[e]) { // If the neighbor is not visited
                        if (set.contains(rem + "->" + e)) res++; // If the edge is directed away, increment res
                        q.add(e); // Add the neighbor to the queue
                    }
                }
            }
        }
        return res; // Return the total count of edges to be reordered
    }
}