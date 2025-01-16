public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums1 = {2, 1, 3};
        int[] nums2 = {10, 2, 5, 0};
        int result = obj.xorAllNums(nums1, nums2);
        System.out.println(result);
    }
}
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0; // Initialize xor1 and xor2 to 0
        for (int num : nums1) xor1 ^= num; // XOR all elements in nums1
        for (int num : nums2) xor2 ^= num; // XOR all elements in nums2
        int result = 0; // Initialize result to 0
        if (nums2.length % 2 != 0) { // Check if the length of nums2 is odd
            result ^= xor1; // XOR result with xor1 if nums2 length is odd
        }
        if (nums1.length % 2 != 0) { // Check if the length of nums1 is odd
            result ^= xor2; // XOR result with xor2 if nums1 length is odd
        }
        return result; // Return the final result
    }
}