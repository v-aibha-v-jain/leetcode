import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        String[] words = {"bab","dab","cab"};
        int[] groups = {1,2,2};
        List<String> result = sol.getWordsInLongestSubsequence(words, groups);
        System.out.println(result);
    }
}
class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n], prev = new int[n];
        Arrays.fill(prev, -1); // initialize previous indices to -1
        int bestLen = 0, bestEnd = 0; // track best subsequence length and its end index
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // each word is a subsequence of length 1
            for (int j = 0; j < i; j++) {
                if (groups[j] != groups[i] && words[j].length() == words[i].length()) { // check group and length
                    String a = words[j], b = words[i];
                    int diff = 0, L = a.length();
                    for (int k = 0; k < L; k++) {
                        if (a.charAt(k) != b.charAt(k) && ++diff > 1) break; // count differing chars
                    }
                    if (diff == 1) { // only one character difference
                        int cand = dp[j] + 1; // candidate subsequence length
                        if (cand > dp[i]) {
                            dp[i] = cand; // update dp if longer subsequence found
                            prev[i] = j; // record previous index
                        }
                    }
                }
            }
            if (dp[i] > bestLen) {
                bestLen = dp[i]; // update best length
                bestEnd = i; // update end index of best subsequence
            }
        }
        LinkedList<String> ans = new LinkedList<>();
        for (int cur = bestEnd; cur != -1; cur = prev[cur]) {
            ans.addFirst(words[cur]); // reconstruct subsequence
        }
        return ans; // return the longest subsequence
    }
}