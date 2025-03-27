import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        List<Integer> nums = List.of(1, 2, 2, 2);
        int result = obj.minimumIndex(nums);
        System.out.println(result);
    }
}
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        int candidate = -1, count = 0;
        // Find the majority candidate using Boyer-Moore Voting Algorithm
        for (int num : nums) {
            if (count == 0) { // Reset candidate when count is zero
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1; // Increment or decrement count
        }

        int totalOccurrences = 0;
        // Count total occurrences of the candidate in the list
        for (int num : nums) {
            if (num == candidate) {
                totalOccurrences++; // Increment total occurrences
            }
        }

        int leftCount = 0;
        // Iterate through the list to find the valid split index
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) {
                leftCount++; // Increment left side count for the candidate
            }
            
            int leftSize = i + 1; // Size of the left partition
            int rightSize = n - leftSize; // Size of the right partition
            int rightCount = totalOccurrences - leftCount; // Count of candidate in the right partition

            // Check if both partitions satisfy the majority condition
            if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
                return i; // Return the valid split index
            }
        }

        return -1; // Return -1 if no valid split index is found
    }
}