import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        List<Integer> nums = List.of(3,2,4); // example input list
        int modulo = 2; // example modulo value
        int k = 1; // example k value
        long result = solution.countInterestingSubarrays(nums, modulo, k); // call the method
        System.out.println("Count of interesting subarrays: " + result); // print the result
    }
}
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Integer> cnt = new HashMap<>(); // map to store prefix mod counts
        cnt.put(0, 1); // initialize with prefix mod 0 count as 1
        long res = 0; // result to store the count of interesting subarrays
        int prefix = 0; // prefix sum modulo value
        for (int num : nums) {
            if (num % modulo == k) prefix++; // increment prefix if num % modulo equals k
            res += cnt.getOrDefault((prefix - k + modulo) % modulo, 0); // add count of valid prefixes
            cnt.put(prefix % modulo, cnt.getOrDefault(prefix % modulo, 0) + 1); // update prefix mod count
        }
        return res; // return the total count of interesting subarrays
    }
}