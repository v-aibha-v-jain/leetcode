import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[][] queries = {{0, 1}, {1, 0}};
        List<Boolean> result = solution.checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(result);
    }
}
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // Initialize the graph as an adjacency list
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); // Add an empty list for each course
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]); // Add the prerequisite relationship to the graph
        }
        ArrayList<Boolean> result = new ArrayList<>(); // Initialize the result list
        for (int[] query : queries) {
            boolean[] visited = new boolean[numCourses]; // Track visited nodes for each query
            result.add(dfs(graph, query[0], query[1], visited)); // Perform DFS to check if the prerequisite relationship exists
        }
        return result; // Return the result list
        }

        public boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true; // If source is the same as destination, return true
        }
        visited[src] = true; // Mark the current node as visited
        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) { // If the neighbor has not been visited
                if (dfs(graph, neighbor, dest, visited)) {
                    return true; // If DFS from the neighbor to the destination is true, return true
                }
            }
        }
        return false; // If no path is found, return false
    }
}