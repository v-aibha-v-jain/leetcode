import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> sums = solution.threeSum(nums);
        for (List<Integer> sum : sums) {
            System.out.println(sum);
        }
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new ArrayList<>(); // List of lists
        Arrays.sort(nums); // Sort the array
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] )
                continue; // Skip duplicates

            int ival = nums[i];
            if (ival > 0) 
                break; // No need to check further

            int left = i + 1; // Start from next element
            int right = nums.length - 1; // Start from last element

            while(left < right) {
                int sum = nums[left] + nums[right] + ival; // Calculate sum
                if (sum < 0) {
                    left++; // Move left pointer
                } else if (sum > 0) {
                    right--; // Move right pointer
                } else {
                    sums.add(Arrays.asList(ival, nums[left], nums[right])); // Add to list
                    left++; // Move left pointer
                    while(left < right && nums[left] == nums[left-1]) 
                        left++; // Skip duplicates
                }
            }
        }
        return sums;
    }
}