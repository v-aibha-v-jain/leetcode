public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int prices[] = {8,4,6,2,3};
        int ans[] = obj.finalPrices(prices);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
class Solution {
    public int[] finalPrices(int[] prices) {
        int len = prices.length; // get the length of the prices array
        int ans[] = new int[len]; // create a new array to store the final prices
        for (int i = 0; i < len; i++) // copy the original prices to the ans array
            ans[i] = prices[i];
        for (int i = 0; i < len - 1; i++) { // iterate through each price
            for (int j = i + 1; j < len; j++) { // find the next smaller or equal price
            if (i < j && prices[i] >= prices[j]) { // if the current price is greater than or equal to the next price
                ans[i] = prices[i] - prices[j]; // subtract the next price from the current price
                break; // break the inner loop once the discount is applied
            }
            }
        }
        return ans; // return the final prices array
    }
}