import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 6;
        int[][] edges = {{1, 2}, {1, 4}, {1, 5}, {2, 6}, {2, 3}, {4, 6}};
        int ans = solution.magnificentSets(n, edges);
        System.out.println(ans);
    }
}
class Solution {
    boolean isBiPartile; // flag to check if the graph is bipartite
    void dfs(int src, int c, int[] color, List<Integer> component, List<List<Integer>> graph) {
        component.add(src); // add current node to the component
        color[src] = 3 - c; // color the current node with the opposite color
        for (int next : graph.get(src)) { // iterate through all adjacent nodes
            if (color[next] == -1) { // if the adjacent node is not colored
                dfs(next, color[src], color, component, graph); // recursively call dfs
            } else if (color[next] == color[src]) { // if the adjacent node has the same color
                isBiPartile = false; // the graph is not bipartite
            }
        }
    }
    int bfs(int src, List<List<Integer>> graph, int size) {
        Queue<Integer> que = new ArrayDeque<>(); // queue for BFS
        que.add(src); // add the source node to the queue
        boolean[] vis = new boolean[size]; // visited array
        vis[src] = true; // mark the source node as visited
        int[] dist = new int[size]; // distance array
        dist[src] = 1; // distance of source node is 1
        int maxLen = 1; // maximum length of the path
        while (!que.isEmpty()) { // while the queue is not empty
            int top = que.poll(); // get the front node from the queue
            for (int next : graph.get(top)) { // iterate through all adjacent nodes
                if (!vis[next]) { // if the adjacent node is not visited
                    vis[next] = true; // mark the adjacent node as visited
                    dist[next] = 1 + dist[top]; // update the distance of the adjacent node
                    que.add(next); // add the adjacent node to the queue
                    maxLen = Math.max(maxLen, dist[next]); // update the maximum length
                }
            }
        }
        return maxLen; // return the maximum length
    }
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(); // adjacency list for the graph
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>()); // initialize the adjacency list
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]); // add edge to the graph
            graph.get(e[1]).add(e[0]); // add edge to the graph
        }
        int[] color = new int[n + 1]; // color array
        Arrays.fill(color, -1); // initialize the color array with -1
        int totalGroups = 0; // total number of groups
        for (int i = 1; i <= n; ++i) {
            if (color[i] == -1) { // if the node is not colored
                isBiPartile = true; // assume the graph is bipartite
                List<Integer> component = new ArrayList<>(); // list to store the component
                dfs(i, 1, color, component, graph); // call dfs to color the component
                if (!isBiPartile) return -1; // if the graph is not bipartite, return -1
                int maxGroups = 0; // maximum number of groups
                for (int src : component) {
                    maxGroups = Math.max(maxGroups, bfs(src, graph, n + 1)); // find the maximum number of groups
                }
                totalGroups += maxGroups; // add the maximum number of groups to the total
            }
        }
        return totalGroups; // return the total number of groups
    }
}