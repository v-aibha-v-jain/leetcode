public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        int result = solution.numEquivDominoPairs(dominoes);
        System.out.println("Number of equivalent domino pairs: " + result);
    }
}
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100]; // Array to count occurrences of each domino pair
        int res = 0; // Variable to store the result (number of equivalent pairs)
        for (int[] d : dominoes) {
            // Calculate a unique value for each domino pair, ensuring order doesn't matter
            int val = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            res += count[val]++; // Add the current count of this pair to the result, then increment the count
        }
        return res; // Return the total number of equivalent domino pairs
    }
}