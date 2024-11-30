import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] pairs = {{5,1},{4,5},{11,9},{9,4}};
        int[][] ans = obj.validArrangement(pairs);
        for (int[] a : ans) {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}
class Solution {
    public int[][] validArrangement(int[][] pairs) {
        int n = pairs.length; // get the number of pairs
        int[][] ans = new int[n][2]; // initialize the answer array
        for (int[] a : ans) { // initialize each pair in the answer array
            a[0] = -1; // set the first element to -1
            a[1] = -1; // set the second element to -1
        }
        Map<Integer, Integer> outdegree = new HashMap<>(); // map to store outdegree of each node
        Map<Integer, Deque<Integer>> out = new HashMap<>(); // map to store adjacency list
        for (int[] pair : pairs) { // iterate over each pair
            outdegree.put(pair[0], outdegree.getOrDefault(pair[0], 0) + 1); // increase outdegree of the first node
            outdegree.put(pair[1], outdegree.getOrDefault(pair[1], 0) - 1); // decrease outdegree of the second node
            out.computeIfAbsent(pair[0], k -> new ArrayDeque<>()); // initialize adjacency list for the first node if not present
            out.computeIfAbsent(pair[1], k -> new ArrayDeque<>()); // initialize adjacency list for the second node if not present
            out.get(pair[0]).addLast(pair[1]); // add the second node to the adjacency list of the first node
        }
        for (Map.Entry<Integer, Integer> entry : outdegree.entrySet()) { // iterate over the outdegree map
            if (entry.getValue() == 1) ans[0][0] = entry.getKey(); // find the starting node
            if (entry.getValue() == -1) ans[n - 1][1] = entry.getKey(); // find the ending node
        }
        if (ans[0][0] == -1) { // if no starting node is found
            ans[0][0] = pairs[0][0]; // set the starting node to the first node of the first pair
            ans[n - 1][1] = pairs[0][0]; // set the ending node to the first node of the first pair
        }
        int i = 0; // initialize the start index
        int j = n - 1; // initialize the end index
        while (i < j) { // iterate until the start index is less than the end index
            int from = ans[i][0]; // get the current node
            Deque<Integer> toList = out.get(from); // get the adjacency list of the current node
            if (toList.size() == 0) { // if the adjacency list is empty
                ans[j][0] = ans[--i][0]; // move the start index back and set the current node to the previous node
                ans[--j][1] = ans[j + 1][0]; // move the end index back and set the current node to the next node
            } else {
                ans[i++][1] = toList.removeLast(); // set the next node and move the start index forward
                ans[i][0] = ans[i - 1][1]; // set the current node to the previous node
            }
        } 
        return ans; // return the answer array
    }
}