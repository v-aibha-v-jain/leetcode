public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.getHappyString(1, 3));
    }
}
class Solution {
    String ans = ""; // to store the k-th happy string
    int count = 0; // to count the number of happy strings generated

    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder(); // to build the happy strings
        helper(n, sb, k); // start the recursive helper function
        return ans; // return the k-th happy string
    }

    void helper(int n, StringBuilder sb, int k) {
        if (sb.length() == n) { // base case: if the length of the string is n
            count += 1; // increment the count of happy strings generated
            if (count == k) { // if the count matches k
                ans = sb.toString(); // store the current string as the answer
            }
            return; // return to stop further processing
        }
        for (int i = 0; i < 3; i++) { // loop through 'a', 'b', 'c'
            char ch = ((char) ('a' + i)); // get the character 'a', 'b', or 'c'
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != ch) { // ensure no consecutive characters are the same
                sb.append(ch); // add the character to the string
                helper(n, sb, k); // recurse with the new string
                sb.deleteCharAt(sb.length() - 1); // backtrack by removing the last character
            }
        }
    }
}