public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String str1 = "ABCABC";
        String str2 = "ABC";
        String result = solution.gcdOfStrings(str1, str2);
        System.out.println(result);
    }
}
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int a = str1.length(); // length of the first string
        int b = str2.length(); // length of the second string
        if(!(str1+str2).equals(str2+str1)) return ""; // check if concatenation in both orders is equal
        int gcdlen = gcd(a, b); // find the greatest common divisor of the lengths
        return str1.substring(0, gcdlen); // return the substring from the start to the gcd length
    }

    private int gcd(int a, int b) {
        while(b != 0) { // loop until b becomes 0
            int temp = a % b; // find the remainder of a divided by b
            a = b; // assign b to a
            b = temp; // assign remainder to b
        }
        return a; // return the greatest common divisor
    }
}