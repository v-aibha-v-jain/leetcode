import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 5;
        int[][] edges = {{0, 2}, {1, 2}, {1, 3}, {2, 4}};
        int[] values = {1, 8, 1, 4, 4};
        int k = 6;
        int result = solution.maxKDivisibleComponents(n, edges, values, k);
        System.out.println("Result: " + result);
    }
}
class Solution {
    public int ans = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>()); // initialize graph with empty lists
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]); // add edge to graph
            graph.get(e[1]).add(e[0]); // add reverse edge to graph
        }
        int parent = 0;
        for (int i = 0; i < n; i++)
            if (graph.get(i).size() == 2)
                parent = i; // find a node with exactly 2 connections
        find(graph, values, n, parent, -1, k); // start DFS from the parent node
        return ans; // return the answer
    }
    private long find(List<List<Integer>> tree, int[] values, int n, int child, int parent, int k) {
        long val = values[child]; // get the value of the current node
        for (int e : tree.get(child))
            if (e != parent)
                val += find(tree, values, n, e, child, k); // add the value of the child nodes
        if (val % k == 0) ans++; // if the sum is divisible by k, increment the answer
        return val; // return the sum of values
    }
}