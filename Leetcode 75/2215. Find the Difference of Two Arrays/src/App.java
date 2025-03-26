import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> ans = obj.findDifference(nums1, nums2);
        System.out.println("Elements in nums1 but not in nums2: " + ans.get(0));
        System.out.println("Elements in nums2 but not in nums1: " + ans.get(1));
    }
}
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList(); // Result list containing two lists
        ans.add(new ArrayList<Integer>()); // First list for elements in nums1 but not in nums2
        ans.add(new ArrayList<Integer>()); // Second list for elements in nums2 but not in nums1
        ArrayList<Integer> list1 = new ArrayList(); // Convert nums1 to a list
        ArrayList<Integer> list2 = new ArrayList(); // Convert nums2 to a list
        
        for(int num : nums1) list1.add(num); // Add all elements of nums1 to list1
        for(int num : nums2) list2.add(num); // Add all elements of nums2 to list2

        for(int num : list1) // Iterate through list1
            if(!list2.contains(num) && !ans.get(0).contains(num)) // If num is not in list2 and not already added
                ans.get(0).add(num); // Add num to the first list in ans
        for(int num : list2) // Iterate through list2
            if(!list1.contains(num) && !ans.get(1).contains(num)) // If num is not in list1 and not already added
                ans.get(1).add(num); // Add num to the second list in ans
        return ans; // Return the result
    }
}