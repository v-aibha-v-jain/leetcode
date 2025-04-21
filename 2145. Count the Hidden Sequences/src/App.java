public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] differences = {1, -3, 4};
        int lower = 1;
        int upper = 6;
        int result = solution.numberOfArrays(differences, lower, upper);
        System.out.println("Number of valid sequences: " + result); // Output the result
    }
}
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long start = 0; // Initialize the starting value of the sequence
        long max = 0, min = 0; // Initialize max and min values for the sequence
        for(int diff : differences){ // Iterate through the differences array
            start += diff; // Update the current value of the sequence
            max = (max < start) ? start : max; // Update max if the current value is greater
            min = (min > start) ? start : min; // Update min if the current value is smaller
        }  
        return (int)Math.max(0, (upper - lower) - (max - min) + 1); // Calculate the number of valid sequences
    }
}