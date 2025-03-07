public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(obj.minDistance(word1, word2));
    }
}
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(); // length of word1
        int m = word2.length(); // length of word2
        int[] prev = new int[m+1]; // previous row in DP table
        int[] curr = new int[m+1]; // current row in DP table

        for(int j=0; j<=m; j++) prev[j] = j; // initialize the first row

        for(int i=1; i<=n; i++){
            curr[0] = i; // initialize the first column
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    curr[j] = 0 + prev[j-1]; // characters match, no operation needed
                else curr[j] = 1 + Math.min(prev[j], Math.min(curr[j-1],prev[j-1])); // take the minimum of insert, delete, replace
        
            }
            int[] temp = prev; // swap prev and curr
            prev = curr;
            curr = temp;
        }
        return prev[m]; // return the result from the last cell
    }
}
