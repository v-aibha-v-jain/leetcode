public class App {
    public static void main(String[] args) throws Exception {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        Solution solution = new Solution();
        int result = solution.mincostTickets(days, costs);
        System.out.println("The minimum cost of tickets is: " + result);
    }
}
class Solution {
    Integer[] dp; // Array to store the minimum cost for each day
    boolean[] day; // Array to mark the travel days
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length; // Number of travel days
        dp = new Integer[366]; // Initialize dp array for 365 days
        day = new boolean[366]; // Initialize day array for 365 days
        for(int i = 0; i < n; i++){
            day[days[i]] = true; // Mark the travel days
        }
        return minCost(0, costs); // Start calculating the minimum cost from day 0
    }
    private int minCost(int i, int[] costs){
        if(i >= 366){
            return 0; // If the day exceeds 365, return 0
        }
        if(dp[i] != null){
            return dp[i]; // Return the stored result if already computed
        }
        if(day[i] == false){
            return minCost(i + 1, costs); // If it's not a travel day, move to the next day
        }
        int oneDay = costs[0] + minCost(i + 1, costs); // Cost for 1-day pass
        int sevenDay = costs[1] + minCost(i + 7, costs); // Cost for 7-day pass
        int thirtyDay = costs[2] + minCost(i + 30, costs); // Cost for 30-day pass
        dp[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay)); // Store the minimum cost for the current day
        return dp[i]; // Return the minimum cost for the current day
    }
}