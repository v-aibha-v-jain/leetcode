import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}};
        int[][] edges2 = {{0, 1}};
        int result = obj.minimumDiameterAfterMerge(edges1, edges2);
        System.out.println("Minimum Diameter After Merge: " + result);
    }
}
class Solution {
    class Pair {
        int node;
        int dis;
        Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }
    ArrayList<Integer>[] makeGraph(int[][] edges, int n) {
        ArrayList<Integer>[] graph = new ArrayList[n]; // create an array of ArrayLists
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>(); // initialize each ArrayList
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]); // add edge to the graph
            graph[edge[1]].add(edge[0]); // add reverse edge to the graph
        }
        return graph; // return the constructed graph
    }
    Pair farNode(ArrayList<Integer>[] g, int st, boolean[] vis) {
        vis[st] = true; // mark the starting node as visited
        int farValue = 0; // initialize the farthest distance
        int farNode = st; // initialize the farthest node
        for (int neigh : g[st]) {
            if (!vis[neigh]) { // if the neighbor is not visited
                Pair curr = farNode(g, neigh, vis); // recursively find the farthest node
                if (farValue < curr.dis) { // update the farthest distance and node
                    farValue = curr.dis;
                    farNode = curr.node;
                }
            }
        }
        return new Pair(farNode, farValue + 1); // return the farthest node and distance
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1; // number of nodes in the first graph
        int n2 = edges2.length + 1; // number of nodes in the second graph
        ArrayList<Integer>[] g1 = makeGraph(edges1, n1); // create the first graph
        ArrayList<Integer>[] g2 = makeGraph(edges2, n2); // create the second graph
        Pair g1First = farNode(g1, 0, new boolean[n1]); // find the farthest node from node 0 in the first graph
        Pair g1Second = farNode(g1, g1First.node, new boolean[n1]); // find the farthest node from g1First in the first graph
        Pair g2First = farNode(g2, 0, new boolean[n2]); // find the farthest node from node 0 in the second graph
        Pair g2Second = farNode(g2, g2First.node, new boolean[n2]); // find the farthest node from g2First in the second graph
        int d1 = g1Second.dis - 1; // diameter of the first graph
        int d2 = g2Second.dis - 1; // diameter of the second graph
        int d3 = (d1 + 1) / 2 + (d2 + 1) / 2 + 1; // calculate the minimum diameter after merging
        return Math.max(d1, Math.max(d2, d3)); // return the maximum diameter
    }
}