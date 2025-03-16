public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] ranks = {4, 2, 3, 1};
        int cars = 10;
        long result = solution.repairCars(ranks, cars);
        System.out.println(result);
    }
}
class Solution {
    public long repairCars(int[] ranks, int cars) {
        int max = 0;
        // Find the maximum rank in the array
        for (int n : ranks) max = Math.max(max, n);
        long c = cars, r = max * c * c, l = 0;
        // Perform binary search to find the minimum time
        while (l < r) {
            long m = l + (r - l) / 2; // Calculate the mid-point
            if (isValid(ranks, cars, m)) r = m; // If valid, adjust the upper bound
            else l = m + 1; // Otherwise, adjust the lower bound
        }
        return l; // Return the minimum time
    }

    private boolean isValid(int[] ranks, int cars, long m) {
        // Check if it's possible to repair all cars within time m
        for (int r : ranks)
            if ((cars -= Math.floor(Math.sqrt(m / r))) < 1) // Deduct cars repaired by each mechanic
                return true; // Return true if all cars are repaired
        return cars < 1; // Return true if cars are less than 1
    }
}