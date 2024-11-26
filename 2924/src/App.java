public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}};
        System.out.println(obj.findChampion(n, edges));
    }
}
class Solution {
    public int findChampion(int n, int[][] edges) {
        if (edges.length == 0) { // if there are no edges
            return n == 1 ? 0 : -1; // if there's only one node, return 0, else return -1
        }
        int[] inDeg = new int[n]; // array to store in-degrees of nodes
        for (int[] edge : edges) { // iterate over each edge
            inDeg[edge[1]]++; // increment in-degree of the destination node
        }
        int count = 0; // variable to count nodes with 0 in-degree
        int ans = -1; // variable to store the answer
        for (int i = 0; i < n; i++) { // iterate over each node
            if (inDeg[i] == 0) { // if the node has 0 in-degree
                count++; // increment the count
                ans = i; // update the answer with the current node
            }
        }
        return count == 1 ? ans : -1; // if there's exactly one node with 0 in-degree, return it, else return -1
    }
}