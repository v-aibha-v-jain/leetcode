public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "))()))";
        String locked = "010100";
        boolean result = solution.canBeValid(s, locked);
        System.out.println("Can be valid: " + result);
    }
}
class Solution {
    public boolean canBeValid(String s, String locked) {
        int len = s.length(); // get the length of the string s
        if(len % 2 == 1) return false; // if the length is odd, return false
        int open = 0, close = 0; // counters for open and close parentheses
        int wildCard = 0; // counter for wildcards
        for(int i = 0; i < len; ++i) { // iterate over the string from left to right
            if(locked.charAt(i) == '1') { // if the character is locked
                if(s.charAt(i) == '(') ++open; // if it's an open parenthesis, increment open counter
                else ++close; // if it's a close parenthesis, increment close counter
                if(wildCard < (close - open)) return false; // if wildcards are less than the difference between close and open, return false
            } else {
                ++wildCard; // if the character is not locked, increment wildcard counter
            }
        }
        wildCard = 0; // reset wildcard counter
        open = 0; // reset open counter
        close = 0; // reset close counter
        for(int i = len - 1; i >= 0; i--) { // iterate over the string from right to left
            if(locked.charAt(i) == '1') { // if the character is locked
                if(s.charAt(i) == ')') ++open; // if it's a close parenthesis, increment open counter
                else ++close; // if it's an open parenthesis, increment close counter
                if(wildCard < (close - open)) return false; // if wildcards are less than the difference between close and open, return false
            } else {
                ++wildCard; // if the character is not locked, increment wildcard counter
            }
        }
        return true; // if all checks pass, return true
    }
}