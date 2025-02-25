public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.climbStairs(5));
    }
}
class Solution {
    public int climbStairs(int n) {
        if(n < 4) // If n is less than 4, return n directly
            return n;
        int fis = 3, sec = 2; // Initialize fis to 3 and sec to 2
        for(int i = 0; i < n - 3; i++) { // Loop from 0 to n-3
            fis = fis + sec; // Update fis to be the sum of fis and sec
            sec = fis - sec; // Update sec to be the previous value of fis
        }
        return fis; // Return the final value of fis
    }
}