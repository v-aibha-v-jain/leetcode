import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {55, 3, 38, 110, 49};
        System.out.println(solution.maximumSum(nums));
    }
}
class Solution {

    private HashMap<Integer,Integer> map = new HashMap<>();

    public int maximumSum(int[] nums) {
        int dsum = 0; // Initialize digit sum
        int res = -1; // Initialize result
        for(int num : nums){ // Iterate through each number in the array
            dsum = findSum(num); // Find the sum of digits of the current number
            if(map.containsKey(dsum)){ // Check if the digit sum is already in the map
                res = Math.max(res, num + map.get(dsum)); // Update the result with the maximum sum
            if(num > map.get(dsum)){ // If the current number is greater than the stored number
                map.put(dsum, num); // Update the map with the current number
            }
            }else{
                map.put(dsum, num); // Add the digit sum and number to the map
            }
        }
        return res; // Return the result
    }

    private int findSum (int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

}