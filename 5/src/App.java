public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s));
    }
}
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) { // if the string is null or empty, return an empty string
            return "";
        }
        int start = 0, end = 0; // initialize start and end pointers
        for (int i = 0; i < s.length(); i++) { // iterate over each character in the string
            int len1 = expandAroundCenter(s, i, i); // length of palindrome with center at i
            int len2 = expandAroundCenter(s, i, i + 1); // length of palindrome with center between i and i+1
            int maxLen = Math.max(len1, len2); // get the maximum length of the two palindromes
            if (maxLen > end - start) { // if the found palindrome is longer than the current longest
            start = i - (maxLen - 1) / 2; // update start pointer
            end = i + maxLen / 2; // update end pointer
            }
        }
        return s.substring(start, end + 1); // return the longest palindrome substring
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { // expand while characters on both sides are equal
            left--; // move left pointer to the left
            right++; // move right pointer to the right
        }
        return right - left - 1; // return the length of the palindrome
    }
}