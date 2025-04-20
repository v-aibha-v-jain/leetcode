import java.util.Arrays;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        int k = 3;
        long result = solution.maxScore(nums1, nums2, k);
        System.out.println("Maximum Subsequence Score: " + result); // Output: 35
    }
}
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++){
            pairs[i] = new int[] {nums1[i], nums2[i]}; // create pairs of nums1 and nums2
        }
        Arrays.sort(pairs, (a,b) -> b[1] - a[1]); // sort pairs by nums2 in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap to store nums1 values
        long ksum = 0; // sum of the top k nums1 values
        for(int i = 0; i < k; i++){
            ksum += pairs[i][0]; // add the nums1 value to ksum
            pq.add(pairs[i][0]); // add the nums1 value to the heap
        }
        long answer = ksum * pairs[k-1][1]; // calculate initial score
        for(int i = k; i < n; i++){
            int prev_small = pq.poll(); // remove the smallest nums1 value from the heap
            ksum += pairs[i][0] - prev_small; // update ksum with the new nums1 value
            pq.add(pairs[i][0]); // add the new nums1 value to the heap
            answer = Math.max(answer, ksum *  pairs[i][1]); // update the maximum score
        }
        return answer; // return the maximum score
    }
}