import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1, 2, 1};
        int k = 3;
        int[][] edges = {{0, 1}, {0, 2}};
        long result = obj.maximumValueSum(nums, k, edges);
        System.out.println(result);
    }
}
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long baseSum = 0; // sum of all original node values
        List<Integer> gains = new ArrayList<>(); // list to store gain for each node if we apply XOR
        for (int num : nums) {
            int xorVal = num ^ k; // value after XOR with k
            int gain = xorVal - num; // gain if we choose to XOR this node
            baseSum += num; // add original value to baseSum
            gains.add(gain); // store gain
        }
        gains.sort(Collections.reverseOrder()); // sort gains in descending order
        long maxGain = 0, currentGain = 0; // maxGain tracks best total gain, currentGain accumulates gains
        int count = 0; // count of nodes we choose to XOR
        for (int g : gains) {
            currentGain += g; // add current gain
            count++; // increment count
            if (count % 2 == 0) { // only consider even number of XORs
                maxGain = Math.max(maxGain, currentGain); // update maxGain if current is better
            }
        }
        return baseSum + maxGain; // return the maximum possible sum
    }
}