import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        // Define the adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(List.of(2, 4)); // Example adjacency list
        adjList.add(List.of(1, 3));
        adjList.add(List.of(2, 4));
        adjList.add(List.of(1, 3));

        // Create the graph from the adjacency list
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            nodes.add(new Node(i + 1));
        }
        for (int i = 0; i < adjList.size(); i++) {
            for (int neighbor : adjList.get(i)) {
            nodes.get(i).neighbors.add(nodes.get(neighbor - 1));
            }
        }

        // Clone the graph
        Node clonedGraph = solution.cloneGraph(nodes.get(0));

        // Print the cloned graph (for verification)
        System.out.println("Cloned graph node value: " + clonedGraph.val);
        for (Node neighbor : clonedGraph.neighbors) {
            System.out.println("Neighbor: " + neighbor.val);
        }
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    Node dfs(Node org, HashSet<Node> h1,HashMap<Integer,Node> nodelist) {
    if(h1.contains(org)) return nodelist.get(org.val); // if the node is already visited, return its clone from the map
        h1.add(org); // mark the node as visited
        Node ref = new Node(); // create a new node
        ref.val = org.val; // set the value of the new node
        nodelist.put(org.val, ref); // add the new node to the map
        for(Node n : org.neighbors){ // iterate through all the neighbors of the original node
            ref.neighbors.add(dfs(n, h1, nodelist)); // recursively clone the neighbors and add them to the new node's neighbors list
        }
        return ref; // return the cloned node
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null; // if the input node is null, return null
        HashSet<Node> h1 = new HashSet<>(); // create a set to keep track of visited nodes
        HashMap<Integer, Node> nodelist = new HashMap<>(); // create a map to store the cloned nodes
        Node ans = dfs(node, h1, nodelist); // start the DFS from the input node
        return ans; // return the cloned graph
    }
}