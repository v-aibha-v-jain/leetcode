import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(obj.kidsWithCandies(candies, extraCandies));
    }
}
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0; // Initialize the maximum number of candies to 0
        int n = candies.length; // Get the number of kids
        List<Boolean> res = new ArrayList<>(n); // Create a list to store the results
        for (int candy : candies) {
            max = Math.max(max, candy); // Find the maximum number of candies any kid has
        }
        for (int candy : candies) {
            res.add(candy + extraCandies >= max); // Check if the current kid can have the greatest number of candies
        }
        return res; // Return the list of results
    }
}