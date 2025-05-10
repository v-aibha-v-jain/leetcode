public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums1 = {3,2,0,1,0};
        int[] nums2 = {6,5,0};    
        System.out.println(solution.minSum(nums1, nums2)); // Output: 7
    }
}
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long n1 = 0; // sum of elements in nums1
        long n2 = 0; // sum of elements in nums2
        long cnt1 = 0; // count of zeros in nums1
        long cnt2 = 0; // count of zeros in nums2

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) { // if element in nums1 is zero
                cnt1++; // increment zero count for nums1
                nums1[i]++; // replace zero with 1
            }
            n1 += nums1[i]; // add element to sum of nums1
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) { // if element in nums2 is zero
                cnt2++; // increment zero count for nums2
                nums2[i]++; // replace zero with 1
            }
            n2 += nums2[i]; // add element to sum of nums2
        }

        // if one array's sum is smaller and has no zeros to adjust, return -1
        if ((n1 < n2 && cnt1 == 0) || (n2 < n1 && cnt2 == 0)) return -1;

        return Math.max(n1, n2); // return the maximum sum of the two arrays
    }
}