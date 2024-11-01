public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "leeetcode";
        System.out.println(solution.makeFancyString(s));
    }
}
class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0)); // add the first character
        int n = s.length();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ans.charAt(ans.length() - 1)) { // if the character is same as the last character
                count++;
                if (count < 3) { // count should be always less than 3 (no three consecutive characters are equal)
                    ans.append(s.charAt(i)); // add the character
                }
            } else { // if the character is different
                count = 1; // reset the count
                ans.append(s.charAt(i)); // and add the character
            }
        }
        return ans.toString();
    }
}