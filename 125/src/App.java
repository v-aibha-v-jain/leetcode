public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(obj.isPalindrome(s));
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        if (s.trim().isEmpty()) return true; // if the string is empty, return true
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++; // if the character is not a letter or digit, move to the next character
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--; // if the character is not a letter or digit, move to the previous character
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false; // if the characters are not equal, return false
            }
            left++;
            right--;
        }
        return true;
    }
}
