import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int multiplier = 2;
        int[] result = solution.getFinalState(nums, k, multiplier);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> nums[i] - nums[j] == 0 ? i - j : nums[i] - nums[j]); // Min-heap based on nums values, break ties by index
        for (int i = 0; i < nums.length; i++) 
            pq.offer(i); // Add all indices to the priority queue
        while (k-- > 0) {
            int i = pq.poll(); // Get the index of the smallest element
            nums[i] *= multiplier; // Multiply the smallest element by the multiplier
            pq.offer(i); // Reinsert the updated index back into the priority queue
        }
        return nums; // Return the modified array
    }
}