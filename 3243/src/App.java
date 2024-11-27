import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int n = 5;
        int[][] queries = {{2,4}, {0,2}, {0,4}};
        int[] ans = obj.shortestDistanceAfterQueries(n, queries);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length]; // initialize answer array
        int k = 0; // initialize index for answer array
        List<List<Integer>> adj = new ArrayList<>(n); // create adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // initialize each list in adjacency list
        }
        for (int i = 0; i < n - 1; i++) {
            adj.get(i).add(i + 1); // add edge to adjacency list
        }
        for (int[] qu : queries) {
            adj.get(qu[0]).add(qu[1]); // add query edge to adjacency list
            ans[k++] = bfs(adj, n); // perform bfs and store result in answer array
        }
        return ans; // return answer array
    }

    public int bfs(List<List<Integer>> adj, int n) {
        int[] res = new int[n]; // initialize result array
        Arrays.fill(res, -1); // fill result array with -1
        res[0] = 0; // set distance to start node as 0
        Queue<Integer> q = new LinkedList<>(); // initialize queue for bfs
        q.offer(0); // add start node to queue
        while (!q.isEmpty()) {
            int cur = q.poll(); // get current node from queue
            for (int nei : adj.get(cur)) {
                if (res[nei] == -1) { // if neighbor node is not visited
                    res[nei] = res[cur] + 1; // update distance to neighbor node
                    q.offer(nei); // add neighbor node to queue
                }
            }
        }
        return res[n - 1]; // return distance to last node
    }
}