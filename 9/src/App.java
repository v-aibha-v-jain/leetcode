public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.isPalindrome(121));
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) { // negative numbers are not palindromes
            return false;
        }
        int num = x; // store the original number
        int rev = 0; // variable to store the reversed number
        while (num != 0) { // loop until all digits are processed
            int ld = num % 10; // get the last digit
            rev = rev * 10 + ld; // add the last digit to the reversed number
            num = num / 10; // remove the last digit from the original number
        }
        return rev == x; // check if the reversed number is equal to the original number
    }
}