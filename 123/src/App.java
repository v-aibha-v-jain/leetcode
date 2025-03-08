public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(obj.maxProfit(prices));
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0; // if prices array is empty or null, return 0
        int firstBuy = Integer.MIN_VALUE, firstSell = 0; // initialize first buy and sell
        int secondBuy = Integer.MIN_VALUE, secondSell = 0; // initialize second buy and sell
        for (int price : prices) { // iterate over each price
            firstBuy = Math.max(firstBuy, -price); // maximize the first buy
            firstSell = Math.max(firstSell, firstBuy + price); // maximize the first sell
            secondBuy = Math.max(secondBuy, firstSell - price); // maximize the second buy
            secondSell = Math.max(secondSell, secondBuy + price); // maximize the second sell
        }
        return secondSell; // return the maximum profit after two transactions
    }
}