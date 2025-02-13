public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String a = "11", b = "1";
        System.out.println(solution.addBinary(a, b));
    }
}
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder(); // to store the result
        int i = a.length() - 1, j = b.length() - 1, carry = 0; // pointers for a and b, and carry
        while (i >= 0 || j >= 0 || carry > 0) { // loop until all digits and carry are processed
            int sum = carry; // start with carry
            if (i >= 0) sum += a.charAt(i--) - '0'; // add digit from a if available
            if (j >= 0) sum += b.charAt(j--) - '0'; // add digit from b if available
            result.append(sum % 2); // append the binary digit to result
            carry = sum / 2; // update carry
        }
        return result.reverse().toString(); // reverse the result and convert to string
    }
}