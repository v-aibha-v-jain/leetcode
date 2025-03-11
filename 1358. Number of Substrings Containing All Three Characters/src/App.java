import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "abcabc";
        System.out.println(obj.numberOfSubstrings(s));
    }
}
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(); // length of the input string
        HashMap<Character, Integer> freq = new HashMap<>(); // frequency map to store count of 'a', 'b', 'c'
        freq.put('a', 0); // initialize count of 'a' to 0
        freq.put('b', 0); // initialize count of 'b' to 0
        freq.put('c', 0); // initialize count of 'c' to 0
        int low = 0, high = 0, count = 0; // pointers for the sliding window and count of valid substrings
        while (high < n) { // iterate over the string with the high pointer
            char ch = s.charAt(high); // get the current character
            freq.put(ch, freq.get(ch) + 1); // increment the frequency of the current character
            while (freq.get('a') > 0 && freq.get('b') > 0 && freq.get('c') > 0) { // check if all characters 'a', 'b', 'c' are present in the current window
                count += n - high; // add the number of valid substrings ending at 'high' to count
                char left = s.charAt(low); // get the character at the low pointer
                freq.put(left, freq.get(left) - 1); // decrement the frequency of the character at the low pointer
                low++; // move the low pointer to the right
            }
            high++; // move the high pointer to the right
        }
        return count; // return the total count of valid substrings
    }
}