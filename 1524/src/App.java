public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] arr = {1,3,5};
        System.out.println(obj.numOfSubarrays(arr));
    }
}
class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddCount = 0; // count of subarrays with odd sum
        int evenCount = 1; // count of subarrays with even sum (initially 1 to account for the empty subarray)
        int result = 0; // result to store the number of subarrays with odd sum
        int mod = 1000000007; // modulus value to prevent overflow

        if (arr[0] % 2 == 0) { // check if the first element is even
            evenCount++; // increment even count
        } else {
            oddCount++; // increment odd count
            result += oddCount; // add odd count to result
        }

        for (int i = 1; i < arr.length; i++) { // iterate through the array starting from the second element
            arr[i] = arr[i] + arr[i - 1]; // update the current element to be the sum of itself and the previous element
            if (arr[i] % 2 == 0) { // check if the current prefix sum is even
            result += oddCount; // add odd count to result
            evenCount++; // increment even count
            result = result % mod; // take modulus to prevent overflow
            } else {
            result += evenCount; // add even count to result
            oddCount++; // increment odd count
            result = result % mod; // take modulus to prevent overflow
            }
        }
        return result; // return the final result
    }
}