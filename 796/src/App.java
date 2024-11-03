public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(obj.rotateString(s, goal));
    }
}
class Solution {
    public boolean rotateString(String s, String goal) {
      if(s.length() != goal.length()) { // if the length of s and goal are not equal, return false
        return false;
      } else { 
        // since there are shifts in the string, we can concatenate the string s with itself 
        // and check if the goal is a substring of the concatenated string
        return (s + s).contains(goal);
      }
    }
}