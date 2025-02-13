import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {2, 11, 10, 1, 3};
        int k = 10;
        int result = solution.minOperations(nums, k);
        System.out.println(result);
    }
}
class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0; // initialize operation count
        PriorityQueue<Long> pq = new PriorityQueue<Long>(); // create a priority queue to store numbers
        for (int num : nums) {
            pq.add((long) num); // add each number to the priority queue
        }
        while (pq.peek() < k && pq.size() >= 2) { // while the smallest number is less than k and there are at least two elements in the queue
            long x = pq.poll(); // remove the smallest element
            long y = pq.poll(); // remove the next smallest element
            pq.add(Math.min(x, y) * 2 + Math.max(x, y)); // combine the two elements and add the result back to the queue
            count++; // increment the operation count
        }
        return count; // return the total number of operations
    }
}