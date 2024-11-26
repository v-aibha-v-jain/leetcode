import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(obj.containsNearbyDuplicate(nums, k));
    }
}
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>(); // create a new HashSet to store elements
        for (int left = 0; left < nums.length; left++) { // iterate through the array
            if (set.contains(nums[left])) return true; // if the set contains the current element, return true
            set.add(nums[left]); // add the current element to the set
            if (left >= k) set.remove(nums[left - k]); // remove the element that is out of the k range
        }
        return false; // return false if no duplicates are found within the k range
    }
}