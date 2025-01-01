public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "011101";
        int result = obj.maxScore(s);
        System.out.println("Maximum score: " + result);
    }
}
class Solution {
    public int maxScore(String s) {
        StringBuilder sb  = new StringBuilder(); // StringBuilder to store the left part of the string
        int cnt = 0; // variable to store the current score
        int maxcnt = 0; // variable to store the maximum score
        for(int i = 0 ; i < s.length() - 1 ; i++) { // iterate through the string, excluding the last character
            int zerocnt = 0; // count of '0's in the left part
            int onecnt = 0; // count of '1's in the right part
            sb.append(s.charAt(i)); // add the current character to the left part
            for(int j = 0 ; j < sb.length() ; j++) { // count '0's in the left part
            if(sb.charAt(j) == '0' ){
               zerocnt++; // increment zerocnt if the character is '0'
            }
            }
            for(int k = i + 1 ; k < s.length() ; k++) { // count '1's in the right part
            if(s.charAt(k) == '1') {
               onecnt++; // increment onecnt if the character is '1'
            }
            }
            cnt = onecnt + zerocnt; // calculate the current score
            maxcnt = Math.max(cnt, maxcnt); // update maxcnt if the current score is higher
            System.out.println(cnt); // print the current score
        }
        return maxcnt; // return the maximum score
    }
}