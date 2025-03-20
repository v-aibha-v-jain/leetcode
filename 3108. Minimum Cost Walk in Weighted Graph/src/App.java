import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 5;
        int[][] edges = {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
        int[][] queries = {{0, 3}, {3, 4}};
        int[] res = solution.minimumCost(n, edges, queries);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
class Solution {
    int[] parent, minCost;

    // Find the root of the set containing 'u' with path compression
    public int find(int u) {
        if (parent[u] < 0) return u; // If 'u' is a root, return it
        return parent[u] = find(parent[u]); // Path compression
    }

    // Calculate the minimum cost for queries in a weighted graph
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n]; // Initialize parent array for union-find
        minCost = new int[n]; // Initialize minCost array
        Arrays.fill(parent, -1); // Set all nodes as their own roots
        Arrays.fill(minCost, -1); // Initialize minCost with -1

        // Process edges to build the union-find structure
        for (int[] edge : edges) {
            int u = find(edge[0]), v = find(edge[1]), w = edge[2]; // Find roots of edge endpoints
            if (u != v) { // If they belong to different sets
                minCost[u] &= minCost[v]; // Combine minCost values
                parent[v] = u; // Union the sets
            }
            minCost[u] &= w; // Update minCost for the root
        }

        int res[] = new int[query.length]; // Result array for queries
        for (int i = 0; i < query.length; i++) {
            int source = query[i][0], target = query[i][1]; // Extract source and target from query
            int absSourceRoot = find(source), absTargetRoot = find(target); // Find their roots
            if (absSourceRoot != absTargetRoot) res[i] = -1; // If not connected, result is -1
            else res[i] = minCost[absSourceRoot]; // Otherwise, return the minCost of the root
        }
        return res; // Return the results for all queries
    }
}