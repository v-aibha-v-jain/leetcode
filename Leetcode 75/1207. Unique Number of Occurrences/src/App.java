import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] arr = {1,2,2,1,1,3};
        boolean result = obj.uniqueOccurrences(arr);
        System.out.println(result);
    }
}
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr); // Sort the array to group identical elements together
        int[] occrs = new int[arr.length]; // Array to store occurrences of each unique number
        int index = 0; // Index to track the position in the occurrences array
        int count = 1; // Counter for occurrences of the current number

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) count++; // When consecutive elements are equal, increase count
            else {
                occrs[index++] = count; // Store the count of the previous number
                count = 1; // Reset count for the next number
            }
        }
        occrs[index++] = count; // Store the count of the last number

        Arrays.sort(occrs, 0, index); // Sort the occurrences array to check for duplicates
        for (int i = 1; i < index; i++) {
            if (occrs[i] == occrs[i - 1]) // If two consecutive counts are equal, return false
                return false;
        }

        return true; // All occurrences are unique
    }
}