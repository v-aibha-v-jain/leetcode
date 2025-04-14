public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution(); // create an instance of the Solution class
        int[] arr = {3, 0, 1, 1, 9, 7};
        int a = 7, b = 2, c = 3;
        int result = sol.countGoodTriplets(arr, a, b, c);
        System.out.println("Number of good triplets: " + result);
    }
}
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length, count = 0; // initialize array length and count
        for(int i = 0; i < n - 2; i++) { // iterate over the first element of the triplet
            for(int j = i + 1; j < n - 1; j++) { // iterate over the second element of the triplet
                if(Math.abs(arr[i] - arr[j]) <= a) { // check if the first condition is satisfied
                    for(int k = j + 1; k < n; k++) { // iterate over the third element of the triplet
                        if(Math.abs(arr[j] - arr[k]) <= b && 
                        Math.abs(arr[i] - arr[k]) <= c) count++; // check remaining conditions and increase count
                    }
                }
            }
        }
        return count; // return the total count of good triplets
    }
}