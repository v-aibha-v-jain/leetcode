public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "abc", t = "ahbgdc";
        System.out.println(obj.isSubsequence(s, t));
    }
}
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) // if s is empty, return true
            return true;
        if (t.isEmpty()) // if t is empty, return false
            return false;
        int subsquPos = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(subsquPos) == t.charAt(i)) { // if the character in s is equal to the character in t
                subsquPos++; // move to the next character in s
                if (subsquPos == s.length()) // if all characters in s are found in t
                    return true; // return true
            }
        }
        return false;
    }
}