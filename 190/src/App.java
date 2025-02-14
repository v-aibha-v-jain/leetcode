public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int n = 43261596;
        int result = obj.reverseBits(n);
        System.out.println(result);
    }
}
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        var res = 0; // initialize result to 0
        for (int i = 0; i < 32; i++, n >>= 1) { // iterate over all 32 bits of the integer
            res <<= 1; // shift result left by 1 to make space for the next bit
            res += n & 1; // add the least significant bit of n to result
        }
        return res; // return the reversed bits result
    }
}