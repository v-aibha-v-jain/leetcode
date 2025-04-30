public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {12, 345, 2, 6, 7896};
        int result = solution.findNumbers(nums);
        System.out.println(result);
    }
}
class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0; // initialize the count of numbers with even digits
        for(int i = 0; i < nums.length; i++) { // iterate through each number in the array
            int count = 0; // initialize digit count for the current number
            while(nums[i] > 0) { // loop until the number becomes 0
                count++; // increment digit count
                nums[i] = nums[i] / 10; // remove the last digit of the number
            }
            if(count % 2 == 0) ans++; // if digit count is even, increment the answer
        }
        return ans; // return the total count of numbers with even digits
    }
}