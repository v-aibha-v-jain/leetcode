public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; // left pointer of the sliding window
        int max = 0; // maximum length of substring found
        int n = s.length(); // length of the input string
        int[] arr = new int[128]; // array to store the last index of each character
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right); // current character
            left = Math.max(left, arr[c]); // update left pointer to avoid repeating characters
            max = Math.max(right - left + 1, max); // update max length if a longer substring is found
            arr[c] = right + 1; // store the index of the next character
        }
        return max;
    }
}