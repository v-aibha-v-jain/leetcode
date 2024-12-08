import java.util.Arrays;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        int ans = solution.maxTwoEvents(events);
        System.out.println(ans);
    }
}
class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); // Sort events by start time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); // Min-heap to store events by end time
        int maxVal = 0, ans = 0; // Initialize maxVal and ans
        for (int[] event : events) {
            int start = event[0], end = event[1], value = event[2]; // Extract start, end, and value from event
            while (!pq.isEmpty() && pq.peek()[0] < start) { // Remove events that end before the current event starts
            maxVal = Math.max(maxVal, pq.poll()[1]); // Update maxVal with the maximum value of past events
            }
            ans = Math.max(ans, maxVal + value); // Update ans with the maximum value of two non-overlapping events
            pq.add(new int[]{end, value}); // Add the current event to the priority queue
        }
        return ans; // Return the maximum value of two non-overlapping events
    }
}