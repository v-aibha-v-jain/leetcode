import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1,5,3,9,8};
        int limit = 2;
        int[] result = solution.lexicographicallySmallestArray(nums, limit);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length; // get the length of the input array
        if (n == 0) return new int[0]; // if the array is empty, return an empty array
        int[][] sortedPairs = new int[n][2]; // create a 2D array to store the numbers and their original indices
        for (int i = 0; i < n; i++) {
            sortedPairs[i][0] = nums[i]; // store the number
            sortedPairs[i][1] = i; // store the original index
        }
        Arrays.sort(sortedPairs, Comparator.comparingInt(a -> a[0])); // sort the pairs based on the numbers
        int[] result = new int[n]; // create the result array
        int groupStart = 0; // initialize the start of the group
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || sortedPairs[i + 1][0] - sortedPairs[i][0] > limit) { // check if the current group should end
            List<Integer> indices = new ArrayList<>(); // create a list to store the indices of the current group
            for (int j = groupStart; j <= i; j++) indices.add(sortedPairs[j][1]); // add the indices to the list
            Collections.sort(indices); // sort the indices
            for (int j = 0; j < indices.size(); j++) result[indices.get(j)] = sortedPairs[groupStart + j][0]; // assign the sorted values to the result array
            groupStart = i + 1; // update the start of the next group
            }
        }
        return result; // return the result array
    }
}