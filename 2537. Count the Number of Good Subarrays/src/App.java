import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        int k = 10;
        System.out.println(solution.countGood(nums, k));
    }
}
class Solution {
    public long countGood(int[] nums, int k) {
        int N = nums.length; // length of the input array
        Map<Integer, Integer> map = new HashMap<>(); // map to store frequency of elements
        long ans = 0; // variable to store the result
        int l = 0, r; // two pointers: l for left, r for right
        int pairs = 0; // count of pairs satisfying the condition

        for (r = 0; r < N; ++r) { // iterate through the array with the right pointer
            int key = nums[r]; // current element
            map.put(key, map.getOrDefault(key, 0) + 1); // update frequency of the current element
            pairs += map.get(key) - 1; // add the number of pairs formed with the current element

            if (pairs >= k) { // if the number of pairs is greater than or equal to k
                ans += N - r; // add the count of valid subarrays starting from l to r
                while (l < r && pairs >= k) { // shrink the window from the left
                    key = nums[l]; // element at the left pointer
                    map.put(key, map.get(key) - 1); // decrease its frequency
                    pairs -= map.get(key); // update the pair count
                    l++; // move the left pointer
                    if (pairs >= k) ans += N - r; // add valid subarrays if condition still holds
                }
            }
        }
        return ans; // return the total count of good subarrays
    }
    
}