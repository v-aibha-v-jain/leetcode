import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int bob = 3;
        int[] amount = {-2, 4, 2, -4, 6};
        System.out.println(solution.mostProfitablePath(edges, bob, amount));
    }
}
class Solution {
    public class Node {
        int cost, time, node;
        Node(int c, int t, int n) {
            this.cost = c;
            this.time = t;
            this.node = n;
        }
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>(); // initialize adjacency list
        }
        for (int[] i : edges) {
            adj[i[0]].add(i[1]); // add edge to adjacency list
            adj[i[1]].add(i[0]); // add reverse edge to adjacency list
        }
        int[] timeStamp = new int[n];
        Arrays.fill(timeStamp, Integer.MAX_VALUE); // initialize timestamps
        dfs(timeStamp, bob, 0, -1, adj); // perform DFS to set timestamps
        Queue<Node> qn = new LinkedList<>();
        qn.add(new Node(0, 0, 0)); // start BFS from node 0
        boolean[] visit = new boolean[n];
        int ans = Integer.MIN_VALUE;
        while(!qn.isEmpty()) {
            Node cur = qn.poll(); // get current node
            if (visit[cur.node]) {
                continue; // skip if already visited
            }
            visit[cur.node] = true; // mark as visited
            int costToOpen = 0;
            if (timeStamp[cur.node] == cur.time) {
                costToOpen = amount[cur.node] / 2; // half amount if Bob and Alice meet
            } else if (timeStamp[cur.node] > cur.time) {
                costToOpen = amount[cur.node]; // full amount if Alice arrives first
            }
            if (cur.node != 0 && adj[cur.node].size() == 1) {
                ans = Math.max(ans, costToOpen + cur.cost); // update max profit at leaf node
            }
            for (int i : adj[cur.node]) {
                qn.add(new Node(costToOpen + cur.cost, cur.time + 1, i)); // add neighbors to queue
            }
        }
        return ans; // return maximum profit
    }

    boolean dfs(int[] timeStamp, int node, int time, int par, ArrayList<Integer>[] adj) {
        if (node == 0) {
            timeStamp[node] = time; // set timestamp for node 0
            return true;
        }
        timeStamp[node] = time; // set timestamp for current node
        for (int i : adj[node]) {
            if (i == par) {
                continue; // skip parent node
            }
            if (dfs(timeStamp, i, time + 1, node, adj)) {
                return true; // continue DFS
            }
        }
        timeStamp[node] = Integer.MAX_VALUE; // reset timestamp if not leading to node 0
        return false;
    }

    void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " "); // print array elements
        }
        System.out.println();
    }
}