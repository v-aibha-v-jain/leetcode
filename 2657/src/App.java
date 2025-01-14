import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};
        int[] result = solution.findThePrefixCommonArray(A, B);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>(); // Create a set to store unique elements
        int[] arr = new int[A.length]; // Initialize the result array
        for(int i = 0 ; i < A.length; i++){
            set.add(A[i]); // Add element from array A to the set
            set.add(B[i]); // Add element from array B to the set
            int cnt = (i+1)*2 - set.size(); // Calculate the count of common elements
            arr[i] = cnt; // Store the count in the result array
        }
        return arr; // Return the result array
    }
}