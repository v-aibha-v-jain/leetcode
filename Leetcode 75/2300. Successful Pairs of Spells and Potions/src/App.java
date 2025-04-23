import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 7;
        int[] result = sol.successfulPairs(spells, potions, success);
        System.out.println(Arrays.toString(result));
    }
}
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length; // number of spells
        int m = potions.length; // number of potions
        int[] pairs = new int[n]; // array to store the result
        Arrays.sort(potions); // sort potions array for binary search
        for (int i = 0; i < n; i++) { // iterate through each spell
            int spell = spells[i]; // current spell
            int left = 0; // left pointer for binary search
            int right = m - 1; // right pointer for binary search
            while (left <= right) { // binary search loop
            int mid = left + (right - left) / 2; // calculate mid index
            long product = (long) spell * potions[mid]; // calculate product of spell and potion
            if (product >= success) { // if product meets or exceeds success threshold
                right = mid - 1; // move right pointer to narrow search
            } else { // if product is less than success threshold
                left = mid + 1; // move left pointer to narrow search
            }
            }
            pairs[i] = m - left; // count of successful pairs for current spell
        }
        return pairs; // return the result array
    }
}