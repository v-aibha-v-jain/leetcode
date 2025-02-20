public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int arr[] = {9,9,9};
        int res[] = obj.plusOne(arr);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length; // get the length of the digits array
        for(int i = n-1; i >= 0; i--){ // iterate from the last element to the first
            if(digits[i]<9){ // if the current digit is less than 9
                digits[i]++; // increment the current digit by 1
                return digits; // return the modified array
            }
            digits[i] = 0; // set the current digit to 0 if it was 9
        }
        int arr[] = new int[n+1]; // create a new array with an extra space
        arr[0] = 1; // set the first element to 1
        return arr; // return the new array
    }
}