public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.myPow(2.00000, 10));
    }
}
class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x,n);
    }
}