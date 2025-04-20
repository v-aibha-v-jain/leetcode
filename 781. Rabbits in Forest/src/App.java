import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] answers = {1, 1, 2};
        System.out.println(solution.numRabbits(answers)); // Output: 5
    }
}
class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers); // Sort the answers array
        int res = 0, count = 0; // Initialize result and count variables
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 0) res++; // If answer is 0, add 1 rabbit to result
            else if (i == 0 || answers[i] != answers[i - 1] || count == 0) {
                res += answers[i] + 1; // Add the group size (answer + 1) to result
                count = answers[i]; // Reset count to the current answer
            } 
            else count--; // Decrease count for the current group
        }
        return res; // Return the total number of rabbits
    }
}