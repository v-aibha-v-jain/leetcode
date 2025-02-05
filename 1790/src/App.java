public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s1 = "bank", s2 = "kanb";
        System.out.println(solution.areAlmostEqual(s1, s2));
    }
}
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0; // to count the number of differing positions
        int i = 0, j = 0; // to store the indices of the differing positions
        int n = s1.length(); // length of the strings
        for (int p = 0; p < n; p++) { // iterate through each character in the strings
            if (s1.charAt(p) != s2.charAt(p)) { // if characters at position p are different
                count++; // increment the count of differing positions
                if (count > 2) return false; // if more than 2 positions differ, return false
                if (count == 1) i = p; // store the first differing position
                else if (count == 2) j = p; // store the second differing position
            }
        }
        return (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i)); // check if swapping the differing characters makes the strings equal
    }
}