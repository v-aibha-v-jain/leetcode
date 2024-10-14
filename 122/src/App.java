public class App {

    //Calculates the maximum profit that can be achieved from an array of stock prices.
    public int maxProfit(int[] prices) {
        int profit = 0; // Initialize profit to 0
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) { // Check if current price is greater than previous price
                profit += prices[i] - prices[i - 1]; // Add the difference to profit
            }
        }
        
        return profit; // Return the calculated profit
    }

    // The main method to test the maxProfit method.
    public static void main(String[] args) throws Exception {
        App app = new App(); // Create an instance of App
        int[] prices = {1,2,3,4,5}; // Example array of stock prices
        System.out.println(app.maxProfit(prices)); // Print the maximum profit
    }
}
