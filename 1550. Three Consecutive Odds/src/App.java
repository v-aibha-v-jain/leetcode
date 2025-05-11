public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] arr = {1,2,34,3,4,5,7,23,12};
        boolean result = solution.threeConsecutiveOdds(arr);
        System.out.println(result);
    }
}
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0; // counter to track consecutive odd numbers
        for (int i = 1; i < arr.length; i = i + 2) { // iterate through the array, skipping even indices
            if (arr[i] % 2 == 1) { // check if the current number is odd
                cnt++; // increment counter for odd numbers
                if (cnt == 1 && i + 1 < arr.length) { // check if it's the first odd and within bounds
                    if (arr[i - 1] % 2 == 1 && arr[i + 1] % 2 == 1) return true; // check if neighbors are odd
                }
                if (cnt == 2) { // check if it's the second odd in sequence
                    if (arr[i - 1] % 2 == 1) return true; // check if the previous number is odd
                    else cnt--; // decrement counter if condition fails
                }
            } else cnt = 0; // reset counter if the number is not odd
        }
        return false; // return false if no three consecutive odds are found
    }
}