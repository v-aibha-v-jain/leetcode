public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] questions = {{3, 2}, {4, 3}, {4, 4}, {2, 5}}; // example input
        long result = solution.mostPoints(questions); // call the method to get the result
        System.out.println(result); // print the result
    }
}
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length; // total number of questions
        long[] dp = new long[n + 1]; // dp array to store maximum points

        for (int i = n - 1; i >= 0; i--) { // iterate from the last question to the first
            int nextIndex = i + questions[i][1] + 1; // index of the next question to solve after skipping
            long solve = questions[i][0] + (nextIndex < n ? dp[nextIndex] : 0); // points if we solve the current question
            long skip = dp[i + 1]; // points if we skip the current question
            dp[i] = Math.max(solve, skip); // take the maximum of solving or skipping
        }
        return dp[0]; // maximum points starting from the first question
    }
}