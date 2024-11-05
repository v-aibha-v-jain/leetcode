public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "   Hello   World       ";
        System.out.println(obj.lengthOfLastWord(s));
    }
}
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.stripTrailing(); // remove trailing spaces
        String[] s_parts = s.split(" "); // split the string by space
        return s_parts[s_parts.length - 1].length(); // return the length of the last word
    }
}