public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "abacbc";
        int k = 2;
        int result = solution.takeCharacters(s, k);
        System.out.println(result);
    }
}
class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length(); // get the length of the string
        int[] ord = new int[n]; // create an array to store the ordinal values of characters
        int[] cnt = new int[3]; // create an array to count occurrences of 'a', 'b', and 'c'
        for (int i = 0; i < n; i++) { // iterate over the string
            ord[i] = s.charAt(i) - 'a'; // convert character to ordinal value
            cnt[ord[i]]++; // increment the count of the character
        }
        for (int c: cnt) // iterate over the count array
            if (c < k) // if any character count is less than k
                return -1; // return -1
        int res = 0; // initialize result variable
        for (int r = 0, l = 0; r < n; r++) { // iterate over the string with two pointers
            cnt[ord[r]]--; // decrement the count of the current character
            while (cnt[ord[r]] < k) { // while the count of the current character is less than k
                cnt[ord[l]]++; // increment the count of the left pointer character
                l++; // move the left pointer to the right
            }
            res = Math.max(res, r - l + 1); // update the result with the maximum length
        }
        return n - res; // return the minimum number of characters to be removed
    }
}