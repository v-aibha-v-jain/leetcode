import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] favorite = {2,2,1,2};
        int res = solution.maximumInvitations(favorite);
        System.out.println(res);
    }
}
class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n]; // array to store in-degrees of nodes
        int[] chainLen = new int[n]; // array to store lengths of chains ending at each node
        boolean[] visited = new boolean[n]; // array to mark visited nodes
        Queue<Integer> queue = new LinkedList<>(); // queue for processing nodes with zero in-degree
        for (int f : favorite) {
            inDegree[f]++; // increment in-degree for each favorite
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i); // add nodes with zero in-degree to the queue
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll(); // process node u
            visited[u] = true; // mark node u as visited
            int v = favorite[u]; // get the favorite of node u
            chainLen[v] = Math.max(chainLen[v], chainLen[u] + 1); // update chain length for node v
            inDegree[v]--; // decrement in-degree of node v
            if (inDegree[v] == 0) {
                queue.offer(v); // add node v to the queue if its in-degree is zero
            }
        }
        int maxCycle = 0, pairChains = 0; // variables to store the maximum cycle length and sum of pair chains
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue; // skip already visited nodes
            }
            int cycleLen = 0; // variable to store the length of the current cycle
            int current = i; // start from node i
            while (!visited[current]) {
                visited[current] = true; // mark current node as visited
                current = favorite[current]; // move to the favorite node
                cycleLen++; // increment cycle length
            }
            if (cycleLen == 2) {
                pairChains += 2 + chainLen[i] + chainLen[favorite[i]]; // add to pair chains if cycle length is 2
            } else {
                maxCycle = Math.max(maxCycle, cycleLen); // update maximum cycle length
            }
        }
        return Math.max(maxCycle, pairChains); // return the maximum of maxCycle and pairChains
    }
}