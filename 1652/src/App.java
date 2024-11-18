public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] code = {5,7,1,4};
        int k = 3;
        int[] result = solution.decrypt(code, k);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length]; // initialize result array with the same length as code
        int n = code.length; // get the length of the code array
        for(int i = 0; i < n; i++){
            result[i] = 0; // set all elements in result array to 0
        }
        if(k == 0) return result; // if k is 0, return the result array as is
        for (int i = 0; i < n; i++) {
            int sum = 0; // initialize sum to 0 for each element in code
            if (k > 0) // if k is positive
                for (int j = 1; j <= k; j++) // sum the next k elements
                    sum += code[(i + j) % n]; // add the element at (i + j) % n to sum
            else // if k is negative
                for (int j = 1; j <= -k; j++) // sum the previous k elements
                    sum += code[(i - j + n) % n]; // add the element at (i - j + n) % n to sum
            result[i] = sum; // set the result at index i to the calculated sum
        }
        return result; // return the result array
    }
}