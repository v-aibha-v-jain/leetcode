import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length; // get the number of buildings
        int[] result = new int[queries.length]; // initialize result array
        Arrays.fill(result, -1); // fill result array with -1
        List<List<int[]>> qs = new ArrayList<>(); // list to store queries for each building
        for (int i = 0; i < n; i++) {
            qs.add(new ArrayList<>()); // initialize list for each building
        }
        for (int index = 0; index < queries.length; index++) {
            int alice = queries[index][0]; // get alice's building index
            int bob = queries[index][1]; // get bob's building index
            if (alice > bob) {
            int temp = alice; // swap alice and bob if alice > bob
            alice = bob;
            bob = temp;
            }
            if (alice == bob || heights[alice] < heights[bob]) {
            result[index] = bob; // if alice and bob are the same or alice's building is shorter, set result to bob
            } else {
            qs.get(bob).add(new int[]{heights[alice], index}); // add query to bob's list
            }
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // min-heap to process queries
        for (int index = 0; index < n; index++) {
            int height = heights[index]; // get current building height
            for (int[] q : qs.get(index)) {
            minHeap.add(q); // add queries to min-heap
            }
            while (!minHeap.isEmpty() && minHeap.peek()[0] < height) {
            int[] query = minHeap.poll(); // process queries with height less than current building
            int queryIndex = query[1]; // get query index
            result[queryIndex] = index; // set result to current building index
            }
        }
        return result; // return the result array
    }
}