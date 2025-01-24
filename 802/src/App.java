import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> result = obj.eventualSafeNodes(graph);
        System.out.println(result);
    }
}
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length; // number of vertices in the graph
        int[] visit = new int[v]; // to track visited nodes
        int[] pathVisit = new int[v]; // to track nodes in the current path
        int[] check = new int[v]; // to mark safe nodes
        for (int i = 0; i < v; i++) {
            if (visit[i] == 0) { // if the node is not visited
                dfs(i, graph, visit, pathVisit, check); // perform DFS
            }
        }
        List<Integer> safeNodes = new ArrayList<>(); // list to store safe nodes
        for (int i = 0; i < v; i++) {
            if (check[i] == 1) { // if the node is safe
                safeNodes.add(i); // add to the list of safe nodes
            }
        }
        return safeNodes; // return the list of safe nodes
        }
        boolean dfs(int node, int[][] graph, int[] visit, int[] pathVis, int[] check) {
        visit[node] = 1; // mark the node as visited
        pathVis[node] = 1; // mark the node in the current path
        check[node] = 0; // assume the node is not safe initially
        for (int it : graph[node]) {
            if (visit[it] == 0) { // if the adjacent node is not visited
                if (dfs(it, graph, visit, pathVis, check)) { // perform DFS on the adjacent node
                    return true; // if a cycle is found, return true
                }
            }
            else if (pathVis[it] == 1) { // if the adjacent node is in the current path
                return true; // a cycle is found, return true
            }
        }
        check[node] = 1; // mark the node as safe
        pathVis[node] = 0; // remove the node from the current path
        return false; // no cycle found, return false
    }
}