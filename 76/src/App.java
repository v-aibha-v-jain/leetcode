public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(obj.minWindow(s, t));
    }
}
class Solution {
    public String minWindow(String s, String t) {
        // Check for null or empty strings and if s is shorter than t
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return new String(); // Return empty string if any condition is true
        int[] map = new int[128]; // Array to store frequency of characters in t
        int count = t.length(); // Number of characters to be matched
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0; // Initialize pointers and variables
        // Populate the map with frequency of characters in t
        for (char c : t.toCharArray()) 
            map[c]++;
        char[] chS = s.toCharArray(); // Convert s to character array
        // Traverse the string s
        while (end < chS.length) {
            // Decrease the count of the character in the map and decrease count if it was a match
            if (map[chS[end++]]-- > 0)
                count--;
            // When all characters are matched
            while (count == 0) {
                // Update the minimum length and start index if a smaller window is found
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                // Increase the count of the character in the map and increase count if it was a match
                if (map[chS[start++]]++ == 0)
                    count++;
            }
        }
        // Return the minimum window or empty string if no such window is found
        return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen);
    }
}