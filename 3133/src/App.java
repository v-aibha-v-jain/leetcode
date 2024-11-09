public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution().minEnd(5, 3));
    }
}
class Solution {
    public long minEnd(int n, int x) {
        long answer = 0;
        n--;
        for (long i = 1; x > 0 || n > 0; i *= 2, x /= 2) {
            // i is doubled each iteration (i *= 2)
            // x is halved each iteration (x /= 2)
            // Loop continues as long as either x > 0 or n > 0
            if ((x & 1) == 1) { // if x is odd
                answer += i; // add i to answer
                continue;
            }
            if ((n & 1) == 1) answer += i; // if n is odd, add i to answer
            n /= 2;
        }
        return answer;
    }
}