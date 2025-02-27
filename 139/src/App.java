import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        List<String> wordDict = List.of("leet", "code");
        System.out.println(solution.wordBreak("leetcode", wordDict));
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Convert wordDict to a set for faster lookup
        boolean[] dp = new boolean[s.length() + 1]; // Create a dp array to store results of subproblems
        dp[0] = true; // Base case: empty string can be segmented
        for (int i = 1; i <= s.length(); i++) { // Iterate over the length of the string
            for (int j = 0; j < i; j++) { // Check all substrings ending at i
                if (dp[j] && wordSet.contains(s.substring(j, i))) { // If substring s[j:i] is in wordSet and dp[j] is true
                    dp[i] = true; // Mark dp[i] as true
                    break; // No need to check further, break the inner loop
                }
            }
        }
        return dp[s.length()]; // Return the result for the entire string
    }
}