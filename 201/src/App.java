public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int left = 5, right = 7;
        System.out.println(obj.rangeBitwiseAnd(left, right));
    }
}
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int diff = right - left, count = 0; // calculate the difference between right and left, initialize count to 0
        while(diff > 0){
            count++; // increment count
            diff = diff >> 1; // right shift diff by 1
        }
        int sol = (left & right) >> count; // bitwise AND left and right, then right shift by count
        return sol << count; // left shift sol by count and return the result
    }
}