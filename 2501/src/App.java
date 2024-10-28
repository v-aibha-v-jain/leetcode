import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {4,3,6,16,8,2};
        System.out.println(obj.longestSquareStreak(nums));
    }
}
class Solution {
    public int longestSquareStreak(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>(); // to remove duplicates
        for (int num : nums) {
            set.add(num); // add all elements to set
        }
        List<Integer> setArr = new ArrayList<>(set); // convert set to list
        Collections.sort(setArr); // sort the list
        for (int i = 0; i < setArr.size(); i++) {
            int curr = setArr.get(i); 
            int count = 0; // count of streak
            while (set.contains(curr)) { // check if set contains curr
                set.remove(curr); // remove curr from set
                curr = curr * curr; // update curr
                count++; // increment count
            }
            max = Math.max(max, count); // update max
        }
        return max > 1 ? max : -1;
    }
}