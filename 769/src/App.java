public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] arr = {4,3,2,1,0};
        System.out.println(obj.maxChunksToSorted(arr));
    }
}
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0; // Initialize the maximum value seen so far
        int chunks = 0; // Initialize the number of chunks
        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]); // Update the maximum value seen so far
            if (maxSoFar == i) { // If the maximum value seen so far is equal to the current index
            chunks++; // Increment the number of chunks
            }
        }
        return chunks; // Return the number of chunks
    }
}