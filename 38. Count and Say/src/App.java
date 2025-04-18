public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 4;
        String result = solution.countAndSay(n);
        System.out.println("The " + n + "th term in the count-and-say sequence is: " + result);
    }
}
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1"; // base case: if n is 1, return "1"
        String prev = countAndSay(n - 1); // recursively get the previous sequence
        StringBuilder result = new StringBuilder(); // to build the current sequence
        int count = 1; // initialize count for the first character
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++; // when consecutive characters are the same, increase count
            } else {
                result.append(count).append(prev.charAt(i - 1)); // append count and character to result
                count = 1; // reset count for the new character
            }
        }
        result.append(count).append(prev.charAt(prev.length() - 1)); // append the last group to result
        return result.toString(); // return the final sequence
    }
}