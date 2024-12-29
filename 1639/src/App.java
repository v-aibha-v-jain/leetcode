public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String[] words = {"acca","bbbb","caca"};
        String target = "aba";
        System.out.println(obj.numWays(words, target));
    }
}
class Solution {
    private static final int MOD = 1_000_000_007;
    public int numWays(String[] words, String target) {
        int n = target.length(); // length of the target string
        int m = words[0].length(); // length of the words in the array
        var freq = new int[m][26]; // frequency array to count character occurrences at each position
        for(var word : words) {
            for(int i=0; i<m; ++i){
            ++freq[i][word.charAt(i)-'a']; // increment the frequency of the character at position i
            }            
        }
        var dp = new long[m]; // dynamic programming array to store the number of ways
        int c = target.charAt(0) - 'a'; // character index of the first character in the target
        for(int j=0; j<=m-n; ++j) {
            dp[j] = freq[j][c]; // initialize dp with the frequency of the first character
            if(j>0) dp[j] += dp[j-1]; // accumulate the number of ways
        }
        for(int i=1; i<n; ++i) {
            c = target.charAt(i) - 'a'; // character index of the current character in the target
            int max = m - n + i; // maximum index to consider for the current character
            for(int j=max; j>=i; --j) {
            dp[j] = dp[j-1] * freq[j][c]; // update dp with the product of the previous dp and the frequency
            dp[j] %= MOD; // take modulo to avoid overflow
            }
            for(int j=i+1; j<=max; ++j) {
            dp[j] += dp[j-1]; // accumulate the number of ways
            dp[j] %= MOD; // take modulo to avoid overflow
            }
        }
        return (int)dp[m-1]; // return the final number of ways
    }
}