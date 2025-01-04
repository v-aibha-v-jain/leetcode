public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "aabca";
        System.out.println(solution.countPalindromicSubsequence(s));
    }
}
class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] count = new int[26]; // Array to count occurrences of each character
        for(int i = 0 ; i < s.length() ; i++){
            count[s.charAt(i) - 'a']++; // Count each character in the string
        }
        boolean mark[] = new boolean[26]; // Array to mark characters that have been processed
        int[] present = new int[26]; // Array to count characters present up to the current index
        int res = 0; // Result to store the count of palindromic subsequences
        for(int i = 0 ; i< s.length() ; i++){
            present[s.charAt(i) - 'a']++; // Increment the count of the current character
            if(!mark[s.charAt(i) - 'a'] && (present[s.charAt(i) - 'a'] < count[s.charAt(i) - 'a']) ){
            // If the character has not been marked and its count is less than its total count
            if( (count[s.charAt(i) - 'a'] - present[s.charAt(i) - 'a']) > 1 ) res++; // If there are more than one remaining, increment result
            int[] sec = new int[26]; // Temporary array to count characters from the end
            for(int j = 0 ; j < 26 ; j++){
                sec[j] = count[j]; // Copy the count array
            }
            for(int k = s.length() - 1 ; k>=0 ; k--){
                if(s.charAt(i) == s.charAt(k)) break; // Break if the character matches the current character
                sec[s.charAt(k)-'a']--; // Decrement the count of the character from the end
            }
            for(int j = 0 ; j < 26 ; j++){
                if( ((sec[j] - present[j]) > 0) && (j != (s.charAt(i) - 'a')) ) res++; // If there are remaining characters and it's not the current character, increment result
            }
            mark[s.charAt(i) - 'a'] = true; // Mark the character as processed
            }
        }
        return res; // Return the result
    }
}