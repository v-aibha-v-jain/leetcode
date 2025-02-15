public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int n = 00000000000000000000000000001011;
        int result = obj.hammingWeight(n);
        System.out.println(result);
    }
}
class Solution {
    public int hammingWeight(int n) {
        int cnt = 0; // Initialize count to 0
        while(n > 0) { // Loop until n becomes 0
            if(n % 2 == 1) cnt++; // If the least significant bit is 1, increment count
            n /= 2; // Right shift n by 1 (equivalent to dividing by 2)
        }
        return cnt; // Return the count of 1s in the binary representation of n
    }
}