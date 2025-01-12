import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int n = 2;
        int[][] arr = {{1, 0}};
        System.out.println(obj.canFinish(n, arr));
    }
}
class Solution {
    public boolean canFinish(int n, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // adjacency list
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>()); // initialize adjacency list
        for (int i = 0; i < arr.length; i++) adj.get(arr[i][1]).add(arr[i][0]); // fill adjacency list with edges
        int size = adj.size(); // size of adjacency list
        int[] indegree = new int[size]; // array to store indegree of nodes
        for (int i = 0; i < size; i++) 
            for (Integer it : adj.get(i)) 
            indegree[it]++; // calculate indegree of each node
        Queue<Integer> q = new LinkedList<>(); // queue for BFS
        for (int i = 0; i < size; i++) 
            if (indegree[i] == 0) 
            q.add(i); // add nodes with 0 indegree to queue
        ArrayList<Integer> ans = new ArrayList<Integer>(); // list to store the result
        while (!q.isEmpty()) {
            int node = q.poll(); // get node from queue
            ans.add(node); // add node to result
            for (Integer it : adj.get(node)) {
            indegree[it]--; // decrease indegree of adjacent nodes
            if (indegree[it] == 0) q.add(it); // if indegree becomes 0, add to queue
            }
        }
        return ans.size() == n; // check if all nodes are processed
    }
}