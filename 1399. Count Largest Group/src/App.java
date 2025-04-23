import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.countLargestGroup(13));
    }
}
class Solution {
    public int countLargestGroup(int n) {
        int largest = 0; // to count the number of groups with the largest size
        int arr[] = new int[37]; // array to store the frequency of sums of digits (max sum of digits for 9999 is 36)
        for (int i = 1; i <= n; i++) { // iterate through all numbers from 1 to n
            int digit = 0; // to store the sum of digits of the current number
            int k = i; // copy of the current number
            while (k > 0) { // calculate the sum of digits
                int temp = k % 10; // get the last digit
                k /= 10; // remove the last digit
                digit += temp; // add the digit to the sum
            }
            arr[digit]++; // increment the count for this sum of digits
        }
        Arrays.sort(arr); // sort the array to find the largest frequency
        if (arr[arr.length - 1] != 0) // check if the largest frequency is non-zero
            for (int i = 0; i < arr.length; i++) // iterate through the array
                if (arr[i] == arr[arr.length - 1]) // check if the frequency matches the largest frequency
                    largest++; // increment the count of groups with the largest size
        return largest; // return the count of largest groups
    }
}