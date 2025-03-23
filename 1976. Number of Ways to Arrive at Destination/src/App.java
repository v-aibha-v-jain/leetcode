import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 4, 1}, {4, 5, 2}, {5, 6, 3}};
        int result = solution.countPaths(n, roads);
        System.out.println(result);
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007; // Modulo for large numbers to prevent overflow
        List<List<int[]>> graph = new ArrayList<>(); // Adjacency list to represent the graph

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()); // Initialize adjacency list for each node
        }
        
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time}); // Add edge u -> v with weight time
            graph.get(v).add(new int[]{u, time}); // Add edge v -> u with weight time
        }
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0])); // Min-heap for Dijkstra's algorithm
        pq.offer(new long[]{0, 0}); // Start with node 0 and time 0
        
        long[] dist = new long[n]; // Array to store shortest distances
        Arrays.fill(dist, Long.MAX_VALUE); // Initialize distances to infinity
        dist[0] = 0; // Distance to the starting node is 0
        
        int[] ways = new int[n]; // Array to store the number of ways to reach each node
        ways[0] = 1; // There's one way to reach the starting node
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll(); // Get the node with the smallest distance
            long time = curr[0]; // Current time to reach the node
            int node = (int) curr[1]; // Current node
            
            if (time > dist[node]) continue; // Skip if the current time is greater than the shortest known time
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0]; // Neighbor node
                long newTime = time + neighbor[1]; // Time to reach the neighbor
                
                if (newTime < dist[nextNode]) { // Found a shorter path to the neighbor
                    dist[nextNode] = newTime; // Update shortest distance
                    pq.offer(new long[]{newTime, nextNode}); // Add neighbor to the priority queue
                    ways[nextNode] = ways[node]; // Update ways to reach the neighbor
                } else if (newTime == dist[nextNode]) { // Found another shortest path to the neighbor
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD; // Add the number of ways
                }
            }
        }
        
        return ways[n - 1]; // Return the number of ways to reach the destination node
    }
}
