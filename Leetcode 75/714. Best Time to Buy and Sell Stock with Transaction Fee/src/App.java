public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int result = solution.maxProfit(prices, fee);
        System.out.println(result);
    }
}
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int free = 0; // maximum profit when no stock is held
        int hold = -prices[0]; // maximum profit when a stock is held
        for (int i : prices) {
            int tmp = hold; // temporarily store the current hold value
            hold = Math.max(hold, free - i); // update hold: either keep holding or buy new stock
            free = Math.max(free, tmp + i - fee); // update free: either keep free or sell stock
        }
        return free; // return the maximum profit when no stock is held
    }
}